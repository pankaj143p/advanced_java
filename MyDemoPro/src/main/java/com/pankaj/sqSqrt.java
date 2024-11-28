package com.pankaj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet ("/sq")
public class sqSqrt extends HttpServlet {
public void doGet(HttpServletRequest req, HttpServletResponse res ) throws IOException {
//	int result=Integer.parseInt(req.getParameter("result"));
//    HttpSession ss = req.getSession();
//    int result = (int)ss.getAttribute("ans");
	int result = 0;
	Cookie cookies[]= req.getCookies();
	for(Cookie c  : cookies) {
		if(c.getName().equals("ans")) {
			result=Integer.parseInt(c.getValue());
		}
	}
	result*=result;
	PrintWriter out = res.getWriter();
	out.println("hi I'm Pankaj "+result);
	
	System.out.println("sq called");
	
	
  }
}
