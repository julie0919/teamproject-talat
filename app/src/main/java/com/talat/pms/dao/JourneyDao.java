package com.talat.pms.dao;

import java.util.List;
import com.talat.pms.domain.Journey;
import com.talat.pms.domain.Route;

// JourneyDao 의 규칙 정의
public interface JourneyDao {

  int insert(Journey journey, List<Route> route) throws Exception;

  List<Journey> findAll() throws Exception;

  List<Journey> findAll2() throws Exception;

  //  List<Journey> findByKeyword(String departure, String arrival) throws Exception;

  Journey findByNo(int no) throws Exception;

  int update(Journey journey, List<Route> route) throws Exception;

  int delete(int no) throws Exception;

  //  List<Route> search(String departure, String arrival) throws Exception;

  List<Route> findRoutes(int journeyNo) throws Exception;
}












