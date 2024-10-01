package myWebapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/url2")
public class MySecondServlet extends GenericServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		pw.println("Welcom Dude");
		
		RequestDispatcher rd = req.getRequestDispatcher("url3");
		rd.forward(req, res);
		
		
	}
	
	
}
