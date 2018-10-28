package cn.kabuto.ssm.pojo;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import cn.kabuto.ssm.exception.CartException;



public class Cart {
	//键值分别为商品的id和商品对应的购物车条目
	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();
	
	public void add(CartItem cartItem) throws CartException{
		
		//先判断里面是否存在该商品
		if(map.containsKey(cartItem.getGoodsExtend().getGid())){
			//购物车里面已经存在
			throw new CartException("购物车中已存在该商品!");
		}else{
			map.put(cartItem.getGoodsExtend().getGid(), cartItem);
		}
	}
	
	/**
	 * 总计方法
	 * 使用BigDecimal处理了二进制计算误差的问题
	 */
	public double getTotal(){
		//使用BigDecimal对象时,必须使用String构造器
		BigDecimal total = new BigDecimal("0");
		
		for(CartItem c : map.values()){
			BigDecimal subtotal = new BigDecimal(c.getSubtotal()+"");
			total = total.add(subtotal);
		}
		return total.doubleValue();
	}
	
	/**
	 * 清空购物车
	 */
	public void clear(){
		map.clear();
	}
	
	/**
	 * 清空指定的条目
	 * @param bid
	 */
	public void delete(Integer gid){
		map.remove(gid);
	}
	
	/**
	 * 查看我的购物车
	 * @return
	 */
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
}
