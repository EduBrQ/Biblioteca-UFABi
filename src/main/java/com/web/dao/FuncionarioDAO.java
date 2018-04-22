package com.web.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.web.model.Funcionario;
import com.web.resources.DbUtil;

/**
 * Classe FuncionarioDAO respons�vel criar, 
 * editar mostrar e deletar os anais de crongressos
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */
public class FuncionarioDAO {

	private Connection connection;
	
	private static final Logger logger = LogManager.getLogger(FuncionarioDAO.class); 
	
	private void runMe(String parameter){
		
		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		}
		
		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}
		
		logger.warn("This is warn : " + parameter);
		//logger.error("This is error : " + parameter);
		//logger.fatal("This is fatal : " + parameter);
		
	}

	public FuncionarioDAO() {
		this.runMe("FuncionarioDAO");
		connection = DbUtil.getConnection();
	}

	/**
	 * Adiciona um funcion�rio
	 * @param funcionario
	 */
	public void addFuncionario(Funcionario funcionario) {
		try {
			PreparedStatement preparedStatement = connection
				.prepareStatement("insert into funcionarios(nome, senha, cpf, naturalidade, endereco, telefone, email) values (?, ?, ?, ?, ?, ?, ?)");
			
			preparedStatement.setString(1, funcionario.getNome());
			preparedStatement.setString(2, funcionario.getSenha());
			preparedStatement.setString(3, funcionario.getCpf());
			preparedStatement.setString(4, funcionario.getNaturalidade());
			preparedStatement.setString(5, funcionario.getEndereco());
			preparedStatement.setString(6, funcionario.getTelefone());
			preparedStatement.setString(7, funcionario.getEmail());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) { 
			this.runMe(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Deleta um funcion�rio apenas se for admin ou root
	 * @param nome
	 */
	public void deleteFuncionario(int id) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from funcionarios where id=?");
			
			preparedStatement.setInt(1,id);
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			this.runMe(e.getMessage());
			e.printStackTrace();
		}
	}

	
	/**
	 * Atualiza funcion�rio
	 * @param newFuncionario
	 * @param funcionario
	 */
	public void updateFuncionario(Funcionario newFuncionario, Funcionario funcionario) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update funcionarios set Nome=?, Senha=?, Cpf=?, Naturalidade=?, Endereco=?, Telefone=?, Email=? where Nome=? and Cpf=?");
						
			preparedStatement.setString(1, newFuncionario.getNome());
			preparedStatement.setString(2, newFuncionario.getSenha());
			preparedStatement.setString(3, newFuncionario.getCpf());
			preparedStatement.setString(4, newFuncionario.getNaturalidade());
			preparedStatement.setString(5, newFuncionario.getEndereco());
			preparedStatement.setString(6, newFuncionario.getTelefone());
			preparedStatement.setString(7, newFuncionario.getEmail());
			preparedStatement.setString(8, funcionario.getNome());
			preparedStatement.setString(9, funcionario.getCpf());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			this.runMe(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Recupera todos os funcion�rios
	 * @return
	 * @throws IOException 
	 */
	public List<Funcionario> getAllFuncionarios() throws IOException {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from funcionarios");
			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("Nome"));
				funcionario.setSenha(rs.getString("Senha"));
				funcionario.setCpf(rs.getString("Cpf"));
				funcionario.setNaturalidade(rs.getString("Naturalidade"));
				funcionario.setEndereco(rs.getString("Endereco"));
				funcionario.setTelefone(rs.getString("Telefone"));
				funcionario.setEmail(rs.getString("Email"));
				
				funcionarios.add(funcionario);
			}
		} catch (SQLException e) {
			this.runMe(e.getMessage());
			e.printStackTrace();
		}

		return funcionarios;
	}

	
	/**
	 * Recupera um funcion�rio
	 * @param id
	 * @return
	 * @throws IOException 
	 */
	public Funcionario getFuncionarioById(int id) throws IOException {
		Funcionario funcionario = new Funcionario();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from funcionarios where id=?");
			
			preparedStatement.setInt(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
			
				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("Nome"));
				funcionario.setSenha(rs.getString("Senha"));
				funcionario.setCpf(rs.getString("Cpf"));
				funcionario.setNaturalidade(rs.getString("Naturalidade"));
				funcionario.setEndereco(rs.getString("Endereco"));
				funcionario.setTelefone(rs.getString("Telefone"));
				funcionario.setEmail(rs.getString("Email"));
				
			}
		} catch (SQLException e) {
			this.runMe(e.getMessage());
			e.printStackTrace();
		}

		return funcionario;
	}
}
