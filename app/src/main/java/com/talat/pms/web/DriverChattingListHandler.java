package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Member;
import com.talat.pms.service.ChattingService;
import com.talat.pms.service.JourneyService;

@Controller
public class DriverChattingListHandler {

  ChattingService chattingService;
  JourneyService journeyService;

  public DriverChattingListHandler(ChattingService chattingService, JourneyService journeyService) {
    this.chattingService = chattingService;
    this.journeyService = journeyService;
  }

  @RequestMapping("/driver_chatting_list")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    HttpServletRequest httpRequest = request;
    Member loginUser = (Member) httpRequest.getSession().getAttribute("loginUser");

    request.setAttribute("chattings", chattingService.list());
    request.setAttribute("journey", journeyService.list());
    request.setAttribute("loginUser", loginUser); // 로그인 유저

    return "chatting/driver_chatting_list";
  }
}