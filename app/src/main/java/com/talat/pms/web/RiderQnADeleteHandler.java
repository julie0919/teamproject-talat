package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.RiderQnA;
import com.talat.pms.service.RiderQnAService;

@Controller
public class RiderQnADeleteHandler {

  RiderQnAService riderQnAService;

  public RiderQnADeleteHandler(RiderQnAService riderQnAService) {
    this.riderQnAService = riderQnAService;
  }

  @RequestMapping("/qna/rider/delete")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    RiderQnA oldRiderQnA = riderQnAService.get(no);
    if (oldRiderQnA == null) {
      throw new Exception("해당 번호의 라이더 문의가 없습니다.");
    }

    //    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    //    if (oldRiderQnA.getWriter().getMno() != loginUser.getMno()) {
    //      throw new Exception("삭제 권한이 없습니다!");
    //    }

    riderQnAService.delete(no);
    return "redirect:list";
  }
}






