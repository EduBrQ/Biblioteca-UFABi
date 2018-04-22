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

import com.web.model.Curso;
import com.web.resources.DbUtil;

/**
 * Classe CursoDAO responsável criar, 
 * editar mostrar e deletar os anais de crongressos
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */
public class CursoDAO {

	private Connection connection;
	
	private static final Logger logger = LogManager.getLogger(CursoDAO.class); 
	
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

	public CursoDAO() {
		this.runMe("CursoDAO");
		connection = DbUtil.getConnection();
	}

	/**
	 * Adciona  um novo curso
	 * @param curso
	 */
	public void addCurso(Curso curso) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into cursos(nome, area, nivel, sigla) values (?, ?, ?, ?)");
			// Parameters start with 1

			preparedStatement.setString(1, curso.getNome());
			preparedStatement.setString(2, curso.getArea());
			preparedStatement.setString(3, curso.getNivel());
			preparedStatement.setString(4, curso.getSigla());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}

	/**
	 * Deleta um curso se for admin ou root
	 * @param nome
	 * @param nivelAcesso
	 */
	public void deleteCurso(Curso curso, int nivelAcesso) {
		/* Sprint2 - Colocando nivel de acesso para efetuar a operação
		 * Niveis:
		 * 0 - root
		 * 1 - admin
		 * 2 - user
		 * */
		if(nivelAcesso == 0 || nivelAcesso == 1) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("delete from cursos where nome=?");
				// Parameters start with 1
				preparedStatement.setString(1, curso.getNome());
				preparedStatement.executeUpdate();
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			throw new IllegalAccessError("Você não possui permissão para esta operação!");
		}
	}

	/**
	 * Atualiza um Curso
	 * @param newCurso
	 * @param curso
	 */
	public void updateCurso(Curso newCurso, Curso curso) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update cursos set nome=?, area=?, nivel=?, sigla=?" + "where nome=? and nivel=?");
			// Parameters start with 1
			
			preparedStatement.setString(1, newCurso.getNome());
			preparedStatement.setString(2, newCurso.getArea());
			preparedStatement.setString(3, newCurso.getNivel());
			preparedStatement.setString(4, newCurso.getSigla());
			preparedStatement.setString(5, curso.getNome());
			preparedStatement.setString(6, curso.getNivel());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lista todos os cursos
	 * @return
	 */
	public List<Curso> getAllCursos() {
		List<Curso> cursos = new ArrayList<Curso>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from cursos");
			while (rs.next()) {
				Curso curso = new Curso();
				curso.setId(rs.getInt("id"));
				curso.setNome(rs.getString("nome"));
				curso.setArea(rs.getString("area"));
				curso.setNivel(rs.getString("nivel"));
				curso.setSigla(rs.getString("sigla"));
				
				cursos.add(curso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cursos;
	}
	
	

	/**
	 * Recupera um curso
	 * @param id
	 * @return
	 */
	public Curso getCursoById(int id) {
		Curso curso = new Curso();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from cursos where id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				curso.setId(rs.getInt("id"));
				curso.setNome(rs.getString("Nome"));
				curso.setArea(rs.getString("Area"));
				curso.setNivel(rs.getString("Nivel"));
				curso.setSigla(rs.getString("Sigla"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return curso;
	}
	
	public boolean compare(Curso curso1, Curso curso2) {
		int semelhancas = 0;
		semelhancas += curso1.getArea() == curso2.getArea() ? 1 : 0;
		semelhancas += curso1.getNivel() == curso2.getNivel() ? 1 : 0;
		semelhancas += curso1.getNome() == curso2.getNome() ? 1 : 0;
		semelhancas += curso1.getSigla() == curso2.getSigla() ? 1 : 0;
		
		if(semelhancas == 4) {
			return true;
		} else {
			return false;
		}
	}
}
