package com.bpjoshi.advertsys.test.tests;

import java.util.List;

import javax.sql.DataSource;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bpjoshi.advertsys.dao.AdvertDao;
import com.bpjoshi.advertsys.dao.UserDao;
import com.bpjoshi.advertsys.model.Advert;
import com.bpjoshi.advertsys.model.User;



@ActiveProfiles("dev")
@ContextConfiguration(locations={"classpath:com/bpjoshi/advertsys/config/dao-context.xml",
		"classpath:com/bpjoshi/advertsys/config/security-context.xml"
		, "classpath:com/bpjoshi/advertsys/test/config/datasource.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

public class AdvertDaoTest {

	@Autowired
	private AdvertDao advertDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DataSource dataSource;
	
	@Before
	public void init(){
		JdbcTemplate jdbc= new JdbcTemplate(dataSource);
		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");
	}
	
	@Test
	public void testAdvert(){
		User u= new User("naman", "Naman Rawat", "naman@rawat.com", "password", true, "ROLE_USER");
		assertTrue("Admin Account Created", userDao.createAccount(u));
		
		User u1= new User("rohit", "rohit palariya", "rohit@palariya.com", "password", true, "ROLE_USER");
		assertTrue("Admin Account Created", userDao.createAccount(u1));
		
		Advert adv0= new Advert(u1, "Spring");
		assertTrue("Advert Creation should return true", advertDao.createAdvert(adv0));
		
		Advert adv= new Advert(u, "JUnit Testing expert");
		assertTrue("Advert Creation should return true", advertDao.createAdvert(adv));
		
		
		
		/*List<Advert> advList= advertDao.getCurrentAdverts();
		assertEquals("There should be only 1 Advert",1, advList.size());*/
		
		Advert adv2= new Advert(u, "Passport System Expert");
		assertTrue("Advert Creation should return true", advertDao.createAdvert(adv2));
		
		/*adv= advList.get(0);
		adv.setAdvert("JUnit expert is here");
		assertTrue("This should return true", advertDao.updateAdvert(adv));*/
		List<Advert> advertList;
		advertList =advertDao.getAdvertsByUsername(u.getUsername());
		assertEquals("There should be two adverts", 2, advertList.size());
		
		/*assertTrue("This should return true on delete", advertDao.delete(adv.getId()));
		
		advList=advertDao.getCurrentAdverts();
		assertEquals("There should be no Advert",0, advList.size());
		*/
		
		
	}
	
	
	
}
