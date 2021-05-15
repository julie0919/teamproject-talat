package com.talat.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.RiderQnA;
import com.talat.pms.service.RiderQnAService;

@SuppressWarnings("serial")
@WebServlet("/qna/rider/detail")
public class RiderQnADetailHandler extends HttpServlet {

  SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
  SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RiderQnAService riderQnAService = (RiderQnAService) request.getServletContext().getAttribute("riderQnAService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>라이더 문의 상세</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>라이더 문의 상세보기</h1>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      RiderQnA rq = riderQnAService.get(no);
      if (rq == null) {
        out.println("<p>해당 번호의 라이더 문의가 없습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }
      out.println("<form action='update' method='post'>");
      out.println("<table border='1'>");
      out.println("<tbody>");
      out.printf("<tr><th>번호</th>"
          + " <td><input type='text' name='no' value='%d' readonly></td></tr>\n", rq.getNo());
      out.printf("<tr><th>문의 유형</th>"
          + " <td><input name='typeTitle' type='text' value='%s'></td></tr>\n", rq.getQtype().getTypeTitle());
      out.printf("<tr><th>작성자</th>"
          + " <td><input name='writer' type='text' value='%s'></td></tr>\n", rq.getWriter().getMname());
      out.printf("<tr><th>파트너</th>"
          + " <td><input name='partner' type='text' value='%s'></td></tr>\n", rq.getPartner().getMname());
      out.printf("<tr><th>등록일</th> <td>%s</td></tr>\n", formatterDate.format(rq.getRegisteredDate()));
      out.printf("<tr><th>등록시간</th> <td>%s</td></tr>\n", formatterTime.format(rq.getRegisteredDate()));
      if (rq.getStatus() == 0) {
        out.printf("<tr><th>답변상태</th> <td>답변대기</td></tr>\n");
      } else {
        out.printf("<tr><th>답변상태</th> <td>답변완료</td></tr>\n");
      }
      out.printf("<tr><th>문의 내용</th>"
          + " <td><textarea name='qContent' rows='10' cols='60'>%s</textarea></td></tr>\n", rq.getqContent());
      out.printf("<tr><th>문의 답변</th>"
          + " <td><textarea name='aContent' rows='10' cols='60'>%s</textarea></td></tr>\n", rq.getaContent());
      out.printf("<tr><th>첨부파일</th>"
          + " <td><input name='file' type='text' value='%s'></td></tr>\n", rq.getFile());

      out.println("</tbody>");
      out.println("</table>");

      out.println("<input type='submit' value='변경'> ");
      out.printf("<a href='delete?no=%d'>삭제</a>\n", rq.getNo());
      out.println("</form>");

    } catch (Exception e) {
      throw new ServletException(e);    
    }
    out.println("<p><a href='list'>목록</a></p>");

    out.println("</body>");
    out.println("</html>");
  }
}






