package com.product;

public class ProductDTO {
	private int id;
	private String brand;
	private double price;
	private double discount;

	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}
	public String getBrand() {
		return brand;
	}

//	public void setBrand(String brand) {
//		this.brand = brand;
//	}
	public double getPrice() {
		return price;
	}

//	public void setPrice(double price) {
//		this.price = price;
//	}
	public double getDiscount() {
		return discount;
	}
//	public void setDiscount(double discount) {
//		this.discount = discount;
//	}

	public ProductDTO(int id, String brand, double price, double discount) {
		super();
		this.id = id;
		this.brand = brand;
		this.price = price;
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Product id= " + id + "" + "\nbrand= " + brand + "\nprice= " + price + "\ndiscount= " + discount + "";
	}
}
