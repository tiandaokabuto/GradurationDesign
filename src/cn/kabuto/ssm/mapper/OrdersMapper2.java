package cn.kabuto.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.kabuto.ssm.pojo.Orderitem;
import cn.kabuto.ssm.pojo.OrderitemExtend;
import cn.kabuto.ssm.pojo.OrdersExtend;

public interface OrdersMapper2 {
	public List<OrdersExtend> selectBuyOrdersByUid(@Param("uid")Integer uid);
	public List<OrdersExtend> selectSaleOrdersBySaleuid(@Param("uid")Integer uid);
	public List<Orderitem> selectOrderitemByUidOid(@Param("uid")Integer uid,@Param("oid")String oid);
	public List<OrdersExtend> findAllOrders();
	public List<OrderitemExtend> findItemByOid(String oid);
}
