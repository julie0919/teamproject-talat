package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.RiderQnA;
import com.talat.pms.service.RiderQnAService;

@Controller
public class RiderQnAManagerUpdateHandler {

  RiderQnAService riderQnAService;

  public RiderQnAManagerUpdateHandler(RiderQnAService riderQnAService) {
    this.riderQnAService = riderQnAService;
  }

  @RequestMapping("/qna/rider/manager/update")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    RiderQnA oldRiderQnA = riderQnAService.get(no);
    if (oldRiderQnA == null) {
      throw new Exception("해당 번호의 라이더 문의가 없습니다.");
    }

    RiderQnA rq = new RiderQnA();
    rq.setNo(oldRiderQnA.getNo());
    rq.setQtype(oldRiderQnA.getQtype());
    rq.setWriter(oldRiderQnA.getWriter());
    rq.setPartner(oldRiderQnA.getPartner());
    rq.setRegisteredDate(oldRiderQnA.getRegisteredDate());
    rq.setStatus(1);
    rq.setqContent(oldRiderQnA.getqContent());
    rq.setaContent(request.getParameter("aContent"));
    rq.setFile(oldRiderQnA.getFile());

    riderQnAService.managerUpdate(rq);
    return "redirect:list";
  }
}






