package com.bpjoshi.advertsys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.bpjoshi.advertsys.dao.AdvertDao;
import com.bpjoshi.advertsys.model.Advert;

/**
 * @author Bhagwati Prasad - write2bpj@gmail.com
 * 
 *  */

@Service("advertService")
public class AdvertService {
	
	private AdvertDao advertDao;
	
	@Autowired
	public void setAdvertDao(AdvertDao advertDao) {
		this.advertDao = advertDao;
	}
	
	public List<Advert> getCurrentAdverts(){
		return advertDao.getCurrentAdverts();
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public boolean createAdvert(Advert advert) {
		return advertDao.createAdvert(advert);
	}
	
	public boolean hasAdverts(String name) {
		if(name==null) return false;
		List<Advert> advertList= advertDao.getAdvertsByUsername(name);
			if(advertList.size()==0){
				return false;
			}
		return true;
	}
}
