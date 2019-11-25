package com.elec5619.sr.service;

import java.util.ArrayList;


import com.elec5619.sr.domain.StudentReview;

import org.springframework.stereotype.Service;

import java.util.*;


public class ReviewService {

	private final String TITLE_1 = "Meeting Punctuality";
	private final String TITLE_2 = "Effort";
	private final String TITLE_3 = "Team Skills";
	private final String TITLE_4 = "Technical Skills";
	private final String TITLE_5 = "Contextual Skills";

	public ReviewService () {}

	
	public int getTotalAverage ( HashMap<String, Integer> map) {
		int sum = 0;
		sum += map.get(TITLE_1);
		sum += map.get(TITLE_2);
		sum += map.get(TITLE_3);
		sum += map.get(TITLE_4);
		sum += map.get(TITLE_5);
		
		return sum / 5;
	}


	public HashMap<String, Integer> getAverageReviewOfUser( ArrayList<StudentReview> srList){
		
		HashMap<String, Integer> result = new HashMap<String,Integer>();
		
		int t1_sum = 0, t1_count = 0, t1_average;
		int t2_sum = 0, t2_count = 0, t2_average;
		int t3_sum = 0, t3_count = 0, t3_average;
		int t4_sum = 0, t4_count = 0, t4_average;
		int t5_sum = 0, t5_count = 0, t5_average;

		for(StudentReview sr : srList){
			if(sr.getTitle().equals(TITLE_1)){
				System.out.println(sr.getStudentUsername().getUsername());

				t1_sum += sr.getRev_points();
				t1_count += sr.getRev_count();
			}
			else if(sr.getTitle().equals(TITLE_2)){
				t2_sum += sr.getRev_points();
				t2_count += sr.getRev_count();
			}
			else if(sr.getTitle().equals(TITLE_3)){
				t3_sum += sr.getRev_points();
				t3_count += sr.getRev_count();
			}
			else if(sr.getTitle().equals(TITLE_4)){
				t4_sum += sr.getRev_points();
				t4_count += sr.getRev_count();
			}			 
			else if(sr.getTitle().equals(TITLE_5)){
				t5_sum += sr.getRev_points();
				t5_count += sr.getRev_count();
			}			 
		 }
		System.out.println("Sum 1 =" + t1_sum);
		System.out.println("Sum 2 =" + t2_sum);
		System.out.println("Sum 3 =" + t3_sum);
		System.out.println("Sum 4 =" + t4_sum);
		System.out.println("Sum 5 =" + t5_sum);
		
		System.out.println("count 1 =" + t1_count);
		System.out.println("count 2 =" + t2_count);
		System.out.println("count 3 =" + t3_count);
		System.out.println("count 4 =" + t4_count);
		System.out.println("count 5 =" + t5_count);

		 try{
			 t1_average = t1_sum / t1_count;
			 t2_average = t2_sum / t2_count;
			 t3_average = t3_sum / t3_count;
			 t4_average = t4_sum / t4_count;
			 t5_average = t5_sum / t5_count;
			 
				System.out.println("average 1 =" + t1_average);
				System.out.println("average 2 =" + t2_average);
				System.out.println("average 3 =" + t3_average);
				System.out.println("average 4 =" + t4_average);
				System.out.println("average 5 =" + t5_average);


			 result.put(TITLE_1, t1_average);
			 result.put(TITLE_2, t2_average);
			 result.put(TITLE_3, t3_average);
			 result.put(TITLE_4, t4_average);
			 result.put(TITLE_5, t5_average);

		 }catch(Exception e) {
			 System.out.print("getAverageReviewOfUser exception" + e.toString());
			 
			 result.put(TITLE_1, 0);
			 result.put(TITLE_2, 0);
			 result.put(TITLE_3, 0);
			 result.put(TITLE_4, 0);
			 result.put(TITLE_5, 0);
			 
		 }
		 return result;
	 }
	 public ArrayList<String> getDescriptionList(HashMap<String, Integer> sr_average) {
		ArrayList<String> result = new ArrayList<String>();
		result.add(getReviewDesciption(TITLE_1, sr_average.get(TITLE_1)));
		result.add(getReviewDesciption(TITLE_2, sr_average.get(TITLE_2)));
		result.add(getReviewDesciption(TITLE_3, sr_average.get(TITLE_3)));
		result.add(getReviewDesciption(TITLE_4, sr_average.get(TITLE_4)));
		result.add(getReviewDesciption(TITLE_5, sr_average.get(TITLE_5)));

		return result;
	 }

	//return corresponding description according to given title and point 
	private String getReviewDesciption (String title, int rev_point) {
		try{
			if(title.equals("Meeting Punctuality")){

				switch(rev_point) {
					case 1:					
					return "This person rarely or never attended meetings.";
				
					case 2:
					return "This person had less attendances than absences.";
				
					case 3:
					return "This person more attendances than absences.";
	
					case 4:
					return "This person attended 90% of the meetings," 
						+ " notified teammates when he couldn’t make it.";
					
					case 5:
					return "This person attended all the meetings.";
					
					default:
						//do nothing
				}

			}
			else if(title.equals("Effort")){

				switch(rev_point) {
					case 1:
					return "This person  is responsible, actively listen, supportive and respecting few of the time.";
					
					case 2:
					return "This person  is responsible, actively listen, supportive and respecting sometimes.";
					
					case 3:
					return "This person  is responsible, actively listen,"
						+ " supportive and respecting half of the time.";
					
					case 4:
					return "this person r is responsible, actively listen,"
						+ " supportive and respecting most of the time.";
					
					case 5:
					return "This person  is evermore responsible, actively listen, supportive and respecting";
					
					default:
					//do nothing
				
				}

			}
			else if(title.equals("Team Skills")){

				switch(rev_point) {
					case 1:
					return "This person rarely or never contributed to the past group project.";
					
					case 2:
					return "This person contributed less than average in the past group project.";
					
					case 3:
					return "This person contributed averagely in the past group project.";
					
					case 4:
					return "This person contributed well  in the past group project.";
					
					case 5:
					return "This person contributed more than average in the past group project.";
					
					default:
					//do nothing
				}
	
			}
			else if(title.equals("Technical Skills")){

				switch(rev_point) {
	
					case 1:
					return "This person can't  solve technical problems no matter what.";
					
					case 2:
					return "This person has few technical skills, struggling to solve "
						+ "technical problems even with extra time or helps.";
					
					case 3:
					return "This person has some technical skills, able to "
						+ "solve technical problems with extra time or helps.";
			
					case 4:
					return "This person has enough understanding of technical skills,"
							+ " can solve problems individually and really need help.";
					
					case 5:
					return "This person is a technical master and  a excellent problem-solver";
					
					default:
					//do nothing
				}
			}
			else if(title.equals("Contextual Skills")){

				switch(rev_point) {		
			
					case 1:
					return "This person is not able to  learn, " 
				    	+ "understand and demonstrate  the given academic material at all.";
								
					case 2:				
					return "This person is not able to  learn, "
						+ "understand and demonstrate most of the given academic material.";
				
					case 3:
					return "This person is able to  learn, "
						+ "understand and demonstrate some of the given academic material.";
				
					case 4:
					return "This person is able to  learn, "
						+ "understand and demonstrate most of the given academic material";
				
					case 5:
					return "This person is a maser of learning, "
						+ "understanding and demonstrating the given academic material.";
				
					default:
					//do nothing
					}

				}

		}
		catch(Exception e){
			System.out.println("getReviewDesciption exception in ReviewService.class");
			System.out.println(e.toString());
		}
		return null;
	}
	
}