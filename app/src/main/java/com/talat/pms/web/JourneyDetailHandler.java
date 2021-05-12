package com.talat.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.Journey;
import com.talat.pms.service.JourneyService;

@SuppressWarnings("serial")
@WebServlet("/journey/detail")
public class JourneyDetailHandler extends HttpServlet {

  SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyService journeyService = (JourneyService) request.getServletContext().getAttribute("journeyService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    int no = Integer.parseInt(request.getParameter("jno"));

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>여정 상세</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>여정 상세보기</h1>");

    try {
      Journey j = journeyService.get(no);
      if (j == null) {
        out.println("<p>해당 번호의 여정이 없습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }
      out.println("<form action='update' method='post'>");
      out.println("<table border='1'>");
      out.println("<tbody>");
      out.printf("<tr><th>번호</th>"
          + " <td><input type='text' name='jno' value='%d' readonly></td></tr>\n", j.getJno());
      out.printf("<tr><th>출발지</th>"
          + " <td><input name='departure' type='text' value='%s'></td></tr>\n", j.getDeparture());
      out.printf("<tr><th>도착지</th>"
          + " <td><input name='arrival' type='text' value='%s'></td></tr>\n", j.getArrival());
      out.printf("<tr><th>여정날짜</th> <td>%s</td></tr>\n", formatterDate.format(j.getJourneyDate()));
      out.printf("<tr><th>도착시간</th> <td>%s</td></tr>\n", formatterTime.format(j.getJourneyTime()));
      out.printf("<tr><th>보조석 인원</th> <td>%d명</td></tr>\n", j.getSeatPassenger());
      out.printf("<tr><th>뒷자석 인원</th> <td>%d명</td></tr>\n", j.getSeatRear());
      out.printf("<tr><th>반려동물 탑승</th>"
          + " <td><input type='radio' name='pet' value='%d' checked onclick='return(false)></td></tr>\n", j.getPet());
      out.printf("<tr><th>여정 설명</th>"
          + " <td><textarea name='content' rows='10' cols='60'>%s</textarea></td></tr>\n", j.getContent());

      out.println("</tbody>");      //
      //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      //      if (loginUser != null && j.getDriver().getMno() == loginUser.getMno()) {
      //        out.println("<tfoot>");
      //        out.println("<tr><td colspan='2'>");
      //        out.println("<input type='submit' value='변경'> "
      //            + "<a href='delete?no=" + j.getMno() + "'>삭제</a> ");
      //        out.println("</td></tr>");
      //        out.println("</tfoot>");
      //      }

      out.println("</table>");
      out.println("</form>");


    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }
    out.println("<p><a href='list'>목록</a></p>");

    out.println("</body>");
    out.println("</html>");
  }
}






