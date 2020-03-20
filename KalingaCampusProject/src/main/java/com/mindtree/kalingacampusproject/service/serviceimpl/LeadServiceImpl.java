package com.mindtree.kalingacampusproject.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.kalingacampusproject.entity.CampusMinds;
import com.mindtree.kalingacampusproject.entity.Lead;
import com.mindtree.kalingacampusproject.exception.serviceexception.KalingaCampusServiceApplicationException;
import com.mindtree.kalingacampusproject.exception.serviceexception.customexception.LeadAlreadyPresentException;
import com.mindtree.kalingacampusproject.exception.serviceexception.customexception.LeadNotDeletedException;
import com.mindtree.kalingacampusproject.exception.serviceexception.customexception.LeadNotFoundException;
import com.mindtree.kalingacampusproject.repository.LeadRepository;
import com.mindtree.kalingacampusproject.service.LeadService;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired

	private LeadRepository leadrepository;

	@Override
	public Lead addLead(Lead lead) throws KalingaCampusServiceApplicationException {
		/* Add leads */
		if (leadrepository.findByLeadName(lead.getLeadName()).isPresent())
			throw new LeadAlreadyPresentException("Lead Is Already Present");

		leadrepository.save(lead);

		return lead;

	}

	@Override
	public Lead addLeadWithCampusMinds(Lead lead) throws KalingaCampusServiceApplicationException {
		/* Add Lead with campus mind */

		if (leadrepository.findByLeadName(lead.getLeadName()).isPresent())
			throw new LeadAlreadyPresentException("Lead Is Already Present");

//		lead.getCampusminds().forEach(i -> i.setLead(lead));

		for (CampusMinds campusMind : lead.getCampusminds()) {
			campusMind.setLead(lead);
		}

		leadrepository.save(lead);

		return leadrepository.findByLeadName(lead.getLeadName()).get();

	}

	@Override
	public Lead getLeadById(long leadId) throws KalingaCampusServiceApplicationException {
		return leadrepository.findById(leadId).orElseThrow(() -> new LeadNotFoundException("Lead Not Found"));
	}

	/* Get all campusMinds of leads */
	@Override
	public List<Lead> displayAllLeads() throws KalingaCampusServiceApplicationException {
		if (leadrepository.findAll().isEmpty()) {
			throw new LeadNotFoundException("List not found");
		}
		return leadrepository.findAll();
	}

	/* Delete lead with minds */

	@Override
	public void deleteLeads(long leadId) throws KalingaCampusServiceApplicationException {
		Lead lead = leadrepository.findById(leadId).orElseThrow(() -> new LeadNotDeletedException("Leads not deleted"));
		leadrepository.delete(lead);
	}

	/* Sorting lead in desc order according to campus minds */
	@Override
	public List<Lead> sortLeads() throws KalingaCampusServiceApplicationException {

		List<Lead> leads = leadrepository.findAll();
		if(leads.isEmpty()) {
			throw new LeadNotFoundException("List Not Found");
		}
		else {
		for (int x = 0; x < leads.size(); x++) {
			for (int i = 0; i < leads.size() - i; i++) {
				if (leads.get(i).getCampusminds().size() < (leads.get(i + 1).getCampusminds().size())) {
					Lead temp = leads.get(i);
					leads.set(i, leads.get(i + 1));
					leads.set(i + 1, temp);
				}

			}
		}
		}
		return leads;
	}
}
