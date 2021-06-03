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
public class AdminReviewList {

  MemberRiderService memberRiderService;
  MemberDriverService memberDriverService;
  public AdminReviewList(MemberRiderService memberRiderService, MemberDriverService memberDriverService) {
    this.memberDriverService = memberDriverService;
    this.memberRiderService = memberRiderService;
  }

  @RequestMapping("/adminreview")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    List<MemberRider> rider = memberRiderService.list();
    List<MemberDriver> driver = memberDriverService.list();

    request.setAttribute("rider", rider);
    request.setAttribute("driver", driver);

    return "admin/adminreview";
  }
}
