package com.elec5619.sr.domain;

import junit.framework.TestCase;

public class LoginTest extends TestCase{
	private  Login login;
	
	protected void setUp() throws Exception {
		login = new Login();
	}
	

    public void testSetAndGetUsername() {
        String testUsername = "aUsername";
        assertNull(login.getUsername());
        login.setUsername(testUsername);
        assertEquals(testUsername, login.getUsername());
    }
    
    public void testSetAndGetPassword() {
        String testPassword = "aPassword";
        assertNull(login.getPassword());
        login.setPassword(testPassword);
        assertEquals(testPassword, login.getPassword());
    }
    
    public void testSetAndGetPasswordAfterSet() {
        String testPassword = "aPassword";        
        login.setPassword(testPassword);
        assertNotNull(login.getPassword());
    }
}
