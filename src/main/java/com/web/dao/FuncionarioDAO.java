package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.web.model.Funcionario;
import com.web.resources.DbUtil;

public class FuncionarioDAO {

	private Connection connection;

	public FuncionarioDAO() {
		connection = DbUtil.getConnection();
	}

	public void addFuncionario(Funcionario funcionario) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into funcionarios(nome, senha, cpf, naturalidade, endereco, telefone, email) values (?, ?, ?, ?, ?, ?, ?)");
			// Parameters start with 1

			preparedStatement.setString(1, funcionario.getNome());
			preparedStatement.setString(2, funcionario.getSenha());
			preparedStatement.setString(3, funcionario.getCpf());
			preparedStatement.setString(4, funcionario.getNaturalidade());
			preparedStatement.setString(5, funcionario.getEndereco());
			preparedStatement.setString(6, funcionario.getTelefone());
			preparedStatement.setString(7, funcionario.getEmail());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}

	public void deleteFuncionario(String nome) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from funcionarios where nome=?");
			// Parameters start with 1
			preparedStatement.setString(1, nome);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateFuncionario(Funcionario newFuncionario, Funcionario funcionario) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update funcionarios set Nome=?, Senha=?, Cpf=?, Naturalidade=?, Endereco=?, Telefone=?, Email=?" + "where Nome=?");
			// Parameters start with 1
			
			preparedStatement.setString(1, funcionario.getNome());
			preparedStatement.setString(2, funcionario.getSenha());
			preparedStatement.setString(3, newFuncionario.getCpf());
			preparedStatement.setString(4, newFuncionario.getNaturalidade());
			preparedStatement.setString(5, newFuncionario.getEndereco());
			preparedStatement.setString(6, newFuncionario.getTelefone());
			preparedStatement.setString(7, newFuncionario.getEmail());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Funcionario> getAllFuncionarios() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from funcionarios");
			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("Nome"));
				funcionario.setSenha(rs.getString("Senha"));
				funcionario.setNaturalidade(rs.getString("Naturalidade"));
				funcionario.setEndereco(rs.getString("Endereco"));
				funcionario.setTelefone(rs.getString("Telefone"));
				funcionario.setEmail(rs.getString("Email"));
				
				funcionarios.add(funcionario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return funcionarios;
	}

	public Funcionario getFuncionarioById(int id) {
		Funcionario funcionario = new Funcionario();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from funcionarios where id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
			
				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("Nome"));
				funcionario.setSenha(rs.getString("Senha"));
				funcionario.setNaturalidade(rs.getString("Naturalidade"));
				funcionario.setEndereco(rs.getString("Endereco"));
				funcionario.setTelefone(rs.getString("Telefone"));
				funcionario.setEmail(rs.getString("Email"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return funcionario;
	}
}
