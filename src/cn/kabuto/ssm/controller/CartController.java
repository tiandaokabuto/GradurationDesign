package cn.kabuto.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kabuto.ssm.exception.CartException;
import cn.kabuto.ssm.exception.GoodsException;
import cn.kabuto.ssm.pojo.Cart;
import cn.kabuto.ssm.pojo.CartItem;
import cn.kabuto.ssm.pojo.GoodsExtend;
import cn.kabuto.ssm.service.GoodsService;

@Controller
public class CartController {

	@Autowired
	GoodsService goodsService;

	@RequestMapping("/addCart")
	public String addCart(Integer gid, HttpSession session, Model model,Integer uid)
			throws GoodsException {
		Cart cart = (Cart) session.getAttribute("cart");
		CartItem cartItem = new CartItem();
		GoodsExtend goodsExtend = goodsService.selectByGid(gid);
		Integer id = goodsExtend.getUid();
		if(id==uid){
			model.addAttribute("msg", "自己不能购买自己发布的商品哦~");
			return "pages/cart/cartmsg.jsp";
		}
		
		
		cartItem.setCount(1);
		cartItem.setGoodsExtend(goodsExtend);

		try {
			cart.add(cartItem);
		} catch (CartException e) {
			model.addAttribute("msg",e.getMessage());
			return "pages/cart/cartmsg.jsp";
		}
		
		return "redirect:pages/cart/cart.jsp";
	}

	@RequestMapping("/deleteCartItem")
	public String deleteCartItem(Integer gid, HttpSession session, Model model) {
		Cart cart = (Cart) session.getAttribute("cart");
		cart.delete(gid);
		return "pages/cart/cart.jsp";
	}

	@RequestMapping("/clearCart")
	public String clearCart(HttpSession session, Model model) {
		Cart cart = (Cart) session.getAttribute("cart");
		cart.clear();
		return "pages/cart/cart.jsp";
	}
}
