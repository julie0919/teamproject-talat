package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Journey;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.service.JourneyRiderService;

// 여정 변경
@Controller
public class JourneyRiderUpdateHandler {

  JourneyRiderService journeyRiderService;

  public JourneyRiderUpdateHandler(JourneyRiderService journeyRiderService) {
    this.journeyRiderService = journeyRiderService;
  }

  @RequestMapping("/journey/rider/update")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    HttpSession session = request.getSession();

    int jno = Integer.parseInt(request.getParameter("no"));
    int rjno = (int) session.getAttribute("journeyRiderNo");

    JourneyRider jr = new JourneyRider();
    jr.setMatchingStatus(0);
    jr.setJourneyRiderNo(rjno);

    Journey journey = new Journey();
    journey.setJno(jno);
    jr.setJourney(journey);
    //      Member rider = new Member();
    //      rider.setMno(12); //로그인 유저
    //      jr.setRider(rider);

    journeyRiderService.update(jr);

    return "redirect:my_journey_list";

  }
}






