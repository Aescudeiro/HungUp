package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.model.ReviewModel;

import java.util.List;

public interface ReviewService {

	ReviewModel get(Integer id);

	double getRating(Integer id);

	String getReview(Integer id);

	void save(ReviewModel reviewModel);

	void delete(Integer id);

	List<ReviewModel> list();

}
