package com.talat.pms.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.Journey;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.domain.Member;
import com.talat.pms.service.JourneyRiderService;

// 카풀신청
@SuppressWarnings("serial")
@WebServlet("/journey/rider/add")
public class JourneyRiderAddHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyRiderService journeyRiderService = (JourneyRiderService) request.getServletContext().getAttribute("journeyRiderService");

    try {
      int jno = Integer.parseInt(request.getParameter("no"));
      JourneyRider jr = new JourneyRider();
      jr.setMatchingStatus(0);

      Journey journey = new Journey();
      journey.setJno(jno);
      jr.setJourney(journey);

      Member rider = new Member();
      rider.setMno(12); // 로그인 유저
      jr.setRider(rider);

      journeyRiderService.add(jr);

      request.setAttribute("journeyRiders", jr);

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/journeyRider/form.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

}