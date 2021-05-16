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

// 카풀신청
@SuppressWarnings("serial")
@WebServlet("/journey/rider/add")
public class JourneyRiderAddHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyRiderService journeyRiderService = (JourneyRiderService) request.getServletContext().getAttribute("journeyRiderService");

    JourneyRider jr = new JourneyRider();

    jr.getJourney().setJno(Integer.parseInt(request.getParameter("jno")));

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>카풀 신청</title>");

    try {
      journeyRiderService.add(jr);

      out.println("<meta http-equiv='Refresh' content='1;url=list'>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>카풀 신청이 완료되었습니다!</h1>");

    } catch (Exception e) {
      throw new ServletException(e);

    }

    out.println("</body>");
    out.println("</html>");
  }
}






