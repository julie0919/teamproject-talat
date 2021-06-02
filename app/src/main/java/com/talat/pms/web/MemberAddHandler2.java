package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberAddHandler2{

  @RequestMapping("/member/add2")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    HttpSession session = request.getSession();
    session.setAttribute("mname", request.getParameter("mname"));
    session.setAttribute("email", request.getParameter("email"));
    session.setAttribute("password", request.getParameter("password"));
    session.setAttribute("tel", request.getParameter("tel"));
    session.setAttribute("birth", request.getParameter("birth"));
    session.setAttribute("mType", request.getParameter("mType"));

    if (request.getParameter("mType").equals("2")) {
      return "/member/form2";
    } else if (request.getParameter("mType").equals("1")) {
      return "/member/form2_driver";
    }
    return "member/memberlist";
  }
}