package com.web.resources;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Classe utilitária com diversas funções helpers
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */

public class Ferramentas {
	
	private static final Logger logger = LogManager.getLogger(Ferramentas.class);

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
	
	public Ferramentas() {
		this.runMe("Ferramentas");
	}
	/**
	 * Transforma lista em string
	 * @param lista
	 * @return
	 */
	public static String listToString(List<String> lista) {
		String str = "";
		
		for(int i=0; i< lista.size(); i++) {
			if(i!=lista.size()-1) {
				str += lista.get(i) + ";";
			} else {
				str += lista.get(i);
			}
		}
		
		return str;
	}
	
	/**
	 * lista em string em uma linha
	 * @param lista
	 * @return
	 */
	public static String listToStringInline(List<String> lista) {
		String str = "";
		
		for(int i=0; i< lista.size(); i++) {
			if(i!=lista.size()-1) {
				str += lista.get(i) + ", ";
			} else {
				str += lista.get(i);
			}
		}
		
		return str;
	}
	
	
	/**
	 * Verifica os tipos
	 * @param tipo
	 * @param tipos
	 * @return
	 */
	public static boolean verificaTipos(String tipo, String[] tipos) {
		for(int i=0; i < tipos.length; i++) {
			if(tipo == tipos[i]) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Verifica se é um cpf válido
	 * @param cpfEntrada
	 * @return
	 */
	public static boolean verificaCPF(String cpfEntrada) {
		
		String cpfA = cpfEntrada.replace(".", "");
		cpfA = cpfA.replace("-", "");
		char [] cpf = cpfA.toCharArray();
		
		int sm = 0;
		
		for(int i=0; i<cpfA.length()-2; i++) {
			sm += Integer.parseInt(cpf[i]+"") * (10-i);
		}
		
		if(11-(sm%11) == Integer.parseInt(cpf[9]+"")) {
			
			sm = 0;
			for(int i=0; i<cpfA.length()-1; i++) {
				sm += Integer.parseInt(cpf[i]+"") * (11-i);
			}
			
			
			if(11 - sm%11 == 10 || 11 - sm%11 == 11) {
				int digit = 0;
				
				if(digit==Integer.parseInt(cpf[10]+"")) {
					return true;
				}
			}
			
		}
		return false; 
	}

}
