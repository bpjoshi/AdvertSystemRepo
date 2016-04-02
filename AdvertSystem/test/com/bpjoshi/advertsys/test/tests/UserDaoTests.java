package com.bpjoshi.advertsys.test.tests;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bpjoshi.advertsys.dao.UserDao;
import com.bpjoshi.advertsys.model.User;

@ActiveProfiles("dev")
@ContextConfiguration(locations={"classpath:com/bpjoshi/advertsys/config/dao-context.xml",
		"classpath:com/bpjoshi/advertsys/config/security-context.xml"
		, "classpath:com/bpjoshi/advertsys/test/config/datasource.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void init(){
		JdbcTemplate jdbc= new JdbcTemplate(dataSource);
		jdbc.execute("delete from authorities");
		jdbc.execute("delete from users");
	}
	
	@Test
	public void testCreateAccount(){
		
		User user= new User("rohit", "rohit@palariya.com", "password", true, "ROLE_USER");
		assertTrue("Admin Account Created", userDao.createAccount(user));
		
		List<User> userList= userDao.getAllUsers();
		assertEquals("Number of User should be 1",1, userList.size());
		
		assertTrue("This user should exist", userDao.exists(user.getUsername()));
		
		assertEquals("The users must be euqal", user, userList.get(0));
	}
}
