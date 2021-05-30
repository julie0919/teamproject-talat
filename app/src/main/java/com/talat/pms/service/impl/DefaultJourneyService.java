package com.talat.pms.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import com.talat.pms.dao.JourneyDao;
import com.talat.pms.dao.RouteDao;
import com.talat.pms.domain.Journey;
import com.talat.pms.domain.Route;
import com.talat.pms.service.JourneyService;

@Service
public class DefaultJourneyService implements JourneyService {

  TransactionTemplate transactionTemplate;

  JourneyDao journeyDao; 
  RouteDao routeDao;

  public DefaultJourneyService(PlatformTransactionManager txManager, JourneyDao journeyDao, RouteDao routeDao) {
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.journeyDao = journeyDao;
    this.routeDao = routeDao;
  }

  // 등록 업무
  @Override
  public int add(Journey journey, List<Route> routes) throws Exception {
    return transactionTemplate.execute(new TransactionCallback<Integer>() {
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        try {
          // 트랜잭션으로 묶어서 실행할 작업을 기술한다.
          // 1) 여정 정보를 입력한다.
          int count = journeyDao.insert(journey, routes); 

          for (Route r : routes) {
            r.setJno(journey.getJno());
            routeDao.insert(r);
          }
          return count;

        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  // 목록 조회 업무
  @Override
  public List<Journey> list() throws Exception {
    return journeyDao.findAll2();
  }

  // 상세 조회 업무
  @Override
  public Journey get(int no) throws Exception {
    return journeyDao.findByNo(no);
  }

  @Override
  public List<Route> getRoutes(int journeyNo) throws Exception {
    return journeyDao.findRoutes(journeyNo);
  }

  // 변경 업무
  @Override
  public int update(Journey journey, List<Route> routes) throws Exception {
    return transactionTemplate.execute(new TransactionCallback<Integer>() {
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        try {
          int count = journeyDao.update(journey, routes);

          // 기존의 Routes 정보 삭제
          // 1) 여정의 경로정보 삭제
          // routeDao와 Mapper를 보면 routeDao.delete은 jno=${value}일 때의 route 정보 삭제
          routeDao.delete(journey.getJno());

          // 2) 새로운 경로정보 추가
          for (Route r : routes) {
            r.setJno(journey.getJno());
            routeDao.insert(r);
          }
          return count;

        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  // 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return transactionTemplate.execute(new TransactionCallback<Integer>() {
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        try {

          // 트랜잭션으로 묶어서 실행할 작업을 기술한다.       
          // 1) 여정의 경로정보 삭제
          // routeDao와 Mapper를 보면 routeDao.delete은 jno=${value}일 때의 route 정보 삭제
          routeDao.delete(no);
          // 2) 여정 삭제
          return journeyDao.delete(no);

        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  // 검색 업무
  //  @Override
  //  public List<Journey> search(String departure, String arrival, Date journeyDate, Time journeyTime) throws Exception {
  //    return journeyDao.findByKeyword(departure, arrival, journeyDate, journeyTime);
  //  }
  //
  //  public List<Journey> search(String departure, String arrival) throws Exception {
  //    HashMap<String,Object> params = new HashMap<>();
  //    params.put("departure", departure);
  //    params.put("arrival", arrival);
  //
  //    return journeyDao.findByRoutes(params);
  //  }


}







