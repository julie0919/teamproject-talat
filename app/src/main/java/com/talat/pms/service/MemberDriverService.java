package com.talat.pms.service;

import java.util.List;
import com.talat.pms.domain.Member;
import com.talat.pms.domain.MemberDriver;
import com.talat.pms.domain.MemberRider;

public interface MemberDriverService {

  int add(Member member, MemberRider memberRider, MemberDriver memberDriver) throws Exception;

  List<MemberDriver> list() throws Exception;

  int update(MemberRider memberRider) throws Exception;

  public MemberDriver get(String email, String password) throws Exception;

  MemberDriver get(int no) throws Exception;

  int delete(int no) throws Exception;

}







