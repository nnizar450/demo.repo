package com.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Data {
	public Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema?user=root&password=5142");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int insertData(ProductDTO p) throws SQLException {

		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("insert into product values(?,?,?,?)");

		pst.setInt(1, p.getId());
		pst.setString(2, p.getBrand());
		pst.setDouble(3, p.getPrice());
		pst.setDouble(4, p.getDiscount());

		return pst.executeUpdate();
	}

	public ProductDTO fetchData(int id) throws SQLException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from product where id = ?");

		pst.setInt(1, id);

		ResultSet rst = pst.executeQuery();

		while (rst.next()) {
			ProductDTO p = new ProductDTO(rst.getInt(1), rst.getString(2), rst.getDouble(3), rst.getDouble(4));

			return p;
		}

		return null;

	}

	public int deleteData(int id) throws SQLException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("delete from product where id = ?");

		pst.setInt(1, id);

		return pst.executeUpdate();
	}

	public List<ProductDTO> fetchAll() throws SQLException {
		Connection con = getConnection();
		Statement st = con.createStatement();

		ResultSet rst = st.executeQuery("select * from product");
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		while (rst.next()) {
			ProductDTO p = new ProductDTO(rst.getInt(1), rst.getString(2), rst.getDouble(3), rst.getDouble(4));
			list.add(p);

		}
		return list;
	}
}
