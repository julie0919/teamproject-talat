package com.talat.pms.dao;

import java.util.List;
import com.talat.pms.domain.DriverQnA;

public interface DriverQnADao {

  int insert(DriverQnA driverQnA) throws Exception;

  List<DriverQnA> findAll() throws Exception;

  List<DriverQnA> findByKeyword(String keyword) throws Exception;

  DriverQnA findByNo(int no) throws Exception;

  int update(DriverQnA driverQnA) throws Exception;

  int managerUpdate(DriverQnA driverQnA) throws Exception;

  int deleteByJourneyNo(int journeyNo) throws Exception;

  int delete(int no) throws Exception;
}












