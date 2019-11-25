package com.elec5619.sr.domain;

import java.util.Date;

import org.junit.Test;

import junit.framework.TestCase;

public class AdminLogTest extends TestCase {
	private AdminLog adminLog;
	
	protected void setUp() throws Exception {
		adminLog = new AdminLog();
	}
    public void testSetAndGetId() {
        int id = 2;
        adminLog.setId(id);
        assertEquals(id,adminLog.getId());
    }
	
    public void testSetAndGetDescription() {
        String testDescription = "aDescription";
        assertNull(adminLog.getDescription());
        adminLog.setDescription(testDescription);
        assertEquals(testDescription, adminLog.getDescription());
    }
    
    public void testSetAndGetUnit_group_id() {
        String testUnit_group_id = "aUnit_group_id";
        assertNull(adminLog.getUnit_group_id());
        adminLog.setUnit_group_id(testUnit_group_id);
        assertEquals(testUnit_group_id, adminLog.getUnit_group_id());
    }
    
    public void testSetAndGetCreatedDate() {
    	Date testCreatedDate = new Date( "2019/10/20");
        assertNull(adminLog.getCreatedDate());
        adminLog.setCreatedDate(testCreatedDate);
        assertEquals(testCreatedDate, adminLog.getCreatedDate());
    }
}
