package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.web.model.TrabalhosConclusao;
import com.web.resources.DbUtil;

public class TrabalhoConclusaoDAO {

	private Connection connection;

	public TrabalhoConclusaoDAO() {
		connection = DbUtil.getConnection();
	}

	public void addTrabalhoConclusao(TrabalhosConclusao trabalhoConclusao) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into trabalhoConclusaos(titulo, autor, orientador, tipo, anoDefesa, local) values (?, ?, ?, ?, ?, ?)");
			// Parameters start with 1
			
			preparedStatement.setString(1, trabalhoConclusao.getTitulo());
			preparedStatement.setString(2, trabalhoConclusao.getAutor());
			preparedStatement.setString(3, trabalhoConclusao.getOrientador());
			preparedStatement.setString(4, trabalhoConclusao.getTipo());
			preparedStatement.setInt(5, trabalhoConclusao.getAnoDefesa());
			preparedStatement.setString(6, trabalhoConclusao.getLocal());
		
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}

	public void deleteTrabalhoConclusao(String Titulo) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from trabalhoConclusaos where Titulo=?");
			// Parameters start with 1
			preparedStatement.setString(1, Titulo);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateTrabalhoConclusao(TrabalhosConclusao newTrabalhoConclusao, TrabalhosConclusao trabalhoConclusao) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update trabalhoConclusaos set titulo=?, autor=?, orientador=?, tipo=?, anoDefesa=?, local=?" + "where titulo=?");
			// Parameters start with 1
			
			preparedStatement.setString(1, newTrabalhoConclusao.getTitulo());
			preparedStatement.setString(2, newTrabalhoConclusao.getAutor());
			preparedStatement.setString(3, newTrabalhoConclusao.getOrientador());
			preparedStatement.setString(4, newTrabalhoConclusao.getTipo());
			preparedStatement.setInt(5, newTrabalhoConclusao.getAnoDefesa());
			preparedStatement.setString(6, newTrabalhoConclusao.getLocal());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<TrabalhosConclusao> getAllTrabalhoConclusaos() {
		List<TrabalhosConclusao> trabalhoConclusaos = new ArrayList<TrabalhosConclusao>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from trabalhoConclusaos");
			while (rs.next()) {
				
				TrabalhosConclusao trabalhoConclusao = new TrabalhosConclusao();
				trabalhoConclusao.setId(rs.getInt("id"));
				trabalhoConclusao.setTitulo(rs.getString("Titulo"));
				trabalhoConclusao.setAutor(rs.getString("Autor"));
				trabalhoConclusao.setOrientador(rs.getString("Orientador"));
				trabalhoConclusao.setTipo(rs.getString("Tipo"));
				trabalhoConclusao.setAnoDefesa(rs.getInt("AnoDefesa"));
				trabalhoConclusao.setLocal(rs.getString("Local"));
				
				trabalhoConclusaos.add(trabalhoConclusao);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return trabalhoConclusaos;
	}

	public TrabalhosConclusao getTrabalhoConclusaoById(int Id) {
		TrabalhosConclusao trabalhoConclusao = new TrabalhosConclusao();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from trabalhoConclusaos where id=?");
			preparedStatement.setInt(1, Id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				trabalhoConclusao.setId(rs.getInt("id"));
				trabalhoConclusao.setTitulo(rs.getString("Titulo"));
				trabalhoConclusao.setAutor(rs.getString("Autor"));
				trabalhoConclusao.setOrientador(rs.getString("Orientador"));
				trabalhoConclusao.setTipo(rs.getString("Tipo"));
				trabalhoConclusao.setAnoDefesa(rs.getInt("AnoDefesa"));
				trabalhoConclusao.setLocal(rs.getString("Local"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return trabalhoConclusao;
	}
}
