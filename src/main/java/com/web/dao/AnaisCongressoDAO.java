package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.web.model.AnaisCongresso;
import com.web.resources.DbUtil;


/**
 * Classe AnaisCongressoDAO responsável criar, 
 * editar mostrar e deletar os anais de crongressos
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */
public class AnaisCongressoDAO {

	private static final Logger logger = LogManager.getLogger(AnaisCongressoDAO.class); 
	
	private void runMe(String parameter){
		
		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		}
		
		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}
		
		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);
		
	}
	
	private Connection connection;

	/**
	 * Instancia a conexão com o banco
	 */
	public AnaisCongressoDAO() {
		this.runMe("AnaisCongressoDAO");
		connection = DbUtil.getConnection();
	}

	/**
	 * Adiciona novo AnaisCongresso
	 * @param anaisCongresso
	 */
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

	/**
	 * Deleta um AnaisCongresso
	 * @param Id
	 * 
	 */
	public void deleteAnaisCongresso(int Id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from anaiscongressos where id=?");
			// Parameters start with 1
			preparedStatement.setInt(1, Id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza um AnaisCongresso
	 * @param newAnaisCongresso
	 * @param anaisCongresso
	 */
	public void updateAnaisCongresso(AnaisCongresso newAnaisCongresso, AnaisCongresso anaisCongresso) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update anaisCongressos set Tipo=?, NomeCongresso=?, Local=?" + "where NomeCongresso=?");
			// Parameters start with 1
			
			preparedStatement.setString(1, newAnaisCongresso.getTipo());
			preparedStatement.setString(2, newAnaisCongresso.getNomeCongresso());
			preparedStatement.setString(3, newAnaisCongresso.getLocal());
			preparedStatement.setString(4, anaisCongresso.getNomeCongresso());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Recupera todos AnaisCongresso
	 * @return
	 */
	public List<AnaisCongresso> getAllAnaisCongressos() {
		List<AnaisCongresso> anaisCongressos = new ArrayList<AnaisCongresso>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from anaiscongressos");
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

	/**
	 * Recupera um AnaisCongresso
	 * @param Id
	 * @return
	 */
	public AnaisCongresso getAnaisCongressoById(int Id) {
		AnaisCongresso anaisCongresso = new AnaisCongresso();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from anaisCongressos where id=?");
			preparedStatement.setInt(1, Id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				anaisCongresso.setId(rs.getInt("id"));
				System.out.println(rs.getString("tipo"));
				anaisCongresso.setTipo(rs.getString("tipo"));
				anaisCongresso.setNomeCongresso(rs.getString("nomeCongresso"));
				anaisCongresso.setLocal(rs.getString("local"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return anaisCongresso;
	}
}
