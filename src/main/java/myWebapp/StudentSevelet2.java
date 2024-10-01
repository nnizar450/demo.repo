package myWebapp;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/s2")
public class StudentSevelet2 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String email =(String)req.getAttribute("email");
		String password= (String)req.getAttribute("password");
		
		res.getWriter().println("Email: "+email+"Password: "+password);
		
		
	}
	
	
}
