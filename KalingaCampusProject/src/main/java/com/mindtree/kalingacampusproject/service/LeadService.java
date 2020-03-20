package com.mindtree.kalingacampusproject.service;

import java.util.List;

import com.mindtree.kalingacampusproject.entity.Lead;
import com.mindtree.kalingacampusproject.exception.serviceexception.KalingaCampusServiceApplicationException;

public interface LeadService {

	Lead addLead(Lead clientInputDTOToEntity) throws KalingaCampusServiceApplicationException;

	Lead addLeadWithCampusMinds(Lead lead) throws KalingaCampusServiceApplicationException;

	Lead getLeadById(long leadId) throws KalingaCampusServiceApplicationException;

	List<Lead> displayAllLeads() throws KalingaCampusServiceApplicationException;

	void deleteLeads(long leadId) throws KalingaCampusServiceApplicationException;

	List<Lead> sortLeads() throws KalingaCampusServiceApplicationException;

	

	

}
