//package com.talat.pms.web;
//
//import java.sql.Date;
//import java.sql.Time;
//import java.util.List;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import com.talat.pms.domain.Journey;
//import com.talat.pms.domain.Route;
//import com.talat.pms.service.JourneyService;
//
//@Controller
//public class JourneyAddHandler{
//
//  JourneyService journeyService;
//
//  public JourneyAddHandler(JourneyService journeyService) {
//    this.journeyService = journeyService;
//  }
//
//  @SuppressWarnings("unchecked")
//  @RequestMapping("/journey/add")
//  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//    HttpSession session = request.getSession();
//
//    Journey j = new Journey();
//
//    j.setJourneyDate(Date.valueOf((String) session.getAttribute("journeyDate")));
//    j.setJourneyTime(Time.valueOf((String) session.getAttribute("journeyTime") + ":00"));
//
//    j.setSeatPassenger(Integer.parseInt(request.getParameter("seatPsng")));
//    j.setSeatRear(Integer.parseInt(request.getParameter("seatRear")));
//    j.setPet(Integer.parseInt(request.getParameter("pet")));
//    j.setFee(Integer.parseInt(request.getParameter("fee")));
//    j.setContent(request.getParameter("journeyContent"));
//
//    j.setRoutes((List<Route>) session.getAttribute("routes"));
//
//    journeyService.add(j, (List<Route>) session.getAttribute("routes"));
//
//    return "redirect:list";
//  }
//}
//
//
//
