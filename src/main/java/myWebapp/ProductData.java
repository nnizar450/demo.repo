package myWebapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/saveproduct")
public class ProductData extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("pid"));
		String brand = req.getParameter("pbrand");
		double discount = Double.parseDouble(req.getParameter("pdiscount"));
		double price = Double.parseDouble(req.getParameter("pprice"));

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql:///mydatabase?user=root&password=5142");
			PreparedStatement pst = con.prepareStatement("insert into product values(?,?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, brand);
			pst.setDouble(3, discount);
			pst.setDouble(4, price);

			int a = pst.executeUpdate();

			res.getWriter().print(a + " row inserted");
			con.close();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

}
