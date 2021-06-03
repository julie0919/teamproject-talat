package com.talat.pms.service;

import java.util.List;
import com.talat.pms.domain.Chatting;

public interface ChattingService {

  int add(Chatting chatting) throws Exception;

  List<Chatting> list() throws Exception;

  Chatting get(int no) throws Exception;

}
