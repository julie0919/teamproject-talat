package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Member;
import com.talat.pms.service.MemberDriverService;
import com.talat.pms.service.MemberRiderService;
import com.talat.pms.service.MemberService;

@Controller
public class MemberDeleteHandler {

  MemberService memberService;
  MemberRiderService memberRiderService;
  MemberDriverService memberDriverService;

  public MemberDeleteHandler(
      MemberService memberService, MemberRiderService memberRiderService, MemberDriverService memberDriverService) {
    this.memberService = memberService;
    this.memberRiderService = memberRiderService;
    this.memberDriverService = memberDriverService;
  }

  @RequestMapping("/member/delete")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("mno"));
    Member m = memberService.get(no);

    if (m.getmType() == 1) {
      memberService.deleteRider(no);
    } else if (m.getmType() == 2) {
      memberService.deleteDriver(no);
    }
    return "redirect:list";
  }
}






