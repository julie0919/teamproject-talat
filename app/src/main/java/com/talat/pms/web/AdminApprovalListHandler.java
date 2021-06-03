package com.talat.pms.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.MemberDriver;
import com.talat.pms.service.MemberDriverService;

@Controller
public class AdminApprovalListHandler{

  MemberDriverService memberDriverService;

  public AdminApprovalListHandler(MemberDriverService memberDriverService) {
    this.memberDriverService = memberDriverService;
  }

  @RequestMapping("/adminapvllist")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    List<MemberDriver> list = memberDriverService.list();
    request.setAttribute("aplist", list);

    return "admin/admin_approval";


  }
}







