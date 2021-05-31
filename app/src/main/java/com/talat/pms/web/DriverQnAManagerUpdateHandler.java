package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.DriverQnA;
import com.talat.pms.service.DriverQnAService;

@Controller
public class DriverQnAManagerUpdateHandler {

  DriverQnAService driverQnAService;

  public DriverQnAManagerUpdateHandler(DriverQnAService driverQnAService) {
    this.driverQnAService = driverQnAService;
  }

  @RequestMapping("/qna/driver/manager/update")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    DriverQnA oldDriverQnA = driverQnAService.get(no);
    if (oldDriverQnA == null) {
      throw new Exception("해당 번호의 드라이버 문의가 없습니다.");
    }

    //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    //      if (1 != loginUser.getMno()) {
    //        throw new Exception("수정 권한이 없습니다!");
    //      }

    DriverQnA dq = new DriverQnA();
    dq.setNo(oldDriverQnA.getNo());
    dq.setQtype(oldDriverQnA.getQtype());
    dq.setWriter(oldDriverQnA.getWriter());
    dq.setPartner(oldDriverQnA.getPartner());
    dq.setRegisteredDate(oldDriverQnA.getRegisteredDate());
    dq.setStatus(1);
    dq.setqContent(oldDriverQnA.getqContent());
    dq.setaContent(request.getParameter("aContent"));
    dq.setFile(oldDriverQnA.getFile());

    driverQnAService.managerUpdate(dq);
    return "redirect:list";
  }
}






