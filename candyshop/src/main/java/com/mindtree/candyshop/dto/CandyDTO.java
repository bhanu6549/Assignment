package com.mindtree.candyshop.dto;

import javax.validation.constraints.NotNull;

import com.mindtree.candyshop.entity.Shop;

public class CandyDTO {
	private int candyId;
	@NotNull(message = "candy name can not be null")
	private String candyName;
	@NotNull(message = "number of candy can not be null")
	private int noOfCandy;
	private Shop shop;

	public CandyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CandyDTO(int candyId, @NotNull(message = "candy name can not be null") String candyName,
			@NotNull(message = "number of candy can not be null") int noOfCandy, Shop shop) {
		super();
		this.candyId = candyId;
		this.candyName = candyName;
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
