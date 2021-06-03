package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminApprovalSuccess {
  @RequestMapping("/apvlsuccess")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    return "admin/update_success";
  }
}
