package com.talat.pms.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import com.talat.pms.dao.MemberDao;
import com.talat.pms.dao.MemberDriverDao;
import com.talat.pms.dao.MemberRiderDao;
import com.talat.pms.domain.Member;
import com.talat.pms.service.MemberService;

@Service
public class DefaultMemberService implements MemberService {

  TransactionTemplate transactionTemplate;
  MemberDriverDao memberDriverDao;
  MemberRiderDao memberRiderDao;
  MemberDao memberDao;

  public DefaultMemberService(
      PlatformTransactionManager txManager,
      MemberRiderDao memberRiderDao,
      MemberDao memberDao,
      MemberDriverDao memberDriverDao) {
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.memberRiderDao = memberRiderDao;
    this.memberDao = memberDao;
    this.memberDriverDao = memberDriverDao;
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

  // mtype으로 해당 서비스 이용자 검색
  @Override
  public Member getService(int no) throws Exception {
    Member member = memberDao.findByService(no);
    return member;
  }

  @Override
  public Member admin() throws Exception {
    Member admin = memberDao.admin();
    return admin;
  }

  // 변경 업무
  @Override
  public int update(Member member) throws Exception {
    return memberDao.update(member);
  }

  @Override
  public int deleteDriver(int no) throws Exception {
    return transactionTemplate.execute(new TransactionCallback<Integer>() {
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        try {
          memberRiderDao.delete(no);
          memberDriverDao.delete(no);
          return memberDao.delete(no);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  @Override
  public int deleteRider(int no) throws Exception {
    return transactionTemplate.execute(new TransactionCallback<Integer>() {
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        try {
          memberRiderDao.delete(no);
          return memberDao.delete(no);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

}







