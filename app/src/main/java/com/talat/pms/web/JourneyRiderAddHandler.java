package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Journey;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.domain.Member;
import com.talat.pms.service.JourneyRiderService;

// 카풀신청
@Controller
public class JourneyRiderAddHandler {

  JourneyRiderService journeyRiderService;

  public JourneyRiderAddHandler(JourneyRiderService journeyRiderService) {
    this.journeyRiderService = journeyRiderService;
  }

  @RequestMapping("/journey/rider/add")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));
    JourneyRider jr = new JourneyRider();
    jr.setMatchingStatus(0);

    Journey journey = new Journey();
    journey.setJno(no);
    jr.setJourney(journey);

    //    HttpServletRequest httpRequest = request;
    //    Member loginUser = (Member) httpRequest.getSession().getAttribute("loginUser");
    //    jr.setRider(loginUser);

    Member rider = new Member();
    rider.setMno(12); // 로그인 유저
    jr.setRider(rider);

    journeyRiderService.add(jr);

    jr = journeyRiderService.getJno(no);

    request.setAttribute("journeyRiders", jr);

    return "/jsp/journeyRider/form.jsp";

  }

}