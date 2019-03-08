package com.itheima.myconventer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

public class MyConvebter implements Converter {

	@Override
	public Object convert(Class clazz, Object value) {
		//class 要装成的类型
		//object 页面上传入的值
		
		//将object 转成date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse((String)value);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
