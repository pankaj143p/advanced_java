package com.pankaj;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebListener("/add")
public class addTwo extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int n1=Integer.parseInt(req.getParameter("num1"));
		int n2=Integer.parseInt(req.getParameter("num2"));
		int result=n1+n2;
//		req.setAttribute("ans", result);
		
//		HttpSession ss = req.getSession();
//		ss.setAttribute("ans", result);
		
		Cookie cookie = new Cookie("ans", result+"");
		res.addCookie(cookie);		
		res.sendRedirect("sq");
		
//	    RequestDispatcher rd = req.getRequestDispatcher("sq");
//	    rd.forward(req, res);
//		PrintWriter out =  res.getWriter();
//		out.println("addition is : "+ result);
//		System.out.println("result : "+result);
	}
}
