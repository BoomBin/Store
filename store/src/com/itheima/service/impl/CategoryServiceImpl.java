package com.itheima.service.impl;

import java.io.InputStream;
import java.util.List;

import com.itheima.dao.CategoryDao;
import com.itheima.dao.impl.CategoryDaoImpl;
import com.itheima.domain.Category;
import com.itheima.service.CategoryService;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CategoryServiceImpl implements CategoryService {
	/**
	 * 查询所有的分类
	 */
	@Override
	public List<Category> findAll() throws Exception {
		//1创建缓存管理器
		CacheManager cm = CacheManager.create(CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml"));
		//2获取指定的缓存
		Cache cache = cm.getCache("categoryCache");
		//3通过缓存获取数值,将cache看成是一个map集合
		Element element = cache.get("clist");
		List<Category> list =null;
		//4判断数据
		if(element==null) {
			//从数据库中获取
			CategoryDao cd = new CategoryDaoImpl();
			list = cd.findAll();
			//将list放入缓存
			cache.put(new Element("clist",list));
			System.out.println("缓存中没有数据，已去数据库中获取");
		}else {
			//直接返回
			list = (List<Category>)element.getObjectValue();
			
			System.out.println("缓存中有数据");
		}
		
		return list;
	}
	public static void main(String[] args) {
		InputStream is = CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml");
		System.out.println(is);
	}
}
