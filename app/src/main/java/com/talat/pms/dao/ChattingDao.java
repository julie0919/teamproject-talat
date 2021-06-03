package com.talat.pms.dao;

import java.util.List;
import com.talat.pms.domain.Chatting;

public interface ChattingDao {

  int insert(Chatting chatting) throws Exception;

  Chatting findByJno(int no) throws Exception;

  List<Chatting> findAll() throws Exception;

}
