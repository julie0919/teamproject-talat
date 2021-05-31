package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.RiderQnA;
import com.talat.pms.service.RiderQnAService;

@Controller
public class RiderQnADetailHandler {

  RiderQnAService riderQnAService;

  public RiderQnADetailHandler(RiderQnAService riderQnAService) {
    this.riderQnAService = riderQnAService;
  }

  @RequestMapping("/qna/rider/detail")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    RiderQnA riderQnA = riderQnAService.get(no);
    if (riderQnA == null) {
      throw new Exception("해당 번호의 라이더 문의가 없습니다.");
    }

    request.setAttribute("riderQnA", riderQnA);
    return "riderQnA/detail";
  }
}






