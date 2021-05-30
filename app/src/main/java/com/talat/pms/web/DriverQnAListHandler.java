package com.talat.pms.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.DriverQnA;
import com.talat.pms.service.DriverQnAService;

@Controller
public class DriverQnAListHandler {

  DriverQnAService driverQnAService;

  public DriverQnAListHandler(DriverQnAService driverQnAService) {
    this.driverQnAService = driverQnAService;
  }

  @RequestMapping("/qna/driver/list")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    List<DriverQnA> driverQnas = driverQnAService.list();
    request.setAttribute("list", driverQnas);
    return "/jsp/driverQnA/list.jsp";
  }
}






