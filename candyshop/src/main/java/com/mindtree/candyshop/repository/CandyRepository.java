package com.mindtree.candyshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.candyshop.entity.Candy;

@Repository
public interface CandyRepository extends JpaRepository<Candy, Integer> {
	public Optional<Candy> findByCandyName(String candyName);
}
