package com.talat.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.service.JourneyRiderService;

// 여정 검색
@SuppressWarnings("serial")
@WebServlet("/journey/rider/search")
public class JourneyRiderSearchHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyRiderService journeyRiderService = (JourneyRiderService) request.getServletContext().getAttribute("journeyRiderService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter(); 

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>여정 검색</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>함께 할 드라이버를 찾아볼까요!</h1>");

    try {
      String departure = request.getParameter("departure");
      String arrival = request.getParameter("arrival");
      Date journeyDate = Date.valueOf(request.getParameter("journeyDate"));
      Time journeyTime = Time.valueOf(request.getParameter("journeyTime"));

      List<JourneyRider> journeyRiders = journeyRiderService.search(departure, arrival, journeyDate, journeyTime);

      //      if ((departure != null && departure.length() > 0) ||
      //          (arrival != null && arrival.length() > 0) ||
      //          (journeyDate != null && journeyDate.toString().length() > 0) ||
      //          (journeyTime != null && journeyTime.toString().length() > 0)) {
      //        journeyRiders = journeyRiderService.search(departure, arrival, journeyDate, journeyTime);
      //      } else {
      //        journeyRiders = journeyRiderService.list();
      //      }

      out.println("<form method='get'>");
      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr>");
      out.println("<th>번호</th> <th>출발지</th> <th>도착지</th> <th>여정 날짜</th> <th>시간</th>");
      out.println("</tr>");
      out.println("</thead>");
      out.println("<tbody>");
      for (JourneyRider jr : journeyRiders) {
        out.printf("<tr>"
            + " <td>%d</td>"
            + " <td>%s</td>"
            + " <td>%s</td>"
            + " <td>%s</td>"
            + " <td>%s</td>"
            + " <td>%s</td>",
            jr.getJourney().getJno(),
            jr.getDriver().getMname(),
            jr.getJourney().getDeparture(),
            jr.getJourney().getArrival(),
            jr.getJourney().getJourneyTime(),
            jr.getJourney().getJourneyDate()
            );
      }
      out.println("</tbody>");
      out.println("</table>");
      out.println("<p><input type='submit' value='카풀 신청하기'>");
      out.println("</form>");

    } catch (Exception e) {
      throw new ServletException(e); 
    }

    out.println("</body>");
    out.println("</html>");
  }
}
