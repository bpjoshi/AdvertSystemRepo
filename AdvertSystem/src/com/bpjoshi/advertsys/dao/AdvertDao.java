package com.bpjoshi.advertsys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.bpjoshi.advertsys.model.Advert;

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

		return jdbc.query("select * from offers", new RowMapper<Advert>() {

			public Advert mapRow(ResultSet rs, int rowNum) throws SQLException {
				Advert advert = new Advert();

				advert.setId(rs.getInt("id"));
				advert.setName(rs.getString("name"));
				advert.setAdvert(rs.getString("offer"));
				advert.setEmail(rs.getString("email"));

				return advert;
			}

		});
	}

	public boolean createAdvert(Advert advert) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(advert);
		return jdbc.update("insert into offers (name, offer, email) values (:name, :advert, :email)", params) == 1;
	}
}
 