package com.talat.pms.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Chatting;
import com.talat.pms.domain.Journey;
import com.talat.pms.domain.MemberRider;
import com.talat.pms.service.ChattingService;

@Controller
public class ChattingAddHandler {

  ChattingService chattingService;

  public ChattingAddHandler(ChattingService chattingService) {
    this.chattingService = chattingService;
  }

  @RequestMapping("/chatting_add")
  public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));
    String input = request.getParameter("input");
    int chattingType = Integer.parseInt(request.getParameter("cttype"));
    int mno = Integer.parseInt(request.getParameter("mno"));

    Chatting ct = new Chatting();
    // jno, mno(라이더번호), chattingContent, chattingType
    ct.setChattingContent(input);
    ct.setChattingType(chattingType);

    Journey journey = new Journey();
    journey.setJno(no);
    ct.setJourney(journey);

    MemberRider member = new MemberRider();
    member.setMno(mno);
    ct.setRider(member);

    chattingService.add(ct);

    if (chattingType == 3) {
      RequestDispatcher rd = request.getRequestDispatcher("driver_chatting");
      rd.forward(request, response);
    } else {
      RequestDispatcher rd = request.getRequestDispatcher("rider_chatting");
      rd.forward(request, response);
    }
  }
}
