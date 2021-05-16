package com.talat.pms.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.talat.pms.domain.JourneyRider;

// 여정 검색
@SuppressWarnings("serial")
@WebServlet("/journey/rider/search2")
public class JourneyRiderSearch2Handler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // 클라이언트에서 보낸 값을 세션에 보관한다.
    HttpSession session = request.getSession();
    session.setAttribute("departure", request.getParameter("departure"));
    session.setAttribute("arrival", request.getParameter("arrival"));
    session.setAttribute("journeyDate", request.getParameter("journeyDate"));
    session.setAttribute("journeyTime", request.getParameter("journeyTime"));

    try {
      JourneyRider jr = new JourneyRider();
      jr.getJourney().setDeparture((String) session.getAttribute("departure"));
      jr.getJourney().setArrival((String) session.getAttribute("arrival"));
      jr.getJourney().setJourneyDate((Date.valueOf((String) session.getAttribute("journeyDate"))));
      jr.getJourney().setJourneyTime((Time.valueOf((String) session.getAttribute("journeyTime"))));

      response.sendRedirect("list");
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
