package com.mindtree.service.serviceimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mindtree.Exceptions.IdInvalidException;
import com.mindtree.Exceptions.InvalidModelException;
import com.mindtree.entity.Laptop;
import com.mindtree.service.Service1;

public class Service2 implements Service1 {

	@Override
	public Laptop addLaptop(List<Laptop> laptop, int serialNo, double price, String model, String brand)
			throws IdInvalidException {
		Laptop p = null;

		for (Laptop f : laptop) {
			if (f.getSerialNo() == (serialNo)) {
				throw new IdInvalidException("Id already exist");
			}
		}
		p = new Laptop(serialNo, price, model, brand);
		return p;
	}

	@Override
	public List<String> displayBrands(List<Laptop> laptop) {
		List<String> brands = new ArrayList<String>();

		for (int i = 0; i < laptop.size(); i++) {
			int count = 1;
			String name = laptop.get(i).getBrand();
			// System.out.println(name);
			for (int j = (i+1); j < laptop.size(); j++) {
				String name1 = laptop.get(j).getBrand();
				if (laptop.get(i).getBrand().equalsIgnoreCase(name)) {
					count++;
					 //System.out.println("cunt"+count);
				}
			
				if (count > 3) {
					brands.add(name1);
					break;
				}}
				
		} 
		if (brands.isEmpty()) {
			System.out.println("No brands have more than three models");

		}
		return brands;
	}

	@Override
	public List<Laptop> addLaptop1(List<Laptop> laptop, String model) throws InvalidModelException {
		List<Laptop> laptop2 = new ArrayList<Laptop>();
		for (Laptop f : laptop) {
			if (f.getModel().equalsIgnoreCase(model)) {
				// System.out.println("hkjhk");
				laptop2.add(f);
			}
		}
		if (laptop2.isEmpty()) {
			throw new InvalidModelException("invalid type of model");
		}

		return laptop2;
	}

}
