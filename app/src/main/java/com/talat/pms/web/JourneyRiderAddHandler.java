package com.talat.pms.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Journey;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.domain.MemberRider;
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

    HttpSession session = request.getSession();
    session.getAttribute("keyword1");
    session.getAttribute("keyword2");
    session.getAttribute("keyword3");
    session.getAttribute("keyword4");

    List<JourneyRider> oldJourneyRider = journeyRiderService.list();

    //  이미 신청한 여정일 경우 다시 search2 화면으로
    for (JourneyRider jr : oldJourneyRider) {
      if (jr.getJourney().getJno() == no) {
        return "journeyRider/add_fail";
      }
    }

    JourneyRider jr = new JourneyRider();
    jr.setMatchingStatus(0);

    Journey journey = new Journey();
    journey.setJno(no);
    jr.setJourney(journey);

    //    HttpServletRequest httpRequest = request;
    //    Member loginUser = (Member) httpRequest.getSession().getAttribute("loginUser");
    //    jr.setRider(loginUser);

    MemberRider rider = new MemberRider();
    rider.setMno(12); // 로그인 유저
    jr.setRider(rider);

    journeyRiderService.add(jr);
    jr = journeyRiderService.getJno(no);
    request.setAttribute("journeyRiders", jr);
    request.setAttribute("list", journeyRiderService.list());


    return "journeyRider/form";

  }

}