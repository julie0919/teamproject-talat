package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Member;

@Controller
public class LogoutHandler{

  @RequestMapping("/logout")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    Member member = (Member) request.getSession().getAttribute("loginUser");
    request.getSession().invalidate();

    return "redirect:login";
  }
}






