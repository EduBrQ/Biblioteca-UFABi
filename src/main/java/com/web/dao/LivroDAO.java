package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.web.model.Livro;
import com.web.resources.DbUtil;

public class LivroDAO {

	private Connection connection;

	public LivroDAO() {
		connection = DbUtil.getConnection();
	}

	public void addLivro(Livro livro) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into livros(isbn, editora, titulo, autores, edicao, anoPublicacao, numPaginas, areaConhecimento) values (?, ?, ?, ?, ?, ?, ?, ?)");
			// Parameters start with 1

			preparedStatement.setString(1, livro.getIsbn());
			preparedStatement.setString(2, livro.getEditora());
			preparedStatement.setString(3, livro.getTitulo());
			preparedStatement.setString(1, livro.getAutores());
			preparedStatement.setInt(1, livro.getEdicao());
			preparedStatement.setInt(1, livro.getAnoPublicacao());
			preparedStatement.setInt(1, livro.getNumPaginas());
			preparedStatement.setString(1, livro.getAreaConhecimento());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}

	public void deleteLivro(String Titulo) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from livros where Titulo=?");
			// Parameters start with 1
			preparedStatement.setString(1, Titulo);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateLivro(Livro newLivro, Livro livro) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update livros set isbn=?, editora=?, titulo=?, autores=?, edicao=?, anoPublicacao=?, numPaginas=?, areaConhecimento=?" + "where titulo=?");
			// Parameters start with 1
			
			preparedStatement.setString(1, newLivro.getIsbn());
			preparedStatement.setString(2, newLivro.getEditora());
			preparedStatement.setString(3, livro.getTitulo());
			preparedStatement.setString(1, newLivro.getAutores());
			preparedStatement.setInt(1, newLivro.getEdicao());
			preparedStatement.setInt(1, newLivro.getAnoPublicacao());
			preparedStatement.setInt(1, newLivro.getNumPaginas());
			preparedStatement.setString(1, newLivro.getAreaConhecimento());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Livro> getAllLivros() {
		List<Livro> livros = new ArrayList<Livro>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from livros");
			while (rs.next()) {
				Livro livro = new Livro();
				livro.setId(rs.getInt("id"));
				livro.setIsbn(rs.getString("Isbn"));
				livro.setEditora(rs.getString("Editora"));
				livro.setTitulo(rs.getString("Titulo"));
				livro.setEdicao(rs.getInt("Edicao"));
				livro.setAnoPublicacao(rs.getInt("AnoPublicacao"));
				livro.setNumPaginas(rs.getInt("NumPaginas"));
				livro.setAreaConhecimento(rs.getString("AreaConhecimento"));
				livro.addAutores(rs.getString("Autores").split(";"));
				livros.add(livro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return livros;
	}

	public Livro getLivroById(int Id) {
		Livro livro = new Livro();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from livros where id=?");
			preparedStatement.setInt(1, Id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				livro.setId(rs.getInt("id"));
				livro.setIsbn(rs.getString("Isbn"));
				livro.setEditora(rs.getString("Editora"));
				livro.setTitulo(rs.getString("Titulo"));
				livro.setEdicao(rs.getInt("Edicao"));
				livro.setAnoPublicacao(rs.getInt("AnoPublicacao"));
				livro.setNumPaginas(rs.getInt("NumPaginas"));
				livro.setAreaConhecimento(rs.getString("AreaConhecimento"));
				livro.addAutores(rs.getString("Autores").split(";"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return livro;
	}
}
