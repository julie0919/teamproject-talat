package com.talat.pms.service.impl;

import com.talat.pms.dao.RouteDao;
import com.talat.pms.domain.Route;
import com.talat.pms.service.RouteService;

public class DefaultRouteService implements RouteService {

  RouteDao routeDao; 

  public DefaultRouteService(RouteDao routeDao) {
    this.routeDao = routeDao;
  }

  // 등록 업무
  @Override
  public int add(Route route) throws Exception {
    return routeDao.insert(route);
  }
  //
  //  // 목록 조회 업무
  //  @Override
  //  public List<Journey> list() throws Exception {
  //    return journeyDao.findByKeyword(null, null, null, null);
  //  }
  //
  // 상세 조회 업무
  @Override
  public Route get(int no) throws Exception {
    Route route = routeDao.findByNo(no);
    return route; 
  }

  // 변경 업무
  @Override
  public int update(Route route) throws Exception {
    return routeDao.update(route);
  }

  // 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return routeDao.delete(no);
  }
  //
  //  // 검색 업무
  //  @Override
  //  public List<Journey> search(String departure, String arrival, Date journeyDate, Time journeyTime) throws Exception {
  //    return journeyDao.findByKeyword(departure, arrival, journeyDate, journeyTime);
  //  }
}







