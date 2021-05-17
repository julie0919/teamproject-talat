package com.talat.pms.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import com.talat.pms.domain.Journey;
import com.talat.pms.domain.JourneyRider;

public interface JourneyRiderService {

  int add(JourneyRider journeyRider) throws Exception;

  List<JourneyRider> list() throws Exception;

  JourneyRider get(int no) throws Exception;

  int update(JourneyRider journeyRider) throws Exception;

  int delete(int no) throws Exception;

  List<JourneyRider> search(String departure, String arrival, Date journeyDate, Time journeyTime) throws Exception;

  List<Journey> getJourney(int journeyRiderNo) throws Exception;
}






