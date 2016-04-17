package com.bpjoshi.advertsys.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session().save(user);
	}

	public boolean exists(String username) {
		Criteria cr= session().createCriteria(User.class);
		cr.add(Restrictions.idEq(username));
		User user=(User) cr.uniqueResult();
		return user!=null;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		List<User> result= (List<User>) session().createQuery("from User").list();
		 return result;
	}
}
 