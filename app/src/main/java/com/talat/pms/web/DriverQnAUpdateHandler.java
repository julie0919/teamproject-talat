package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.DriverQnA;
import com.talat.pms.domain.QnA;
import com.talat.pms.service.DriverQnAService;

@Controller
public class DriverQnAUpdateHandler {

  DriverQnAService driverQnAService;

  public DriverQnAUpdateHandler(DriverQnAService driverQnAService) {
    this.driverQnAService = driverQnAService;
  }

  @RequestMapping("/qna/driver/update")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    DriverQnA oldDriverQnA = driverQnAService.get(no);
    if (oldDriverQnA == null) {
      throw new Exception("해당 번호의 라이더 문의가 없습니다.");
    }

    DriverQnA dq = new DriverQnA();
    dq.setNo(oldDriverQnA.getNo());

    QnA q = new QnA();
    q.setNo(Integer.parseInt(request.getParameter("qtype")));
    if (Integer.parseInt(request.getParameter("qtype")) == 1) {
      q.setTypeTitle("분실물 문의");
    } else if (Integer.parseInt(request.getParameter("qtype")) == 2) {
      q.setTypeTitle("안전문제보고");
    } else if (Integer.parseInt(request.getParameter("qtype")) == 3) {
      q.setTypeTitle("파트너의 의견 제공");
    } else if (Integer.parseInt(request.getParameter("qtype")) == 4) {
      q.setTypeTitle("여정 관련 고객지원");
    }
    dq.setQtype(q);
    dq.setqContent(request.getParameter("qContent"));
    dq.setFile(request.getParameter("file"));

    driverQnAService.update(dq);
    return "redirect:list";
  }
}






