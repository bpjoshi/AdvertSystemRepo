package com.bpjoshi.advertsys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bpjoshi.advertsys.model.Advert;
import com.bpjoshi.advertsys.model.User;

public class AdvertRowMapper implements RowMapper<Advert> {

	@Override
	public Advert mapRow(ResultSet rs, int rowNum) throws SQLException {
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
	}

}
