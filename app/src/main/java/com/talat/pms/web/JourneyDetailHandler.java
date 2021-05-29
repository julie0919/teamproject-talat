//package com.talat.pms.web;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import com.talat.pms.service.JourneyService;
//import com.talat.pms.service.RouteService;
//
//@Controller
//public class JourneyDetailHandler {
//
//  JourneyService journeyService;
//  RouteService routeService;
//
//  public JourneyDetailHandler(JourneyService journeyService,RouteService routeService) {
//    this.journeyService = journeyService;
//    this.routeService = routeService;
//  }
//
//  @RequestMapping("/journey/detail")
//  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//    int no = Integer.parseInt(request.getParameter("jno"));
//
//    request.setAttribute("journey", journeyService.get(no));
//    request.setAttribute("routes", routeService.getRoutes(no));
//    return "/jsp/journey/detail.jsp";
//  }
//}
//
//
//
//
//
//
