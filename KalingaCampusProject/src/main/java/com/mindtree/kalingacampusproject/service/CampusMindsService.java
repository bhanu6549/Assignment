package com.mindtree.kalingacampusproject.service;

import com.mindtree.kalingacampusproject.entity.CampusMinds;
import com.mindtree.kalingacampusproject.entity.Lead;
import com.mindtree.kalingacampusproject.exception.serviceexception.KalingaCampusServiceApplicationException;

public interface CampusMindsService {

	CampusMinds addMinds(CampusMinds clientInputDTOToEntity) throws KalingaCampusServiceApplicationException;

	

	CampusMinds addMindsToLead(CampusMinds map, long leadId) throws KalingaCampusServiceApplicationException;



	CampusMinds updateMindsCapability(long mindId, int noOfCapabilities) throws KalingaCampusServiceApplicationException;



	void deleteMinds(long mindId) throws KalingaCampusServiceApplicationException;



	Lead addCampusMindsToLead(Lead dTOToEntity) throws KalingaCampusServiceApplicationException;

}
