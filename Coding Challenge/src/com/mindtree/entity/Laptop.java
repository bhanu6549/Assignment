package com.mindtree.entity;

public class Laptop {
	
	private int serialNo;
	private double price;
	private String model;
	private String brand;

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	
	
	public Laptop(int serialNo, double price, String model, String brand) {
		super();
		this.serialNo = serialNo;
		this.price = price;
		this.model = model;
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Laptop [serialNo=" + serialNo + ", price=" + price + ", model=" + model + ", brand=" + brand + "]";
	}

}
