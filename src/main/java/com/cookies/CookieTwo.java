package com.cookies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookietwo")
public class CookieTwo extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie [] cookie = req.getCookies();
		
		for(Cookie cookies : cookie)
		{
			resp.getWriter().print(cookies.getValue());
		}
	}
}
