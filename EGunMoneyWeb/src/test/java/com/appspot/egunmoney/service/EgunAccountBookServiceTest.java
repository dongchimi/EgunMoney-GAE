package com.appspot.egunmoney.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalUserServiceTestConfig;

public class EgunAccountBookServiceTest {

	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalUserServiceTestConfig()).setEnvIsAdmin(true)
			.setEnvIsLoggedIn(true);

	@Before
	public void setUp() {
		helper.setUp();
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}
	
	@Test
    public void testIsAdmin() {
    }
}