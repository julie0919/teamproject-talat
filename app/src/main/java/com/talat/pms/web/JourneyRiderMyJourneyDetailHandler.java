package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.service.JourneyRiderService;
import com.talat.pms.service.RouteService;

// 나의 여정 상세정보
@Controller
public class JourneyRiderMyJourneyDetailHandler {

  JourneyRiderService journeyRiderService;
  RouteService routeService;

  public JourneyRiderMyJourneyDetailHandler(JourneyRiderService journeyRiderService, RouteService routeService) {
    this.journeyRiderService = journeyRiderService;
    this.routeService = routeService;
  }

  @RequestMapping("/journey/rider/my_journey_detail")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    JourneyRider journeyRider = journeyRiderService.getRjno(no);
    request.setAttribute("journeyRider", journeyRider);
    request.setAttribute("routes", routeService.getJourneyRoutes(no));

    HttpSession session = request.getSession();
    session.setAttribute("journeyRiderNo", no);
    session.getAttribute("keyword1");
    session.getAttribute("keyword2");
    session.getAttribute("keyword3");
    session.getAttribute("keyword4");

    return "/jsp/journeyRider/my_journey_detail.jsp";

  }
}






