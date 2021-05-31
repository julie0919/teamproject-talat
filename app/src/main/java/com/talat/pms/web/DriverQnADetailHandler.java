package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.DriverQnA;
import com.talat.pms.service.DriverQnAService;

@Controller
public class DriverQnADetailHandler {

  DriverQnAService driverQnAService;

  public DriverQnADetailHandler(DriverQnAService driverQnAService) {
    this.driverQnAService = driverQnAService;
  }

  @RequestMapping("/qna/driver/detail")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    DriverQnA driverQnA = driverQnAService.get(no);
    if (driverQnA == null) {
      throw new Exception("해당 번호의 드라이버 문의가 없습니다.");
    }

    request.setAttribute("driverQnA", driverQnA);
    return "driverQnA/detail";
  }
}






