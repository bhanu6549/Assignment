package com.mindtree.service.serviceimpl;

import java.util.Comparator;

import com.mindtree.entity.Laptop;

public class PriceComparator implements Comparator<Laptop> {

	@Override
	public int compare(Laptop arg0, Laptop arg1) {
		if (arg0.getPrice() > arg1.getPrice())
			return -1;
		if (arg0.getPrice() < arg0.getPrice())
			return 1;
		else
			return 0;
	}

}
