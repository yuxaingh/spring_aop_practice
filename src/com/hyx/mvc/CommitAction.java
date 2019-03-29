package com.hyx.mvc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.hyx.aop.ExecuteInsert;
import com.hyx.aop.UserInterface;

public class CommitAction extends MultiActionController {
	
	private UserInterface myCheckClass;

	public UserInterface getMyCheckClass() {
		return myCheckClass;
	}

	public void setMyCheckClass(UserInterface myCheckClass) {
		this.myCheckClass = myCheckClass;
	}

	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws SQLException,
			ServletException, IOException {
		request.setCharacterEncoding("GBK");
		String username = new String(request.getParameter("username").getBytes("ISO-8859-1"),"GBK");
		String password =  new String(request.getParameter("password").getBytes("ISO-8859-1"),"GBK");
		String realname =  new String(request.getParameter("realname").getBytes("ISO-8859-1"),"GBK");
		String age = request.getParameter("age");
		String tel =request.getParameter("tel");
		String sql="insert into tb_user2 (username,password,realname,age,tel) values('"+username+"','"+password+"','"+realname+"','"+age+"','"+tel+"')";
		System.out.println("...........................");
		myCheckClass.executeInsert(sql);
		System.out.println("...........................");
		myCheckClass.getConn();
		Map<String,String> map = new HashMap<>();
		map.put("msg", "Register successfully.");
		return new ModelAndView("index", map);
	}
}
