package com.talat.pms.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.MemberDriver;
import com.talat.pms.service.MemberDriverService;

@Controller
public class MemberListHandler{

  MemberDriverService memberDriverService ;

  public MemberListHandler(MemberDriverService memberDriverService) {
    this.memberDriverService = memberDriverService;
  }

  @RequestMapping("/member/list")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    List<MemberDriver> list = memberDriverService.list();

    request.setAttribute("list", list);

    return "/jsp/member/memberlist.jsp";

  }
}







