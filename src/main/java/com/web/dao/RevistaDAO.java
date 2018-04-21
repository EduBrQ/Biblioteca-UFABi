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

import com.web.model.Revista;
import com.web.resources.DbUtil;

/**
 * Classe RevistaDAO responsável criar, editar mostrar e deletar os anais de
 * crongressos
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */
public class RevistaDAO {

	private Connection connection;

	private static final Logger logger = LogManager.getLogger(RevistaDAO.class);

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

	public RevistaDAO() {
		this.runMe("RevistaDAO");
		connection = DbUtil.getConnection();
	}

	/**
	 * Adiciona Revista
	 * 
	 * @param revista
	 */
	public void addRevista(Revista revista) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into revistas(titulo, editora, dataPublicacao, edicao, numPaginas) values (?, ?, ?, ?, ?)");
			// Parameters start with 1

			preparedStatement.setString(1, revista.getTitulo());
			preparedStatement.setString(2, revista.getEditora());
			preparedStatement.setString(3, revista.getDataPublicacao());
			preparedStatement.setInt(4, revista.getEdicao());
			preparedStatement.setInt(5, revista.getNumPaginas());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deleta Revistas
	 * 
	 * @param Titulo
	 */
	public void deleteRevista(String Titulo) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from revistas where Titulo=?");
			// Parameters start with 1
			preparedStatement.setString(1, Titulo);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza Revistas
	 * 
	 * @param newRevista
	 * @param revista
	 */
	public void updateRevista(Revista newRevista, Revista revista) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update revistas set titulo=?, editora=?, dataPublicacao=?, edicao=?, numPaginas=?"
							+ "where titulo=?");
			// Parameters start with 1

			preparedStatement.setString(1, newRevista.getTitulo());
			preparedStatement.setString(2, newRevista.getEditora());
			preparedStatement.setString(3, newRevista.getDataPublicacao());
			preparedStatement.setInt(4, newRevista.getEdicao());
			preparedStatement.setInt(5, newRevista.getNumPaginas());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retorna todas as revistas
	 * 
	 * @return
	 */
	public List<Revista> getAllRevistas() {
		List<Revista> revistas = new ArrayList<Revista>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from revistas");
			while (rs.next()) {

				Revista revista = new Revista();
				revista.setId(rs.getInt("id"));
				revista.setTitulo(rs.getString("Titulo"));
				revista.setEditora(rs.getString("Editora"));
				revista.setDataPublicacao(rs.getString("DataPublicacao"));
				revista.setEdicao(rs.getInt("Edicao"));
				revista.setNumPaginas(rs.getInt("NumPaginas"));

				revistas.add(revista);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return revistas;
	}

	/**
	 * Recupera uma revista
	 * 
	 * @param Id
	 * @return
	 */
	public Revista getRevistaById(int Id) {
		Revista revista = new Revista();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from revistas where id=?");
			preparedStatement.setInt(1, Id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				revista.setId(rs.getInt("id"));
				revista.setTitulo(rs.getString("Titulo"));
				revista.setEditora(rs.getString("Editora"));
				revista.setDataPublicacao(rs.getString("DataPublicacao"));
				revista.setEdicao(rs.getInt("Edicao"));
				revista.setNumPaginas(rs.getInt("NumPaginas"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return revista;
	}
}
