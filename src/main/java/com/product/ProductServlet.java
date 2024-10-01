package com.product;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet1")
public class ProductServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("pid"));
		String brand = req.getParameter("pbrand");
		double discount = Double.parseDouble(req.getParameter("pdiscount"));
		double price = Double.parseDouble(req.getParameter("pprice"));

		ProductDTO p = new ProductDTO(id, brand, discount, price);

		Data d = new Data();
		try {
			int result = d.insertData(p);
			res.getWriter().println(result + " row has been inserted successfully");
//			req.setAttribute("product", p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
