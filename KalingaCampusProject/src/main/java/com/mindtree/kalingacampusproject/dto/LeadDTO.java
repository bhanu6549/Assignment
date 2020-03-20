package com.mindtree.kalingacampusproject.dto;

import java.util.List;

import javax.validation.constraints.NotNull;


public class LeadDTO {
	private long id;

	@NotNull(message = "Lead Name Cannot Be Empty")
	private String leadName;
	@NotNull(message = "Minds Cannot Be Empty")
	private int noOfminds;

	private List<CampusMindDTO> campusminds;

	public LeadDTO() {
		super();
		
	}

	public LeadDTO(@NotNull(message = "Lead Name Cannot Be Empty") String leadName,
			@NotNull(message = "Minds Cannot Be Empty") int noOfminds, List<CampusMindDTO> campusminds) {
		super();
		this.leadName = leadName;
		this.noOfminds = noOfminds;
		this.campusminds = campusminds;
	}

	public LeadDTO(long id, @NotNull(message = "Lead Name Cannot Be Empty") String leadName,
			@NotNull(message = "Minds Cannot Be Empty") int noOfminds, List<CampusMindDTO> campusminds) {
		super();
		this.id = id;
		this.leadName = leadName;
		this.noOfminds = noOfminds;
		this.campusminds = campusminds;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLeadName() {
		return leadName;
	}

	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}

	public int getNoOfminds() {
		return noOfminds;
	}

	public void setNoOfminds(int noOfminds) {
		this.noOfminds = noOfminds;
	}

	public List<CampusMindDTO> getCampusminds() {
		return campusminds;
	}

	public void setCampusminds(List<CampusMindDTO> campusminds) {
		this.campusminds = campusminds;
	}

}