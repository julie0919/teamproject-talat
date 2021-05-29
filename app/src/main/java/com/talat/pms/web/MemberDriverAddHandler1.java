package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberDriverAddHandler1 {

  //  private String uploadDir;
  //
  //  @Override
  //  public void init() throws ServletException {
  //    this.uploadDir = this.getServletContext().getRealPath("/upload");
  //  }

  @RequestMapping("/member/addd1")
  public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    HttpSession session = request.getSession();

    session.setAttribute("nicName", request.getParameter("nicName"));
    session.setAttribute("gender", request.getParameter("gender"));
    session.setAttribute("postNo", request.getParameter("postNo"));
    session.setAttribute("profile", request.getParameter("profile"));
    session.setAttribute("basicAddress", request.getParameter("basicAddress"));
    session.setAttribute("detailAddress", request.getParameter("detailAddress"));
    session.setAttribute("preferenceGender", request.getParameter("preferenceGender"));
    session.setAttribute("starAverage", request.getParameter("starAverage"));
    session.setAttribute("reviewAverage", request.getParameter("reviewAverage"));

    return "/jsp/member/form3.jsp";
  }
}