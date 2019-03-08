package com.itheima.dao;

import java.util.List;

import com.itheima.domain.Product;

public interface ProductDao {

	List<Product> findnew() throws Exception;

	List<Product> findHot()throws Exception;

	Product getByPid(String pid) throws Exception;

	List<Product> findByPage(int currPage, int pageSize, String cid) throws Exception;

	int getTotalCount(String cid) throws Exception;

}
