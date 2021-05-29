package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.MemberDriver;
import com.talat.pms.service.MemberDriverService;

@Controller
public class MemberDetailHandler {

  MemberDriverService memberDriverService;

  public MemberDetailHandler(MemberDriverService memberDriverService) {
    this.memberDriverService = memberDriverService;
  }

  @RequestMapping("/member/detail")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {


    int no = Integer.parseInt(request.getParameter("mno"));

    MemberDriver m = memberDriverService.get(no);

    request.setAttribute("member", m);
    return "/jsp/member/detail.jsp";
  }
}







