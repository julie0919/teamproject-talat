package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.MemberDriver;
import com.talat.pms.service.MemberDriverService;

@Controller
public class ApprovalDetailHandler {

  MemberDriverService memberDriverService;

  public ApprovalDetailHandler
  (MemberDriverService memberDriverService) {
    this.memberDriverService = memberDriverService;
  }

  @RequestMapping("/apdetail")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("mno"));

    MemberDriver m = memberDriverService.get(no);
    request.setAttribute("apmember", m);

    return "admin/admin_apdetail";
  }
}
