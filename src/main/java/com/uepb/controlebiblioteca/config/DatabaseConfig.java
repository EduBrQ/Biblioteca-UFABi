package com.uepb.controlebiblioteca.config;

import com.uepb.controlebiblioteca.model.Aluno;
import com.uepb.controlebiblioteca.model.AnaisCongresso;
import com.uepb.controlebiblioteca.model.AppUser;
import com.uepb.controlebiblioteca.model.Curso;
import com.uepb.controlebiblioteca.model.Funcionario;
import com.uepb.controlebiblioteca.model.Livro;
import com.uepb.controlebiblioteca.model.MidiasEletronicas;
import com.uepb.controlebiblioteca.model.Revista;
import com.uepb.controlebiblioteca.model.TrabalhosConclusao;
import com.uepb.controlebiblioteca.model.UserRole;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
    /*
    * create database
    * create database inventory_management; */
    @Autowired
    private ApplicationContext appContext;


    
//    @Bean(name = "DataSource")
//    public HikariDataSource getDataSource(){
//        HikariDataSource ds = new HikariDataSource();
//        ds.setMaximumPoolSize(100);
//        ds.setMinimumIdle(30);
//        ds.setDriverClassName("org.h2.Driver");
//        ds.setJdbcUrl("jdbc:h2:mem:test");
//        ds.setUsername("root");
//        ds.setPassword("root");
//        return ds;
//    }
//
    @Bean(name = "DataSource")
    public HikariDataSource getDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        dataSource.addDataSourceProperty("databaseName", "controle_biblioteca");
        dataSource.addDataSourceProperty("portNumber", "3306");
        dataSource.addDataSourceProperty("serverName", "127.0.0.1");
        dataSource.addDataSourceProperty("user", "root");
        dataSource.addDataSourceProperty("password", "");
        return dataSource;
    }
    
    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(hibernate5SessionFactoryBean().getObject());
        return manager;
    }

    @Bean
    public LocalSessionFactoryBean hibernate5SessionFactoryBean(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource((DataSource) appContext.getBean("DataSource"));
        localSessionFactoryBean.setAnnotatedClasses(
                AppUser.class,
                UserRole.class,
                Aluno.class,
                AnaisCongresso.class,
                Curso.class,
                MidiasEletronicas.class,
                Revista.class,
                TrabalhosConclusao.class,
                Livro.class,
                Funcionario.class
        );

        Properties properties = new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.hbm2ddl.auto","update");
        properties.put("hibernate.show_sql","true");

        localSessionFactoryBean.setHibernateProperties(properties);
        return localSessionFactoryBean;
    }
}
