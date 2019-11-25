//package com.elec5619.sr.domain;
//
//import static org.junit.Assert.*;
//import com.elec5619.sr.domain.Reviews;
//
//import java.util.Date;
//
//import org.junit.Test;
//
//import junit.framework.TestCase;
//
//public class ReviewsTest extends TestCase {
//	private Reviews reviews;
//	
//	protected void setUp() throws Exception {
//		reviews = new Reviews();
//	}
//    public void testSetAndGetId() {
//        int id = 2;
//        reviews.setId(id);
//        assertEquals(id,reviews.getId());
//    }
//	
//    public void testSetAndGetDescription() {
//        String testDescription = "aDescription";
//        assertNull(reviews.getDescription());
//        reviews.setDescription(testDescription);
//        assertEquals(testDescription, reviews.getDescription());
//    }
//    
//    public void testSetAndGetTitle() {
//        String testTitle = "aTitle";
//        assertNull(reviews.getTitle());
//        reviews.setTitle(testTitle);
//        assertEquals(testTitle, reviews.getTitle());
//    }
//    
//    public void testSetAndGetStudentReview() {
//    	
//    	StudentReview studentReview = new StudentReview();
//    	studentReview.setId(1);
//    	studentReview.setRev_id("aRev_id");
//    	studentReview.setRev_points(1);
//    	studentReview.setRev_count(1);
//        assertNull(reviews.getStudentReview());
//        
//        reviews.setStudentReview(studentReview);
//        assertEquals(studentReview, reviews.getStudentReview());
//    }
//}
//
