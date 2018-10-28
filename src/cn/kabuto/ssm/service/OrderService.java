package cn.kabuto.ssm.service;

import java.util.List;

import cn.kabuto.ssm.exception.OrderException;
import cn.kabuto.ssm.pojo.Orderitem;
import cn.kabuto.ssm.pojo.OrderitemExtend;
import cn.kabuto.ssm.pojo.Orders;
import cn.kabuto.ssm.pojo.OrdersExtend;

public interface OrderService {
	public void addOrders(Orders orders)throws OrderException;
	public void addOrderitemList(List<Orderitem> orderitemList)throws OrderException;
	public List<OrdersExtend> selectBuyOrdersByUid(Integer uid)throws OrderException;
	public void confirmorders(String oid)throws OrderException;
	public void sendorders(String oid,Integer uid)throws OrderException;
	public List<OrdersExtend> selectSaleOrdersByUid(Integer uid)throws OrderException;
	public List<OrdersExtend> findAllOrders()throws OrderException; 
	public Orders findOrdersByOid(String oid)throws OrderException;
	public void updateInf(Orders orders)throws OrderException;
	public List<OrderitemExtend> findItemByOid(String oid)throws OrderException;
}
