package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.service.JourneyRiderService;
import com.talat.pms.service.RouteService;

// 여정 검색 상세정보
@Controller
public class JourneyRiderSearchDetailHandler {

  JourneyRiderService journeyRiderService;
  RouteService routeService;

  public JourneyRiderSearchDetailHandler(JourneyRiderService journeyRiderService, RouteService routeService) {
    this.journeyRiderService = journeyRiderService;
    this.routeService = routeService;
  }

  @RequestMapping("/journey/rider/search_detail")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    JourneyRider journeyRider = journeyRiderService.getJno(no);
    request.setAttribute("journeyRider", journeyRider);
    request.setAttribute("routes", routeService.getRoutes(no));

    return "journeyRider/search_detail";
  }
}






