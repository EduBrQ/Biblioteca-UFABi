package com.jackrutorial.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.jackrutorial.model.Livro;


@Repository
public class LivroDaoImpl implements LivroDao {
 
 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 
 @Autowired
 public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
 }

 public List listAllLivros() {
  String sql = "SELECT id, isbn, titulo, autores, editora, anoPublicacao, edicao,\r\n" + 
  		"			paginas, areaConhecimento, tema, address FROM livros";
  
  List list = namedParameterJdbcTemplate
.query(sql, getSqlParameterByModel(null), new LivroMapper());
  
  return list;
 }
 
 private SqlParameterSource getSqlParameterByModel(Livro livro){
  MapSqlParameterSource parameterSource = new MapSqlParameterSource();
  if(livro != null){
   parameterSource.addValue("id", livro.getId());
   parameterSource.addValue("isbn", livro.getIsbn());
   parameterSource.addValue("titulo", livro.getTitulo());
   parameterSource.addValue("autores", livro.getAutores());
   parameterSource.addValue("editora", livro.getEditora());
   parameterSource.addValue("anoPublicacao", livro.getAnoPublicacao());
   parameterSource.addValue("edicao", livro.getEdicao());
   parameterSource.addValue("paginas", livro.getPaginas());
   parameterSource.addValue("areaConhecimento", livro.getAreaConhecimento());
   parameterSource.addValue("tema", livro.getTema());
  }
  return parameterSource;
 }
 
 private static final class LivroMapper implements RowMapper{

  public Livro mapRow(ResultSet rs, int rowNum) throws SQLException {
   Livro livro = new Livro();
   livro.setId(rs.getInt("id"));
   livro.setIsbn(rs.getString("isbn"));
   livro.setTitulo(rs.getString("titulo"));
   livro.setAutores(rs.getInt("autores"));
   livro.setEditora(rs.getString("editora"));
   livro.setAnoPublicacao(rs.getDate("anoPublicacao"));
   livro.setEdicao(rs.getString("edicao"));
   livro.setPaginas(rs.getInt("paginas"));
   livro.setAreaConhecimento(rs.getString("areaConhecimento"));
   livro.setTema(rs.getString("tema"));
   
   return livro;
  }
  
 }

 public void addLivro(Livro livro) {
  String sql = "INSERT INTO livros(isbn, titulo, autores, editora, anoPublicacao, edicao, paginas, areaConhecimento, tema) VALUES(:isbn, :titulo, :autores, :editora, :anoPublicacao, :edicao, :paginas, :areaConhecimento, :tema)";
  
  namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(livro));
 }

 public void updateLivro(Livro livro) {
  String sql = "UPDATE livros SET isbn = :isbn, titulo = :titulo, autores = :autores, editora = :editora, anoPublicacao = :anoPublicacao, edicao = :edicao, paginas = :paginas, areaConhecimento = :areaConhecimento, tema = :tema WHERE id = :id";
  
  namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(livro));
 }

 public void deleteLivro(int id) {
  String sql = "DELETE FROM livros WHERE id = :id";
  
  namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Livro()));
 }

 public Livro findLivroById(int id) {
  String sql = "SELECT * FROM livros WHERE id = :id";
  
  return (Livro) namedParameterJdbcTemplate
.queryForObject(sql, getSqlParameterByModel(new Livro()), new LivroMapper());
 }

}