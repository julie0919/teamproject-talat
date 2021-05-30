package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.RiderQnA;
import com.talat.pms.service.RiderQnAService;

@Controller
public class RiderQnAManagerDetailHandler {

  RiderQnAService riderQnAService;

  public RiderQnAManagerDetailHandler(RiderQnAService riderQnAService) {
    this.riderQnAService = riderQnAService;
  }

  @RequestMapping("/qna/rider/manager/detail")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    RiderQnA riderQnA = riderQnAService.get(no);
    if (riderQnA == null) {
      throw new Exception("해당 번호의 라이더 문의가 없습니다.");
    }

    //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    //      if ( loginUser.getMno() == 1) {
    //        out.println("<input type='submit' value='변경'> ");
    //      }

    request.setAttribute("riderQnA", riderQnA);
    return "/jsp/riderQnA/manager_detail.jsp";
  }
}






