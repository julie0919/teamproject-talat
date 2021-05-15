package com.talat.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/journey/add1")
public class JourneyAdd1Handler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>여정 등록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>여정 등록: 1단계</h1>");
    out.println("<p>함께 할 라이더를 찾아볼까요!</p>");

    out.println("<form action='add2' method='post'>");
    out.println("출발지: <input type='text' name='departure'><br>");
    //    out.println("경유지1: <input type='text' name='route1'><br>");
    //    out.println("경유지2: <input type='text' name='route2'><br>");
    out.println("도착지: <input type='text' name='arrival'><br>");
    out.println("날짜: <input type='date' name='journeyDate'><br>");
    out.println("시간: <input type='time' name='journeyTime'><br>");
    out.println("<p><input type='submit' value='여정 등록하기'>");
    out.println("<a href='list'>취소</a></p>");
    out.println("</form>");

    out.println("</body>");
    out.println("</html>");
  }
}






