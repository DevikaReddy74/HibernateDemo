package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.Dao.CourseDao;
import com.cts.Dao.ReviewDao;
import com.cts.model.Course;
import com.cts.model.Review;

@RestController
public class ReviewController {

	@Autowired
	private CourseDao courseDao;

	@Autowired
	private ReviewDao reviewDao;
	
	@RequestMapping("/addReview")
	public String creatingReview() {
		int id=1;
		Course course=courseDao.getCourseById(id);
		Review review=new Review("Great Course");
		Review review2=new Review("Super Course");
		course.addReview(review);
		course.addReview(review2);
		reviewDao.addReview(review);
		reviewDao.addReview(review2);
		return "Added";
	}
	
	@RequestMapping("/getCourseReviews/{id}")
	public List<Review> getReviewsByCourseId(@PathVariable("id") int id) {
		Course course=courseDao.getCourseById(id);
		List<Review> reviews=course.getReviews();
		return reviews;
	}
	
	@RequestMapping("/deleteReviewById/{id}")
	public String deleteReviewById(@PathVariable("id") int id) {
		reviewDao.deleteReview(id);
		return "Deleted";
	}
}
