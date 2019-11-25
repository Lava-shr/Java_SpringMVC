package com.elec5619.sr.dao;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elec5619.sr.domain.*;
import java.util.*;


/*
 * This Dao is used to generate some sample data and add necessary data , not tested for this class
 */


@Repository(value = "dataAdditionDao")
@Transactional

public class DataAdditionDao {
	
	@Autowired
	private UserDao userDao ;

	@Resource
	 private SessionFactory sessionFactory;
	

	 
	public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
	

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    // Adding user login 
    public void addAdminLogUserLogin(User u) {
    	AdminLog a = new AdminLog();
    	a.setDescription("User logged in with user name: " + u.getUsername());
    	a.setCreatedDate(new Date());
		sessionFactory.getCurrentSession().save(a);
    	
    }
    
    // DATA addition for testing
    public void addUserForTesting(User u) {
		sessionFactory.getCurrentSession().save(u);
		
    }
    
    
    // Example Method to Updating user details
    public void addUser() {
    	Session currentSession = this.sessionFactory.getCurrentSession();
    	Query q = currentSession.createQuery("from User u where u.id = :uid");
    	q.setInteger("uid", 2);
    	
    	List<User> user = q.list();
    	User u = user.get(0);
    	u.setEmail("user1@uni.com");
    	u.setPhoneNumber("0412312300");
		sessionFactory.getCurrentSession().save(u);

    }
	
	// Just some data to populate the SQL tables;
    public void addData() {

		// Adding users
		User user = new User();
		user.setUsername("user1");
		user.setHashPass("password");
		user.setFullName("James Jackson");
		user.setAge(11);
		user.setId(2);
		user.setEmail("user1@uni.com");
		sessionFactory.getCurrentSession().save(user);

		User user2 = new User();
		user2.setUsername("user2");
		user2.setHashPass("password");
		user2.setFullName("Andrew AM");
		user2.setAge(11);
		user2.setId(3);
		user2.setEmail("user2@uni.com");
		sessionFactory.getCurrentSession().save(user2);

		User user3 = new User();
		user3.setUsername("user3");
		user3.setHashPass("password");
		user3.setFullName("Harry Potter");
		user3.setAge(11);
		user3.setId(4);
		user3.setEmail("user3@uni.com");
		sessionFactory.getCurrentSession().save(user3);
		
		User user4 = new User();
		user4.setUsername("user4");
		user4.setHashPass("password");
		user4.setFullName("John John");
		user4.setAge(11);
		user4.setId(5);
		user4.setEmail("user4@uni.com");
		sessionFactory.getCurrentSession().save(user4);
		
		User user5 = new User();
		user5.setUsername("user5");
		user5.setHashPass("password");
		user5.setFullName("Jadyen John");
		user5.setAge(11);
		user5.setId(6);
		user5.setEmail("user5@uni.com");
		sessionFactory.getCurrentSession().save(user5);
		
		User user6 = new User();
		user6.setUsername("user6");
		user6.setHashPass("password");
		user6.setFullName("Andy Murray");
		user6.setAge(11);
		user6.setId(7);
		user.setEmail("user6@uni.com");
		sessionFactory.getCurrentSession().save(user6);
		
		User user7 = new User();
		user7.setUsername("user7");
		user7.setHashPass("password");
		user7.setFullName("Rafeal Nadal");
		user7.setAge(11);
		user7.setId(8);
		user7.setEmail("user7@uni.com");
		sessionFactory.getCurrentSession().save(user7);
		
		User user8 = new User();
		user8.setUsername("user8");
		user8.setHashPass("password");
		user8.setFullName("Messi Jun");
		user8.setAge(11);
		user8.setId(8);
		user8.setEmail("user8@uni.com");
		sessionFactory.getCurrentSession().save(user8);
		
		User user9 = new User();
		user9.setUsername("user9");
		user9.setHashPass("password");
		user9.setFullName("Ronaldo Chris");
		user9.setAge(11);
		user9.setId(9);
		user9.setEmail("user9@uni.com");
		sessionFactory.getCurrentSession().save(user9);
		
		User user10 = new User();
		user10.setUsername("user10");
		user10.setHashPass("password");
		user10.setFullName("Chris Hall");
		user10.setAge(11);
		user10.setId(11);
		user10.setEmail("user10@uni.com");
		sessionFactory.getCurrentSession().save(user10);
		
		User user11 = new User();
		user11.setUsername("user11");
		user11.setHashPass("password");
		user11.setFullName("Ryan Renolds");
		user11.setAge(11);
		user11.setId(12);
		user11.setEmail("user11@uni.com");
		sessionFactory.getCurrentSession().save(user11);
		
		System.out.println("User added");
		
		User user12 = new User();
		user12.setUsername("user12");
		user12.setHashPass("password");
		user12.setFullName("Harold Man");
		user12.setAge(11);
		user12.setId(13);
		user12.setEmail("use12r@uni.com");
		sessionFactory.getCurrentSession().save(user12);
		System.out.println("User added");

		// Adding course
		Course course1 = new Course();
		course1.setCode("ELEC5619");
		course1.setDescription("Java using Spring Frameworks");
		course1.setTitle("Software Frameworks");
		sessionFactory.getCurrentSession().save(course1);

		Course course2 = new Course();
		course2.setCode("ELEC3609");
		course2.setDescription("Pythin using Django Frameworks");
		course2.setTitle("Software Frameworks");
		sessionFactory.getCurrentSession().save(course2);

		Course course3 = new Course();
		course3.setCode("ELEC2302");
		course3.setDescription("Maths, Fourier Transform");
		course3.setTitle("Signals and Systems");
		sessionFactory.getCurrentSession().save(course3);
		System.out.println("Course added");
		
		Course course4 = new Course();
		course4.setCode("ELEC3610");
		course4.setDescription("E-Business Analysis and Design");
		course4.setTitle("E-Business Analysis and Design");
		sessionFactory.getCurrentSession().save(course4);
		System.out.println("Course added");
		
		Course course5 = new Course();
		course5.setCode("ENGG1111");
		course5.setDescription("Integerated Engineering 1");
		course5.setTitle("Integerated Engineering 1");
		sessionFactory.getCurrentSession().save(course5);
		System.out.println("Course added");
		
		Course course6 = new Course();
		course6.setCode("INFO3315");
		course6.setDescription("Human Computer Interaction");
		course6.setTitle("Human Computer Interaction");
		sessionFactory.getCurrentSession().save(course6);
		System.out.println("Course added");
					


		// Adding courses Enrolled for first user
		CourseEnrolled courseEn1U1 = new CourseEnrolled();
		courseEn1U1.setUserCourseEnrolled(user);
		courseEn1U1.setUnitCodeCourse(course1);
		courseEn1U1.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn1U1);

		CourseEnrolled courseEn2U1 = new CourseEnrolled();
		courseEn2U1.setUserCourseEnrolled(user);
		courseEn2U1.setUnitCodeCourse(course2);
		courseEn2U1.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn2U1);

		CourseEnrolled courseEn3U1 = new CourseEnrolled();
		courseEn3U1.setUserCourseEnrolled(user);
		courseEn3U1.setUnitCodeCourse(course3);
		courseEn3U1.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn3U1);
		System.out.println("Course Enrolled added");
		
		// Adding courses Enrolled for second user
		CourseEnrolled courseEn1U2 = new CourseEnrolled();
		courseEn1U2.setUserCourseEnrolled(user2);
		courseEn1U2.setUnitCodeCourse(course1);
		courseEn1U2.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn1U2);

		CourseEnrolled courseEn2U2 = new CourseEnrolled();
		courseEn2U2.setUserCourseEnrolled(user2);
		courseEn2U2.setUnitCodeCourse(course2);
		courseEn2U2.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn2U2);

		CourseEnrolled courseEn3U2 = new CourseEnrolled();
		courseEn3U2.setUserCourseEnrolled(user2);
		courseEn3U2.setUnitCodeCourse(course3);
		courseEn3U2.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn3U2);
		System.out.println("Course Enrolled added");
		
		CourseEnrolled courseEn4U2 = new CourseEnrolled();
		courseEn4U2.setUserCourseEnrolled(user2);
		courseEn4U2.setUnitCodeCourse(course4);
		courseEn4U2.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn4U2);
		
		// Adding courses Enrolled for third user
		CourseEnrolled courseEn1U3 = new CourseEnrolled();
		courseEn1U3.setUserCourseEnrolled(user3);
		courseEn1U3.setUnitCodeCourse(course1);
		courseEn1U3.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn1U3);

		CourseEnrolled courseEn2U3 = new CourseEnrolled();
		courseEn2U3.setUserCourseEnrolled(user3);
		courseEn2U3.setUnitCodeCourse(course3);
		courseEn2U3.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn2U3);

		CourseEnrolled courseEn3U3 = new CourseEnrolled();
		courseEn3U3.setUserCourseEnrolled(user3);
		courseEn3U3.setUnitCodeCourse(course6);
		courseEn3U3.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn3U3);
		
					
		// Adding courses Enrolled for fourth user
		CourseEnrolled courseEn1U4 = new CourseEnrolled();
		courseEn1U4.setUserCourseEnrolled(user4);
		courseEn1U4.setUnitCodeCourse(course2);
		courseEn1U4.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn1U4);

		CourseEnrolled courseEn2U4 = new CourseEnrolled();
		courseEn2U4.setUserCourseEnrolled(user4);
		courseEn2U4.setUnitCodeCourse(course3);
		courseEn2U4.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn2U4);

		CourseEnrolled courseEn3U4 = new CourseEnrolled();
		courseEn3U4.setUserCourseEnrolled(user4);
		courseEn3U4.setUnitCodeCourse(course4);
		courseEn3U4.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn3U4);
		
		// Adding courses Enrolled for fifth user
		CourseEnrolled courseEn1U5 = new CourseEnrolled();
		courseEn1U5.setUserCourseEnrolled(user5);
		courseEn1U5.setUnitCodeCourse(course2);
		courseEn1U5.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn1U5);

		CourseEnrolled courseEn2U5 = new CourseEnrolled();
		courseEn2U5.setUserCourseEnrolled(user5);
		courseEn2U5.setUnitCodeCourse(course1);
		courseEn2U5.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn2U5);

		CourseEnrolled courseEn3U5 = new CourseEnrolled();
		courseEn3U5.setUserCourseEnrolled(user5);
		courseEn3U5.setUnitCodeCourse(course4);
		courseEn3U5.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn3U5);
		
		CourseEnrolled courseEn4U5 = new CourseEnrolled();
		courseEn4U5.setUserCourseEnrolled(user5);
		courseEn4U5.setUnitCodeCourse(course5);
		courseEn4U5.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn4U5);
		System.out.println("Course Enrolled added");
		
		// Adding courses Enrolled for sixth user
		CourseEnrolled courseEn1U6 = new CourseEnrolled();
		courseEn1U6.setUserCourseEnrolled(user6);
		courseEn1U6.setUnitCodeCourse(course3);
		courseEn1U6.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn1U6);

		CourseEnrolled courseEn2U6 = new CourseEnrolled();
		courseEn2U6.setUserCourseEnrolled(user6);
		courseEn2U6.setUnitCodeCourse(course1);
		courseEn2U6.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn2U6);

		CourseEnrolled courseEn3U6 = new CourseEnrolled();
		courseEn3U6.setUserCourseEnrolled(user6);
		courseEn3U6.setUnitCodeCourse(course6);
		courseEn3U6.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn3U6);
		
		CourseEnrolled courseEn4U6 = new CourseEnrolled();
		courseEn4U6.setUserCourseEnrolled(user6);
		courseEn4U6.setUnitCodeCourse(course5);
		courseEn4U6.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn4U6);
		System.out.println("Course Enrolled added");
		
		// Adding courses Enrolled for seventh user
		CourseEnrolled courseEn1U7 = new CourseEnrolled();
		courseEn1U7.setUserCourseEnrolled(user7);
		courseEn1U7.setUnitCodeCourse(course5);
		courseEn1U7.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn1U7);

		CourseEnrolled courseEn2U7 = new CourseEnrolled();
		courseEn2U7.setUserCourseEnrolled(user7);
		courseEn2U7.setUnitCodeCourse(course3);
		courseEn2U7.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn2U7);

		CourseEnrolled courseEn3U7 = new CourseEnrolled();
		courseEn3U7.setUserCourseEnrolled(user7);
		courseEn3U7.setUnitCodeCourse(course6);
		courseEn3U7.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn3U7);
		
		CourseEnrolled courseEn4U7 = new CourseEnrolled();
		courseEn4U7.setUserCourseEnrolled(user7);
		courseEn4U7.setUnitCodeCourse(course1);
		courseEn4U7.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn4U7);
		System.out.println("Course Enrolled added");
		
		// Adding courses Enrolled for fifth user
		CourseEnrolled courseEn1U8 = new CourseEnrolled();
		courseEn1U8.setUserCourseEnrolled(user8);
		courseEn1U8.setUnitCodeCourse(course1);
		courseEn1U8.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn1U8);

		CourseEnrolled courseEn2U8 = new CourseEnrolled();
		courseEn2U8.setUserCourseEnrolled(user8);
		courseEn2U8.setUnitCodeCourse(course4);
		courseEn2U8.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn2U8);

		CourseEnrolled courseEn3U8 = new CourseEnrolled();
		courseEn3U8.setUserCourseEnrolled(user8);
		courseEn3U8.setUnitCodeCourse(course3);
		courseEn3U8.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn3U8);
		
		CourseEnrolled courseEn4U8 = new CourseEnrolled();
		courseEn4U8.setUserCourseEnrolled(user8);
		courseEn4U8.setUnitCodeCourse(course5);
		courseEn4U8.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn4U8);
		System.out.println("Course Enrolled added");
		
		// Adding courses Enrolled for ninth user
		CourseEnrolled courseEn1U9 = new CourseEnrolled();
		courseEn1U5.setUserCourseEnrolled(user9);
		courseEn1U5.setUnitCodeCourse(course2);
		courseEn1U5.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn1U9);

		CourseEnrolled courseEn2U9 = new CourseEnrolled();
		courseEn2U9.setUserCourseEnrolled(user9);
		courseEn2U9.setUnitCodeCourse(course1);
		courseEn2U9.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn2U9);

		CourseEnrolled courseEn3U9 = new CourseEnrolled();
		courseEn3U9.setUserCourseEnrolled(user9);
		courseEn3U9.setUnitCodeCourse(course4);
		courseEn3U9.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn3U9);
		
		// Adding courses Enrolled for tenth user
		CourseEnrolled courseEn1U10 = new CourseEnrolled();
		courseEn1U10.setUserCourseEnrolled(user10);
		courseEn1U10.setUnitCodeCourse(course6);
		courseEn1U10.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn1U10);

		CourseEnrolled courseEn2U10 = new CourseEnrolled();
		courseEn2U10.setUserCourseEnrolled(user10);
		courseEn2U10.setUnitCodeCourse(course2);
		courseEn2U10.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn2U10);

		CourseEnrolled courseEn3U10 = new CourseEnrolled();
		courseEn3U10.setUserCourseEnrolled(user10);
		courseEn3U10.setUnitCodeCourse(course4);
		courseEn3U10.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn3U10);
		
		CourseEnrolled courseEn4U10 = new CourseEnrolled();
		courseEn4U10.setUserCourseEnrolled(user10);
		courseEn4U10.setUnitCodeCourse(course5);
		courseEn4U10.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn4U10);
		System.out.println("Course Enrolled added");
		
		// Adding courses Enrolled for eleventh user
		CourseEnrolled courseEn1U11 = new CourseEnrolled();
		courseEn1U11.setUserCourseEnrolled(user11);
		courseEn1U11.setUnitCodeCourse(course6);
		courseEn1U11.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn1U11);

		CourseEnrolled courseEn2U11 = new CourseEnrolled();
		courseEn2U11.setUserCourseEnrolled(user11);
		courseEn2U11.setUnitCodeCourse(course1);
		courseEn2U11.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn2U11);

		CourseEnrolled courseEn3U11 = new CourseEnrolled();
		courseEn3U11.setUserCourseEnrolled(user11);
		courseEn3U11.setUnitCodeCourse(course4);
		courseEn3U11.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn3U11);
		
		CourseEnrolled courseEn4U11 = new CourseEnrolled();
		courseEn4U11.setUserCourseEnrolled(user11);
		courseEn4U11.setUnitCodeCourse(course5);
		courseEn4U11.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn4U11);
		System.out.println("Course Enrolled added");
		
		// Adding courses Enrolled for twelfth user
		CourseEnrolled courseEn1U12 = new CourseEnrolled();
		courseEn1U12.setUserCourseEnrolled(user12);
		courseEn1U12.setUnitCodeCourse(course1);
		courseEn1U12.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn1U12);

		CourseEnrolled courseEn2U12 = new CourseEnrolled();
		courseEn2U12.setUserCourseEnrolled(user12);
		courseEn2U12.setUnitCodeCourse(course5);
		courseEn2U12.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn2U12);

		CourseEnrolled courseEn3U12 = new CourseEnrolled();
		courseEn3U12.setUserCourseEnrolled(user12);
		courseEn3U12.setUnitCodeCourse(course4);
		courseEn3U12.setEnrolledStatus("Enrolled");
		sessionFactory.getCurrentSession().save(courseEn3U12);

		// Adding Group for courseEn1 and user
		Group group1 = new Group();
		group1.setUnitGroupId("1");
		group1.setCourseEnrolledGroup(courseEn1U1);
		group1.setStudentUsername(user);
		group1.setGroupLimit("5");
		group1.setGroupMiniLimit("2");
		group1.setContract("Contract between groups");
		group1.setLocked(false);
		sessionFactory.getCurrentSession().save(group1);

		// Adding Group for courseEn1 and user2
		Group group2 = new Group();
		group2.setUnitGroupId("1");
		group2.setCourseEnrolledGroup(courseEn1U1);
		group2.setStudentUsername(user2);
		group2.setGroupLimit("5");
		group2.setGroupMiniLimit("2");
		group2.setContract("Contract between groups");
		group2.setLocked(false);
		sessionFactory.getCurrentSession().save(group2);

		// Adding Group for courseEn1 and user3
		Group group3 = new Group();
		group3.setUnitGroupId("1");
		group3.setCourseEnrolledGroup(courseEn1U1);
		group3.setStudentUsername(user3);
		group3.setGroupLimit("5");
		group3.setGroupMiniLimit("2");
		group3.setContract("Contract between groups");
		group3.setLocked(false);
		sessionFactory.getCurrentSession().save(group3);
		System.out.println("Group added");
		// Adding reviews to studentReview review1
				System.out.println("Data added");

		// Adding reviews to studentReview review1
		System.out.println("Data added");

    }
    
	public void addNewReview() {

		User user = userDao.getUserById(2);

			// Adding Student reviews for first user;
			StudentReview review1 = new StudentReview();
			review1.setStudentUsername(user);
			review1.setTitle("Meeting Punctuality");
			review1.setRev_points(5);
			review1.setRev_count(1);
			sessionFactory.getCurrentSession().save(review1);
	
			StudentReview review2 = new StudentReview();
			review2.setStudentUsername(user);
			review2.setTitle("Effort");
			review2.setRev_points(5);
			review2.setRev_count(2);
			sessionFactory.getCurrentSession().save(review2);
			System.out.println("Student reviews added");
	
			StudentReview review3 = new StudentReview();
			review3.setStudentUsername(user);
			review3.setTitle("Team Skills");
			review3.setRev_points(5);
			review3.setRev_count(3);
			sessionFactory.getCurrentSession().save(review3);
			System.out.println("Student reviews added");
	
			StudentReview review4 = new StudentReview();
			review4.setStudentUsername(user);
			review4.setTitle("Technical Skills");
			review4.setRev_points(5);
			review4.setRev_count(4);
			sessionFactory.getCurrentSession().save(review4);
			System.out.println("Student reviews added");
	
			StudentReview review5 = new StudentReview();
			review5.setStudentUsername(user);
			review5.setTitle("Contextual Skills");
			review5.setRev_points(5);
			review5.setRev_count(5);
			sessionFactory.getCurrentSession().save(review5);
			System.out.println("Student reviews added");

	}

	/*
	 * user; reviewing this user with given points
	 */
	public void addReviewOfStudent(User user, int punctuality, int effort, int team_skill, 
									int tech_skill, int con_skill) {
		
		StudentReview review1 = new StudentReview();
		review1.setStudentUsername(user);
		review1.setTitle("Meeting Punctuality");
		review1.setRev_points(punctuality);
		review1.setRev_count(1);
		sessionFactory.getCurrentSession().save(review1);

		StudentReview review2 = new StudentReview();
		review2.setStudentUsername(user);
		review2.setTitle("Effort");
		review2.setRev_points(effort);
		review2.setRev_count(2);
		sessionFactory.getCurrentSession().save(review2);

		StudentReview review3 = new StudentReview();
		review3.setStudentUsername(user);
		review3.setTitle("Team Skills");
		review3.setRev_points(team_skill);
		review3.setRev_count(3);
		sessionFactory.getCurrentSession().save(review3);

		StudentReview review4 = new StudentReview();
		review4.setStudentUsername(user);
		review4.setTitle("Technical Skills");
		review4.setRev_points(tech_skill);
		review4.setRev_count(4);
		sessionFactory.getCurrentSession().save(review4);

		StudentReview review5 = new StudentReview();
		review5.setStudentUsername(user);
		review5.setTitle("Contextual Skills");
		review5.setRev_points(con_skill);
		review5.setRev_count(5);
		sessionFactory.getCurrentSession().save(review5);
		
		
	}
   

}
