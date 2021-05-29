package com.talat.pms.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.service.JourneyRiderService;

// 여정 변경 검색
@Controller
public class JourneyRiderUpdateSearchHandler {

  JourneyRiderService journeyRiderService;

  public JourneyRiderUpdateSearchHandler(JourneyRiderService journeyRiderService) {
    this.journeyRiderService = journeyRiderService;
  }

  @RequestMapping("/journey/rider/updateSearch")
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {

      String keyword1 = request.getParameter("keyword1");
      String keyword2 = request.getParameter("keyword2");
      String keyword3 = request.getParameter("keyword3");
      String keyword4 = request.getParameter("keyword4");

      List<JourneyRider> journeyRiders = journeyRiderService.search(keyword1, keyword2, keyword3, keyword4);

      request.setAttribute("journeyRiders", journeyRiders);

      response.setContentType("text/html;charset=UTF-8");
      RequestDispatcher rd = request.getRequestDispatcher("/jsp/journeyRider/update_search.jsp");
      rd.forward(request, response);
    } catch (Exception e) {
      throw new ServletException(e);
    }

  }


}
