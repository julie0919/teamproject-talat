package com.talat.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.RiderQnA;
import com.talat.pms.service.RiderQnAService;

@SuppressWarnings("serial")
@WebServlet("/qna/rider/list")
public class RiderQnAListHandler extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 클라이언트가 /board/list 를 요청하면 톰캣 서버가 이 메서드를 호출한다. 

    RiderQnAService riderQnAService = (RiderQnAService) request.getServletContext().getAttribute("riderQnAService");

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>라이더 문의 목록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>라이더 문의 목록</h1>");

    try {
      List<RiderQnA> riderQnas = riderQnAService.list();

      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr>");
      out.println("<th>번호</th> <th>문의 유형</th> <th>작성자</th> <th>파트너</th> <th>등록일</th> <th>답변상태</th>");
      out.println("</tr>");
      out.println("</thead>");
      out.println("<tbody>");

      for (RiderQnA rq : riderQnas) {
        out.printf("<tr>"
            + " <td><a href='detail?no=%1$d'>%d</a></td>"
            + " <td>%s</td>"
            + " <td>%s</td>"
            + " <td>%s</td>"
            + " <td>%s</td>"
            + " <td>%d</td> </tr>\n",
            rq.getNo(),
            rq.getQtype().getTypeTitle(),
            rq.getWriter().getMname(),
            rq.getPartner().getMname(),
            rq.getRegisteredDate(),
            rq.getStatus());
      }
      out.println("</tbody>");
      out.println("</table>");

    } catch (Exception e) {
      throw new ServletException(e);
    }
    out.println("</body>");
    out.println("</html>");
  }
}






