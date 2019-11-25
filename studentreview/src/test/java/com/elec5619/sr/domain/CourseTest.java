package com.elec5619.sr.domain;

import junit.framework.TestCase;

public class CourseTest extends TestCase {
	private Course course;
	
	protected void setUp() throws Exception {
		course = new Course();
	}
	
    public void testSetAndGetCode() {
        String testCode = "aCode";
        assertNull(course.getCode());
        course.setCode(testCode);
        assertEquals(testCode, course.getCode());
    }
	 
    public void testSetAndGetDescription() {
        String testDescription = "aDescription";
        assertNull(course.getDescription());
        course.setDescription(testDescription);
        assertEquals(testDescription, course.getDescription());
    }
    
    public void testSetAndGetTitle() {
        String testTitle = "aTitle";
        assertNull(course.getTitle());
        course.setTitle(testTitle);
        assertEquals(testTitle, course.getTitle());
    }
}
