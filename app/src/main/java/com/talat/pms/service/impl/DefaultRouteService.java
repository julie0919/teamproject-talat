package com.talat.pms.service.impl;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import com.talat.pms.dao.RouteDao;
import com.talat.pms.domain.Route;
import com.talat.pms.service.RouteService;

@Service
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
  @Override
  public List<Route> list() throws Exception {
    return routeDao.findAll();
  }

  // 상세 조회 업무
  @Override
  public Route get(int no) throws Exception {
    Route route = routeDao.findByNo(no);
    return route; 
  }

  // 여정의 경로 검색
  @Override
  public List<Route> getRoutes(int no) throws Exception {
    return routeDao.findByJourneyNo(no);
  }

  // 라이더여정의 경로 검색
  @Override
  public List<Route> getJourneyRiderRoutes(int no) throws Exception {
    return routeDao.findByJourneyRiderNo(no);
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

  // 검색 업무
  @Override
  public List<Route> search(BigDecimal latitude, BigDecimal longitude) throws Exception {
    return routeDao.findByKeyword(latitude, longitude);
  }
}







