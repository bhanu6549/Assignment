package com.mindtree.candyshop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Candy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int candyId;

	private String candyName;
	private double price;
	private int noOfCandy;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Shop shop;

	public Candy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Candy(int candyId, String candyName, double price, int noOfCandy, Shop shop) {
		super();
		this.candyId = candyId;
		this.candyName = candyName;
		this.price = price;
		this.noOfCandy = noOfCandy;
		this.shop = shop;
	}

	public int getCandyId() {
		return candyId;
	}

	public void setCandyId(int candyId) {
		this.candyId = candyId;
	}

	public String getCandyName() {
		return candyName;
	}

	public void setCandyName(String candyName) {
		this.candyName = candyName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNoOfCandy() {
		return noOfCandy;
	}

	public void setNoOfCandy(int noOfCandy) {
		this.noOfCandy = noOfCandy;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
}
