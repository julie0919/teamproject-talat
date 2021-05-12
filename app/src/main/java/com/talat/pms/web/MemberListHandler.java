package com.talat.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.Member;
import com.talat.pms.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/member/list") 
public class MemberListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>회원목록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원</h1>");

    out.println("<a href='member1.html'>관리자 가입</a>");
    out.println("<a href='member2.html'>회원 가입</a>");

    try {
      List<Member> list = memberService.list();

      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr>");
      out.println("<th>회원번호</th> "
          + "<th style='width:100px;'>이름</th> "
          + "<th style='width:100px;'>이메일</th>"
          + "<th style='width:100px;'>전화번호</th>"
          + "<th style='width:100px;'>생년월일</th>"
          + "<th style='width:100px;'>멤버타입</th>");
      out.println("</tr>");
      out.println("</thead>");
      out.println("<tbody>");

      for (Member m : list) {
        out.printf("<tr>"
            + " <td>%d</td>"
            + " <td>%s</td>"
            + " <td>%s</td>"
            + " <td>%s</td>"
            + " <td>%s</td>"
            + " <td>%d</td></tr>\n",  
            m.getMno(), 
            m.getMname(),
            m.getEmail(),
            m.getTel(),
            m.getBirth(),
            m.getmType());
      }
      out.println("</tbody>");
      out.println("</table>");
    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
      out.println(strWriter.toString());
      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }
    out.println("</body>");
    out.println("</html>");
  }

}






