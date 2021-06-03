package com.talat.pms.web;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.service.JourneyRiderService;

// 여정 취소
@Controller
public class JourneyRiderDeleteHandler {

  JourneyRiderService journeyRiderService;

  public JourneyRiderDeleteHandler(JourneyRiderService journeyRiderService) {
    this.journeyRiderService = journeyRiderService;
  }

  @RequestMapping("/journey/rider/delete")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    JourneyRider oldJourneyRider = journeyRiderService.getRjno(no);

    //    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    //    if (oldJourneyRider.getRider().getMno() != loginUser.getMno()) {
    //      throw new Exception("삭제 권한이 없습니다!");

    journeyRiderService.delete(no);

    return "redirect:my_journey_list";

  }
}






