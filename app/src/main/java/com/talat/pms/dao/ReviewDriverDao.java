package com.talat.pms.dao;

import java.util.List;
import com.talat.pms.domain.ReviewDriver;

public interface ReviewDriverDao {

  int insert(ReviewDriver reviewDriver) throws Exception;

  List<ReviewDriver> findAll() throws Exception;

  // ReviewDriver findByNo(int no) throws Exception;

  // List<Review> findReviews(int no) throws Exception;
}












