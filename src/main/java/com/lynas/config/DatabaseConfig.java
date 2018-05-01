package com.lynas.config;

import com.lynas.model.Aluno;
import com.lynas.model.AnaisCongresso;
import com.lynas.model.AppUser;
import com.lynas.model.Curso;
import com.lynas.model.Funcionario;
import com.lynas.model.Livro;
import com.lynas.model.MidiasEletronicas;
import com.lynas.model.Revista;
import com.lynas.model.TrabalhosConclusao;
import com.lynas.model.UserRole;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by sazzad on 9/7/15
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
    /*
    * create database
    * create database inventory_management; */
    @Autowired
    private ApplicationContext appContext;



    @Bean(name = "DataSource")
    public HikariDataSource getDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        dataSource.addDataSourceProperty("databaseName", "security");
        dataSource.addDataSourceProperty("portNumber", "3306");
        dataSource.addDataSourceProperty("serverName", "127.0.0.1");
        dataSource.addDataSourceProperty("user", "root");
        dataSource.addDataSourceProperty("password", "");
        return dataSource;
    }
    
    
//    @Bean(name = "DataSource")
//    public HikariDataSource getDataSource(){
//        HikariConfig config = new HikariConfig();
//        config.setDataSourceClassName("org.h2.jdbcx.JdbcDataSource");
//        config.setConnectionTestQuery("VALUES 1");
//        config.addDataSourceProperty("URL", "jdbc:h2:~/testdb;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false;MODE=MSSQLServer");
//        config.addDataSourceProperty("user", "sa");
//        config.addDataSourceProperty("password", "sa");
//        HikariDataSource ds = new HikariDataSource(config);
//
//        HikariDataSource dataSource = new HikariDataSource(config);
//
//        return dataSource;
//    }




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
        //properties.put("hibernate.current_session_context_class","thread");
        properties.put("hibernate.hbm2ddl.auto","update");
        properties.put("hibernate.show_sql","true");

        localSessionFactoryBean.setHibernateProperties(properties);
        return localSessionFactoryBean;
    }
}
