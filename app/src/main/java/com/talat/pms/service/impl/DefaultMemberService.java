package com.talat.pms.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.talat.pms.dao.MemberDao;
import com.talat.pms.domain.Member;
import com.talat.pms.service.MemberService;

@Service
public class DefaultMemberService implements MemberService {

  MemberDao memberDao;

  public DefaultMemberService(MemberDao memberDao) {
    this.memberDao = memberDao;
  }  

  // 등록 업무
  @Override
  public int add(Member member) throws Exception {
    return memberDao.insert(member);
  }

  // 조회 업무
  @Override
  public List<Member> list() throws Exception {
    return memberDao.findAll();
  }

  //사용자 조회 업무
  @Override
  public Member get(int no) throws Exception {
    Member member = memberDao.findByNo(no);

    return member;
  }

  // 변경 업무
  @Override
  public int update(Member member) throws Exception {
    return memberDao.update(member);
  }

  // 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return memberDao.delete(no);
  }

}







