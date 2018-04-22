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

import com.web.model.Aluno;
import com.web.model.Curso;
import com.web.model.RDM;
import com.web.resources.DbUtil;

/**
 * Classe RDMDAO responsável criar, 
 * editar mostrar e deletar os RDMs
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */
public class RDMDAO {
	
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
	AlunoDAO alunoDAO = new AlunoDAO();
	CursoDAO cursoDAO = new CursoDAO();
	
	/**
	 * Instancia a conexão com o banco
	 */
	public RDMDAO() {
		connection = DbUtil.getConnection();
	}
	
	/**
	 * Adiciona novo RDM
	 * @param rdm
	 * @param aluno
	 * @param curso
	 */
	public void addRDM(RDM rdm, Aluno aluno, Curso curso) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into rdm(matricula, senha, ano, periodo, idAluno, idCurso) values (?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, rdm.getMatricula());
			preparedStatement.setString(2, rdm.getSenha());
			preparedStatement.setInt(3, rdm.getAno());
			preparedStatement.setInt(4, rdm.getPeriodo());
			preparedStatement.setInt(5, aluno.getId());
			preparedStatement.setInt(6, curso.getId());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			this.runMe(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Deleta um RDM
	 * @param Id
	 * 
	 */
	public void deleteRDM(int id) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from rdm where id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			this.runMe(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Atualiza um RDM
	 * @param newRDM
	 * @param rdm
	 */
	
	public void updateRDM(RDM newRDM,RDM rdm) {
		
		if(!alunoDAO.compare(newRDM.getAluno(), rdm.getAluno())) {
			alunoDAO.updateAluno(newRDM.getAluno(), rdm.getAluno());
		}
		if(!cursoDAO.compare(newRDM.getCurso(), rdm.getCurso())) {
			cursoDAO.updateCurso(newRDM.getCurso(), rdm.getCurso());
		}
		
		
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update rdm set Matricula=?, Senha=?, Ano=?, Periodo=?, idAluno=?, idCurso=? "
							+ "where Matricula=?");
			
			preparedStatement.setString(1, newRDM.getMatricula());
			preparedStatement.setString(2, newRDM.getSenha());
			preparedStatement.setInt(3, newRDM.getAno());
			preparedStatement.setInt(4, newRDM.getPeriodo());
			preparedStatement.setInt(5, newRDM.getAluno().getId());
			preparedStatement.setInt(6, newRDM.getCurso().getId());
			preparedStatement.setString(7, rdm.getMatricula());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			this.runMe(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Recupera todos os RDMs
	 * @return
	 */
	public List<RDM> getAllRDM(){
		List<RDM> rdms = new ArrayList<RDM>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from rdm");
			while(rs.next()) {
				RDM rdm = new RDM();
				rdm.setId(rs.getInt("id"));
				rdm.setAno(rs.getInt("ano"));
				rdm.setPeriodo(rs.getInt("periodo"));
				rdm.setMatricula(rs.getString("matricula"));
				rdm.setAluno(alunoDAO.getAlunoById(rs.getInt("idAluno")));
				rdm.setCurso(cursoDAO.getCursoById(rs.getInt("idCurso")));
				rdms.add(rdm);
			}
		} catch (Exception e) {
			this.runMe(e.getMessage());
			e.printStackTrace();
		}
		return rdms;
	}
	
	/**
	 * Recupera um RDM
	 * @param Id
	 * @return
	 */
	public RDM getRDMById(int id) {
		RDM rdm = new RDM();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from rdm where id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				rdm.setId(rs.getInt("id"));
				rdm.setAno(rs.getInt("ano"));
				rdm.setPeriodo(rs.getInt("periodo"));
				rdm.setMatricula(rs.getString("matricula"));
				rdm.setAluno(alunoDAO.getAlunoById(rs.getInt("idAluno")));
				rdm.setCurso(cursoDAO.getCursoById(rs.getInt("idCurso")));
			}
		} catch (Exception e) {
			this.runMe(e.getMessage());
			e.printStackTrace();
		}
		return rdm;
	}
	

}
