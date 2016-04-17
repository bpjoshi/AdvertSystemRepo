package com.bpjoshi.advertsys.test.tests;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
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
	
	private User user1= new User("rohit1", "rohit palariya", "rohit@palariya.com", "password", true, "ROLE_USER");
	private User user2= new User("rohit2", "rohit palariya", "rohit@palariya.com", "password", true, "ROLE_USER");
	
	
	@Before
	public void init(){
		JdbcTemplate jdbc= new JdbcTemplate(dataSource);
		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");
	}
	
	@Test
	public void testCreateRetrieve(){
		userDao.createAccount(user1);
		List<User> userList= userDao.getAllUsers();
		assertEquals("Only user should have been created", 1, userList.size());
		assertEquals("Insert and retrieved users should match", user1, userList.get(0));
		
		userDao.createAccount(user2);
		userList= userDao.getAllUsers();
		assertEquals("Should be 2 insert users", 2, userList.size());
	}
	
	
	@Test
	public void exists(){
		userDao.createAccount(user1);
		userDao.createAccount(user2);
		
		assertTrue("This user should exist", userDao.exists(user2.getUsername()));
		assertFalse("This user should not exist", userDao.exists("abcdefg"));
	}
}
