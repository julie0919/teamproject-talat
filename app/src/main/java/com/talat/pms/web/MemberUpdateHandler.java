package com.talat.pms.web;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.Member;
import com.talat.pms.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/member/update")
public class MemberUpdateHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

    try {
      int no = Integer.parseInt(request.getParameter("mno"));

      Member oldMember = memberService.get(no);

      Member m = new Member();
      m.setMno(oldMember.getMno());
      m.setMname(request.getParameter("mname"));
      m.setEmail(request.getParameter("email"));
      m.setTel(request.getParameter("tel"));
      m.setBirth(Date.valueOf(request.getParameter("birth")));
      m.setNickName(request.getParameter("nicName"));
      m.setPostNo(request.getParameter("postNo"));
      m.setBasicAddress(request.getParameter("basicAddress"));
      m.setDetailAddress(request.getParameter("detailAddress"));
      m.setPreferenceGender(Integer.parseInt(request.getParameter("preferenceGender")));

      memberService.update(m);

      response.sendRedirect("detail");
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






