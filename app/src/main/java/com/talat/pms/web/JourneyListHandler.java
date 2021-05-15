package com.talat.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.Journey;
import com.talat.pms.service.JourneyService;


@SuppressWarnings("serial")
@WebServlet("/journey/list")
public class JourneyListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyService journeyService = (JourneyService) request.getServletContext().getAttribute("journeyService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>여정 목록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>여정 목록</h1>");

    try {
      List<Journey> journeys = journeyService.list();;

      String item = request.getParameter("item");
      String keyword = request.getParameter("keyword");

      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr>");
      out.println("<th>번호</th> <th>드라이버</th> <th>출발지</th> <th>도착지</th> <th>시간</th> <th>일자</th>");
      out.println("</tr>");
      out.println("</thead>");
      out.println("<tbody>");

      for (Journey j : journeys) {

        //        StringBuilder strBuilder = new StringBuilder();
        //        List<Route> routes = j.getRoutes();
        //        for (Route r : routes) {
        //          if (strBuilder.length() > 0) {
        //            strBuilder.append(",");
        //          }
        //          strBuilder.append(r.getSpotName());
        //        }

        out.printf("<tr>"
            + " <td><a href='detail?jno=%1$d'>%d</a></td>"
            + " <td>%s</td>"
            + " <td>%s</td>"
            //            + " <td>%s</td>"
            + " <td>%s</td>"
            + " <td>%s</td>"
            + " <td>%s</td> </tr>\n", 
            j.getJno(), 
            j.getDriver().getMname(),
            j.getDeparture(), 
            //          strBuilder.toString(),
            j.getArrival(), 
            j.getJourneyTime(),
            j.getJourneyDate());
      }
      out.println("</tbody>");
      out.println("</table>");

      out.println("<form action='search' method='get'>");
      out.println("<input type='text' name='keyword'> ");
      out.println("<button>검색</button>");
      out.println("</form>");

      out.println("<form method='get'>");
      out.println("<select name='item'>");
      out.printf("  <option value='0' %s>전체</option>\n", 
          (item != null && item.equals("0")) ? "selected" : "");
      out.printf("  <option value='1' %s>출발지</option>\n", 
          (item != null && item.equals("1")) ? "selected" : "");
      out.printf("  <option value='2' %s>도착지</option>\n", 
          (item != null && item.equals("2")) ? "selected" : "");
      out.println("</select>");
      out.printf("<input type='search' name='keyword' value='%s'> \n",
          keyword != null ? keyword : "");
      out.println("<button>검색</button>");
      out.println("</form>");





    } catch (Exception e) {
      throw new ServletException(e);
    }

    out.println("</body>");
    out.println("</html>");
  }
}






