package com.mindtree.kalingacampusproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.kalingacampusproject.entity.Lead;
@Repository
public interface LeadRepository extends JpaRepository<Lead, Long>{

	Optional<Lead> findByLeadName(String leadName);

}
