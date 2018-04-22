package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.web.model.Aluno;
import com.web.resources.DbUtil;

/**
 * Classe AlunoDAO responsável criar, 
 * editar mostrar e deletar de Aluno
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */
public class AlunoDAO {
	
private static final Logger logger = LogManager.getLogger(AnaisCongressoDAO.class); 
	
	private void runMe(String parameter){
		
		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		}
		
		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}
		
		
		logger.error("This is error : " + parameter);
		//logger.warn("This is warn : " + parameter);
		//logger.fatal("This is fatal : " + parameter);
		
	}
	
	private Connection connection;
	
	/**
	 * Instancia a conexão com o banco
	 */
	public AlunoDAO() {
		connection = DbUtil.getConnection();
	}
	
	/**
	 * Adiciona novo Aluno
	 * @param aluno
	 */
	public void addAluno(Aluno aluno) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into alunos(nomeCompleto, endereco, telefone, naturalidade, nomeMae, nomePai, cpf, rg) values (?, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, aluno.getNomeCompleto());
			preparedStatement.setString(2, aluno.getEndereco());
			preparedStatement.setString(3, aluno.getTelefone());
			preparedStatement.setString(4, aluno.getNaturalidade());
			preparedStatement.setString(5, aluno.getNomeMae());
			preparedStatement.setString(6, aluno.getNomePai());
			preparedStatement.setString(7, aluno.getCpf());
			preparedStatement.setString(8, aluno.getRg());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			this.runMe(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Deleta um Aluno
	 * @param Id
	 * 
	 */
	public void deleteAluno(Aluno aluno) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from alunos where nomeCompleto=? and cpf=?");
			preparedStatement.setString(1, aluno.getNomeCompleto());
			preparedStatement.setString(2, aluno.getCpf());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			this.runMe(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Atualiza um Aluno
	 * @param newAluno
	 * @param aluno
	 */
	public void updateAluno(Aluno newAluno, Aluno aluno) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update alunos set NomeCompleto=?, Endereco=?, Telefone=?, Naturalidade=?, NomeMae=?, NomePai=?, Cpf=?, Rg=?"
							+ " where NomeCompleto=? and Cpf=?");
			preparedStatement.setString(1, newAluno.getNomeCompleto());
			preparedStatement.setString(2, newAluno.getEndereco());
			preparedStatement.setString(3, newAluno.getTelefone());
			preparedStatement.setString(4, newAluno.getNaturalidade());
			preparedStatement.setString(5, newAluno.getNomeMae());
			preparedStatement.setString(6, newAluno.getNomePai());
			preparedStatement.setString(7, newAluno.getCpf());
			preparedStatement.setString(8, newAluno.getRg());
			preparedStatement.setString(9, aluno.getNomeCompleto());
			preparedStatement.setString(10, aluno.getCpf());
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			this.runMe(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Recupera todos os Alunos
	 * @return
	 */
	public List<Aluno> getAllAlunos(){
		List<Aluno> alunos = new ArrayList<Aluno>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from alunos");
			while(rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getInt("id"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setEndereco(rs.getString("endereco"));
				aluno.setNaturalidade(rs.getString("naturalidade"));
				aluno.setNomeCompleto(rs.getString("nomeCompleto"));
				aluno.setNomeMae(rs.getString("nomeMae"));
				aluno.setNomePai(rs.getString("nomePai"));
				aluno.setRg(rs.getString("rg"));
				aluno.setTelefone(rs.getString("telefone"));
				alunos.add(aluno);
			}
		} catch (Exception e) {
			this.runMe(e.getMessage());
			e.printStackTrace();
		}
		return alunos;
	}
	
	/**
	 * Recupera um Aluno
	 * @param Id
	 * @return
	 */
	public Aluno getAlunoById(int id) {
		Aluno aluno = new Aluno();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from alunos where id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				aluno.setId(rs.getInt("id"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setEndereco(rs.getString("endereco"));
				aluno.setNaturalidade(rs.getString("naturalidade"));
				aluno.setNomeCompleto(rs.getString("nomeCompleto"));
				aluno.setNomeMae(rs.getString("nomeMae"));
				aluno.setNomePai(rs.getString("nomePai"));
				aluno.setRg(rs.getString("rg"));
				aluno.setTelefone(rs.getString("telefone"));
			}
		} catch (Exception e) {
			this.runMe(e.getMessage());
			e.printStackTrace();
		}
		return aluno;
	}
	
	public boolean compare(Aluno aluno1, Aluno aluno2) {
		int semelhancas = 0;
		semelhancas += aluno1.getCpf().equals(aluno2.getCpf()) ? 1 : 0;
		semelhancas += aluno1.getEndereco().equals(aluno2.getEndereco()) ? 1 : 0;
		semelhancas += aluno1.getNaturalidade().equals(aluno2.getNaturalidade()) ? 1 : 0;
		semelhancas += aluno1.getNomeCompleto().equals(aluno2.getNomeCompleto()) ? 1 : 0;
		semelhancas += aluno1.getNomeMae().equals(aluno2.getNomeMae()) ? 1 : 0;
		semelhancas += aluno1.getNomePai().equals(aluno2.getNomePai()) ? 1 : 0;
		semelhancas += aluno1.getRg().equals(aluno2.getRg()) ? 1 : 0;
		semelhancas += aluno1.getTelefone().equals(aluno2.getTelefone()) ? 1 : 0;
		if(semelhancas == 8) {
			return true;
		} else {
			return false;
		}
	}

}
