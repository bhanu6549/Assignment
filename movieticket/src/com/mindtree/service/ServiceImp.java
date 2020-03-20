package com.mindtree.service;

import com.mindtree.dao.ServiceDao;
import com.mindtree.dao.ServiceDaoImp;

public class ServiceImp implements Service {
	ServiceDao dao = new ServiceDaoImp();

	@Override
	public void insert(int portalId, String portalName) {
		dao.insertDb(portalId, portalName);

	}

	@Override
	public void delete(int portalId) {
		dao.deleteDb(portalId);

	}

	@Override
	public void sort() {
		dao.sortDb();

	}

	@Override
	public void bookTicket(int movieId, String movieName, int price, String portalName, int portalId) {
		dao.bookTicket(movieId, movieName, price, portalName, portalId);

	}

}
