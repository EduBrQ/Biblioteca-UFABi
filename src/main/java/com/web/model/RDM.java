package com.web.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/**
 * Classe que representa a entidade RDM 
 * Onde é efetuada toda a lógica de negócio
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */
public class RDM {
	private static final Logger logger = LogManager.getLogger(RDM.class);

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

	
	String matricula;
	String senha;
	int ano;
	int periodo;
	
	private int idAluno;
	private int idCurso;
	
	public RDM() {
		this.runMe("RDM");
		// No momento que ele cria o rdm, ele faz a matricula do aluno, então é chamado o alunoDAO pra criar um novo
	}
	
	
	public String gerarMatricula() {
		String resultado = "";
		
		return resultado;
	}

}
