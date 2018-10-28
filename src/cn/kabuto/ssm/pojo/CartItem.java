package cn.kabuto.ssm.pojo;

import java.math.BigDecimal;

public class CartItem {
	private GoodsExtend goodsExtend;
	private Integer count;

	
	@Override
	public String toString() {
		return "CartItem [goodsExtend=" + goodsExtend + ", count=" + count
				+ "]";
	}
	public GoodsExtend getGoodsExtend() {
		return goodsExtend;
	}
	public void setGoodsExtend(GoodsExtend goodsExtend) {
		this.goodsExtend = goodsExtend;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	/**
	 * 小计方法
	 * @return
	 */
	public double getSubtotal(){
		//使用BigDecimal对象时,必须使用String构造器
		BigDecimal d1 = new BigDecimal(goodsExtend.getNewprice()+"");
		BigDecimal d2 = new BigDecimal(count+"");
		return d1.multiply(d2).doubleValue();
	}
}
