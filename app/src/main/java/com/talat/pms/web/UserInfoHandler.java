package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Member;
import com.talat.pms.domain.MemberDriver;
import com.talat.pms.domain.MemberRider;
import com.talat.pms.service.MemberDriverService;
import com.talat.pms.service.MemberRiderService;

@Controller
public class UserInfoHandler {
  MemberDriverService memberDriverService;
  MemberRiderService memberRiderService;

  public UserInfoHandler(MemberRiderService memberRiderService, MemberDriverService memberDriverService) {
    this.memberRiderService = memberRiderService;
    this.memberDriverService = memberDriverService;
  }
  @RequestMapping("/userInfo")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    HttpSession session = request.getSession();

    Member m = (Member) request.getSession().getAttribute("loginUser");
    MemberDriver m1 = memberDriverService.get(m.getMno());
    MemberRider m2 = memberRiderService.get(m.getMno());

    if (m1 != null) {
      session.setAttribute("loginUserInfo", m1);
    } else {
      session.setAttribute("loginUserInfo", m2);
    }

    return "loginUser/login_userInfo";
  }
}
