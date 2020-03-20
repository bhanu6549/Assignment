package com.mindtree.candyshop.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shopId;

	private String shopName;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "shop")
	private List<Candy> candy;

	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shop(int shopId, String shopName, List<Candy> candy) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.candy = candy;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public List<Candy> getCandy() {
		return candy;
	}

	public void setCandy(List<Candy> candy) {
		this.candy = candy;
	}
}
