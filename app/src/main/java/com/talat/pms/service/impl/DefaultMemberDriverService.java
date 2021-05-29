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
import com.talat.pms.domain.MemberDriver;
import com.talat.pms.domain.MemberRider;
import com.talat.pms.service.MemberDriverService;

@Service
public class DefaultMemberDriverService implements MemberDriverService {

  TransactionTemplate transactionTemplate;
  MemberDriverDao memberDriverDao;
  MemberRiderDao memberRiderDao;
  MemberDao memberDao;

  public DefaultMemberDriverService(
      PlatformTransactionManager txManager, MemberRiderDao memberRiderDao, MemberDao memberDao, MemberDriverDao memberDriverDao) {
    this.memberDriverDao = memberDriverDao;
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.memberRiderDao = memberRiderDao;
    this.memberDao = memberDao;
  }  

  // 등록 업무
  @Override
  public int add(Member member, MemberRider memberRider, MemberDriver memberDriver) throws Exception {
    return transactionTemplate.execute(new TransactionCallback<Integer>() {
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        try {
          memberDao.insert(member);
          memberRider.setRmno(member.getMno());
          memberRiderDao.insert(memberRider);
          memberDriver.setDmno(member.getMno());
          return memberDriverDao.insert(memberDriver);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  // 조회 업무
  @Override
  public List<MemberDriver> list() throws Exception {
    return memberDriverDao.findAll();
  }

  @Override
  public MemberDriver get(int no) throws Exception {
    return memberDriverDao.findByNo(no);
  }

  @Override
  public MemberDriver get(String email, String password) throws Exception {
    Map<String,Object> params = new HashMap<>();
    params.put("email", email);
    params.put("password", password);

    return memberDriverDao.findByEmailPassword(params);
  }

  // 변경 업무
  @Override
  public int update(MemberRider memberRider) throws Exception {
    return memberDriverDao.update(memberRider);
  }

  // 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return memberDriverDao.delete(no);
  }

}







