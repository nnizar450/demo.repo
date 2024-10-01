package com.product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet2")
public class ProductServlet2 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		
		Data d = new Data();
		try {
			List<ProductDTO> li = d.fetchAll();
			for(ProductDTO p : li)
			{
				res.getWriter().println(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
