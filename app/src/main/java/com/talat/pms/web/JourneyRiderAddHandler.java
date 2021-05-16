package com.talat.pms.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.service.JourneyRiderService;

// 카풀신청
@SuppressWarnings("serial")
@WebServlet("/journey/rider/add")
public class JourneyRiderAddHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyRiderService journeyRiderService = (JourneyRiderService) request.getServletContext().getAttribute("journeyRiderService");

    HttpSession session = request.getSession();

    try {
      JourneyRider jr = new JourneyRider();

      jr.getJourney().setJno(Integer.parseInt((String) session.getAttribute("jno")));

      journeyRiderService.add(jr);


    } catch (Exception e) {
      throw new ServletException(e);

    }
  }
}






