package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.web.model.MidiasEletronicas;
import com.web.resources.DbUtil;

public class MidiaEletronicaDAO {

	private Connection connection;

	public MidiaEletronicaDAO() {
		connection = DbUtil.getConnection();
	}

	public void addMidiaEletronica(MidiasEletronicas midiaEletronica) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into midiaEletronicas(tipo, titulo, dataGravacao) values (?, ?, ?)");
			// Parameters start with 1

			preparedStatement.setString(1, midiaEletronica.getTipo());
			preparedStatement.setString(2, midiaEletronica.getTitulo());
			preparedStatement.setString(3, midiaEletronica.getDataGravacao());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}

	public void deleteMidiaEletronica(String Titulo) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from midiaEletronicas where Titulo=?");
			// Parameters start with 1
			preparedStatement.setString(1, Titulo);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateMidiaEletronica(MidiasEletronicas newMidiaEletronica, MidiasEletronicas midiaEletronica) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update midiaEletronicas set tipo=?, titulo=?, dataGravacao=?" + "where titulo=?");
			// Parameters start with 1
			

			preparedStatement.setString(1, newMidiaEletronica.getTipo());
			preparedStatement.setString(2, newMidiaEletronica.getTitulo());
			preparedStatement.setString(3, newMidiaEletronica.getDataGravacao());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<MidiasEletronicas> getAllMidiaEletronicas() {
		List<MidiasEletronicas> midiaEletronicas = new ArrayList<MidiasEletronicas>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from midiaEletronicas");
			while (rs.next()) {
				
				MidiasEletronicas midiaEletronica = new MidiasEletronicas();
				
				midiaEletronica.setId(rs.getInt("id"));
				midiaEletronica.setTitulo(rs.getString("Titulo"));
				midiaEletronica.setDataGravacao(rs.getString("DataGravacao"));
				
				midiaEletronicas.add(midiaEletronica);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return midiaEletronicas;
	}

	public MidiasEletronicas getMidiaEletronicaById(int Id) {
		MidiasEletronicas midiaEletronica = new MidiasEletronicas();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from midiaEletronicas where Titulo=?");
			preparedStatement.setInt(1, Id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				midiaEletronica.setId(rs.getInt("id"));
				midiaEletronica.setTitulo(rs.getString("Titulo"));
				midiaEletronica.setDataGravacao(rs.getString("DataGravacao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return midiaEletronica;
	}
}
