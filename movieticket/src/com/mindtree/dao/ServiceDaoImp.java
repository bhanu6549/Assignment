package com.mindtree.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mindtree.utility.JdbcConnection;

public class ServiceDaoImp implements ServiceDao {

	@Override
	public void insertDb(int portalId, String portalName) {
		Connection con = JdbcConnection.getConnection();
		 CallableStatement stmt = null;
		 String sql = "{call getPortalEntry (?, ?)}";

		try {
			stmt = con.prepareCall(sql);
			stmt.setInt(1, portalId);                                                            
			stmt.setString(2, portalName);
			stmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void sortDb() {
		Connection con = JdbcConnection.getConnection();
		String sql1 = "select * from  movie order by price desc";
		try {
			PreparedStatement pt = con.prepareStatement(sql1);
			ResultSet rs = pt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(2) + " " + rs.getString(4) + " " + rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteDb(int portalId) {
		Connection con = JdbcConnection.getConnection();
		String sql3 = "delete from portal where portalId=?";
		try {
			PreparedStatement stm = con.prepareStatement(sql3);
			ResultSet rs = stm.executeQuery(sql3);
			if (rs.next()) {
				System.out.println("deleted");

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	@Override
	public void bookTicket(int movieId, String movieName, int price, String portalName, int portalId) {
		Connection con = JdbcConnection.getConnection();
		String sql4 = "insert into movie values(?,?,?,?,?)";
		try {
			PreparedStatement pt = con.prepareStatement(sql4);
			pt.setInt(1, movieId);
			pt.setString(2, movieName);
			pt.setInt(3, price);
			pt.setString(4, portalName);
			pt.setInt(5, portalId);
			pt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
