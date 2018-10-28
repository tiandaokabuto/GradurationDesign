package cn.kabuto.ssm.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.commons.CommonUtils;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
import cn.kabuto.ssm.exception.GoodsException;
import cn.kabuto.ssm.exception.UserException;
import cn.kabuto.ssm.pojo.Cart;
import cn.kabuto.ssm.pojo.GoodsExtend;
import cn.kabuto.ssm.pojo.User;
import cn.kabuto.ssm.pojo.UserPassword;
import cn.kabuto.ssm.service.GoodsService;
import cn.kabuto.ssm.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private GoodsService goodsService;

	/**
	 * 用户注册功能
	 * 
	 * @param user
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/regist")
	public String regist(Model model, @Validated @ModelAttribute User user,
			BindingResult bindingResult) throws IOException {

		// 获取校验错误信息
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();

			for (ObjectError error : allErrors) {
				System.out.println(error.getDefaultMessage());
			}
			model.addAttribute("errors", allErrors);
			return "pages/user/regist.jsp";
		}

		// 补充校验码
		user.setCode(CommonUtils.uuid());
		//补充帐号使用状态(1为可用,0为冻结)
		user.setUsestate((byte)1);
		//补充注册时间
		user.setRegistdate(new Date());
		// 注册
		try {
			userService.regist(user);
		} catch (UserException e) {
			model.addAttribute("msg", e.getMessage());
			return "pages/user/regist.jsp";
		}

		/*
		 * 发邮件 准备配置文件
		 */
		// 获取配置文件
		Properties pro = new Properties();
		pro.load(this.getClass().getClassLoader()
				.getResourceAsStream("email_config.properties"));
		// 获取相关信息
		String from = pro.getProperty("from");// 获得发件人
		String un = pro.getProperty("un");// 获得用户名
		String pwd = pro.getProperty("pwd");// 获得授权码
		String host = pro.getProperty("host");// 获得邮箱服务器
		String to = user.getEmail();// 获得收件人
		String title = pro.getProperty("title");// 获得邮件标题
		String content = pro.getProperty("content");// 获得邮件正文内容

		content = MessageFormat.format(content, user.getCode());// 把占位符{0}替换成激活码code

		Session session = MailUtils.createSession(host, un, pwd);
		Mail mail = new Mail(from, to, title, content);
		try {
			MailUtils.send(session, mail);
		} catch (MessagingException e) {

		}
		model.addAttribute("msg", "注册成功,请到邮箱激活");
		return "index.jsp";
	}

	/**
	 * 邮箱激活功能
	 * 
	 * @param code
	 * @param model
	 * @return
	 */
	@RequestMapping("/activate")
	public String activate(String code, Model model) {
		try {
			userService.activate(code);
			model.addAttribute("msg", "激活成功!");
		} catch (UserException e) {
			model.addAttribute("msg", e.getMessage());
		}
		return "index.jsp";

	}

	/**
	 * 用户登录功能
	 * 
	 * @param user
	 * @param model
	 * @return
	 */

	@RequestMapping("/login")
	public String login(User user, Model model, HttpSession session) {
		User u;
		try {
			u = userService.login(user);
			u.setLogindate(new Date());
			userService.updateInf(u);
		} catch (UserException e) {
			model.addAttribute("msg", e.getMessage());

			return "pages/user/login.jsp";
		}
		model.addAttribute("user", u);
		session.setAttribute("user", u);
		session.setAttribute("cart", new Cart());
		return "homeGoods.action";
		// return "jsp/success.jsp";

	}

	/**
	 * 更新用户信息
	 * 
	 * @param model
	 * @param session
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateInf")
	public String updateInf(Model model, HttpSession session, User user) {
		User u = (User) session.getAttribute("user");
		Integer uid = u.getUid();
		user.setUsername(u.getUsername());
		user.setUid(uid);
		
		try {
			u = userService.updateInf(user);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("user", u);
		session.setAttribute("user", u);

		return "pages/user/success.jsp";
	}

	/**
	 * 修改用户密码
	 * 
	 * @param model
	 * @param session
	 * @param password
	 * @param firstPassword
	 * @param secondPassword
	 * @return
	 * @throws UserException
	 */
	@RequestMapping("/updatePassword")
	public String updatePassword(Model model, HttpSession session,
			@Validated  @ModelAttribute UserPassword userPassword,
			BindingResult bindingResult) throws UserException {

		User user = (User) session.getAttribute("user");
		if (!userPassword.getPassword().equals(user.getPassword())) {
			model.addAttribute("msg", "原密码输入错误");
			return "pages/user/password.jsp";
		}
		if (!userPassword.getFirstPassword().equals(
				userPassword.getSecondPassword())) {
			model.addAttribute("msg", "两次密码输入不一致");
			return "pages/user/password.jsp";

		}

		// 获取校验错误信息
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();

			for (ObjectError error : allErrors) {
				System.out.println(error.getDefaultMessage());
			}
			model.addAttribute("errors", allErrors);
			return "pages/user/password.jsp";
		}

		userService.updatePassword(userPassword.getFirstPassword(), user);
		user.setPassword(userPassword.getFirstPassword());

		model.addAttribute("user", user);
		session.setAttribute("user", user);

		return "pages/user/success.jsp";
	}
	
	@RequestMapping("/allGoods")
	public String allGoods(Model model,HttpSession session) throws GoodsException{
		User user = (User) session.getAttribute("user");
		Integer uid = user.getUid();
		List<GoodsExtend> goodsExtendList =  goodsService.findGoodsByUid(uid);
		model.addAttribute("goodsExtendList", goodsExtendList);
		return "pages/user/goods.jsp";
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "homeGoods.action";
	}
}
