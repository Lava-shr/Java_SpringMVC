package com.elec5619.sr.service;

import com.elec5619.sr.dao.*;
import com.elec5619.sr.domain.*;

import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Handles requests for the application home page.
 */

@Controller
@SessionAttributes("id")
public class HomeController {
			
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private ReviewService reviewService;

	
	 @Autowired
	 private UserDao userDao;
	 
	 @Autowired
	 private DataAdditionDao d;
	 
	 @Autowired
	 private AdminLogDao aL;
	 
	 @Autowired
	 private StudentReviewDao studentReviewDao;
	 
	 
	 
	 /**
	  * Uses one endpoint!
	  */
	 @RequestMapping(value = "/sr", method = RequestMethod.GET)
	 public String redirect() {
		 return "redirect:/studentreview";
	 }
	 
	/**
	 * Redirects to login if session attribute does not exist, else goes to user's home page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		
		if (!isLoggedIn(model)) {
			model.addAttribute("login", new Login());
			return new ModelAndView("login", "model", model);
		}
		
		// User is logged in
		User user = userDao.getUserById(((Integer)model.asMap().get("id")).intValue());
		Login credentials = new Login();
		credentials.setUsername(user.getUsername());
		credentials.setPassword(user.getHashPass());
		addLoginDetails(model);
		
		return new ModelAndView("home", "model", model);
	}
	
	/**
	 * Does Login here
	 * If login is successful must send the following to the jsp: 
	 * 1- courses user is enrolled in
	 * 2- group information for user  
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("login") Login credentials, Model model){
		
		if(userDao.isUser(credentials.getUsername(), credentials.getPassword()) == true) {
			User user = userDao.getUserByCredentials(credentials.getUsername(), credentials.getPassword());
			model.addAttribute("id", user.getId());
			addLoginDetails(model);
			// Adding user login activities
			d.addAdminLogUserLogin(user);
			return new ModelAndView("home", "model", model);
		}

		model.addAttribute("message", "Incorrect Username or Password");

		return new ModelAndView("login", "model", model);
		
	}
	
	/**
	 * Logout method
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus session) {
		
		session.setComplete();
		return "redirect:/";
	}

	/**
	 * Contract page for the log in user
	 */
	@RequestMapping(value="/contract" , method = RequestMethod.GET)
	public ModelAndView contract(Model model) {
		
		if (!isLoggedIn(model)) {
			model.addAttribute("login", new Login());
			return new ModelAndView("login", "model", model);
		}
		
		addSideMenuDetails(model);
		
		return new ModelAndView("contract", "model", model);
	}
	
	
	/**
	 * Contract posting page for the log in user
	 */
	@RequestMapping(value="/contractPosting/{uos}" , method = RequestMethod.POST)
	public ModelAndView contract(@PathVariable("uos") String uos, @ModelAttribute("contract") String contract,
									Model model) {
		User user = userDao.getUserById(((Integer)model.asMap().get("id")).intValue());
		
		
		if(!userDao.updateContract(user.getUsername(), uos, contract)) {
			model.addAttribute("errorMessage" , "Need to have group to update contract");
		}

		addSideMenuDetails(model);
		
		return new ModelAndView("contract", "model", model);
	}
	
	
	/**
	 * Group page for the log in user
	 * 
	 */
	@RequestMapping(value="/group" , method = RequestMethod.GET)
	public ModelAndView group (Model model){
		
		if (!isLoggedIn(model)) {
			model.addAttribute("login", new Login());
			return new ModelAndView("login", "model", model);
		}
		
		User user = userDao.getUserById(((Integer)model.asMap().get("id")).intValue());
		
		String username = user.getUsername();
		// User unit of study
		ArrayList<String> user_courses = new ArrayList<String>();
		user_courses = userDao.getUserCourse(username);
		model.addAttribute("username", username);
		model.addAttribute("courses", user_courses);
		// Group number for the Unit of study
		Map<String, String> user_group_no = userDao.getGroupNo(user.getUsername(), user_courses);
		model.addAttribute("user_group_no", user_group_no);
		
		// Attributes to add to group button
		ArrayList<GroupJspPage> group_list = new ArrayList<GroupJspPage>();
		ArrayList<Integer> user_courses_id = new ArrayList<Integer>();
		user_courses_id = userDao.getUserCoursesId(username);
		
		// Getting group details for one course at a time and adding to group_list		
		for(String course : user_courses) {
			String group_no = userDao.getGroupNo(username, course);
			String group_limit = userDao.getGroupLimit(username, course);
			int course_id = userDao.getCourseId(course);
			ArrayList<String> group_members = new ArrayList<String>();
			group_members = userDao.getPeopleInSameGroup(username , group_no, course_id);
			
			
			GroupJspPage temp = new GroupJspPage();
			temp.setCourse(course);
			temp.setGroup_no(group_no);
			temp.setGroup_limit(group_limit);
			temp.setGroup_member(group_members);
			
			group_list.add(temp);
			
		}
		
		model.addAttribute("group", group_list);
		
		return new ModelAndView("group", "model", model);
	}
	
	

	/**
	 *  Dynamic page loading for the user's UOS students
	 *  
	 */
	@RequestMapping(value="/uos" , method = RequestMethod.GET)
	public ModelAndView studentList(@RequestParam String uosId, Model model){
		
		if (!isLoggedIn(model)) {
			model.addAttribute("login", new Login());
			return new ModelAndView("login", "model", model);
		}
		
		ArrayList <User> users = userDao.getAllUsers(uosId);
			
		ArrayList<String> group_no = new ArrayList<String>();
		for(User u: users ) {
			group_no.add(userDao.getGroupNo(u.getUsername(), uosId));
		}

		ArrayList<String> group_limit = new ArrayList<String>();
		for(User u: users ) {
			group_limit.add(userDao.getGroupLimit(u.getUsername(), uosId));
		}
		
		// Generating random number for now.
		ArrayList<String> user_ratings = new ArrayList<String>();
		for(User u: users ) {
			double random = Math.random() * 4 + 1;
			String result = String.format("%.2f", random);
			user_ratings.add(result);
		}
		
		ArrayList<ListOfStudents> l = new ArrayList<ListOfStudents>();
		
		for(int i = 0; i < users.size(); ++i) {
			ListOfStudents temp = new ListOfStudents();
			
			temp.setUsername(users.get(i).getFullName());
			temp.setEmail(users.get(i).getEmail());
			temp.setGroup_no(group_no.get(i));
			temp.setGroup_limit(group_limit.get(i));
			
			reviewService = new ReviewService();
			ArrayList<StudentReview> studentReviews = studentReviewDao.getStudentReviewsByUsername(users.get(i).getUsername());
			HashMap<String, Integer> sr_average = reviewService.getAverageReviewOfUser(studentReviews);
			temp.setAvg_ratings(String.valueOf(reviewService.getTotalAverage(sr_average)));
			
			l.add(temp);
			
		}	
		model.addAttribute("user_list" , l);
		model.addAttribute("uosId" , uosId);
		
		// For Sidemenu
		addSideMenuDetails(model);
		
		return new ModelAndView("listOfStudents", "model", model);
		
	}
	
	/**
	 * Sidemenu data - not required if addLoginDetails is used for the request
	 */
	protected void addSideMenuDetails(Model model) {
		User user = userDao.getUserById(((Integer)model.asMap().get("id")).intValue());
		// User unit of study
		ArrayList<String> user_courses = new ArrayList<String>();
		user_courses = userDao.getUserCourse(user.getUsername());
		model.addAttribute("courses", user_courses);
		// Group number for the Unit of study
		Map<String, String> user_group_no = userDao.getGroupNo(user.getUsername(), user_courses);
		model.addAttribute("user_group_no", user_group_no);
		
		
		ArrayList<String> user_course = new ArrayList<String>();

		for (String key : user_group_no.keySet()) {
		    user_course.add(key);
		}
		
		// Getting contract details for all the user for each subject
		ArrayList<String> contracts = userDao.getAllContractsForUser(user, user_course);
		if(contracts.size() != 0) {
			model.addAttribute("contracts", contracts);

		}
		
	}

	/**
	 * Add details for most models
	 */
	protected void addLoginDetails(Model model) {
		User user = userDao.getUserById(((Integer)model.asMap().get("id")).intValue());
			
		// User unit of study
		ArrayList<String> user_courses = new ArrayList<String>();
		user_courses = userDao.getUserCourse(user.getUsername());
		model.addAttribute("courses", user_courses);
		
		// Group number for the Unit of study
		Map<String, String> user_group_no = userDao.getGroupNo(user.getUsername(), user_courses);
		model.addAttribute("user_group_no", user_group_no);
		
		// People Not in group	
		Map<String, Integer> not_in_group = userDao.getPeopleNoInGroup(user.getUsername(), user_courses);
		model.addAttribute("not_in_group", not_in_group);
		
		// Group limit for the Unit of study
		Map<String, String> group_limit = userDao.getGroupLimit(user.getUsername(), user_courses);
		model.addAttribute("group_limit", group_limit);
					
		// Total students for the all unit of study
		Map<String, Integer> unit_total_students = userDao.getTotalStudents(user_courses);
		model.addAttribute("unit_total_students", unit_total_students);
		
//		//people in group for that Unit of study
//		ArrayList group_people = (ArrayList) userDao.getPeopleInSameGroup("User1", "ELEC5619");
//		model.addAttribute("group_people", group_people);
		
	}
	
	/**
	 * Session checker
	 */
	protected boolean isLoggedIn(Model model) {
		if (model.asMap().get("id") == null) {
			return false;
		} else {
			return true;
		}
	}
}
