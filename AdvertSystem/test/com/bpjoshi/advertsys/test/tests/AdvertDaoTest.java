package com.bpjoshi.advertsys.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bpjoshi.advertsys.dao.AdvertDao;
import com.bpjoshi.advertsys.model.Advert;

@ActiveProfiles("dev")
@ContextConfiguration(locations={"classpath:com/bpjoshi/advertsys/config/dao-context.xml",
		"classpath:com/bpjoshi/advertsys/config/security-context.xml"
		, "classpath:com/bpjoshi/advertsys/test/config/datasource.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdvertDaoTest {
	
	@Autowired
	private AdvertDao advertDao;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void init(){
		JdbcTemplate jdbc= new JdbcTemplate(dataSource);
		jdbc.execute("delete from offers");
		jdbc.execute("delete from authorities");
		jdbc.execute("delete from users");
	}
	
	@Test
	public void testOffer(){
		Advert adv= new Advert("Test Ad", "test@junit.com", "I am a Junit Test");
		
		assertTrue("Advert Creation should return true", advertDao.createAdvert(adv));
		
		List<Advert> advList= advertDao.getCurrentAdverts();
		assertEquals("There should be only 1 Advert",1, advList.size());
		
		adv= advList.get(0);
		adv.setAdvert("JUnit expert is here");
		assertTrue("This should return true", advertDao.updateAdvert(adv));
		
		assertTrue("This should return true on delete", advertDao.delete(adv.getId()));
		
		advList=advertDao.getCurrentAdverts();
		assertEquals("There should be no Advert",0, advList.size());
	}
}
