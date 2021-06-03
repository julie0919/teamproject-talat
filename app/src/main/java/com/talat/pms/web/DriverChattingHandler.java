package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Member;
import com.talat.pms.service.ChattingService;
import com.talat.pms.service.JourneyService;

@Controller
public class DriverChattingHandler {

  ChattingService chattingService;
  JourneyService journeyService;

  public DriverChattingHandler(ChattingService chattingService, JourneyService journeyService) {
    this.chattingService = chattingService;
    this.journeyService = journeyService;
  }

  @RequestMapping("/driver_chatting")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    HttpServletRequest httpRequest = request;
    Member loginUser = (Member) httpRequest.getSession().getAttribute("loginUser");

    int no = Integer.parseInt(request.getParameter("no"));
    request.setAttribute("chattings", chattingService.list());
    request.setAttribute("journey", journeyService.get(no));
    request.setAttribute("loginUser", loginUser); // 로그인 유저 -> 라이더

    return "chatting/driver_chatting_form";
  }
}