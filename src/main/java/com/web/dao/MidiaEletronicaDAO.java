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

import com.web.model.MidiasEletronicas;
import com.web.resources.DbUtil;


/**
 * Classe MidiaEletronicaDAO responsável criar, 
 * editar mostrar e deletar os anais de crongressos
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */
public class MidiaEletronicaDAO {

	private Connection connection;
	
	private static final Logger logger = LogManager.getLogger(MidiaEletronicaDAO.class); 
	
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

	public MidiaEletronicaDAO() {
		this.runMe("MidiaEletronicaDAO");
		connection = DbUtil.getConnection();
	}

	/**
	 * Adiciona MidiaEletronica
	 * @param midiaEletronica
	 */
	public void addMidiaEletronica(MidiasEletronicas midiaEletronica) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into midiasEletronicas(tipo, titulo, dataGravacao) values (?, ?, ?)");
			// Parameters start with 1

			preparedStatement.setString(1, midiaEletronica.getTipo());
			preparedStatement.setString(2, midiaEletronica.getTitulo());
			preparedStatement.setString(3, midiaEletronica.getDataGravacao());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}

	
	/**
	 * Deleta Mídias Eletrônica
	 * @param Titulo
	 */
	public void deleteMidiaEletronica(MidiasEletronicas midia) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from midiasEletronicas where Titulo=? and DataGravacao=?");
			// Parameters start with 1
			preparedStatement.setString(1, midia.getTitulo());
			preparedStatement.setString(2, midia.getDataGravacao());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza MidiaEletronica
	 * @param newMidiaEletronica
	 * @param midiaEletronica
	 */
	public void updateMidiaEletronica(MidiasEletronicas newMidiaEletronica, MidiasEletronicas midiaEletronica) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update midiasEletronicas set tipo=?, titulo=?, dataGravacao=?" + "where titulo=? and DataGravacao=?");
			// Parameters start with 1
			preparedStatement.setString(1, newMidiaEletronica.getTipo());
			preparedStatement.setString(2, newMidiaEletronica.getTitulo());
			preparedStatement.setString(3, newMidiaEletronica.getDataGravacao());
			preparedStatement.setString(4, midiaEletronica.getTitulo());
			preparedStatement.setString(5, midiaEletronica.getDataGravacao());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Recupera todas as MidiaEletronica
	 * @return
	 */
	public List<MidiasEletronicas> getAllMidiaEletronicas() {
		List<MidiasEletronicas> midiaEletronicas = new ArrayList<MidiasEletronicas>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from midiasEletronicas");
			while (rs.next()) {
				
				MidiasEletronicas midiaEletronica = new MidiasEletronicas();
				midiaEletronica.setId				(rs.getInt("id"));
				midiaEletronica.setTitulo			(rs.getString("Titulo"));
				midiaEletronica.setDataGravacao		(rs.getString("DataGravacao"));
				midiaEletronica.setTipo				(rs.getString("Tipo"));
				
				midiaEletronicas.add(midiaEletronica);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return midiaEletronicas;
	}

	/**
	 * Recupera uma MidiaEletronica
	 * @param Id
	 * @return
	 */
	public MidiasEletronicas getMidiaEletronicaById(int Id) {
		MidiasEletronicas midiaEletronica = new MidiasEletronicas();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from midiasEletronicas where id=?");
			preparedStatement.setInt(1, Id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				midiaEletronica.setId				(rs.getInt("id"));
				midiaEletronica.setTitulo			(rs.getString("Titulo"));
				midiaEletronica.setDataGravacao		(rs.getString("DataGravacao"));
				midiaEletronica.setTipo				(rs.getString("Tipo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return midiaEletronica;
	}
}
