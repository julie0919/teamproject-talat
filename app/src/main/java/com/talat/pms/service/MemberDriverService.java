package com.talat.pms.service;

import java.util.List;
import com.talat.pms.domain.Member;
import com.talat.pms.domain.MemberDriver;
import com.talat.pms.domain.MemberRider;

public interface MemberDriverService {

  int add(Member member, MemberRider memberRider, MemberDriver memberDriver) throws Exception;

  List<MemberDriver> list() throws Exception;

  MemberDriver get(int no) throws Exception;

  public MemberDriver get(String email, String password) throws Exception; 

  int update(MemberDriver memberDriver, MemberRider memberRider, Member member) throws Exception;

  int apvlUpdate(MemberDriver memberDriver) throws Exception;

  int delete(int no) throws Exception;

}







