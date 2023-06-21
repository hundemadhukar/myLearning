package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.bean.Login;
import com.config.MyConfiguration;
import com.service.LoginService;
@RunWith(SpringJUnit4ClassRunner.class)   // running spring mvc service layer with junit 4.x 
@ContextConfiguration(classes = MyConfiguration.class,loader = AnnotationConfigContextLoader.class)
public class LoginServiceTest {

	@Autowired
	LoginService loginService;

	@Test
	public void testSignIn() {
		//fail("Not yet implemented");
		Login ll = new Login();
		ll.setEmailid("akash@gmail.com");
		ll.setPassword("123");
		String result = loginService.signIn(ll);
		assertEquals("success", result);
	}

	@Test
	public void testSignUp() {
		Login ll = new Login();
		ll.setEmailid("vikash@gmail.com");
		ll.setPassword("1212");
		String result = loginService.signUp(ll);
		assertEquals("Account created successfully", result);
	}

}
