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


@Repository(value = "courseDao")
@Transactional
public class CourseDao {

	 @Resource
	 private SessionFactory sessionFactory;

	    public SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }

	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }

      public Course geCourseByCode(String code) {
        Session currentSession = this.sessionFactory.getCurrentSession();
        Course course = (Course) currentSession.get(Course.class, code);

        return course;
      }

      public void addCourse(String code ,String title,String description ) {

        Course course = new Course();
        course.setCode(code);
        course.setTitle(title);
        course.setDescription(description);
        sessionFactory.getCurrentSession().save(course);
      }
      


}
