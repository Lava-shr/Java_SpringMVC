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


@Repository(value = "usersDao")
@Transactional
public class UserDao {

	 @Resource
	 private SessionFactory sessionFactory;

	    public SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }

	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }

	    public User getUserByCredentials(String username, String password) {
	    	Session currentSession = this.sessionFactory.getCurrentSession();
	    	User user = (User) currentSession.get(User.class, username);
    		if (user == null) {
    			return null;
    		} else {
    			if (user.getHashPass().equals(password)) {
    				return user;
    			}
    			return null;
    		}
	    }

	    public User getUserByName(String name) {
	    	Session currentSession = this.sessionFactory.getCurrentSession();
    		User user = (User) currentSession.get(User.class, name);

    		return user;
	    }
	    
	    public void addUser(User user) {
	    	Session currentSession = this.sessionFactory.getCurrentSession();
    		currentSession.save(user);
	    }
	    
	    
	    public User getUserById(int id) {
	    	Session currentSession = this.sessionFactory.getCurrentSession();

	    	Query q = currentSession.createQuery("from User u where u.id = :uid");
	    	q.setInteger("uid", id);
	    	if (q.list().size() == 0) {
	    		return null;
	    	} else {
	    		List<User> u = q.list();
	    		return u.get(0);
	    	}
	    }

	    // Check if user name exist
	    public boolean isUser(String username, String password) {
    		Session currentSession = this.sessionFactory.getCurrentSession();
    		User user = (User) currentSession.get(User.class, username);
    		if (user == null) return false;
    		if (user.getUsername().equals(username) && user.getHashPass().equals(password)) {
    			return true;
    		} else {
    			return false;
    		}
	    }

	    // Get user enrolled Unit Code for log in user
	    public ArrayList<String> getUserCourse(String u) {
	    	ArrayList<String> course = new ArrayList<String>();
    		Session session = this.sessionFactory.getCurrentSession();

    		Query q = session.createQuery("from CourseEnrolled s where s.userCourseEnrolled = :sstudent_username");
    		q.setString("sstudent_username", u);
    		List<CourseEnrolled> result = q.list();

    		//System.out.println("User Course");
    		for (CourseEnrolled var : result)
    		{
    		    course.add(var.getUnitCodeCourse().getCode());
    		}

    		return course;
	    }


	    // Get user enrolled Unit Code ID for log in user for Group Page
	    public ArrayList<Integer> getUserCoursesId(String u) {
	    	ArrayList<Integer> course_id = new ArrayList<Integer>();
    		Session session = this.sessionFactory.getCurrentSession();

    		Query q = session.createQuery("from CourseEnrolled s where s.userCourseEnrolled = :sstudent_username");
    		q.setString("sstudent_username", u);
    		List<CourseEnrolled> result = q.list();

    		//System.out.println("User Course");
    		for (CourseEnrolled var : result)
    		{
    		    course_id.add(var.getId());
    		}

    		return course_id;
	    }

	    // Get course ID for the Course given unit_code
	    public int getCourseId(String course) {
    		Session session = this.sessionFactory.getCurrentSession();
	    	Query q = session.createQuery("from CourseEnrolled s where s.unitCodeCourse = :sunit_code");
	    	q.setString("sunit_code", course);
	    	List<CourseEnrolled> l = q.list();


	    	return l.get(0).getId();
	    }


	    //get people in the same group for group page
	    public ArrayList<String> getPeopleInSameGroup(String user, String group_no, int user_course_id){
	    	Session session = this.sessionFactory.getCurrentSession();
	    	Query q = session.createQuery("from Group g WHERE g.unitGroupId = :ggroupId and g.courseEnrolledGroup = :gcourseCode");
	    	q.setString("ggroupId", group_no);
	    	q.setInteger("gcourseCode", user_course_id);
	    	List<Group> results = q.list();

	    	ArrayList<User> group_members = new ArrayList<User>();
	    	ArrayList<String> result = new ArrayList<String>();

	    	for(int i = 1; i < results.size(); ++i) {
	    		result.add(results.get(i).getStudentUsername().getFullName());
	    	}
			return result;

	    }


	    // Getting group no for the user for list of Students page
	    public String getGroupNo(String user, String user_course) {
	    	Session session = this.sessionFactory.getCurrentSession();

	    	Query k = session.createQuery("from CourseEnrolled c where c.unitCodeCourse = :ccourse_code");
    		k.setString("ccourse_code", user_course);
    		List<CourseEnrolled> l = k.list();

    		Query q = session.createQuery("from Group g where g.userGroup = :gstudent_username and g.courseEnrolledGroup  = :gcourse_enrolled_unitcode");
			q.setString("gstudent_username", user);
			q.setInteger("gcourse_enrolled_unitcode",l.get(0).getId());

			if(q.list().size() == 0) {
				return "N/A";
			}else {
				List<Group> g = q.list();
				return g.get(0).getUnitGroupId();
			}
	    }


	    // Getting people not in group logged in user
	    public HashMap<String, Integer> getPeopleNoInGroup(String user, ArrayList<String> user_courses){
	    	Session session = this.sessionFactory.getCurrentSession();
	    	HashMap<String, Integer> no_group = new HashMap<String, Integer>();

	    	for(String var: user_courses) {
	    		Query q = session.createQuery("from CourseEnrolled s where s.unitCodeCourse = :sunit_code and s.enrolledStatus = :senrolled_status");
    			q.setString("sunit_code", var);
    			q.setString("senrolled_status", "Enrolled");
    			int total_students = q.list().size();

    			int in_group = 0;
    			List<CourseEnrolled> students_enrolled = q.list();
    			for(CourseEnrolled c: students_enrolled) {
    				String student = c.getUserCourseEnrolled().getUsername();
    				int unit_code = c.getId();
    				Query k = session.createQuery("from Group g where g.userGroup = :gstudent_username and g.courseEnrolledGroup  = :gcourse_enrolled_unitcode");
    				k.setString("gstudent_username", student);
    				k.setInteger("gcourse_enrolled_unitcode", unit_code);

        			if(k.list().size() != 0) {
        				in_group++;
        			}
    			}

    			int not_in_group = total_students - in_group;
    			no_group.put(var, not_in_group);


	    }
	    	//System.out.println("People not in Group");
	    	for (String name: no_group.keySet()){
                String value = no_group.get(name).toString();
                //System.out.println(name + " " + value);
    		}

	    	return no_group;
	    }

	    // Get total number of students for log in users
	    public HashMap<String, Integer> getTotalStudents(ArrayList<String> user_courses){

    		Session session = this.sessionFactory.getCurrentSession();

    		HashMap<String, Integer> unit_total_students = new HashMap<String, Integer>();

    		for(String var: user_courses) {
    			Query q = session.createQuery("from CourseEnrolled s where s.unitCodeCourse = :sunit_code and s.enrolledStatus = :senrolled_status");
    			q.setString("sunit_code", var);
    			q.setString("senrolled_status", "Enrolled");
    			unit_total_students.put(var, q.list().size());
    		}

    		//System.out.println("Total number of Student");

    		for (String name: unit_total_students.keySet()){
                String value = unit_total_students.get(name).toString();
                //System.out.println(name + " " + value);
    		}

	    	return unit_total_students;
	    }

	    // Get group number for the logged in user
	    public HashMap<String, String> getGroupNo(String user, ArrayList<String> user_courses){
	    	Session session = this.sessionFactory.getCurrentSession();
	    	HashMap<String, String> user_group_no = new HashMap<String, String>();


	    	for(String var: user_courses) {
	    		Query k = session.createQuery("from CourseEnrolled c where c.unitCodeCourse = :ccourse_code");
	    		k.setString("ccourse_code", var);
	    		List<CourseEnrolled> l = k.list();


    			Query q = session.createQuery("from Group g where g.userGroup = :gstudent_username and g.courseEnrolledGroup  = :gcourse_enrolled_unitcode");
    			q.setString("gstudent_username", user);
    			q.setInteger("gcourse_enrolled_unitcode",l.get(0).getId());

    			if(q.list().size() == 0) {
    				user_group_no.put(var, "N/A");
    			}else {
    				List<Group> g = q.list();
    				user_group_no.put(var, String.valueOf(g.get(0).getId()));
    			}
    		}

    		//System.out.println("Getting group number");
	    	for (String name: user_group_no.keySet()){
                //System.out.println(name + " " + user_group_no.get(name));
    		}

	    	return user_group_no;
	    }

	    // Getting group limit for the groups for logged user.
	    public HashMap<String, String> getGroupLimit(String user, ArrayList<String> user_courses){
	    	Session session = this.sessionFactory.getCurrentSession();
	    	HashMap<String, String> group_limit = new HashMap<String, String>();

	    	// need to get user courses ID;


	    	for(String var: user_courses) {
	    		Query k = session.createQuery("from CourseEnrolled e where e.unitCodeCourse = :eunit_code_course");
	    		k.setString("eunit_code_course", var);
	    		List<CourseEnrolled>  unit_code_id = k.list();
	    		int id = unit_code_id.get(0).getId();

    			Query q = session.createQuery("from Group g where g.userGroup = :gstudent_username and g.courseEnrolledGroup  = :gcourse_enrolled_unitcode");
    			q.setInteger("gcourse_enrolled_unitcode", id);
    			q.setString("gstudent_username", user);

    			//System.out.println(q.list().size());
    			if(q.list().size() == 0) {
    				group_limit.put(var, "0/5");

    			}else {
    				List<Group> g = q.list();
    				group_limit.put(var, g.get(0).getGroupMiniLimit()+"/" + g.get(0).getGroupLimit());
    			}
    		}
	    	//System.out.println("Getting group Limit");
	    	for (String name: group_limit.keySet()){
                //System.out.println(name + " " + group_limit.get(name));
    		}
	    	return group_limit;
	    }


	 // Getting group limit for the groups for list of Students page
	    public String getGroupLimit(String user, String user_course){
	    	Session session = this.sessionFactory.getCurrentSession();

	    	Query k = session.createQuery("from CourseEnrolled e where e.unitCodeCourse = :eunit_code_course");
    		k.setString("eunit_code_course", user_course);
    		List<CourseEnrolled>  unit_code_id = k.list();
    		int id = unit_code_id.get(0).getId();

			Query q = session.createQuery("from Group g where g.userGroup = :gstudent_username and g.courseEnrolledGroup  = :gcourse_enrolled_unitcode");
			q.setInteger("gcourse_enrolled_unitcode", id);
			q.setString("gstudent_username", user);

			if(q.list().size() == 0) {
				return "0/5";

			}else {
				List<Group> g = q.list();
				return g.get(0).getGroupMiniLimit()+"/" + g.get(0).getGroupLimit() ;
			}

	    }
	  //get all students and related info doing particular course
	    public ArrayList<User> getAllUsers(String course) {

	    	ArrayList<User> students = new ArrayList<User>();
	    	Session session = this.sessionFactory.getCurrentSession();
	    	Query q = session.createQuery("from CourseEnrolled s where s.unitCodeCourse = :sunit_code and s.enrolledStatus = :senrolled_status");

	    	q.setString("sunit_code", course);

	    	q.setString("senrolled_status", "Enrolled");
	    	List<CourseEnrolled> result = q.list();

	    	for(CourseEnrolled courses : result) {
	    		students.add(courses.getUserCourseEnrolled());
	    	}

	    	return students;

	    }
	    
	    
	    // get Contract of each subjects for the users
	    public ArrayList<String> getAllContractsForUser (User user, ArrayList<String> user_courses){
	    	ArrayList<String> contracts = new ArrayList<String> ();
    		Session session = this.sessionFactory.getCurrentSession();
    		String username = user.getUsername();
	    	
	    	for(String course: user_courses) {
	    		int course_id = getCourseId(course);
		    	Query q = session.createQuery("from Group g where g.userGroup = :guserGroup and g.courseEnrolledGroup = :gcourseEnrolledGroup");
		    	q.setString("guserGroup", username);
		    	q.setInteger("gcourseEnrolledGroup", course_id);
		    	List<Group> group = q.list();
		    	if (group.size() > 0) {
		    		String contract = group.get(0).getContract();
			    	contracts.add(contract);
		    	}else {
		    		contracts.add("No contracts between the groups");
		    	}
		    	
	    	}
	    	return contracts;
	    }
	    
	   // Update Contracts for the users in the group for the contract Page
	    public boolean updateContract(String username, String uos, String contract) {
	    	
    		Session session = this.sessionFactory.getCurrentSession();
    		int course_id = getCourseId(uos);
	    	Query q = session.createQuery("from Group g where g.userGroup = :guserGroup and g.courseEnrolledGroup = :gcourseEnrolledGroup");
	    	q.setString("guserGroup", username);
	    	q.setInteger("gcourseEnrolledGroup", course_id);
	    	List<Group> group = q.list();

	    	if(group.size() == 0) {
	    		// no groups
	    		return false;
	    	}else {
	    		// update Contract here
	    		Group g = group.get(0);
	    		g.setContract(contract);
	    		sessionFactory.getCurrentSession().save(g);
	    	}
	    	
	    	return true;
	    	
	    }
	   
	    
	    
	    
	    
	    
	  //get users full name
	    public String fullName(String username) {
	    	Session session = this.sessionFactory.getCurrentSession();
	    	Query q = session.createQuery("from User s where s.username = :sstudent_username");
	    	q.setString("sstudent_username", username);
	    	List<User> u = q.list();
	    	String fullName = u.get(0).getFullName();
	    	return fullName;
	    }

	    //get users biography
	    public String biography(String username) {
	    	Session session = this.sessionFactory.getCurrentSession();
	    	Query q = session.createQuery("from User s where s.username = :sstudent_username");
	    	q.setString("sstudent_username", username);
	    	List<User> u = q.list();
	    	String biography = u.get(0).getBiography();
	    	return biography;
	    }

	    //get users email
	    public String email(String username) {
	    	Session session = this.sessionFactory.getCurrentSession();
	    	Query q = session.createQuery("from User s where s.username = :sstudent_username");
	    	q.setString("sstudent_username", username);
	    	List<User> u = q.list();
	    	String email = u.get(0).getEmail();
	    	return email;
	    }

	    //get users phone number
	    public String phoneNumber(String username) {
	    	Session session = this.sessionFactory.getCurrentSession();
	    	Query q = session.createQuery("from User s where s.username = :sstudent_username");
	    	q.setString("sstudent_username", username);
	    	List<User> u = q.list();
	    	String phoneNumber = u.get(0).getPhoneNumber();
	    	return phoneNumber;
	    }

	    // Get user object by its full name
	    public User getUserByFullName(String fullName) {
	    	Session session = this.sessionFactory.getCurrentSession();
	    	Query q = session.createQuery("from User s where s.fullName = :sstudent_fullname");
	    	q.setString("sstudent_fullname", fullName);
	    	List<User> u = q.list();
	    	return u.get(0);
	    }

}
