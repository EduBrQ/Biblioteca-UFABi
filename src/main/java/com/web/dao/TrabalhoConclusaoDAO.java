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

import com.web.model.TrabalhosConclusao;
import com.web.resources.DbUtil;

/**
 * Classe TrabalhoConclusaoDAO responsável criar, 
 * editar mostrar e deletar os anais de crongressos
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */
public class TrabalhoConclusaoDAO {

	private Connection connection;
	
	private static final Logger logger = LogManager.getLogger(TrabalhoConclusaoDAO.class);

	private void runMe(String parameter) {

		if (logger.isDebugEnabled()) {
			logger.debug("This is debug : " + parameter);
		}

		if (logger.isInfoEnabled()) {
			logger.info("This is info : " + parameter);
		}

		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);

	}

	public TrabalhoConclusaoDAO() {
		this.runMe("TrabalhoConclusaoDAO");
		connection = DbUtil.getConnection();
	}

	/**Adiciona um TrabalhosConclusao
	 * @param trabalhoConclusao
	 */
	public void addTrabalhoConclusao(TrabalhosConclusao trabalhoConclusao) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into trabalhosConclusao(tipo, local, titulo, autor, orientador, anoDefesa) values (?, ?, ?, ?, ?, ?)");
			// Parameters start with 1
			
			preparedStatement.setString		(1, trabalhoConclusao.getTipo());
			preparedStatement.setString		(2, trabalhoConclusao.getLocal());
			preparedStatement.setString		(3, trabalhoConclusao.getTitulo());
			preparedStatement.setString		(4, trabalhoConclusao.getAutor());
			preparedStatement.setString		(5, trabalhoConclusao.getOrientador());
			preparedStatement.setInt		(6, trabalhoConclusao.getAnoDefesa());
		
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}

	/**
	 * Deleta um TrabalhoConclusao
	 * @param Titulo
	 */
	public void deleteTrabalhoConclusao(TrabalhosConclusao trabalho) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from trabalhosConclusao where Titulo=? and Autor=?");
			// Parameters start with 1
			preparedStatement.setString(1, trabalho.getTitulo());
			preparedStatement.setString(2, trabalho.getAutor());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza um TrabalhoConclusao
	 * @param newTrabalhoConclusao
	 * @param trabalhoConclusao
	 */
	public void updateTrabalhoConclusao(TrabalhosConclusao newTrabalhoConclusao, TrabalhosConclusao trabalhoConclusao) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update trabalhosConclusao set titulo=?, autor=?, orientador=?, tipo=?, anoDefesa=?, local=? where Titulo=? and Autor=?");
			// Parameters start with 1
			
			preparedStatement.setString		(1, newTrabalhoConclusao.getTitulo());
			preparedStatement.setString		(2, newTrabalhoConclusao.getAutor());
			preparedStatement.setString		(3, newTrabalhoConclusao.getOrientador());
			preparedStatement.setString		(4, newTrabalhoConclusao.getTipo());
			preparedStatement.setInt		(5, newTrabalhoConclusao.getAnoDefesa());
			preparedStatement.setString		(6, newTrabalhoConclusao.getLocal());
			preparedStatement.setString		(7, trabalhoConclusao.getTitulo());
			preparedStatement.setString		(8, trabalhoConclusao.getAutor());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retorna todos TrabalhoConclusao
	 * @return
	 */
	public List<TrabalhosConclusao> getAllTrabalhoConclusaos() {
		List<TrabalhosConclusao> trabalhoConclusaos = new ArrayList<TrabalhosConclusao>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from trabalhosConclusao");
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

	/**Retorna um TrabalhoConclusao
	 * @param Id
	 * @return
	 */
	public TrabalhosConclusao getTrabalhoConclusaoById(int Id) {
		TrabalhosConclusao trabalhoConclusao = new TrabalhosConclusao();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from trabalhosConclusao where id=?");
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
