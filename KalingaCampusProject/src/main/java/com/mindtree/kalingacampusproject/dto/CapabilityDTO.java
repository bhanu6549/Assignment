package com.mindtree.kalingacampusproject.dto;

import javax.validation.constraints.NotNull;

public class CapabilityDTO {

	@NotNull(message = "Minds Capabilities Cannot Be Empty")
	
	int noOfCapabilities;

	public CapabilityDTO() {
		super();
		
	}

	public CapabilityDTO( int noOfCapabilities) {
		super();
		this.noOfCapabilities = noOfCapabilities;
	}

	public int getNoOfCapabilities() {
		return noOfCapabilities;
	}

	public void setNoOfCapabilities(int noOfCapabilities) {
		this.noOfCapabilities = noOfCapabilities;
	}
	
	
	
}
