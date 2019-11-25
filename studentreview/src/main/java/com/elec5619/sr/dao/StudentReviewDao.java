package com.elec5619.sr.dao;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elec5619.sr.domain.*;
import java.util.*;


@Repository(value = "studentReviewDao")
@Transactional

public class StudentReviewDao {
	
	private final String TITLE_1 = "Meeting Punctuality";
	private final String TITLE_2 = "Effort";
	private final String TITLE_3 = "Team Skills";
	private final String TITLE_4 = "Technical Skills";
	private final String TITLE_5 = "Contextual Skills";
	

    @Resource
    private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

 
    //return a arrayList of ids of studentreview of a user
    public ArrayList<StudentReview> getStudentReviewsByUsername(String u){
        Session session = this.sessionFactory.getCurrentSession();
        ArrayList<StudentReview> result;
        Query q = session.createQuery("from StudentReview s where s.userStudentReview = :user_name");
        q.setString("user_name", u);
       
            List<StudentReview> resultList = q.list();
      
        return (ArrayList<StudentReview>) resultList;
    }	

    // add student review when a user has no review
    public void updateStudentReview( User _user, int punctuality, int effort, int team_skill, 
			int tech_skill, int con_skill) {
    	User user = _user;
    	
    	ArrayList<StudentReview> userReviews = getStudentReviewsByUsername(user.getUsername());
    	int one = punctuality;
    	int two = effort;
    	int three = team_skill;
    	int four = tech_skill;
    	int five = con_skill;

    	for (StudentReview studentReview : userReviews) {
    		if(studentReview.getTitle().equals(TITLE_1) && studentReview.getRev_points() == punctuality ) {
    			
    			updateReview( studentReview.getId() );
    			one = -1;	   				
    		}
    		else if(studentReview.getTitle().equals(TITLE_2) && studentReview.getRev_points() == effort ) {
    		
    			updateReview( studentReview.getId() );
    			two = -1;
    		}
    		else if(studentReview.getTitle().equals(TITLE_3) && studentReview.getRev_points() == team_skill ) {
    			
    			updateReview( studentReview.getId() );
    			three = -1;
    		}
    		else if(studentReview.getTitle().equals(TITLE_4) && studentReview.getRev_points() == tech_skill ) {
    			
    			updateReview( studentReview.getId() );
    			four = -1;
    		}
    		else if(studentReview.getTitle().equals(TITLE_5) && studentReview.getRev_points() == con_skill ) {
 
    			updateReview( studentReview.getId() );
    			five = -1;
    		}
    	}
    	
    	if(one == -1) {
    		createNewReview(user, TITLE_1, punctuality) ;
    	}
    	if(two == -1) {
    		createNewReview(user, TITLE_2, effort) ;
    	}
    	if(three == -1) {
    		createNewReview(user, TITLE_3, team_skill) ;
    	}
    	if(four == -1) {
    		createNewReview(user, TITLE_4, tech_skill) ;
    	}
    	if(five == -1) {
    		createNewReview(user, TITLE_5, con_skill) ;
    	}
    }
    
    private void updateReview(int sr_id) {
    	StudentReview sr = (StudentReview) sessionFactory.getCurrentSession().get(StudentReview.class, sr_id);
    	if(sr != null){
    		int rev_count = sr.getRev_count();
    		sr.setRev_count(rev_count+1);
            sessionFactory.getCurrentSession().update(sr);
    	}
    }
    
    private void createNewReview(User user, String title, int point) {
    	System.out.print("create Review called");

		StudentReview review = new StudentReview();
		review.setStudentUsername(user);
		review.setTitle(title);
		review.setRev_points(point);
		review.setRev_count(1);
		sessionFactory.getCurrentSession().save(review);
		}
    //  update student review 
    public void updateStudentReview( int id , int point) {
    	
    	StudentReview sr = (StudentReview) sessionFactory.getCurrentSession().get(StudentReview.class, id);
    	if(sr != null){
    		int rev_count = sr.getRev_count();
    		sr.setRev_count(rev_count+1);
    		int rev_point = sr.getRev_points();
    		sr.setRev_points(rev_point + point);
            sessionFactory.getCurrentSession().update(sr);
    	}
    }
    
    //  add student review 
    public void addStudentReview( int point,String title, User user) {
    	
    		StudentReview sr = new StudentReview();
    		sr.setRev_count(1);
    		sr.setRev_points(point);
    		sr.setTitle(title);
    		sr.setStudentUsername(user);
    	
    		sessionFactory.getCurrentSession().save(sr);
    }
    
    //  add student review 
    public StudentReview getStudentReviewById( int id) {
    	
    	StudentReview sr = (StudentReview) sessionFactory.getCurrentSession().get(StudentReview.class, id);
    	
    	return sr;
    }
    
}
