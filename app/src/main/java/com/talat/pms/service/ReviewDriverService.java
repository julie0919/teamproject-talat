package com.talat.pms.service;

import java.util.List;
import com.talat.pms.domain.ReviewDriver;

public interface ReviewDriverService {

  int add(ReviewDriver reviewDriver) throws Exception;

  List<ReviewDriver> list() throws Exception;

  // ReviewDriver get(int no) throws Exception;

  // List<Review> getReviews(int no) throws Exception;

}







