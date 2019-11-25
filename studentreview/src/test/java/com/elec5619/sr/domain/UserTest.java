package com.elec5619.sr.domain;

import static org.junit.Assert.*;
import junit.framework.TestCase;

public class UserTest extends TestCase{

	private User user;
	
	protected void setUp() throws Exception {
		user = new User();
	}

    public void testSetAndGetId() {
        int id = 2;
        user.setId(id);
        assertEquals(id, user.getId());
    }
    
    public void testSetAndGetUsername() {
        String username = "Test1";
        assertNull(user.getUsername());
        user.setUsername(username);
        assertEquals(username, user.getUsername());
    }
    

    public void testSetAndGetFullname() {
        String fullname = "Test Harold";
        assertNull(user.getFullName());
        user.setFullName(fullname);
        assertEquals(fullname, user.getFullName());
    }
    
	
    public void testSetAndGetHashPass() {
        String hashpass = "xbsd738sudusd77sd7b";
        assertNull(user.getHashPass());
        user.setHashPass(hashpass);
        assertEquals(hashpass, user.getHashPass());
    }
    
	
    public void testSetAndGetEmail() {
        String email = "Test1@gmail.com";
        assertNull(user.getEmail());
        user.setEmail(email);
        assertEquals(email, user.getEmail());
    }
    
	
    public void testSetAndGetPhoneNumber() {
        String phoneNumber = "04123456783";
        assertNull(user.getPhoneNumber());
        user.setPhoneNumber(phoneNumber);
        assertEquals(phoneNumber, user.getPhoneNumber());
    }
	
	  
    public void testSetAndGetAge() {
        int age = 21;
        user.setAge(age);
        assertEquals(age, user.getAge());
    }
    
	
    public void testSetAndGetUniversity() {
        String university = "University of Sydney";
        assertNull(user.getUniversity());
        user.setUniversity(university);
        assertEquals(university, user.getUniversity());
    }
    
	
    public void testSetAndGetGender() {
        String gender = "Male";
        assertNull(user.getGender());
        user.setGender(gender);
        assertEquals(gender, user.getGender());
    }
	
	    
    public void testSetAndGetBiography() {
        String biography = "Hello, I am a software student";
        assertNull(user.getBiography());
        user.setBiography(biography);
        assertEquals(biography, user.getBiography());
    }
    
    
    public void testSetAndGetAvatar() {
        String testImage = "aAvatar";
        byte [] testAvatar = testImage.getBytes();
        assertNull(user.getAvatar());
        user.setAvatar(testAvatar);
        assertEquals(testAvatar, user.getAvatar());
    }
}
