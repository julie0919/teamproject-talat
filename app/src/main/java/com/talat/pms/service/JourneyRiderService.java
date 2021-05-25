package com.talat.pms.service;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.talat.pms.domain.Journey;
import com.talat.pms.domain.JourneyRider;

public interface JourneyRiderService {

  int add(JourneyRider journeyRider) throws Exception;

  List<JourneyRider> list() throws Exception;

  List<JourneyRider> listOfJourney(int journeyNo) throws Exception;

  JourneyRider get(int no) throws Exception;

  int update(JourneyRider journeyRider) throws Exception;

  int delete(int no) throws Exception;

  List<JourneyRider> search(String keyword1, String keyword2, String keyword3, String keyword4) throws Exception;

  List<Journey> getJourneys(int journeyRiderNo) throws Exception;

  int deleteJourney(int journeyRiderNo) throws Exception;

  //  List<Map<String,String>> selectMap(SqlSession session) throws Exception;
  List<JourneyRider> selectList(SqlSession session) throws Exception;
}






