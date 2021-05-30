package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Member;
import com.talat.pms.service.MemberService;

@Controller
public class MemberAdminInforHandler{

  MemberService memberService ;

  public MemberAdminInforHandler(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/admin/info")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    Member m = memberService.admin();

    request.setAttribute("ad", m);

    return "/jsp/member/admin.jsp";

  }
}







