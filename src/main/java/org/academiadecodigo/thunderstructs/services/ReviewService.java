package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.model.ReviewModel;

import java.util.List;

public interface ReviewService {

	ReviewModel get(String cname,Integer id);

	double getRating(String cname, Integer id);

	String getReview(String cname, Integer id);

	void save(String cname,ReviewModel reviewModel);

	void delete(String cname,Integer id);

	List<ReviewModel> list(String cname);

}
