package com.talat.pms.service;

import java.util.List;
import com.talat.pms.domain.Member;

public interface MemberService {

  int add(Member member) throws Exception;

  List<Member> list() throws Exception;

  Member get(int no) throws Exception;

  Member getService(int no) throws Exception;

  Member admin() throws Exception;

  int update(Member member) throws Exception;

  int deleteRider(int no) throws Exception;

  int deleteDriver(int no) throws Exception;

}







