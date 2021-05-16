package com.talat.pms.service.impl;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import com.talat.pms.dao.JourneyRiderDao;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.service.JourneyRiderService;

public class DefaultJourneyRiderService implements JourneyRiderService {

  JourneyRiderDao journeyRiderDao; 

  public DefaultJourneyRiderService(JourneyRiderDao journeyRiderDao) {
    this.journeyRiderDao = journeyRiderDao;
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

  // 상세 조회 업무
  @Override
  public JourneyRider get(int no) throws Exception {
    return journeyRiderDao.findByNo(no); 
  }

  // 변경 업무
  @Override
  public int update(JourneyRider journeyRider) throws Exception {
    return journeyRiderDao.update(journeyRider);
  }

  // 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return journeyRiderDao.delete(no);
  }

  // 검색 업무
  @Override
  public List<JourneyRider> search(String departure, String arrival, Date journeyDate, Time journeyTime) throws Exception {
    HashMap<String, Object> params = new HashMap<>();
    params.put("departure", departure);
    params.put("arrival", arrival);
    params.put("journeyDate", journeyDate);
    params.put("journeyTime", journeyTime);

    return journeyRiderDao.findByKeyword(params);
  }
}







