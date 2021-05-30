package com.talat.pms.dao;

import java.util.List;
import com.talat.pms.domain.Member;

public interface MemberDao {

  int insert(Member member) throws Exception;

  List<Member> findAll() throws Exception;

  Member findByNo(int no) throws Exception;

  Member findByService(int no) throws Exception;

  Member admin() throws Exception;

  int update(Member member) throws Exception;

  int delete(int no) throws Exception;


}