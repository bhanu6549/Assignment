package com.mindtree.kalingacampusproject.controller;


import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.kalingacampusproject.dto.LeadDTO;
import com.mindtree.kalingacampusproject.dto.ResponseBody;
import com.mindtree.kalingacampusproject.entity.Lead;
import com.mindtree.kalingacampusproject.exception.KalingaCampusApplicationException;
import com.mindtree.kalingacampusproject.service.LeadService;


@RestController
public class LeadController {
	@Autowired
	private LeadService leadservice;

	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/leads")
	public ResponseEntity<?> addLead(@Valid @RequestBody LeadDTO lead) throws KalingaCampusApplicationException {
		
		
		
		Lead clientInputDTOToEntity=modelMapper.map(lead,Lead.class);
		Lead serviceOutputEntity=leadservice.addLead(clientInputDTOToEntity);
		LeadDTO outputStoreDTOToSend=modelMapper.map(serviceOutputEntity,LeadDTO.class);
		return new ResponseEntity<ResponseBody<LeadDTO>>(new ResponseBody<LeadDTO>(outputStoreDTOToSend,null,"Lead Added Successfully",true),HttpStatus.OK);
		
	
}
	
	@PostMapping("/lead")
	public ResponseEntity<?> addLeadWithCampusMinds(@Valid @RequestBody LeadDTO lead) throws KalingaCampusApplicationException {
		Lead clientInputDTOToEntity=modelMapper.map(lead,Lead.class);
		Lead serviceOutputEntity=leadservice.addLeadWithCampusMinds(clientInputDTOToEntity);
		LeadDTO outputStoreDTOToSend=modelMapper.map(serviceOutputEntity,LeadDTO.class);
		return new ResponseEntity<ResponseBody<LeadDTO>>(new ResponseBody<LeadDTO>(outputStoreDTOToSend,null,"Lead Added Successfully",true),HttpStatus.OK);
		
	}
	
	@GetMapping("/leads")
	public ResponseEntity<?> displayAllLeads() throws KalingaCampusApplicationException {
		return new ResponseEntity<ResponseBody<List<LeadDTO>>>(new ResponseBody<List<LeadDTO>>(
				modelMapper.map(leadservice.displayAllLeads(), new TypeToken<List<LeadDTO>>() {
				}.getType()), null, "Lead List Found", true), HttpStatus.OK);
	}
	
	
	@GetMapping("/display")
	public ResponseEntity<?> sortLeads() throws KalingaCampusApplicationException {
		return new ResponseEntity<ResponseBody<List<LeadDTO>>>(new ResponseBody<List<LeadDTO>>(
				modelMapper.map(leadservice.sortLeads(), new TypeToken<List<LeadDTO>>() {
				}.getType()), null, "Lead List arranged in ascending order according to campus minds", true), HttpStatus.OK);	
		
	}
	
	
	
	@DeleteMapping("/leads/{leadId}")
	public ResponseEntity<?> deleteLeads(@PathVariable long leadId) throws KalingaCampusApplicationException {
		leadservice.deleteLeads(leadId);
		return new ResponseEntity<ResponseBody<Void>>(
				new ResponseBody<Void>(null, null, "Leads Successfuly Deleted", true), HttpStatus.OK);
}
}