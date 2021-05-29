package com.talat.pms.dao;

import java.util.List;
import java.util.Map;
import com.talat.pms.domain.MemberDriver;
import com.talat.pms.domain.MemberRider;

public interface MemberDriverDao {

  int insert(MemberDriver memberDriver) throws Exception;

  List<MemberDriver> findAll() throws Exception;

  MemberDriver findByNo(int no) throws Exception;

  MemberDriver findByEmailPassword(Map<String,Object> params) throws Exception;

  int update(MemberRider memberRider) throws Exception;

  int delete(int no) throws Exception;

}












