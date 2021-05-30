//package com.talat.pms.web;
//
//import java.util.List;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import com.talat.pms.domain.Member;
//import com.talat.pms.domain.ReviewRider;
//import com.talat.pms.service.MemberService;
//import com.talat.pms.service.ReviewRiderService;
//
//
//@Controller
//public class ReviewRiderListHandler {
//
//  ReviewRiderService reviewRiderService;
//  MemberService memberService;
//
//  public ReviewRiderListHandler(ReviewRiderService reviewRiderService, MemberService memberService) {
//    this.reviewRiderService = reviewRiderService;
//    this.memberService = memberService;
//
//    System.out.println("ReviewRiderListHandler 객체 생성됨!");
//    System.out.println("MemberService 객체 생성됨!");
//  }
//
//  @RequestMapping("/review/member/list")
//  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//    List<ReviewRider> revR = null;
//
//    Member m = memberService.get(1);
//    revR = reviewRiderService.list();
//
//    request.setAttribute("revR", revR);
//    request.setAttribute("member", m);
//
//
// 한서블렛을 하나의 jsp로 보내면서 
// 해당 url주소에 이미 reviewDriverListHandler가 사용중이라고
// bean에러 나옴 --> 수정중
//
//    return "/jsp/review/list.jsp";
//  }
//}
//
//
//
//
