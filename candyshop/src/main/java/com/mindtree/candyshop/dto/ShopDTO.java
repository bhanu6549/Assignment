package com.mindtree.candyshop.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.mindtree.candyshop.entity.Candy;

public class ShopDTO {
	private int shopId;
	@NotNull(message = "shop name can not be null")
	private String shopName;

	List<Candy> candy;

	public ShopDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShopDTO(int shopId, @NotNull(message = "shop name can not be null") String shopName, List<Candy> candy) {
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
