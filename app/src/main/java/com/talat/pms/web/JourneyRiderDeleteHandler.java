package com.talat.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.service.JourneyRiderService;

// 여정 취소
@SuppressWarnings("serial")
@WebServlet("/journey/rider/delete")
public class JourneyRiderDeleteHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyRiderService journeyRiderService = (JourneyRiderService) request.getServletContext().getAttribute("journeyRiderService");
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      JourneyRider oldJourneyRider = journeyRiderService.getRjno(no);

      if (oldJourneyRider == null) {
        throw new Exception("해당 번호의 여정이 없습니다.");
      } else if (oldJourneyRider.getMatchingStatus() == 1) {
        out.println("이미 매칭이 완료되어 취소가 불가능합니다.");
        return;
      }

      journeyRiderService.delete(no);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






