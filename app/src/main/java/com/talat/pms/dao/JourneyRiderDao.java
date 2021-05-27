package com.talat.pms.dao;

import java.util.List;
import java.util.Map;
import com.talat.pms.domain.Journey;
import com.talat.pms.domain.JourneyRider;

public interface JourneyRiderDao {

  int insert(JourneyRider journeyRider) throws Exception;

  List<JourneyRider> findAll() throws Exception;

  List<JourneyRider> findByKeywords(Map<String, Object> params) throws Exception;

  List<JourneyRider> findByJourneyNo(int journeyNo) throws Exception;

  JourneyRider findByRjNo(int no) throws Exception;

  JourneyRider findByJNo(int no) throws Exception;

  int update(JourneyRider journeyRider) throws Exception;

  int delete(int no) throws Exception;

  List<Journey> findJourneys(int journeyRiderNo) throws Exception;

  int insertJourney(Map<String,Object> params) throws Exception;

}












