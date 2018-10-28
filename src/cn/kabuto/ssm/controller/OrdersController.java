package cn.kabuto.ssm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.commons.CommonUtils;
import cn.kabuto.ssm.exception.GoodsException;
import cn.kabuto.ssm.exception.OrderException;
import cn.kabuto.ssm.pojo.Cart;
import cn.kabuto.ssm.pojo.CartItem;
import cn.kabuto.ssm.pojo.Goods;
import cn.kabuto.ssm.pojo.Orderitem;
import cn.kabuto.ssm.pojo.OrderitemExtend;
import cn.kabuto.ssm.pojo.Orders;
import cn.kabuto.ssm.pojo.OrdersExtend;
import cn.kabuto.ssm.pojo.User;
import cn.kabuto.ssm.service.GoodsService;
import cn.kabuto.ssm.service.OrderService;

@Controller
public class OrdersController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private GoodsService goodsService;
	
	/**
	 * 添加订单
	 * @param session
	 * @param model
	 * @return
	 * @throws OrderException
	 * @throws GoodsException 
	 */
	@RequestMapping("/addOrders")
	public String addOrders(HttpSession session,Model model) throws OrderException, GoodsException{
		Cart cart = (Cart) session.getAttribute("cart");
		User user = (User) session.getAttribute("user");
		//设置订单对象的属性
		Orders orders = new Orders();
		orders.setOid(CommonUtils.uuid());
		orders.setOtime(new Date());
		orders.setAddress("aaa");
		orders.setState((short)1);
		orders.setTotal(cart.getTotal());
		orders.setUid(user.getUid());
		orderService.addOrders(orders);
		model.addAttribute("orders", orders);
		
		//设置订单条目继承类的的属性
		List<OrderitemExtend> orderitemExtendList = new ArrayList<OrderitemExtend>();
		//设置订单条目的属性
		List<Orderitem> orderitemList = new ArrayList<Orderitem>();
		//遍历购物车
		for(CartItem cartItem:cart.getCartItems()){
			OrderitemExtend orderitemExtend = new OrderitemExtend();
			orderitemExtend.setGoodsExtend(cartItem.getGoodsExtend());
			orderitemExtend.setSubtotal(cartItem.getSubtotal());
			orderitemExtend.setGid(cartItem.getGoodsExtend().getGid());
			orderitemExtend.setOid(orders.getOid());
			orderitemExtend.setItemstate((byte)1);
			orderitemExtendList.add(orderitemExtend);
			orderitemList.add(orderitemExtend);
			
			//设置商品状态
			Integer gid = cartItem.getGoodsExtend().getGid();
			Goods goods = goodsService.findByGid(gid);
			goods.setSalestate((byte)0);
			goodsService.editGoodsSubmit(goods);
			
		}
		orderService.addOrderitemList(orderitemList);
		model.addAttribute("orderitemExtendList",orderitemExtendList);
		
		//清空购物车
		cart.clear();
//		return "redirect:/pages/orders/orders.jsp";
		return "mybuyorders.action";
	}
	
	/**
	 * 查看购买订单
	 * @param model
	 * @param session
	 * @return
	 * @throws OrderException
	 */
	@RequestMapping("/mybuyorders")
	public String mybuyorders(Model model,HttpSession session) throws OrderException{
		User user = (User) session.getAttribute("user");
		Integer uid = user.getUid();
		List<OrdersExtend> ordersExtendList = orderService.selectBuyOrdersByUid(uid);
		System.out.println(ordersExtendList);
		model.addAttribute("ordersExtendList", ordersExtendList);
		return "/pages/orders/buyorderslist.jsp";
	}
	
	/**
	 * 查看出售订单
	 * @param model
	 * @param session
	 * @return
	 * @throws OrderException
	 */
	@RequestMapping("/mysaleorders")
	public String mysaleorders(Model model,HttpSession session) throws OrderException{
		User user = (User) session.getAttribute("user");
		Integer uid = user.getUid();
		List<OrdersExtend> ordersExtendList = orderService.selectSaleOrdersByUid(uid);
		System.out.println(ordersExtendList);
		model.addAttribute("ordersExtendList", ordersExtendList);
		return "/pages/orders/saleorderslist.jsp";
	}
	
	/**
	 * 确认收货
	 * @param model
	 * @param oid
	 * @return
	 * @throws OrderException
	 */
	@RequestMapping("/confirmorders")
	public String confirmorders(Model model,String oid) throws OrderException{
		orderService.confirmorders(oid);
		
		return "mybuyorders.action";
	}
	
	/**
	 * 发货
	 * @param model
	 * @param oid
	 * @return
	 * @throws OrderException
	 */
	@RequestMapping("/sendorders")
	public String sendorders(Model model,String oid,HttpSession session)throws OrderException{
		User user = (User) session.getAttribute("user");
		Integer uid = user.getUid();		
		orderService.sendorders(oid,uid);
		return "mysaleorders.action";
	}
}
