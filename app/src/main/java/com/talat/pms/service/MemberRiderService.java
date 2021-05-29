package com.talat.pms.service;

import java.util.List;
import com.talat.pms.domain.Member;
import com.talat.pms.domain.MemberRider;

public interface MemberRiderService {

  int add(Member member, MemberRider memberRider) throws Exception;

  List<MemberRider> list() throws Exception;

  int update(MemberRider memberRider) throws Exception;

  int delete(int no) throws Exception;

}







