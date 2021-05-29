package com.talat.pms.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import com.talat.pms.dao.JourneyRiderDao;
import com.talat.pms.dao.RiderQnADao;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.service.JourneyRiderService;

@Service
public class DefaultJourneyRiderService implements JourneyRiderService {

  TransactionTemplate transactionTemplate;
  JourneyRiderDao journeyRiderDao; 
  RiderQnADao riderQnADao;

  public DefaultJourneyRiderService(PlatformTransactionManager txManager, JourneyRiderDao journeyRiderDao,  RiderQnADao riderQnADao) {
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.journeyRiderDao = journeyRiderDao;
    this.riderQnADao = riderQnADao;
  }

  // 등록 업무
  @Override
  public int add(JourneyRider journeyRider) throws Exception {
    return journeyRiderDao.insert(journeyRider);
  }

  // 목록 조회 업무
  @Override
  public List<JourneyRider> list() throws Exception {
    return journeyRiderDao.findAll();
  }

  // 여정 상세조회
  @Override
  public JourneyRider getJno(int no) throws Exception {
    return journeyRiderDao.findByJNo(no);
  }

  // 나의 여정 상세조회
  @Override
  public JourneyRider getRjno(int no) throws Exception {
    return journeyRiderDao.findByRjNo(no);
  }

  // 변경 업무
  @Override
  public int update(JourneyRider journeyRider) throws Exception {
    return journeyRiderDao.update(journeyRider);
  }

  // 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return transactionTemplate.execute(new TransactionCallback<Integer>() {
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        try { // talat_review_driver -> talat_qna_rider -> talat_journey_rider 순서
          riderQnADao.deleteByJourneyRiderNo(no);
          return journeyRiderDao.delete(no);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  // 검색 업무
  @Override
  public List<JourneyRider> search(String keyword1, String keyword2, String keyword3, String keyword4) throws Exception {
    HashMap<String, Object> params = new HashMap<>();
    params.put("keyword1", keyword1);
    params.put("keyword2", keyword2);
    params.put("keyword3", keyword3);
    params.put("keyword4", keyword4);

    return journeyRiderDao.findByKeywords(params);
  }


}







