package com.elec5619.sr.domain;

import org.junit.Test;

import junit.framework.TestCase;


public class StudentReviewTest extends TestCase {
	private StudentReview studentReview;
    @Test
	protected void setUp() throws Exception {
		studentReview = new StudentReview();
		
    }
    @Test
    public void testSetAndGetId() {
        int id = 2;
        studentReview.setId(id);
        assertEquals(id,studentReview.getId());
    }
    
    public void testSetAndGetUserStudentReview() {
    	
    	User user = new User();
    	user.setId(1);
    	user.setUsername("Test Test");
        assertNull(studentReview.getStudentUsername());
        
        studentReview.setStudentUsername(user);
        assertEquals(user, studentReview.getStudentUsername());
    }
    
    public void testSetAndGetRev_id() {
        String testTitle = "Meeting Punctuality";
        assertNull(studentReview.getTitle());
        studentReview.setTitle(testTitle);
        assertEquals(testTitle, studentReview.getTitle());
    }
    
    public void testSetAndGetRev_points() {
        int testRev_points = 5;
        studentReview.setRev_points(testRev_points);
        assertEquals(testRev_points, studentReview.getRev_points());
    }
    
    public void testSetAndGetRev_count() {
        int testRev_count = 10;
        studentReview.setRev_count(testRev_count);
        assertEquals(testRev_count, studentReview.getRev_count());
    }
}
