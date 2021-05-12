package com.talat.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;
import java.sql.Time;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.Journey;
import com.talat.pms.service.JourneyService;

@SuppressWarnings("serial")
@WebServlet("/journey/add")
public class JourneyAddHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyService journeyService = (JourneyService) request.getServletContext().getAttribute("journeyService");

    Journey j = new Journey();

    // 클라이언트가 POST 요청으로 보낸 데이터가 UTF-8임을 알려준다.
    request.setCharacterEncoding("UTF-8");

    j.setDeparture(request.getParameter("departure"));
    j.setArrival(request.getParameter("arrival"));
    j.setJourneyDate(Date.valueOf(request.getParameter("journeyDate")));
    j.setJourneyTime(Time.valueOf(request.getParameter("journeyTime")));
    j.setSeatPassenger(Integer.parseInt(request.getParameter("seatPassenger")));
    j.setSeatRear(Integer.parseInt(request.getParameter("seatRear")));
    j.setPet(Integer.parseInt(request.getParameter("pet")));
    j.setFee(Integer.parseInt(request.getParameter("fee")));
    j.setContent(request.getParameter("content"));

    //    // 작성자는 로그인 사용자이다.
    //    HttpServletRequest httpRequest = request;
    //    Member loginUser = (Member) httpRequest.getSession().getAttribute("loginUser");
    //    j.setDriver(loginUser);

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>여정 등록</title>");

    try {
      journeyService.add(j);

      out.println("<meta http-equiv='Refresh' content='1;url=list'>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>여정 등록</h1>");
      out.println("<p>여정을 등록했습니다.</p>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.println("</head>");
      out.println("<body>");
      out.println("<h1>여정 등록 오류</h1>");
      out.printf("<pre>%s</pre>\n", strWriter.toString());
      out.println("<p><a href='list'>목록</a></p>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}






