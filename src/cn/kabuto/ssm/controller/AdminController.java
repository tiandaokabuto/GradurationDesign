package cn.kabuto.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kabuto.ssm.exception.GoodsException;
import cn.kabuto.ssm.exception.OrderException;
import cn.kabuto.ssm.exception.UserException;
import cn.kabuto.ssm.pojo.Adminuser;
import cn.kabuto.ssm.pojo.Goods;
import cn.kabuto.ssm.pojo.GoodsExtend;
import cn.kabuto.ssm.pojo.OrderitemExtend;
import cn.kabuto.ssm.pojo.Orders;
import cn.kabuto.ssm.pojo.OrdersExtend;
import cn.kabuto.ssm.pojo.User;
import cn.kabuto.ssm.service.AdminuserService;
import cn.kabuto.ssm.service.GoodsService;
import cn.kabuto.ssm.service.OrderService;
import cn.kabuto.ssm.service.UserService;

@Controller
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private AdminuserService adminuserService;
	
	@RequestMapping("/adminLogin")
	public String adminLogin(Adminuser adminuser,Model model,HttpSession session){
		Adminuser a;
		try {
			a = adminuserService.adminLogin(adminuser);
		} catch (UserException e) {
			model.addAttribute("msg", e.getMessage());
			return "pages/admin/login.jsp";
		}
		session.setAttribute("adminuser", a);
		session.setAttribute("name", a.getAdminusername());
		return "findAllUser.action";		
	}
	
	/**
	 * 查找所有用户信息
	 * @param model
	 * @return
	 * @throws UserException
	 */
	@RequestMapping("/findAllUser")
	public String findAllUser(Model model) throws UserException{
		List<User> userList = userService.findAllUser();
		model.addAttribute("userList", userList);
		return "pages/admin/userList.jsp";
	}
	/**
	 * 跳转编辑用户信息页面
	 * @param model
	 * @param uid
	 * @return
	 * @throws UserException
	 */
	@RequestMapping("/adminUpdateUser")
	public String adminUpdateUser(Model model,Integer uid) throws UserException{
		User user = userService.findByUid(uid);
		model.addAttribute("user", user);
		return "pages/admin/updateuser.jsp";
	}
	/**
	 * 提交修改用户信息
	 * @param model
	 * @param user
	 * @return
	 * @throws UserException
	 */
	@RequestMapping("/adminUpdateUserSubmit")
	public String adminUpdateUserSubmit(Model model,User user)throws UserException{
		System.out.println(user.getUid());
		userService.updateInf(user);
		return "findAllUser.action";
	}
	/**
	 * 冻结解冻用户
	 * @param model
	 * @param uid
	 * @return
	 * @throws UserException
	 */
	@RequestMapping("/adminFreezeUser")
	public String adminFreezeUser(Model model,Integer uid) throws UserException{
		User user = userService.findByUid(uid);
		int usestate = user.getUsestate().intValue();
		if(usestate==1){
			user.setUsestate((byte)0);
			userService.updateInf(user);
			return "findAllUser.action";
		}
		else{
			user.setUsestate((byte)1);
			userService.updateInf(user);
			return "findAllUser.action";
		}		
	}	
	/**
	 * 查看全部订单
	 * @param model
	 * @return
	 * @throws OrderException
	 */
	@RequestMapping("/findAllOrders")
	public String findAllOrders(Model model) throws OrderException{
		List<OrdersExtend> extendList = orderService.findAllOrders();
		model.addAttribute("ordersList",extendList);
		return "pages/admin/ordersList.jsp";
	}
	/**
	 * 跳转编辑订单页面
	 * @param model
	 * @param oid
	 * @return
	 * @throws OrderException
	 */
	@RequestMapping("/adminUpdateOrder")
	public String adminUpdateOrder(Model model,String oid) throws OrderException{
		Orders orders = orderService.findOrdersByOid(oid);
		model.addAttribute("orders", orders);
		return "pages/admin/updateorders.jsp";
	}
	/**
	 * 提交订单修改
	 * @param model
	 * @param orders
	 * @return
	 * @throws OrderException
	 */
	@RequestMapping("/adminUpdateOrdersSubmit")
	public String adminUpdateOrdersSubmit(Model model,Orders orders)throws OrderException{
		orderService.updateInf(orders);
		return "findAllOrders.action";
	}
	/**
	 * 查找全部的商品信息
	 * @param model
	 * @return
	 * @throws GoodsException
	 */
	@RequestMapping("findAllGoods")
	public String findAllGoods(Model model) throws GoodsException{
		List<GoodsExtend> extendList = goodsService.findAllGoods();
		model.addAttribute("goodsList", extendList);
		return "pages/admin/goodsList.jsp";
	}
	/**
	 * 商品审核
	 * @param gid
	 * @param model
	 * @return
	 * @throws GoodsException
	 */
	@RequestMapping("/adminGoodsCheck")
	public String adminGoodsCheck(Integer gid,Model model) throws GoodsException{
		Goods goods = goodsService.findByGid(gid);
		if(goods.getUploadstate()==1){
			goods.setUploadstate((byte)0);
		}else {
			goods.setUploadstate((byte)1);
		}
		goodsService.editGoodsSubmit(goods);
		return "redirect:findAllGoods.action";
	}
	/**
	 * 跳转修改商品信息页面
	 * @param goods
	 * @param model
	 * @return
	 * @throws GoodsException
	 */
	@RequestMapping("/adminUpdateGoods")
	public String adminUpdateGoods(Integer gid,Model model) throws GoodsException{
		Goods goods = goodsService.findByGid(gid);
		model.addAttribute("goods", goods);
		return "pages/admin/updategoods.jsp";
	}
	/**
	 * 提交修改商品信息
	 * @param goods
	 * @return
	 * @throws GoodsException
	 */
	@RequestMapping("/adminUpdateGoodsSubmit")
	public String adminUpdateGoodsSubmit(Goods goods) throws GoodsException{
		goodsService.editGoodsSubmit(goods);
		return "redirect:findAllGoods.action";		
	}	
	
	@RequestMapping("/adminfindItemsByOid")
	public String adminfindItemsByOid(String oid,Model model) throws OrderException{
		List<OrderitemExtend> list = orderService.findItemByOid(oid);
		model.addAttribute("itemList", list);
		return "pages/admin/itemlist.jsp";
	}
}
