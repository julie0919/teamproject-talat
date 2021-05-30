package com.talat.pms.dao;

import java.util.List;
import com.talat.pms.domain.RiderQnA;

public interface RiderQnADao {

  int insert(RiderQnA riderQnA) throws Exception;

  List<RiderQnA> findAll() throws Exception;

  List<RiderQnA> findByKeyword(String keyword) throws Exception;

  RiderQnA findByNo(int no) throws Exception;

  int update(RiderQnA riderQnA) throws Exception;

  int managerUpdate(RiderQnA riderQnA) throws Exception;

  int deleteByJourneyRiderNo(int journeyRiderNo) throws Exception;

  int delete(int no) throws Exception;
}












