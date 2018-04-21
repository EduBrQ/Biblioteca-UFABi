package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.web.model.AnaisCongresso;
import com.web.resources.DbUtil;

public class AnaisCongressoDAO {

	private Connection connection;

	public AnaisCongressoDAO() {
		connection = DbUtil.getConnection();
	}

	public void addAnaisCongresso(AnaisCongresso anaisCongresso) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into anaisCongressos(tipo, nomeCongresso, local) values (?, ?, ?)");
			// Parameters start with 1

			preparedStatement.setString(1, anaisCongresso.getTipo());
			preparedStatement.setString(2, anaisCongresso.getNomeCongresso());
			preparedStatement.setString(3, anaisCongresso.getLocal());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}

	public void deleteAnaisCongresso(int Id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from anaisCongressos where id=?");
			// Parameters start with 1
			preparedStatement.setInt(1, Id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateAnaisCongresso(AnaisCongresso newAnaisCongresso, AnaisCongresso anaisCongresso) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update anaisCongressos set Tipo=?, NomeCongresso=?, Local=?" + "where NomeCongresso=?");
			// Parameters start with 1
			
			preparedStatement.setString(1, newAnaisCongresso.getTipo());
			preparedStatement.setString(2, anaisCongresso.getNomeCongresso());
			preparedStatement.setString(3, newAnaisCongresso.getLocal());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<AnaisCongresso> getAllAnaisCongressos() {
		List<AnaisCongresso> anaisCongressos = new ArrayList<AnaisCongresso>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from anaisCongressos");
			while (rs.next()) {
				AnaisCongresso anaisCongresso = new AnaisCongresso();
				anaisCongresso.setId(rs.getInt("id"));
				anaisCongresso.setTipo(rs.getString("Tipo"));
				anaisCongresso.setNomeCongresso(rs.getString("NomeCongresso"));
				anaisCongresso.setLocal(rs.getString("Local"));
				anaisCongressos.add(anaisCongresso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return anaisCongressos;
	}

	public AnaisCongresso getAnaisCongressoById(int Id) {
		AnaisCongresso anaisCongresso = new AnaisCongresso();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from anaisCongressos where id=?");
			preparedStatement.setInt(1, Id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				anaisCongresso.setId(rs.getInt("id"));
				anaisCongresso.setTipo(rs.getString("Tipo"));
				anaisCongresso.setNomeCongresso(rs.getString("NomeCongresso"));
				anaisCongresso.setLocal(rs.getString("Local"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return anaisCongresso;
	}
}
