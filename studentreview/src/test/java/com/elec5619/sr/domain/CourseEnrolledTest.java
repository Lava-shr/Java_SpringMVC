package com.elec5619.sr.domain;

import java.util.Date;

import junit.framework.TestCase;

public class CourseEnrolledTest extends TestCase {
	private CourseEnrolled courseEnrolled;
	
	protected void setUp() throws Exception {
		courseEnrolled = new CourseEnrolled();
	}
	
    public void testSetAndGetId() {
        int id = 2;
        courseEnrolled.setId(id);
        assertEquals(id,courseEnrolled.getId());
    }
    
    public void testSetAndGetUnitCodeCourse() {
    	
    	Course course = new Course();
    	course.setCode("aCode");
    	course.setTitle("aTitle");
    	course.setDescription("aDescription");
        assertNull(courseEnrolled.getUnitCodeCourse());
        
        courseEnrolled.setUnitCodeCourse(course);
        assertEquals(course, courseEnrolled.getUnitCodeCourse());
    }
    

    public void testSetAndGetUserCourseEnrolled() {
    	
    	User user = new User();
    	user.setId(1);
    	user.setUsername("Test Test");
        assertNull(courseEnrolled.getUserCourseEnrolled());
        
        courseEnrolled.setUserCourseEnrolled(user);
        assertEquals(user, courseEnrolled.getUserCourseEnrolled());
    }
    
    public void testSetAndGetEnrolledStatus() {
        String testEnrolledStatus = "aEnrolledStatus";
        assertNull(courseEnrolled.getEnrolledStatus());
        courseEnrolled.setEnrolledStatus(testEnrolledStatus);
        assertEquals(testEnrolledStatus, courseEnrolled.getEnrolledStatus());
    }
}
