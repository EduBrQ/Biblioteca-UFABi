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

import com.web.model.Livro;
import com.web.resources.DbUtil;

/**
 * Classe LivroDAO responsável criar, 
 * editar mostrar e deletar os anais de crongressos
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */
public class LivroDAO {

	private Connection connection;
	
	private static final Logger logger = LogManager.getLogger(LivroDAO.class); 
	
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

	public LivroDAO() {
		this.runMe("LivroDAO");
		connection = DbUtil.getConnection();
	}

	/** Adiciona um livro
	 * @param livro
	 */
	public void addLivro(Livro livro) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into livros(isbn, editora, titulo, autores, edicao, anoPublicacao, numPaginas, areaConhecimento, tema) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			// Parameters start with 1

			preparedStatement.setString			(1, livro.getIsbn());
			preparedStatement.setString			(2, livro.getEditora());
			preparedStatement.setString			(3, livro.getTitulo());
			preparedStatement.setString			(4, livro.getAutores());
			preparedStatement.setInt			(5, livro.getEdicao());
			preparedStatement.setInt			(6, livro.getAnoPublicacao());
			preparedStatement.setInt			(7, livro.getNumPaginas());
			preparedStatement.setString			(8, livro.getAreaConhecimento());
			preparedStatement.setString			(9, livro.getTema());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}

	/**
	 * Deleta um livro
	 * @param Titulo
	 */
	public void deleteLivro(Livro livro) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from livros where Titulo=? and Edicao=?");
			// Parameters start with 1
			preparedStatement.setString		(1, livro.getTitulo());
			preparedStatement.setInt		(2, livro.getEdicao());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza os livros
	 * @param newLivro
	 * @param livro
	 */
	public void updateLivro(Livro newLivro, Livro livro) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update livros set isbn=?, editora=?, titulo=?, autores=?, edicao=?, anoPublicacao=?, numPaginas=?, areaConhecimento=?, tema=?" + "where titulo=? and edicao=?");
			// Parameters start with 1
			
			preparedStatement.setString		(1, newLivro.getIsbn());
			preparedStatement.setString		(2, newLivro.getEditora());
			preparedStatement.setString		(3, newLivro.getTitulo());
			preparedStatement.setString		(4, newLivro.getAutores());
			preparedStatement.setInt		(5, newLivro.getEdicao());
			preparedStatement.setInt		(6, newLivro.getAnoPublicacao());
			preparedStatement.setInt		(7, newLivro.getNumPaginas());
			preparedStatement.setString		(8, newLivro.getAreaConhecimento());
			preparedStatement.setString		(9, newLivro.getTema());
			preparedStatement.setString		(10, livro.getTitulo());
			preparedStatement.setInt		(11, livro.getEdicao());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Recupera todos os livros
	 * @return
	 */
	public List<Livro> getAllLivros() {
		List<Livro> livros = new ArrayList<Livro>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from livros");
			while (rs.next()) {
				Livro livro = new Livro();
				livro.setId						(rs.getInt("id"));
				livro.setIsbn					(rs.getString("Isbn"));
				livro.setEditora				(rs.getString("Editora"));
				livro.setTitulo					(rs.getString("Titulo"));
				livro.addAutores				(rs.getString("Autores").split(";"));
				livro.setEdicao					(rs.getInt("Edicao"));
				livro.setAnoPublicacao			(rs.getInt("AnoPublicacao"));
				livro.setNumPaginas				(rs.getInt("NumPaginas"));
				livro.setAreaConhecimento		(rs.getString("AreaConhecimento"));
				livro.setTema					(rs.getString("Tema"));
				
				livros.add(livro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return livros;
	}

	/**
	 * Recupera um livro especifíco
	 * @param Id
	 * @return
	 */
	public Livro getLivroById(int Id) {
		Livro livro = new Livro();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from livros where id=?");
			preparedStatement.setInt(1, Id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				livro.setId						(rs.getInt("id"));
				livro.setIsbn					(rs.getString("Isbn"));
				livro.setEditora				(rs.getString("Editora"));
				livro.setTitulo					(rs.getString("Titulo"));
				livro.addAutores				(rs.getString("Autores").split(";"));
				livro.setEdicao					(rs.getInt("Edicao"));
				livro.setAnoPublicacao			(rs.getInt("AnoPublicacao"));
				livro.setNumPaginas				(rs.getInt("NumPaginas"));
				livro.setAreaConhecimento		(rs.getString("AreaConhecimento"));
				livro.setTema					(rs.getString("Tema"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return livro;
	}
}
