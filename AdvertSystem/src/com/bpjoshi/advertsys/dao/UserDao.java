package com.bpjoshi.advertsys.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bpjoshi.advertsys.model.User;

/**
 * @author Bhagwati Prasad - write2bpj@gmail.com
 * 
 *  */
@Repository
@Transactional
@Component("userDao")
public class UserDao {
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;
	
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void createAccount(User user) {
		
		/*MapSqlParameterSource prams= new MapSqlParameterSource();
		prams.addValue("username", user.getUsername());
		prams.addValue("email", user.getEmail());
		prams.addValue("name", user.getName());
		prams.addValue("password", passwordEncoder.encode(user.getPassword()));
		prams.addValue("enabled", user.isEnabled());
		prams.addValue("authority", user.getAuthority());	
		//BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		return jdbc.update("insert into users (username, email, name, password, enabled, authority) values (:username, :email, :name, :password, :enabled, :authority)", prams)==1;
		 //jdbc.update("insert into authorities (username, authority) values (:username, :authority)", prams) == 1;
		*/
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session().save(user);
	}

	public boolean exists(String username) {
		System.out.println("duplicate username");
		return jdbc.queryForObject("select count(*) from users where username=:username", 
				new MapSqlParameterSource("username", username), Integer.class)>0; 
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		List<User> result= (List<User>) session().createQuery("from User").list();
		 return result;
	}
}
 