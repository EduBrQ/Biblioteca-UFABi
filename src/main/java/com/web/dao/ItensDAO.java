package com.web.dao;

import com.web.model.*;

public class ItensDAO {

	
	public AnalCongresso criaAnaisCongresso(String titulo, int ano,String tipo, String nomeCongresso, String local) {
		return new AnalCongresso(titulo, ano, tipo, nomeCongresso, local);
	}
	
	public Jornal criaJornal(String titulo, String dataPulicacao, String edicao) {
		return new Jornal(titulo, dataPulicacao, edicao);
	}
	
	public Livro criaLivro(String titulo, int ano, String IBS, String editora, int edicao, int numPaginas, String areaConhecimento, String tema) {
		return new Livro(titulo, ano, IBS, editora, edicao, numPaginas, areaConhecimento, tema);
	}
	
	public MidiaEletronica criaMidiaEletronica(String titulo, String dataPublicacao, String tipo) {
		return new MidiaEletronica(titulo, dataPublicacao, tipo);
	}
	
	public Revista criaRevista(String titulo, String dataPublicacao, String editora, int edicao, int numPaginas) {
		return new Revista(titulo, dataPublicacao, editora, edicao, numPaginas);
	}
	
	public TrabalhoConclusao criaTrabalhoConclusao(String titulo, int ano, String tipo, String local) {
		return new TrabalhoConclusao(titulo, ano, tipo, local);
	}
	
}
