package com.mindtree.service;

import java.util.List;
import java.util.Set;

import com.mindtree.Exceptions.IdInvalidException;
import com.mindtree.Exceptions.InvalidModelException;
import com.mindtree.entity.Laptop;

public interface Service1 {
	Laptop addLaptop(List<Laptop> laptop, int serialNo, double price, String model, String brand)
			throws IdInvalidException;

	List<String> displayBrands(List<Laptop> laptop);

	List<Laptop> addLaptop1(List<Laptop> laptop, String model) throws InvalidModelException;
}
