package com.talat.pms.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.service.JourneyRiderService;

// 여정 검색
@SuppressWarnings("serial")
@WebServlet("/journey/rider/search2")
public class JourneyRiderSearch2Handler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyRiderService journeyRiderService = (JourneyRiderService) request.getServletContext().getAttribute("journeyRiderService");
    try {

      String keyword1 = request.getParameter("keyword1");
      String keyword2 = request.getParameter("keyword2");
      String keyword3 = request.getParameter("keyword3");
      String keyword4 = request.getParameter("keyword4");

      List<JourneyRider> journeyRiders = journeyRiderService.search(keyword1, keyword2, keyword3, keyword4);
      request.setAttribute("journeyRiders", journeyRiders);

      response.setContentType("text/html;charset=UTF-8");
      RequestDispatcher rd = request.getRequestDispatcher("/jsp/journeyRider/search2.jsp");
      rd.forward(request, response);
    } catch (Exception e) {
      throw new ServletException(e);
    }

  }


}
