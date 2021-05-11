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

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("[회원 목록]");

    try {
      List<Member> list = memberService.list();

      for (Member m : list) {
        out.printf("%d, %s, %s, %s\n", 
            m.getNo(), 
            m.getMname(), 
            m.getEmail(),
            m.getTel());
      }
    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
      out.println(strWriter.toString());
    }
  }

}






