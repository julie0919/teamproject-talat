package com.talat.pms.dao;

import com.talat.pms.domain.Route;

// JourneyDao 의 규칙 정의
public interface RouteDao {

  int insert(Route route) throws Exception;
  //
  //  List<Route> findAll() throws Exception;
  //
  //  List<Route> findByKeyword(String departure, String arrival, Date journeyDate, Time journeyTime) throws Exception;
  //
  Route findByNo(int no) throws Exception;

  int update(Route route) throws Exception;

  int delete(int no) throws Exception;
}












