package com.bpjoshi.advertsys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.bpjoshi.advertsys.model.Advert;
import com.bpjoshi.advertsys.model.User;

/**
 * @author Bhagwati Prasad - write2bpj@gmail.com
 * 
 *  */

@Component("advertDao")
public class AdvertDao {
	
	private NamedParameterJdbcTemplate jdbc;
	
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public List<Advert> getCurrentAdverts() {

		return jdbc.query("select u.username, u.password, u.enabled, u.email, u.name, a.authority, o.offer, o.id from users as u join  authorities a on u.username=a.username join offers o on u.username=o.username", new AdvertRowMapper());
	}
	
	public List<Advert> getAdvertsByUsername(String username) {

		return jdbc.query("select u.username, u.password, u.enabled, u.email, u.name, a.authority, o.offer, o.id from users as u join  authorities a on u.username=a.username join offers o on u.username=o.username and o.username=:username", 
				new MapSqlParameterSource("username", username), new AdvertRowMapper());
	}
	
	public boolean createAdvert(Advert advert) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(advert);
		return jdbc.update("insert into offers (username, offer) values (:username, :advert)", params) == 1;
	}
	
	public boolean updateAdvert(Advert advert) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(advert);
		return jdbc.update("update offers set offer=:advert where id=:id", params) == 1;
	}
	
	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		
		return jdbc.update("delete from offers where id=:id", params) == 1;
	}
	
	/*public Advert getAdvert(int id){
		User user= new User();
		user.setAuthority(rs.getString("authority"));
		user.setEmail(rs.getString("email"));
		user.setEnabled(rs.getBoolean("enabled"));
		user.setName(rs.getString("name"));
		user.setUsername(rs.getString("username"));
		Advert advert = new Advert();
		advert.setUser(user);
		advert.setId(rs.getInt("id"));
		advert.setAdvert(rs.getString("offer"));
		return advert;
	}*/
}
 