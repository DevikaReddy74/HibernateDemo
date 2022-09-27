package com.cts.Dao;

import org.springframework.stereotype.Service;

import com.cts.model.Review;

@Service
public interface ReviewDao {

	public void addReview(Review review);
	public void deleteReview(int id);
}
