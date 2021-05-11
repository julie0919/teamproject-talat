package com.talat.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.Member;
import com.talat.pms.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/member/add")
public class MemberAddHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    try {
      out.println("[관리자 등록]");

      Member m = new Member();
      m.setMname(request.getParameter("name"));
      m.setEmail(request.getParameter("email"));
      m.setPassword(request.getParameter("password"));
      m.setTel(request.getParameter("tel"));
      m.setBirth(Date.valueOf(request.getParameter("birth")));
      m.setmType(Integer.parseInt(request.getParameter("mType")));

      memberService.add(m);

      out.println("관리자를 등록하였습니다.");
    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
      out.println(strWriter.toString());
    }
  }
}






