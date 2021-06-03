package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.service.MemberDriverService;
import com.talat.pms.service.MemberRiderService;

@Controller
public class AdminJurneyList {

  MemberRiderService memberRiderService;
  MemberDriverService memberDriverService;
  public AdminJurneyList(MemberRiderService memberRiderService, MemberDriverService memberDriverService) {
    this.memberDriverService = memberDriverService;
    this.memberRiderService = memberRiderService;
  }

  @RequestMapping("/adminjourney")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    return "admin/admin_journeylist";
  }
}
