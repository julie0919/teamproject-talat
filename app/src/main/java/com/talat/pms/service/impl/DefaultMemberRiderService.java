package com.talat.pms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import com.talat.pms.dao.MemberDao;
import com.talat.pms.dao.MemberDriverDao;
import com.talat.pms.dao.MemberRiderDao;
import com.talat.pms.domain.Member;
import com.talat.pms.domain.MemberRider;
import com.talat.pms.service.MemberRiderService;

@Service
public class DefaultMemberRiderService implements MemberRiderService {

  TransactionTemplate transactionTemplate;
  MemberDriverDao memberDriverDao;
  MemberRiderDao memberRiderDao;
  MemberDao memberDao;

  public DefaultMemberRiderService(
      PlatformTransactionManager txManager,
      MemberDriverDao memberDriverDao,
      MemberRiderDao memberRiderDao,
      MemberDao memberDao) {
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.memberDriverDao = memberDriverDao;
    this.memberRiderDao = memberRiderDao;
    this.memberDao = memberDao;
  }  

  // 등록 업무
  @Override
  public int add(Member member, MemberRider memberRider) throws Exception {
    return transactionTemplate.execute(new TransactionCallback<Integer>() {
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        try {
          memberDao.insert(member);
          memberRider.setRmno(member.getMno());
          return memberRiderDao.insert(memberRider);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  // 조회 업무
  @Override
  public List<MemberRider> list() throws Exception {
    return memberRiderDao.findAll();
  }

  // 변경 업무
  @Override
  public int update(Member member, MemberRider memberRider) throws Exception {
    return transactionTemplate.execute(new TransactionCallback<Integer>() {
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        try {
          memberDao.update(member);
          return memberRiderDao.update(memberRider);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  // 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return transactionTemplate.execute(new TransactionCallback<Integer>() {
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        try {
          int count = memberRiderDao.delete(no);
          memberDao.delete(no);
          return count;
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  @Override
  public MemberRider get(int no) throws Exception {
    return memberRiderDao.findByNo(no);
  }

  @Override
  public MemberRider get(String email, String password) throws Exception {
    Map<String,Object> params = new HashMap<>();
    params.put("email", email);
    params.put("password", password);

    return memberDriverDao.findByEmailPassword(params);
  }

}







