package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.MemberDriver;
import com.talat.pms.service.MemberDriverService;

@Controller
public class ApprovalupdateHandler {

  MemberDriverService memberDriverService;

  public ApprovalupdateHandler(MemberDriverService memberDriverService) {
    this.memberDriverService = memberDriverService;
  }

  @RequestMapping("/ap/update")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("mno"));

    MemberDriver m = memberDriverService.get(no);

    MemberDriver md = new MemberDriver();
    md.setMno(m.getMno());
    md.setApproval(Integer.parseInt(request.getParameter("approval")));
    md.setApprovalContent(request.getParameter("approvalContent"));

    memberDriverService.apvlUpdate(md);

    return "redirect:aplist";
  }
}
