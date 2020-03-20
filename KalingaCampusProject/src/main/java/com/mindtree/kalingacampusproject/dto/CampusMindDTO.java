package com.mindtree.kalingacampusproject.dto;

import javax.validation.constraints.NotNull;

public class CampusMindDTO {
	private long id;

	@NotNull(message = "Minds Name Cannot Be Empty")
	private String mindsName;

	@NotNull(message = "Minds capabilities Cannot Be Empty")
	
	private int noOfCapabilities;

	public CampusMindDTO() {
		super();
		
	}

	public CampusMindDTO(long id,String mindsName, int noOfCapabilities) {
		super();
		this.id = id;
		this.mindsName = mindsName;
		this.noOfCapabilities = noOfCapabilities;
	}

	public CampusMindDTO( String mindsName,
			 int noOfCapabilities) {
		super();
		this.mindsName = mindsName;
		this.noOfCapabilities = noOfCapabilities;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMindsName() {
		return mindsName;
	}

	public void setMindsName(String mindsName) {
		this.mindsName = mindsName;
	}

	public int getNoOfCapabilities() {
		return noOfCapabilities;
	}

	public void setNoOfCapabilities(int noOfCapabilities) {
		this.noOfCapabilities = noOfCapabilities;
	}
	
	
}
