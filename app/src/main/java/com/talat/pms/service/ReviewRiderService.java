package com.talat.pms.service;

import java.util.List;
import com.talat.pms.domain.ReviewRider;

public interface ReviewRiderService {

  int add(ReviewRider reviewRider) throws Exception;

  List<ReviewRider> list() throws Exception;

  // ReviewDriver get(int no) throws Exception;

  // List<Review> getReviews(int no) throws Exception;

}







