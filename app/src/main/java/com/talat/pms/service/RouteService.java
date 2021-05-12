package com.talat.pms.service;

import com.talat.pms.domain.Route;

public interface RouteService {

  int add(Route route) throws Exception;

  //  List<Journey> list() throws Exception;
  //
  Route get(int no) throws Exception;

  int update(Route route) throws Exception;

  int delete(int no) throws Exception;

  //  List<Journey> search(String departure, String arrival, Date journeyDate, Time journeyTime) throws Exception;
}







