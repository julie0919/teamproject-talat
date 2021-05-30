//package com.talat.pms.web;
//
//import java.util.List;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import com.talat.pms.domain.Journey;
//import com.talat.pms.service.JourneyService;
//
//@Controller
//public class JourneyListHandler {
//
//  JourneyService journeyService;
//
//  public JourneyListHandler(JourneyService journeyService) {
//    this.journeyService = journeyService;
//  }
//
//  @RequestMapping("/journey/list")
//  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//    List<Journey> journeys = journeyService.list();
//    request.setAttribute("list", journeys);
//    return "/jsp/journey/list.jsp";
//  }
//}
//
//
//
//
//
//
