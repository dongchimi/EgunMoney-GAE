package com.appspot.egunmoney;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalUserServiceTestConfig;


public class AuthenticationTest {

    private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalUserServiceTestConfig())
            .setEnvIsAdmin(true).setEnvIsLoggedIn(true);

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
        UserService userService = UserServiceFactory.getUserService();
        //assertTrue(userService.isUserAdmin());
    }
}
