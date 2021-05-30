package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.DriverQnA;
import com.talat.pms.service.DriverQnAService;

@Controller
public class DriverQnADeleteHandler {

  DriverQnAService driverQnAService;

  public DriverQnADeleteHandler(DriverQnAService driverQnAService) {
    this.driverQnAService = driverQnAService;
  }

  @RequestMapping("/qna/driver/delete")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    DriverQnA oldDriverQnA = driverQnAService.get(no);
    if (oldDriverQnA == null) {
      throw new Exception("해당 번호의 라이더 문의가 없습니다.");
    }

    //    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    //    if (oldBoard.getWriter().getNo() != loginUser.getNo()) {
    //      throw new Exception("삭제 권한이 없습니다!");
    //    }

    driverQnAService.delete(no);
    return "redirect:list";
  }
}






