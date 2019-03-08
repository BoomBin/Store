package com.itheima.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Category;
import com.itheima.service.CategoryService;
import com.itheima.service.impl.CategoryServiceImpl;
import com.itheima.utils.JsonUtil;


public class CategoryServlet extends BaseServlet {
	
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.条用category查询所有的分类 返回值list
				CategoryService cs = new CategoryServiceImpl();
				List<Category> clist =null;
				try {
					clist = cs.findAll();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//2.将返回值转成json 格式
				//request.setAttribute("clist", clist);
				String json  = JsonUtil.list2json(clist);
				//3.写回法
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().println(json);
		return null;
	}

}
