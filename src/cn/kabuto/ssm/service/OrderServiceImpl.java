package cn.kabuto.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.kabuto.ssm.exception.OrderException;
import cn.kabuto.ssm.mapper.OrderitemMapper;
import cn.kabuto.ssm.mapper.OrdersMapper;
import cn.kabuto.ssm.mapper.OrdersMapper2;
import cn.kabuto.ssm.pojo.Orderitem;
import cn.kabuto.ssm.pojo.OrderitemExtend;
import cn.kabuto.ssm.pojo.Orders;
import cn.kabuto.ssm.pojo.OrdersExtend;

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private OrderitemMapper orderitemMapper;
	@Autowired
	private OrdersMapper2 ordersMapper2;

	/**
	 * 添加订单
	 */
	@Override
	public void addOrders(Orders orders) throws OrderException {
		ordersMapper.insertSelective(orders);
	}
	/**
	 * 添加订单
	 */
	@Override
	public void addOrderitemList(List<Orderitem> orderitemList)
			throws OrderException {
		for(Orderitem orderitem:orderitemList){
			orderitemMapper.insertSelective(orderitem);
		}
	}
	/**
	 * 查找我的购买订单
	 */
	@Override
	public List<OrdersExtend> selectBuyOrdersByUid(Integer uid)
			throws OrderException {
		List<OrdersExtend> ordersExtendList = ordersMapper2.selectBuyOrdersByUid(uid);
		return ordersExtendList;
	}
	/**
	 * 确认收货
	 */
	@Override
	public void confirmorders(String oid) throws OrderException {
		// TODO Auto-generated method stub
		Orders orders = ordersMapper.selectByPrimaryKey(oid);
		orders.setState((short)3);
		ordersMapper.updateByPrimaryKeySelective(orders);
	}
	/**
	 * 确认发货
	 */
	@Override
	public void sendorders(String oid,Integer uid) throws OrderException {
		List<Orderitem> orderitList = ordersMapper2.selectOrderitemByUidOid(uid, oid);
		for(Orderitem item:orderitList){
			item.setItemstate((byte)0);
			orderitemMapper.updateByPrimaryKeySelective(item);
		}
		int flag = 0;
		List<Byte> itemstateList = orderitemMapper.selectItemstateByOid(oid);
		for(Byte itemstate:itemstateList){
			int i = itemstate.intValue();
			flag = flag + i;
		}
		Orders orders = ordersMapper.selectByPrimaryKey(oid);
		if(flag==0){
			orders.setState((short)2);		
			ordersMapper.updateByPrimaryKeySelective(orders);
		}
	}
	/**
	 * 查询我的出售订单
	 */
	@Override
	public List<OrdersExtend> selectSaleOrdersByUid(Integer uid)
			throws OrderException {
		List<OrdersExtend> ordersExtendList = ordersMapper2.selectSaleOrdersBySaleuid(uid);
		return ordersExtendList;
	}
	
	@Override
	public List<OrdersExtend> findAllOrders() throws OrderException {
		List<OrdersExtend> extendList = ordersMapper2.findAllOrders();
		return extendList;
	}
	
	public Orders findOrdersByOid(String oid){
		Orders orders = ordersMapper.selectByPrimaryKey(oid);
		return orders;
	}

	@Override
	public void updateInf(Orders orders) throws OrderException {
		ordersMapper.updateByPrimaryKeySelective(orders);
	}
	
	@Override
	public List<OrderitemExtend> findItemByOid(String oid)
			throws OrderException {
		List<OrderitemExtend> list = ordersMapper2.findItemByOid(oid);
		return list;
	}
}
