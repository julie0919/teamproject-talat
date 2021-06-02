package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Member;
import com.talat.pms.service.MemberService;

@Controller
public class MemberDeleteHandler_Driver {

  MemberService memberService;

  public MemberDeleteHandler_Driver(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/delete")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("mno"));
    Member m = memberService.get(no);

    switch (m.getmType()) {
      case 1: {
        memberService.deleteRider(no);
        return "redirect:list";
      }
      case 2:{
        memberService.deleteDriver(no);
        return "redirect:list";
      }
    }
    return "redirect:list";
  }
}






