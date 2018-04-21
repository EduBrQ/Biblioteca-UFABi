package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.web.model.Revista;
import com.web.resources.DbUtil;

public class RevistaDAO {

	private Connection connection;

	public RevistaDAO() {
		connection = DbUtil.getConnection();
	}

	public void addRevista(Revista revista) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into revistas(titulo, editora, dataPublicacao, edicao, numPaginas) values (?, ?, ?, ?, ?)");
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

	public void updateRevista(Revista newRevista, Revista revista) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update revistas set titulo=?, editora=?, dataPublicacao=?, edicao=?, numPaginas=?" + "where titulo=?");
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
