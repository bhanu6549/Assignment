package com.mindtree.service;

public interface Service {

	void insert(int portalId, String portalName);

	void bookTicket(int movieId,String movieName, int price, String portalName, int portalId2);

	void delete(int portalId);

	void sort();

}
