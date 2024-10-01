package com.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home")
public class SessionHome extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String  email =(String) session.getAttribute("email");
		
		
		if(email==null)
			req.getRequestDispatcher("SessionLogin.html").forward(req, resp);
		else
			req.getRequestDispatcher("SessionHome.html").forward(req, resp);
	}
	
}
