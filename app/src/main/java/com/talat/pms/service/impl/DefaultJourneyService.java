package com.talat.pms.service.impl;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import com.talat.pms.dao.JourneyDao;
import com.talat.pms.domain.Journey;
import com.talat.pms.service.JourneyService;

public class DefaultJourneyService implements JourneyService {

  JourneyDao journeyDao; 

  public DefaultJourneyService(JourneyDao journeyDao) {
    this.journeyDao = journeyDao;
  }

  // 등록 업무
  @Override
  public int add(Journey journey) throws Exception {
    return journeyDao.insert(journey);
  }

  // 목록 조회 업무
  @Override
  public List<Journey> list() throws Exception {
    return journeyDao.findAll();
  }

  // 상세 조회 업무
  @Override
  public Journey get(int no) throws Exception {
    Journey journey = journeyDao.findByNo(no);
    return journey; 
  }

  // 변경 업무
  @Override
  public int update(Journey journey) throws Exception {
    return journeyDao.update(journey);
  }

  // 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return journeyDao.delete(no);
  }

  // 검색 업무
  @Override
  public List<Journey> search(String departure, String arrival, Date journeyDate, Time journeyTime) throws Exception {
    return journeyDao.findByKeyword(departure, arrival, journeyDate, journeyTime);
  }
}







