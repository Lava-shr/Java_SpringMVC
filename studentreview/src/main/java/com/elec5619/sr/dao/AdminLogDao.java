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


@Repository(value = "adminLogDao")
@Transactional
public class AdminLogDao {

	 @Resource
	 private SessionFactory sessionFactory;
	 @Autowired
	 private UserDao userDao;
	 

	    public SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }

	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	    
	    public List<AdminLog> getAllLogs(){
	    	Session currentSession = this.sessionFactory.getCurrentSession();
	    	Query query = currentSession.createQuery("from AdminLog"); 
	    	
	    	return query.list();
	    }
	    
	    // Method to add Admin
	    public void addAdmin() {
	    	// Adding admin user
	
	    }
	    
	    // Checking if the user is admin or not
	    public boolean isAdminUser(String username, String password) {
	    	
	    	if(userDao.isUser(username, password) == true) {
	    		User u = userDao.getUserByCredentials(username, password);
	    		u.getUsername().equals("admin");
	    		return true;
	    	}else {
	    		return false;
	    	}
	    		
	    }
	    
	    // Return list of all unit of study for the admin user.
	    public ArrayList<String> getListOfAllUos(){
	    	
	    	ArrayList<String> listOfUos = new ArrayList<String>();
	    	Session session = this.sessionFactory.getCurrentSession();
	    	Query k = session.createQuery("from Course");
    		List<Course> l = k.list();
	    	
    		for(Course c : l) {
    			listOfUos.add(c.getCode());
    		}
	    	return listOfUos;
	    }
	    
	    
	    // Getting all the available group of listing for admin
	    public List<Group> getGroupDetails(String uos){
	  	
	    	Session session = this.sessionFactory.getCurrentSession();
	    	int uosId = userDao.getCourseId(uos);
	    	Query k = session.createQuery("from Group g where g.courseEnrolledGroup = :gcourse_enrolled");
	    	
	    	k.setInteger("gcourse_enrolled", uosId);
	    	return k.list();
	    }
	    
	    // Getting contract details of all the group for admin
	    
	    public List<Group> getContractDetails (String uos){
	    	Session session = this.sessionFactory.getCurrentSession();
	    	int uosId = userDao.getCourseId(uos);
	    	Query k = session.createQuery("from Group g where g.courseEnrolledGroup = :gcourse_enrolled");
	    	
	    	k.setInteger("gcourse_enrolled", uosId);
	    	return k.list();
	    		
	    }
	    
	    
	    // Getting all reviews that are posted of   
	    public List<StudentReview> getReviewsDetails (){
	    	Session session = this.sessionFactory.getCurrentSession();
	    	Query k = session.createQuery("from StudentReview");
	    	return k.list();
	    }
	    
	  
      public AdminLog geLogById(int id) {
        Session currentSession = this.sessionFactory.getCurrentSession();
        AdminLog adminLog = (AdminLog) currentSession.get(AdminLog.class, id);
        return adminLog;
      }
      
      public void addAdminLog(String groupId , String description ) {
        // Adding users
        AdminLog adminLog = new AdminLog();
        adminLog.setUnit_group_id(groupId);
        adminLog.setDescription(description);
        sessionFactory.getCurrentSession().save(adminLog);
      }
      
      


}