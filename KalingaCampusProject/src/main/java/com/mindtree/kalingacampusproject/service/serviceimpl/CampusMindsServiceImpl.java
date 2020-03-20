package com.mindtree.kalingacampusproject.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.kalingacampusproject.entity.CampusMinds;
import com.mindtree.kalingacampusproject.entity.Lead;
import com.mindtree.kalingacampusproject.exception.serviceexception.KalingaCampusServiceApplicationException;
import com.mindtree.kalingacampusproject.exception.serviceexception.customexception.CampusMindsNotFoundexception;
import com.mindtree.kalingacampusproject.exception.serviceexception.customexception.LeadAlreadyPresentException;
import com.mindtree.kalingacampusproject.exception.serviceexception.customexception.MindsAlreadyPresentException;
import com.mindtree.kalingacampusproject.repository.CampusMindsRepository;
import com.mindtree.kalingacampusproject.repository.LeadRepository;
import com.mindtree.kalingacampusproject.service.CampusMindsService;
import com.mindtree.kalingacampusproject.service.LeadService;
@Service
public class CampusMindsServiceImpl implements CampusMindsService{
  
@Autowired
private CampusMindsRepository campusmindsrepository;

@Autowired
private LeadService leadservice;

@Autowired
private LeadRepository leadrepository;

@Override
/*Add Campus Minds*/
public CampusMinds addMinds(CampusMinds minds) throws KalingaCampusServiceApplicationException {
	if (campusmindsrepository.findByMindsName(minds.getMindsName()).
			  isPresent()) throw new
			  MindsAlreadyPresentException("Minds Is Already Present");
	
	return campusmindsrepository.save(minds);
}



	/*Add Campus Minds to Leads*/


@Override
public CampusMinds addMindsToLead(CampusMinds minds, long leadId) throws KalingaCampusServiceApplicationException {
	Lead lead = leadservice.getLeadById(leadId); 
	if (campusmindsrepository.findByMindsName(minds.getMindsName()).isPresent())
		throw new   MindsAlreadyPresentException("Minds Is Already Present");
	minds.setLead(lead);
	campusmindsrepository.save(minds);
	return campusmindsrepository.findByMindsName(minds.getMindsName()).get();
}


/*Update number of capabilities*/
@Override
public CampusMinds updateMindsCapability(long mindId, int noOfCapabilities) throws KalingaCampusServiceApplicationException {
	CampusMinds minds=campusmindsrepository.findById(mindId).orElseThrow(()-> new CampusMindsNotFoundexception("Mindid Is not Found"));
	minds.setNoOfCapabilities(noOfCapabilities);
	return campusmindsrepository.save(minds);
}


/*Delete Campus Minds*/
@Override
public void deleteMinds(long mindId) throws KalingaCampusServiceApplicationException {
	CampusMinds minds=campusmindsrepository.findById(mindId).orElseThrow(()->new CampusMindsNotFoundexception("Mind Not Deleted") );
	
	campusmindsrepository.delete(minds);
}


/*Other approach to add campusminds to lead where name minds cannot be duplicated in other leads*/
@Override
public Lead addCampusMindsToLead(Lead lead) throws KalingaCampusServiceApplicationException {
	String campusMindsWhichAlreadyExists="Campus Minds With Name(s)";
	
boolean error=false;
Lead existingLead=null;
if(!leadrepository.findByLeadName(lead.getLeadName()).isPresent()) {
	throw new LeadAlreadyPresentException("Lead with Same Name Does Npot Exists");
}
else {
	existingLead=	leadrepository.findByLeadName(lead.getLeadName()).get();
}
for (CampusMinds minds : lead.getCampusminds()) {
	if(campusmindsrepository.findByMindsName(minds.getMindsName()).isPresent()) {
		campusMindsWhichAlreadyExists +=" "+minds.getMindsName() +", ";
		error=true;
	}
	else {
		minds.setLead(existingLead);
		campusmindsrepository.save(minds);
	}
	
}
if(error) {
	throw new MindsAlreadyPresentException(campusMindsWhichAlreadyExists +"Already Exists In Database");
}
else {
	return leadrepository.findByLeadName(lead.getLeadName()).get();
}

}

}
