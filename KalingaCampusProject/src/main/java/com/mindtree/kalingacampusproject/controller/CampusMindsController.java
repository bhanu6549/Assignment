package com.mindtree.kalingacampusproject.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.kalingacampusproject.dto.CampusMindDTO;
import com.mindtree.kalingacampusproject.dto.CapabilityDTO;
import com.mindtree.kalingacampusproject.dto.LeadDTO;
import com.mindtree.kalingacampusproject.dto.ResponseBody;
import com.mindtree.kalingacampusproject.entity.CampusMinds;
import com.mindtree.kalingacampusproject.entity.Lead;
import com.mindtree.kalingacampusproject.exception.KalingaCampusApplicationException;
import com.mindtree.kalingacampusproject.exception.serviceexception.KalingaCampusServiceApplicationException;
import com.mindtree.kalingacampusproject.service.CampusMindsService;

@RestController
public class CampusMindsController {
	@Autowired
	private CampusMindsService campusmindsservice;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/minds")
	public ResponseEntity<?> addMinds(@Valid @RequestBody CampusMindDTO minds)
			throws KalingaCampusApplicationException {

		CampusMinds clientInputDTOToEntity = modelMapper.map(minds, CampusMinds.class);
		CampusMinds serviceOutputEntity = campusmindsservice.addMinds(clientInputDTOToEntity);
		CampusMindDTO outputStoreDTOToSend = modelMapper.map(serviceOutputEntity, CampusMindDTO.class);
		return new ResponseEntity<ResponseBody<CampusMindDTO>>(
				new ResponseBody<CampusMindDTO>(outputStoreDTOToSend, null, "Campus Minds Added Successfully", true),
				HttpStatus.OK);

	}

	@PostMapping("/minds/{leadId}")
	public ResponseEntity<?> addMindsToLead(@PathVariable long leadId, @Valid @RequestBody CampusMindDTO minds)
			throws KalingaCampusApplicationException {

		return new ResponseEntity<ResponseBody<CampusMindDTO>>(new ResponseBody<CampusMindDTO>(
				modelMapper.map(campusmindsservice.addMindsToLead(modelMapper.map(minds, CampusMinds.class), leadId),
						CampusMindDTO.class),
				null, "Minds Added To Lead Successfully", true), HttpStatus.OK);
	}

	@PutMapping("/minds/{mindId}")
	public ResponseEntity<?> updateMindsCapability(@PathVariable long mindId,
			@Valid @RequestBody CapabilityDTO capability) throws KalingaCampusApplicationException {

		return new ResponseEntity<ResponseBody<CampusMindDTO>>(new ResponseBody<CampusMindDTO>(
				modelMapper.map(campusmindsservice.updateMindsCapability(mindId, capability.getNoOfCapabilities()),
						CampusMindDTO.class),
				null, "Minds Capabilities Updated Successfully", true), HttpStatus.OK);

	}
	
	@DeleteMapping("/minds/{mindId}")
	public ResponseEntity<?> deleteMinds(@PathVariable long mindId) throws KalingaCampusApplicationException {
		campusmindsservice.deleteMinds(mindId);
		return new ResponseEntity<ResponseBody<Void>>(
				new ResponseBody<Void>(null, null, "Minds Successfuly Deleted", true), HttpStatus.OK);
	}
	
	/*Other approach to add campusminds to lead where name minds cannot be duplicated in other leads*/
	
	@PostMapping("/campusminds")
	public ResponseEntity<?> addCampusMindsToLead(@Valid @RequestBody LeadDTO leads) throws KalingaCampusServiceApplicationException
			 {
		
		Lead DTOToEntity=modelMapper.map(leads,Lead.class);
		Lead OutputOfService=campusmindsservice.addCampusMindsToLead(DTOToEntity);
		LeadDTO entityToDTO=modelMapper.map(OutputOfService,LeadDTO.class);
		return new ResponseEntity<ResponseBody<LeadDTO>>(new ResponseBody<LeadDTO>(entityToDTO,null,"Campus Minds Added Successfully",true),HttpStatus.OK);
	
	}
}