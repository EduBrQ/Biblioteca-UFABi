package com.web.resources;

import java.util.List;

public class Ferramentas {
	
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
