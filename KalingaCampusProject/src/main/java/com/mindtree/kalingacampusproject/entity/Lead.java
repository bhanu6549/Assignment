package com.mindtree.kalingacampusproject.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Lead {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;
	
	private String leadName;
	
	private int noOfMinds;
	
	@OneToMany(mappedBy = "lead", cascade = CascadeType.ALL)
	List<CampusMinds> campusminds ;

	public Lead() {
		super();
		
	}

	public Lead(long id, String leadName, int noOfMinds, List<CampusMinds> campusminds) {
		super();
		this.id = id;
		this.leadName = leadName;
		this.noOfMinds = noOfMinds;
		this.campusminds = campusminds;
	}

	public Lead(String leadName, int noOfMinds, List<CampusMinds> campusminds) {
		super();
		this.leadName = leadName;
		this.noOfMinds = noOfMinds;
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

	public int getNoOfMinds() {
		return noOfMinds;
	}

	public void setNoOfMinds(int noOfMinds) {
		this.noOfMinds = noOfMinds;
	}

	public List<CampusMinds> getCampusminds() {
		return campusminds;
	}

	public void setCampusminds(List<CampusMinds> campusminds) {
		this.campusminds = campusminds;
	}
	
	
}