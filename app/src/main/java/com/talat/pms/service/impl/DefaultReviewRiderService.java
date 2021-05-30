package com.talat.pms.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.talat.pms.dao.ReviewRiderDao;
import com.talat.pms.domain.ReviewRider;
import com.talat.pms.service.ReviewRiderService;

@Service
public class DefaultReviewRiderService implements ReviewRiderService {

  // TransactionTemplate transactionTemplate;

  ReviewRiderDao reviewRiderDao;

  public DefaultReviewRiderService(ReviewRiderDao reviewRiderDao) {
    // this.transactionTemplate = new TransactionTemplate(txManager);
    this.reviewRiderDao = reviewRiderDao;
    System.out.println("DefaultReviewRiderService 객체 생성됨!");
  }  

  // 등록 업무
  @Override
  public int add(ReviewRider reviewRider) throws Exception {
    return reviewRiderDao.insert(reviewRider);
    //    return (int) transactionTemplate.execute(new TransactionCallback() {
    //      @Override
    //      public Object doInTransaction() throws Exception {
    //        // 트랜잭션으로 묶어서 실행할 작업을 기술한다.
    //        // 1) 파트너의 리뷰 정보를 입력한다.
    //        int count = reviewDriverDao.insert(reviewDriver);
    //
    //        if (reviewDriver.getReviews().size() > 0) {
    //          // 2) 리뷰를 입력한다.
    //          HashMap<String,Object> params = new HashMap<>();
    //          params.put("rjno", reviewDriver.getRjno());
    //          params.put("reviews", reviewDriver.getReviews());
    //
    //          reviewDriverDao.insertReviews(params);
    //        }
    //        return count;
    //      }
    //    });
  }

  // 조회 업무
  @Override
  public List<ReviewRider> list() throws Exception {
    return reviewRiderDao.findAll();
  }

  //  // 필요없을 수도 있는 상세 조회
  //  @Override
  //  public ReviewDriver get(int no) throws Exception {
  //    ReviewDriver reviewDriver = reviewDriverDao.findByNo(no);
  //    return reviewDriver;
  //  }

  //  // 왠지 필요 없을 것 같은 리뷰리스트
  //  @Override
  //  public List<Review> getReviews(int no) throws Exception {
  //    return reviewDriverDao.findReviews(no);
  //  }

}







