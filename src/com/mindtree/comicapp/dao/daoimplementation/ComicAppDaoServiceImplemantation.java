package com.mindtree.comicapp.dao.daoimplementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

import com.mindtree.comicapp.dao.ComicAppDaoService;
import com.mindtree.comicapp.entity.SuperHero;
import com.mindtree.comicapp.entity.Univers;
import com.mindtree.comicapp.exception.dao.ComicAppDaoException;
import com.mindtree.comicapp.util.DBConnection;

public class ComicAppDaoServiceImplemantation implements ComicAppDaoService {

	@Override
	public String addUniversToDB(Univers univers) throws ComicAppDaoException {
		Connection connection = DBConnection.getConnection();

		// String sql = "Insert into univers values(?,?)";
		String sql = "{call insertUnivers(?,?)}";

		int a = 0;
		try {
			// PreparedStatement stmt = connection.prepareStatement(sql);
			CallableStatement stmt = connection.prepareCall(sql);
			stmt.setLong(1, univers.getUniversId());
			stmt.setString(2, univers.getUniversName());

			a = stmt.executeUpdate();
		} catch (SQLException e) {
			throw new ComicAppDaoException("Error while inserting Univers !!!", e);
		} finally {
			DBConnection.closeConnection(connection);
		}

		if (a == 1)
			return "Univers Added Sucessfully !!!";
		else
			return "Insert Query is not excuted !!!";

	}

	@Override
	public boolean validateUnivers(Univers univers) throws ComicAppDaoException {

		Connection connection = DBConnection.getConnection();

		String sql = "{call getUnivers()}";

		// String sql = "select * from univers";
		// PreparedStatement stmt;

		CallableStatement cstmt;

		ResultSet rs = null;
		try {
			cstmt = connection.prepareCall(sql);

			rs = cstmt.executeQuery(sql);

			while (rs.next()) {
				if (rs.getString(2).equalsIgnoreCase(univers.getUniversName())) {
					return false;
				}

			}

		} catch (SQLException e) {
			throw new ComicAppDaoException("Error While validating Univers Name !!!", e);
		} finally {
			DBConnection.closeConnection(connection);
		}
		return true;
	}

	@Override
	public String addSuperHeroToDB(SuperHero superHero) throws ComicAppDaoException {
		Connection connection = DBConnection.getConnection();

		// String sql = "Insert into superhero values(?,?,?,?)";
		String sql = "{call insertSuperHero (?,?,?,null)}";

		int a = 0;
		try {
			CallableStatement cstmt = connection.prepareCall(sql);

			cstmt.setLong(1, superHero.getSuperHeroId());
			cstmt.setString(2, superHero.getSuperHeroName());
			cstmt.setLong(3, superHero.getHp());

			a = cstmt.executeUpdate();

		} catch (SQLException e) {
			throw new ComicAppDaoException("Error while inserting Super hero!!!", e);
		} finally {
			DBConnection.closeConnection(connection);
		}

		if (a == 1)
			return "Super Hero Added Sucessfully !!!";
		else
			return "Insert Query is not excuted !!!";

	}

	@Override
	public boolean validateSuperHero(String superHeroName) throws ComicAppDaoException {

		Connection connection = DBConnection.getConnection();

		String sql = "{call getSuperHero()}";

		// String sql = "select * from superhero";
		// PreparedStatement stmt;

		CallableStatement cstmt;

		ResultSet rs = null;
		try {
			cstmt = connection.prepareCall(sql);

			rs = cstmt.executeQuery(sql);

			while (rs.next()) {
				if (rs.getString(2).equalsIgnoreCase(superHeroName)) {
					return false;
				}

			}

		} catch (SQLException e) {
			throw new ComicAppDaoException("Error While validating SuperHero Name !!!", e);
		} finally {
			DBConnection.closeConnection(connection);
		}
		return true;
	}

	@Override
	public String assignSuperHeroToUniversInDB(String spName, long universId) throws ComicAppDaoException {
		Connection connection = DBConnection.getConnection();

		// String sql = "update superhero set universid=? where spname=?";
		String sql = "{call assignSuperHeroToUnivers(?,?)}";
		int a = 0;
		try {
			// PreparedStatement stmt = connection.prepareStatement(sql);
			CallableStatement stmt = connection.prepareCall(sql);

			stmt.setLong(1, universId);
			stmt.setString(2, spName);

			a = stmt.executeUpdate();

		} catch (SQLException e) {
			throw new ComicAppDaoException("Error while assigning Super hero to Univers !!!", e);
		} finally {
			DBConnection.closeConnection(connection);
		}

		if (a == 1)
			return "Super Hero Successfully assigned to Univers !!!";
		else
			return " Query is not excuted !!!";

	}

	@Override
	public long getUniversId(String universName1) throws ComicAppDaoException {
		Connection connection = DBConnection.getConnection();

		// String sql = "{call getUniversByName(?)}";
		String sql = "select universid from univers where universname IN ('" + universName1 + "')";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			// CallableStatement stmt = connection.prepareCall(sql);

			// stmt.setString(1, universName1);

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				return rs.getLong("universid");
			}
		} catch (SQLException e) {
			throw new ComicAppDaoException("Error while retriving univers id by univers name !!!", e);
		}

		return 0;

	}

	@Override
	public boolean validateUnivers(long universId) throws ComicAppDaoException {
		Connection connection = DBConnection.getConnection();

		String sql = "{call getUnivers()}";

		// String sql = "select * from univers";
		// PreparedStatement stmt;

		ResultSet rs = null;
		try {
			CallableStatement cstmt = connection.prepareCall(sql);

			rs = cstmt.executeQuery(sql);

			while (rs.next()) {
				if (rs.getLong(1) == universId) {
					return true;
				}

			}

		} catch (SQLException e) {
			throw new ComicAppDaoException("Error While getting Univers by id !!!", e);
		} finally {
			DBConnection.closeConnection(connection);
		}
		return false;
	}

	@Override
	public Set<SuperHero> getSuperHeroByUniversName(long universId) throws ComicAppDaoException {
		Connection connection = DBConnection.getConnection();

		Set<SuperHero> superHeros = new LinkedHashSet<SuperHero>();

		// String sql = "select * from superhero where universid IN (" + universId + ")";
		String sql = "call getSuperHeroByUniversName(" + universId + ")";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			//CallableStatement stmt = connection.prepareCall(sql);

			// stmt.setLong(1, universId);

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				SuperHero sHero = new SuperHero(rs.getLong(1), rs.getString(2), rs.getLong(3));

				superHeros.add(sHero);

			}

		} catch (SQLException e) {
			throw new ComicAppDaoException("Error while retriving super hero by univers Id  !!!", e);
		}

		return superHeros;
	}

	@Override
	public String updateSuperHeroHpInDB(String sname, long hp1) throws ComicAppDaoException {
		Connection connection = DBConnection.getConnection();

		String sql = "update superhero set hp=? where spname=?";
		int a = 0;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, hp1);
			stmt.setString(2, sname);

			a = stmt.executeUpdate();

		} catch (SQLException e) {
			throw new ComicAppDaoException("Error while updating super hero HP !!!", e);

		}

		if (a == 1)
			return "Super Hero Hp Successfully Updated !!!";
		else
			return " Update Query is not excuted !!!";
	}

	@Override
	public SuperHero getSuperHeroWithMaxHpByUniversName(long universId) throws ComicAppDaoException {

		Connection connection = DBConnection.getConnection();

		SuperHero superHeros = null;
//		String sql = "select spid, spname, max(hp) as hp from superhero where universid IN (" + universId
//				+ ") group by universid";

		String sql = "{call getSuperHeroMaxHp(" + universId + ")}";
		try {
			// PreparedStatement stmt = connection.prepareStatement(sql);
			CallableStatement stmt = connection.prepareCall(sql);

			// stmt.setLong(1, universId);

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

//				superHeros = new SuperHero(rs.getLong("spid"), rs.getString("spname"), rs.getLong("hp"));
				superHeros = new SuperHero(rs.getLong(1), rs.getString(2), rs.getLong(3));

			}

		} catch (SQLException e) {
			throw new ComicAppDaoException("Error while retriving super hero maximum hP by univers Id  !!!", e);
		}

		return superHeros;

	}

}
