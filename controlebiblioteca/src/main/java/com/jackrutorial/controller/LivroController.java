package com.jackrutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jackrutorial.model.Livro;
import com.jackrutorial.service.LivroService;

@Controller
@RequestMapping(value="/livro") 
public class LivroController {

 @Autowired
 LivroService livroService;
 
 @RequestMapping(value="/list", method=RequestMethod.GET)
 public ModelAndView list(){
  ModelAndView model = new ModelAndView("livro/livro_page");
  
  List list = livroService.listAllLivros();
  model.addObject("listLivro", list);
  
  return model;
 }
 
 @RequestMapping(value="/add", method=RequestMethod.GET)
 public ModelAndView add(){
  ModelAndView model = new ModelAndView("livro/livro_form");
  
  Livro livro = new Livro();
  model.addObject("livroForm", livro);
  
  return model;
 }
 
 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
 public ModelAndView update(@PathVariable("id") int id){
  ModelAndView model = new ModelAndView("livro/livro_form");
  
  Livro livro = livroService.findLivroById(id);
  model.addObject("livroForm", livro);
  
  return model;
 }
 
 @RequestMapping(value="/save", method=RequestMethod.POST)
 public ModelAndView save(@ModelAttribute("livroForm") Livro livro){
  if(livro != null && livro.getId() != null){
   livroService.updateLivro(livro);
  } else {
   livroService.addLivro(livro);
  }
  
  return new ModelAndView("redirect:/livro/list");
 }
 
 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
 public ModelAndView delete(@PathVariable("id") int id){
  livroService.deleteLivro(id);
  
  return new ModelAndView("redirect:/livro/list");
 }
}