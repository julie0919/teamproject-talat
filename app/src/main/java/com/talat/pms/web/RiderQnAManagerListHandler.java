package com.talat.pms.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.RiderQnA;
import com.talat.pms.service.RiderQnAService;

@Controller
public class RiderQnAManagerListHandler {

  RiderQnAService riderQnAService;

  public RiderQnAManagerListHandler(RiderQnAService riderQnAService) {
    this.riderQnAService = riderQnAService;
  }

  @RequestMapping("/qna/rider/manager/list")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    List<RiderQnA> riderQnas = riderQnAService.list();
    request.setAttribute("list", riderQnas);
    return "riderQnA/manager_list";
  }
}






