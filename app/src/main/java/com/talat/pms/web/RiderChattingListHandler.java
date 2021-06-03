package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Member;
import com.talat.pms.service.ChattingService;
import com.talat.pms.service.JourneyService;

// 나의 여정 내역
@Controller
public class RiderChattingListHandler {

  ChattingService chattingService;
  JourneyService journeyService;

  public RiderChattingListHandler(ChattingService chattingService, JourneyService journeyService) {
    this.chattingService = chattingService;
    this.journeyService = journeyService;
  }

  @RequestMapping("/rider_chatting_list")
  public String execuet(HttpServletRequest request, HttpServletResponse response) throws Exception {

    HttpServletRequest httpRequest = request;
    Member loginUser = (Member) httpRequest.getSession().getAttribute("loginUser");

    request.setAttribute("journey", journeyService.list());
    request.setAttribute("chattings", chattingService.list());
    request.setAttribute("loginUser", loginUser); // 라이더
    return "chatting/rider_chatting_list";

  } 
}






