package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberAddHandler1 {

  @RequestMapping("/member/add1")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    return "/jsp/member/form1.jsp";

  }
}