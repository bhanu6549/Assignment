package com.mindtree.kalingacampusproject.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CampusMinds {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String mindsName;
	
	private int noOfCapabilities;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Lead lead;

	public CampusMinds() {
		super();
		
	}

	public CampusMinds(String mindsName, int noOfCapabilities, Lead lead) {
		super();
		this.mindsName = mindsName;
		this.noOfCapabilities = noOfCapabilities;
		this.lead = lead;
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

	public Lead getLead() {
		return lead;
	}

	public void setLead(Lead lead) {
		this.lead = lead;
	}
	
	
}
