package com.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class SessionLogin extends HttpServlet{
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("username");
		String pass = req.getParameter("password");
		
		if(email.equals("abc@gmail.com") && pass.equals("abc123"))
		{
			HttpSession session = req.getSession();
			session.setAttribute("email", email);
			req.getRequestDispatcher("SessionHome.html").forward(req, resp);
		}
		else
			req.getRequestDispatcher("SessionLogin.html").forward(req, resp);
	}
}
