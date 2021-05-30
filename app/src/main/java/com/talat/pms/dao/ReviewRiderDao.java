package com.talat.pms.dao;

import java.util.List;
import com.talat.pms.domain.ReviewRider;

public interface ReviewRiderDao {

  int insert(ReviewRider reviewRider) throws Exception;

  List<ReviewRider> findAll() throws Exception;

  // ReviewDriver findByNo(int no) throws Exception;

  // List<Review> findReviews(int no) throws Exception;
}












