package com.talat.pms.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.MemberDriver;
import com.talat.pms.domain.MemberRider;
import com.talat.pms.service.MemberDriverService;
import com.talat.pms.service.MemberRiderService;

@Controller
public class MemberListHandler{

  MemberDriverService memberDriverService;
  MemberRiderService memberRiderService;

  public MemberListHandler(MemberDriverService memberDriverService, MemberRiderService memberRiderService) {
    this.memberDriverService = memberDriverService;
    this.memberRiderService = memberRiderService;
  }

  @RequestMapping("/apvl/list")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    List<MemberDriver> list1 = memberDriverService.list();
    System.out.println(list1);
    List<MemberRider> list2 = memberRiderService.list();
    System.out.println(list2);
    request.setAttribute("list1", list1);
    request.setAttribute("list2", list2);

    return "member/memberlist";


  }
}







