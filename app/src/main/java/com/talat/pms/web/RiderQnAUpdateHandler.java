package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.QnA;
import com.talat.pms.domain.RiderQnA;
import com.talat.pms.service.RiderQnAService;

@Controller
public class RiderQnAUpdateHandler {

  RiderQnAService riderQnAService;

  public RiderQnAUpdateHandler(RiderQnAService riderQnAService) {
    this.riderQnAService = riderQnAService;
  }

  @RequestMapping("/qna/rider/update")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    RiderQnA oldRiderQnA = riderQnAService.get(no);
    if (oldRiderQnA == null) {
      throw new Exception("해당 번호의 라이더 문의가 없습니다.");
    }

    //    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    //    if (oldRiderQnA.getWriter().getMno() != loginUser.getMno()) {
    //      throw new Exception("수정 권한이 없습니다!");
    //    }

    RiderQnA rq = new RiderQnA();
    rq.setNo(oldRiderQnA.getNo());

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
    rq.setQtype(q);
    rq.setqContent(request.getParameter("qContent"));
    rq.setFile(request.getParameter("file"));

    riderQnAService.update(rq);
    return "redirect:list";
  }
}






