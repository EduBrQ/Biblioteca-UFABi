package com.web.model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.web.resources.Ferramentas;

/**
 * Classe que representa a entidade Curso 
 * Onde é efetuada toda a lógica de negócio
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */
public class Curso {
	private static final Logger logger = LogManager.getLogger(Curso.class);

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


	protected int id;
	protected String nome;
	protected String area;
	protected String nivel;
	protected String sigla;
	
	private String[] niveis = new String[] {"Graduação", "Especialização","Mestrado","Douturado"};
	/* Niveis:
	 * 0 - Graduação
	 * 1 - Especialização
	 * 2 - Mestrado
	 * 3 - Douturado
	 * */
	
	public Curso() {
		this.runMe("Curso");
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/*
	 * Getters and Setters
	 * */
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String n) {
		String nivelRes = "";
		
		if(n.length()==1) {
			for (int i=0; i< this.niveis.length; i++) {
				if(n.equals(this.niveis[i].substring(0, 1))) {
					nivelRes = this.niveis[i];
					break;
				}
			}
		} else {
			nivelRes = n;
		}
		if(Ferramentas.verificaTipos(nivelRes,this.niveis)) {
			this.nivel = nivelRes;
		} else {
			throw new IllegalArgumentException("Deve informar um nivel valido!");
		}
	}
	
	public void setNivel(int nivel) {
		if(nivel>=0 && nivel < this.niveis.length) {
			this.nivel = niveis[nivel];
		} else {
			throw new IllegalArgumentException("Deve informar um nivel valido!");
		}
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public String getSigla() {
		return sigla;
	}
}
