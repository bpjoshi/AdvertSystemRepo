package com.bpjoshi.advertsys.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bpjoshi.advertsys.model.User;

/**
 * @author Bhagwati Prasad - write2bpj@gmail.com
 * 
 *  */

@Component("userDao")
public class UserDao {
	
	private NamedParameterJdbcTemplate jdbc;
	
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	@Transactional
	public boolean createAccount(User user) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		jdbc.update("insert into users (username, email, password, enabled) values (:username, :email, :password, enabled)", params);
		return jdbc.update("insert into authorities (username, authority) values (:username, :authority)", params) == 1;
	}

	public boolean exists(String username) {
		System.out.println("duplicate username");
		return jdbc.queryForObject("select count(*) from users where username=:username", 
				new MapSqlParameterSource("username", username), Integer.class)>0; 
	}
}
 