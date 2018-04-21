package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.swing.JComboBox.KeySelectionManager;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.web.model.User;
import com.web.resources.DbUtil;

/**
 * Classe UserDAO responsável criar, 
 * editar mostrar e deletar os anais de crongressos
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */
public class UserDAO {

	private Connection connection;

	private static final Logger logger = LogManager.getLogger(UserDAO.class);

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
	
	public UserDAO() {
		this.runMe("UserDAO");
		connection = DbUtil.getConnection();
	}

	/**Adiciona um User
	 * @param user
	 */
	public void addUser(User user) {
		try {
			
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into users(firstName, lastName, address, nivelAcesso) values (?, ?, ?, ?)");
			
			preparedStatement.setString(1, user.getFirstname());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setInt(4, user.getNivelAcesso());
			preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
	}

	/**Deleta um usuário se for admin ou root 
	 * @param userId
	 */
	public void deleteUser(int userId) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id=?");
			
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**Atualiza um User
	 * @param newUser
	 * @param user
	 */
	public void updateUser(User newUser, User user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update users set Firstname=?, Lastname=?, Address=?, NivelAcesso=?" + " where Firstname=? AND Lastname=?");
			
			preparedStatement.setString(1, newUser.getFirstname());
			preparedStatement.setString(2, newUser.getLastname());
			preparedStatement.setString(3, newUser.getAddress());
			preparedStatement.setInt(4, newUser.getNivelAcesso());
			preparedStatement.setString(5, user.getFirstname());
			preparedStatement.setString(6, user.getLastname());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**Recupera todos os usuários
	 * @return
	 */
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from users");
			while (rs.next()) {
				User user = new User();
				user.setFirstname(rs.getString("Firstname"));
				user.setLastname(rs.getString("Lastname"));
				user.setAddress(rs.getString("Address"));
				user.setNivelAcesso(rs.getInt("NivelAcesso"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	/**Recupera um User
	 * @param userId
	 * @return
	 */
	public User getUserById(int userId) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where id=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setFirstname(rs.getString("Firstname"));
				user.setLastname(rs.getString("Lastname"));
				user.setAddress(rs.getString("Address"));
				user.setNivelAcesso(rs.getInt("NivelAcesso"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	
}
