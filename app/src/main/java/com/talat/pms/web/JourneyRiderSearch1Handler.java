package com.talat.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.service.JourneyRiderService;

// 여정 검색
@SuppressWarnings("serial")
@WebServlet("/journey/rider/search1")
public class JourneyRiderSearch1Handler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyRiderService journeyRiderService = (JourneyRiderService) request.getServletContext().getAttribute("journeyRiderService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter(); 

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>여정 검색</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>함께 할 드라이버를 찾아볼까요!</h1>");
    out.println("<form action='search' method='get'>");
    out.println("<table border='1'>");
    out.println("<tbody>");
    out.println("<tr>");
    out.println("<td><input type='search' name='departure' value='출발지'></td>\n");
    out.println("<td><input type='search' name='arrival' value='도착지'></td>\n");
    out.println("</tr>");
    out.println("<tr>");
    out.println("<td><input type='date' name='journeyDate'></td>\n");
    out.println("<td><input type='time' name='journeyTime' value='도착시간'></td>\n");
    out.println("</tr>");
    out.println("</tbody>");
    out.println("</table>");
    out.println("<p><input type='submit' value='카풀 신청하기'>");
    out.println("</form>");

    out.println("</body>");
    out.println("</html>");
  }
}
