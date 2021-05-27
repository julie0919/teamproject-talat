package com.talat.pms.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.service.JourneyRiderService;

// 여정 상세정보
@SuppressWarnings("serial")
@WebServlet("/journey/rider/detail1")
public class JourneyRiderDetail1Handler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyRiderService journeyRiderService = (JourneyRiderService) request.getServletContext().getAttribute("journeyRiderService");
    int no = Integer.parseInt(request.getParameter("no"));

    try {

      JourneyRider journeyRider = journeyRiderService.getJno(no);
      request.setAttribute("journeyRider", journeyRider);

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/journeyRider/detail1.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






