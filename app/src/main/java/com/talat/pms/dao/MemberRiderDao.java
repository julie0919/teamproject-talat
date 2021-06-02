package com.talat.pms.dao;

import java.util.List;
import com.talat.pms.domain.MemberRider;

public interface MemberRiderDao {

  int insert(MemberRider memberRider) throws Exception;

  List<MemberRider> findAll() throws Exception;

  MemberRider findByNo(int no) throws Exception;

  int update(MemberRider memberRider) throws Exception;

  int delete(int no) throws Exception;

}












