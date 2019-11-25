package com.elec5619.sr.domain;

import junit.framework.TestCase;

public class GroupTest extends TestCase{
	private Group group;
	
	protected void setUp() throws Exception {
		group = new Group();
	}
	
    public void testSetAndGetId() {
        int id = 2;
        group.setId(id);
        assertEquals(id,group.getId());
    }
    
    public void testSetAndGetCourseEnrolledGroup() {
    	
    	CourseEnrolled courseEnrolled = new CourseEnrolled();
    	
    	Course course = new Course();
    	course.setCode("aCode");
    	course.setTitle("aTitle");
    	course.setDescription("aDescription");
    	courseEnrolled.setUnitCodeCourse(course);
        assertNull(group.getCourseEnrolledGroup());
    	group.setCourseEnrolledGroup(courseEnrolled);
        assertEquals(courseEnrolled, group.getCourseEnrolledGroup());
    }
    
    public void testSetAndGetUserGroup() {
    	
    	User user = new User();
    	user.setId(1);
    	user.setUsername("Test Test");
        assertNull(group.getUserGroup());
        
        group.setUserGroup(user);
        assertEquals(user, group.getUserGroup());
    }
    
    public void testSetAndGetUnitGroupId() {
        String testUnitGroupId = "aUnitGroupId";
        assertNull(group.getUnitGroupId());
        group.setUnitGroupId(testUnitGroupId);
        assertEquals(testUnitGroupId, group.getUnitGroupId());
    }
    
    public void testSetAndGetGroupLimit() {
        String testGroupLimit = "aGroupLimit";
        assertNull(group.getGroupLimit());
        group.setGroupLimit(testGroupLimit);
        assertEquals(testGroupLimit, group.getGroupLimit());
    }
    
    public void testSetAndGetGroupMiniLimit() {
        String testGroupMiniLimit = "aGroupMiniLimit";
        assertNull(group.getGroupMiniLimit());
        group.setGroupMiniLimit(testGroupMiniLimit);
        assertEquals(testGroupMiniLimit, group.getGroupMiniLimit());
    }
    
    public void testSetAndGetContract() {
        String testContract = "aContract";
        assertNull(group.getContract());
        group.setContract(testContract);
        assertEquals(testContract, group.getContract());
    }
    
    public void testSetAndGetLocked() {
        boolean testLocked = false;
        group.setLocked(testLocked);
        assertEquals(testLocked, group.isLocked());
    }
}
