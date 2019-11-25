package com.elec5619.sr.service;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.*;

import com.elec5619.sr.dao.*;
import com.elec5619.sr.domain.Login;
import com.elec5619.sr.domain.StudentReview;
import com.elec5619.sr.domain.User;


@Controller
@SessionAttributes("id")
public class AccountController {

	private ReviewService reviewService;
	
	 @Autowired
	 private UserDao userDao;
	 
	 @Autowired
	 private DataAdditionDao d;

	 @Autowired
	 private StudentReviewDao studentReviewDao;
	
	 
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	

	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public ModelAndView details(Model model) {
		if (!isLoggedIn(model)) {
			model.addAttribute("login", new Login());
			return new ModelAndView("login", "model", model);
		}
	
		User user = userDao.getUserById(((Integer)model.asMap().get("id")).intValue());
		
		//user's courses to create hyperlink to them
		// User unit of study
		ArrayList<String> user_courses = new ArrayList<String>();
		user_courses = userDao.getUserCourse(user.getUsername());
		model.addAttribute("courses", user_courses);
		
		// Group number for the Unit of study
		Map<String, String> user_group_no = userDao.getGroupNo(user.getUsername(), user_courses);
		model.addAttribute("user_group_no", user_group_no);
		
		//user's full name
		String fullname;
		fullname = userDao.fullName(user.getUsername());
		model.addAttribute("user_fullname", fullname);
		
		//user's biography
		String biography;
		biography = userDao.biography(user.getUsername());
		model.addAttribute("user_biography", biography);
		
		//User's Contact Details
		//Users email
		String email;
		email = userDao.email(user.getUsername());
		model.addAttribute("user_email", email);		
		//Users phone number

		String phoneNumber;
		phoneNumber = userDao.phoneNumber(user.getUsername());
		model.addAttribute("user_phoneNumber", phoneNumber);
		
		
		// average student average review and desciption
		reviewService = new ReviewService();
		ArrayList<StudentReview> studentReviews = studentReviewDao.getStudentReviewsByUsername(user.getUsername());
		HashMap<String, Integer> sr_average = reviewService.getAverageReviewOfUser(studentReviews);
		ArrayList<String> sr_description = reviewService.getDescriptionList(sr_average);
		
		String average_1 = sr_average.get("Meeting Punctuality").toString();
		String description_1 = sr_description.get(0);
		
		String average_2 = sr_average.get("Effort").toString();
		String description_2 = sr_description.get(1);
		
		String average_3 = sr_average.get("Team Skills").toString();
		String description_3 = sr_description.get(2);
		
		String average_4 = sr_average.get("Technical Skills").toString();
		String description_4 = sr_description.get(3);
		
		String average_5 = sr_average.get("Contextual Skills").toString();
		String description_5 = sr_description.get(4);
		
		model.addAttribute("sr_average", sr_average);
		model.addAttribute("sr_description", sr_description);

		model.addAttribute("average_1", average_1);
		model.addAttribute("description_1", description_1);
		model.addAttribute("average_2", average_2);
		model.addAttribute("description_2", description_2);
		model.addAttribute("average_3", average_3);
		model.addAttribute("description_3", description_3);
		model.addAttribute("average_4", average_4);
		model.addAttribute("description_4", description_4);
		model.addAttribute("average_5", average_5);
		model.addAttribute("description_5", description_5);

		//Add image to model - Must be png to show for now
		if(user.getAvatar() != null) {
			String encoded = Base64.getEncoder().encodeToString(user.getAvatar());
			model.addAttribute("image", encoded);
		}
					
		return new ModelAndView("account", "model", model);
	}
	
	
	/**
	 * Page to add view profile/account of the  users;
	 * 
	 */
	@RequestMapping(value="/viewStudentAccount/{studentName}" , method = RequestMethod.GET)
	public ModelAndView viewStudentAccount(@PathVariable("studentName")String studentName, Model model){
		if (!isLoggedIn(model)) {
			model.addAttribute("login", new Login());
			return new ModelAndView("login", "model", model);
		}
		
		// Get user object from student's full name
		User user = userDao.getUserByFullName(studentName);
		
		// User unit of study
		ArrayList<String> user_courses = new ArrayList<String>();
		user_courses = userDao.getUserCourse(user.getUsername());
		model.addAttribute("courses", user_courses);
		
		//user's full name
		String fullname;
		fullname = userDao.fullName(user.getUsername());
		model.addAttribute("user_fullname", fullname);
		
		//user's biography
		String biography;
		biography = userDao.biography(user.getUsername());
		model.addAttribute("user_biography", biography);
		
		//User's Contact Details
		//Users email
		String email;
		email = userDao.email(user.getUsername());
		model.addAttribute("user_email", email);		
		//Users phone number

		String phoneNumber;
		phoneNumber = userDao.phoneNumber(user.getUsername());
		model.addAttribute("user_phoneNumber", phoneNumber);
		
		// Group number for the Unit of study
		Map<String, String> user_group_no = userDao.getGroupNo(user.getUsername(), user_courses);
		model.addAttribute("user_group_no", user_group_no);
		
		// Group limit for the Unit of study
		Map<String, String> group_limit = userDao.getGroupLimit(user.getUsername(), user_courses);
		model.addAttribute("group_limit", group_limit);		
		
		/*
		 * average student average review and desciption
		 * Reviews not added to all the user and giving null point exception
		 * Commenting it for now
		 * 
		 */
		
		reviewService = new ReviewService();
		ArrayList<StudentReview> studentReviews = studentReviewDao.getStudentReviewsByUsername(user.getUsername());
		HashMap<String, Integer> sr_average = reviewService.getAverageReviewOfUser(studentReviews);
		ArrayList<String> sr_description = reviewService.getDescriptionList(sr_average);
		
		String average_1 = sr_average.get("Meeting Punctuality").toString();
		String description_1 = sr_description.get(0);
		
		String average_2 = sr_average.get("Effort").toString();
		String description_2 = sr_description.get(1);
		
		String average_3 = sr_average.get("Team Skills").toString();
		String description_3 = sr_description.get(2);
		
		String average_4 = sr_average.get("Technical Skills").toString();
		String description_4 = sr_description.get(3);
		
		String average_5 = sr_average.get("Contextual Skills").toString();
		String description_5 = sr_description.get(4);
		
		model.addAttribute("sr_average", sr_average);
		model.addAttribute("sr_description", sr_description);

		model.addAttribute("average_1", average_1);
		model.addAttribute("description_1", description_1);
		model.addAttribute("average_2", average_2);
		model.addAttribute("description_2", description_2);
		model.addAttribute("average_3", average_3);
		model.addAttribute("description_3", description_3);
		model.addAttribute("average_4", average_4);
		model.addAttribute("description_4", description_4);
		model.addAttribute("average_5", average_5);
		model.addAttribute("description_5", description_5);

		System.out.println(average_1);
		System.out.println(average_2);
		System.out.println(average_3);
		System.out.println(average_4);
		System.out.println(average_5);


		//Add image to model - Must be png to show for now
		if(user.getAvatar() != null) {
			String encoded = Base64.getEncoder().encodeToString(user.getAvatar());
			model.addAttribute("image", encoded);
		}
							
		return new ModelAndView("account", "model", model);

	}
	
	
	/**
	 * Links page where the users can view the users.
	 * 
	 */
	@RequestMapping(value="/reviewStudent/{studentName}" , method = RequestMethod.GET)
	public ModelAndView reviewStudent(@PathVariable("studentName")String studentName, Model model){
		if (!isLoggedIn(model)) {
			model.addAttribute("login", new Login());
			return new ModelAndView("login", "model", model);
		}
		User user = userDao.getUserById(((Integer)model.asMap().get("id")).intValue());
		
		model.addAttribute("student", studentName);
		return new ModelAndView("review", "model", model);
		
	}
	
	/**
	 * Page where the users can view the users.
	 * 
	 */
	@RequestMapping(value="/reviewStudentPut/{studentName}" , method = RequestMethod.POST)
	public ModelAndView reviewStudentPost(@PathVariable("studentName")String studentName, 
											@ModelAttribute("Punctuality") int punctuality,
											@ModelAttribute("Effort") int effort,
											@ModelAttribute("TeamSkills") int teamEffort,
											@ModelAttribute("TechnicalSkills") int techSkill,
											@ModelAttribute("ContextualSkills") int contSkill,
											Model model){
		if (!isLoggedIn(model)) {
			model.addAttribute("login", new Login());
			return new ModelAndView("login", "model", model);
		}
		User user = userDao.getUserById(((Integer)model.asMap().get("id")).intValue());
		
		System.out.println("Reviewing student: " + studentName);
		System.out.println(punctuality);
		
		User user_to_review = userDao.getUserByFullName(studentName);
	
		studentReviewDao.updateStudentReview(user_to_review, punctuality, effort, teamEffort, techSkill, contSkill);
		
		
		
		model.addAttribute("student", studentName);
		
		
		return new ModelAndView("reviewSuccessful", "model", model);
		
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