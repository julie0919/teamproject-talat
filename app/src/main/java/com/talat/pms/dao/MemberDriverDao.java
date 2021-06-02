package com.talat.pms.dao;

import java.util.List;
import java.util.Map;
import com.talat.pms.domain.MemberDriver;

public interface MemberDriverDao {

  int insert(MemberDriver memberDriver) throws Exception;

  List<MemberDriver> findAll() throws Exception;

  MemberDriver findByNo(int no) throws Exception;

  MemberDriver findByEmailPassword(Map<String,Object> params) throws Exception;

  int update(MemberDriver memberDriver) throws Exception;

  int updateApvl(MemberDriver memberDriver) throws Exception;

  int delete(int no) throws Exception;

}












