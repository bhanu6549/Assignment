package com.mindtree.dao;

public interface ServiceDao {

	void insertDb(int portalId, String portalName);

	void sortDb();

	void deleteDb(int portalId);

	void bookTicket(int movieId, String movieName, int price, String portalName, int portalId);

}
