package com.talat.pms.service;

import java.util.List;
import com.talat.pms.domain.Journey;
import com.talat.pms.domain.JourneyRider;

public interface JourneyRiderService {

  int add(JourneyRider journeyRider) throws Exception;

  List<JourneyRider> list() throws Exception;

  List<JourneyRider> listOfJourney(int journeyNo) throws Exception;

  JourneyRider getJno(int no) throws Exception;

  JourneyRider getRjno(int no) throws Exception;

  int update(JourneyRider journeyRider) throws Exception;

  int delete(int no) throws Exception;

  List<JourneyRider> search(String keyword1, String keyword2, String keyword3, String keyword4) throws Exception;

  List<Journey> getJourneys(int journeyRiderNo) throws Exception;

}






