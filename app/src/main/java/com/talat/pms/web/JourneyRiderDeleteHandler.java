package com.talat.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.service.JourneyRiderService;

// 여정 취소
@SuppressWarnings("serial")
@WebServlet("/journeyRider/delete")
public class JourneyRiderDeleteHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyRiderService journeyRiderService = (JourneyRiderService) request.getServletContext().getAttribute("journeyRiderService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>여정 취소</title>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      JourneyRider oldJourneyRider = journeyRiderService.get(no);
      if (oldJourneyRider == null) {
        throw new Exception("해당 번호의 여정이 없습니다.");
      }

      journeyRiderService.delete(no);

      out.println("</head>");
      out.println("<body>");
      out.println("<h1>여정 취소</h1>");
      out.println("<p>여정을 취소하였습니다.</p>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.println("</head>");
      out.println("<body>");
      out.println("<h1>여정 취소 오류</h1>");
      out.printf("<p>%s</p>\n", e.getMessage());
      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }

    out.println("</body>");
    out.println("</html>");
  }
}






