package com.mindtree.kalingacampusproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.kalingacampusproject.entity.CampusMinds;
@Repository
public interface CampusMindsRepository extends JpaRepository<CampusMinds, Long>{

	Optional<CampusMinds> findByMindsName(String mindsName);

}
