package com.talat.pms.web;

import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Member;
import com.talat.pms.service.MemberService;

@Controller
public class MemberUpdateHandler {

  MemberService memberService;

  public MemberUpdateHandler(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/update")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("mno"));

    Member oldMember = memberService.get(no);

    Member m = new Member();
    m.setMno(oldMember.getMno());
    m.setMname(request.getParameter("mname"));
    m.setEmail(request.getParameter("email"));
    m.setTel(request.getParameter("tel"));
    m.setBirth(Date.valueOf(request.getParameter("birth")));

    memberService.update(m);

    return "redirect:detail";
  }
}






