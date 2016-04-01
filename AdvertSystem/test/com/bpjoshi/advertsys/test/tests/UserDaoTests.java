package com.bpjoshi.advertsys.test.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("dev")
@ContextConfiguration(locations={"classpath:com/bpjoshi/advertsys/config/dao-context.xml",
		"classpath:com/bpjoshi/advertsys/config/security-context.xml"
		, "classpath:com/bpjoshi/advertsys/test/config/datasource.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {
	@Test
	public void testCreateUser(){
		assertEquals("Dummy Test", 1, 1);
	}
}
