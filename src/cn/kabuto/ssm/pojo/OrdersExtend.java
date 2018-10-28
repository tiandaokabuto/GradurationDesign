package cn.kabuto.ssm.pojo;

import java.util.List;

public class OrdersExtend extends Orders{
	private List<OrderitemExtend> orderitemExtendList ;

	public List<OrderitemExtend> getOrderitemExtendList() {
		return orderitemExtendList;
	}

	public void setOrderitemExtendList(List<OrderitemExtend> orderitemExtendList) {
		this.orderitemExtendList = orderitemExtendList;
	}

}
