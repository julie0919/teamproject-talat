package com.talat.pms.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.talat.pms.dao.ReviewDao;
import com.talat.pms.domain.Review;
import com.talat.pms.service.ReviewService;

@Service
public class DefaultReviewService implements ReviewService {

  ReviewDao reviewDao;

  public DefaultReviewService(ReviewDao reviewDao) {
    this.reviewDao = reviewDao;
    System.out.println("DefaultReviewService 객체 생성됨!");
  }  

  // 등록 업무
  @Override
  public int add(Review review) throws Exception {
    return reviewDao.insert(review);
  }

  // 조회 업무
  @Override
  public List<Review> list() throws Exception {
    return reviewDao.findAll();
  }
}







