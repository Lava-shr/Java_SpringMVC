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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	@Autowired
	private AdminLogDao d;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	
	// Simple way to secure api end point for now
	@RequestMapping(value = "/admin/{username}/{password}", method = RequestMethod.GET)
	public @ResponseBody List<AdminLog> getDummyEmployee(@PathVariable("username") String username,
			@PathVariable("password") String password)  {
		
		if(d.isAdminUser(username, password)){
			return d.getAllLogs();
		}
		else {
			return null;
		}
		
	}
	
	// login for Admin
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		model.addAttribute("adminlogin", new Login());
		return new ModelAndView("adminlogin", "model", model);
	}
	
	// login for Admin
	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public ModelAndView adminHome(@ModelAttribute("adminlogin") Login credentials, Model model) {
		
		if(d.isAdminUser(credentials.getUsername(), credentials.getPassword())){
			
			// Add all the list of subjects
			model.addAttribute("uos",d.getListOfAllUos());
			return new ModelAndView("adminHome", "model", model);
		}
		
		else {
			model.addAttribute("message", "Incorrect Username or Password");
			model.addAttribute("adminlogin", new Login());
			return new ModelAndView("adminlogin", "model", model);
		}

	}
	
	// Getting Group Details of all users for Admin
	@RequestMapping(value = "/admin/group/{uos}", method = RequestMethod.GET)
	public ModelAndView adminGroup(@PathVariable("uos")String uos, Model model) {
		
		ArrayList<Group> group_details = (ArrayList<Group>) d.getGroupDetails(uos);
		model.addAttribute("uos",uos);
		model.addAttribute("group_details",group_details);
		
		return new ModelAndView("adminGroup", "model", model);

	}

	// Getting Contract Details of all users for Admin
	@RequestMapping(value = "/admin/contract/{uos}", method = RequestMethod.GET)
	public ModelAndView adminContract(@PathVariable("uos")String uos, Model model) {
		
		ArrayList<Group> group_details = (ArrayList<Group>) d.getContractDetails(uos);
		
		model.addAttribute("uos",uos);
		model.addAttribute("group_details",group_details);
		
		return new ModelAndView("adminContract", "model", model);

	}

	// Getting Reviews Details of all users for Admin
	@RequestMapping(value = "/admin/reviews/{uos}", method = RequestMethod.GET)
	public ModelAndView adminHome(@PathVariable("uos")String uos, Model model) {
		
		ArrayList<StudentReview> reviews_details = (ArrayList<StudentReview>) d.getReviewsDetails();
		ArrayList<String> fullname = new ArrayList<String>();
		for(StudentReview r : reviews_details) {
			fullname.add(r.getStudentUsername().getFullName());
		}
		
		model.addAttribute("fullname", fullname);
		model.addAttribute("reviews_details", reviews_details);
		return new ModelAndView("adminReview", "model", model);

	}


	
}