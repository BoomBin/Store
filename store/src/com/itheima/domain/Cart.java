package com.itheima.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart implements Serializable{
	//存放购物车项的集合， key：商品的ID，cartItem：购物车项，使用map集合便于删除购物车项
	private Map<String,CartItem> map = new LinkedHashMap<>();
	//总金额
	private Double total = 0.0;
	/**
	 * 获取所有的购物车项
	 * @return
	 */
	public Collection<CartItem> getItems() {
		return map.values();
	}
	/**
	 * 添加到购物车
	 * @param item
	 */
	public void add2Cart(CartItem item) {
		//1.先判断购物车中有误该商品
			//1.1获取商品的ID
		String pid = item.getProduct().getPid();
		if(map.containsKey(pid)) {
			//有
			//设置购买数量，需要获取该商品之前的购买数量+现在的购买数量（item.getCount）
			CartItem oItem = map.get(pid);
			oItem.setCount(oItem.getCount()+item.getCount());
		}else {
			//没有,将购物车项添加进去
			map.put(pid, item);
		}
		//2.添加完成之后修改金额
		total+=item.getSubtotal();
	}
	
	/**
	 * 从购物车中删除指定购物车项
	 * @param pid
	 */
	public void removeFromCart(String pid) {
		//1.从集合中删除
		CartItem item = map.remove(pid);
		
		//2.修改金额
		total -= item.getSubtotal();
	}
	
	
	/**
	 * 清空购物车清空购物车
	 */
	public void clearCart() {
		//1.将map集合制空
		map.clear();
		//2.将金额制空
		total = 0.0;
	}
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
}
