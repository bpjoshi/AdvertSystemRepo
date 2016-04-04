package com.bpjoshi.advertsys.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
	private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;
	
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	@Transactional
	public boolean createAccount(User user) {
		
		MapSqlParameterSource prams= new MapSqlParameterSource();
		prams.addValue("username", user.getUsername());
		prams.addValue("email", user.getEmail());
		prams.addValue("name", user.getName());
		prams.addValue("password", passwordEncoder.encode(user.getPassword()));
		prams.addValue("enabled", user.isEnabled());
		prams.addValue("authority", user.getAuthority());
		
		//BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		jdbc.update("insert into users (username, email, name, password, enabled) values (:username, :email, :name, :password, enabled)", prams);
		return jdbc.update("insert into authorities (username, authority) values (:username, :authority)", prams) == 1;
	}

	public boolean exists(String username) {
		System.out.println("duplicate username");
		return jdbc.queryForObject("select count(*) from users where username=:username", 
				new MapSqlParameterSource("username", username), Integer.class)>0; 
	}

	public List<User> getAllUsers() {
		return jdbc.query("select * from users, authorities where users.username=authorities.username", BeanPropertyRowMapper.newInstance(User.class));
	}
}
 