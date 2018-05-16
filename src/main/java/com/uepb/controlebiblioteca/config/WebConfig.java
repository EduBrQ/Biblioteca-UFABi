package com.uepb.controlebiblioteca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * WebConfig representa configurações de acesso as rotas do sistema.
 * @author Eduardo Borba
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.uepb.controlebiblioteca") // rota para procurar as anotações que serão carregadas.
public class WebConfig extends WebMvcConfigurerAdapter {

	/**
	 * Esse método retorna um prefixo[/pages] e sufixo[.jsp] 
	 * para as as views que serão carregadas.
	 */
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	/**
	 * Metodo para configurar o servelet, no caso é usado o DefaultServletHandlerConfigurer 
	 * para definir essa configuração
	 */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}

















