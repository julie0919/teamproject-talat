package com.talat.pms.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Member;
import com.talat.pms.domain.ReviewDriver;
import com.talat.pms.service.MemberService;
import com.talat.pms.service.ReviewDriverService;


@Controller
public class ReviewDriverListHandler {

  ReviewDriverService reviewDriverService;
  MemberService memberService;

  public ReviewDriverListHandler(ReviewDriverService reviewDriverService, MemberService memberService) {
    this.reviewDriverService = reviewDriverService;
    this.memberService = memberService;

    System.out.println("ReviewDriverListHandler 객체 생성됨!");
    System.out.println("MemberService 객체 생성됨!");
  }

  @RequestMapping("/review/member/list")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    List<ReviewDriver> revD = null;

    Member m = memberService.get(1);
    revD = reviewDriverService.list();

    request.setAttribute("revD", revD);
    request.setAttribute("member", m);

    return "/jsp/review/list.jsp";
  }
}




