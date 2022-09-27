package com.cts.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.Review;
import com.cts.repository.ReviewRepository;

@Service
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Override
	public void addReview(Review review) {
		reviewRepository.save(review);
	}

	@Override
	public void deleteReview(int id) {
		reviewRepository.deleteById(id);
	}

}
