package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Member;
import com.talat.pms.domain.MemberDriver;
import com.talat.pms.domain.MemberRider;
import com.talat.pms.service.MemberDriverService;
import com.talat.pms.service.MemberRiderService;
import com.talat.pms.service.MemberService;

@Controller
public class MemberDetailHandler {

  MemberDriverService memberDriverService;
  MemberRiderService memberRiverService;
  MemberService memberService;

  public MemberDetailHandler
  (MemberDriverService memberDriverService, MemberRiderService memberRiverService, MemberService memberService) {
    this.memberDriverService = memberDriverService;
    this.memberRiverService = memberRiverService;
    this.memberService = memberService;
  }

  @RequestMapping("/member/detail")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("mno"));

    Member m = memberService.get(no);

    switch (m.getmType()) {
      case 2: {
        MemberRider mr = memberRiverService.get(no);
        request.setAttribute("rmember", mr);
        return "member/detail_rider";
      }
      case 1: {
        MemberDriver md = memberDriverService.get(no);
        request.setAttribute("dmember", md);
        return "member/detail_driver";
      }
    }

    return "member/list";
  }
}







