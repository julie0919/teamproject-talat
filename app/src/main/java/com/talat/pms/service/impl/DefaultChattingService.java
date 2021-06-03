package com.talat.pms.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.talat.pms.dao.ChattingDao;
import com.talat.pms.domain.Chatting;
import com.talat.pms.service.ChattingService;

@Service
public class DefaultChattingService implements ChattingService {

  ChattingDao chattingDao;

  public DefaultChattingService(ChattingDao chattingDao) {
    this.chattingDao = chattingDao;
  }

  @Override
  public int add(Chatting chatting) throws Exception {
    return chattingDao.insert(chatting);
  }

  @Override
  public List<Chatting> list() throws Exception {
    return chattingDao.findAll();
  }

  @Override
  public Chatting get(int no) throws Exception {
    return chattingDao.findByJno(no);
  }
}
