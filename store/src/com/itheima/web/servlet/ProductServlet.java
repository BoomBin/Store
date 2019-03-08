package com.itheima.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.service.impl.ProductServiceImpl;


public class ProductServlet extends BaseServlet {
	private static final long seriaVersionUID = 1L;
	/**
	 * 通过ID查询单个商品详情
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	public String getById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.获取商品的ID
		String pid = request.getParameter("pid");
		//2.调用service
		ProductService ps = new ProductServiceImpl();
		Product p = ps.getByPid(pid);
		//3.将结果放入request域中
		request.setAttribute("bean", p);
		return "/jsp/product_info.jsp";
	}
	/**
	 * 分页查询数据
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String findByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.获取类别和当前页，设置一个pagesize
		String cid = request.getParameter("cid");
		int currPage = Integer.parseInt(request.getParameter("currPage"));
		int pageSize = 12;
		//2.调用service,返回pagebean
		ProductService ps = new ProductServiceImpl();
		PageBean<Product> bean = ps.findByPage(currPage,pageSize,cid);
		//3.将结果放入request域中
		request.setAttribute("pb", bean);
		return "/jsp/product_list.jsp";
	}
}
