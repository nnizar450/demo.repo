package myWebapp;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/s1")
public class StudentServlet1 extends GenericServlet{
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String email = req.getParameter("semail");
		String password = req.getParameter("spassword");
		
		req.setAttribute("email", email);
		req.setAttribute("password", password);
		
		req.getRequestDispatcher("s2").forward(req, res);

		
	}
	
	
}
