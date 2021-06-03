package com.talat.pms.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.service.JourneyRiderService;

// 여정 검색 2
@Controller
public class JourneyRiderSearch2Handler {

  JourneyRiderService journeyRiderService;

  public JourneyRiderSearch2Handler(JourneyRiderService journeyRiderService) {
    this.journeyRiderService = journeyRiderService;
  }

  @RequestMapping("/journey/rider/search2")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    HttpSession session = request.getSession();
    String keyword1 = request.getParameter("keyword1");
    String keyword2 = request.getParameter("keyword2");
    String keyword3 = request.getParameter("keyword3");
    String keyword4 = request.getParameter("keyword4");

    session.setAttribute("keyword1", keyword1);
    session.setAttribute("keyword2", keyword2);
    session.setAttribute("keyword3", keyword3);
    session.setAttribute("keyword4", keyword4);

    List<JourneyRider> journeyRiders = journeyRiderService.search(keyword1, keyword2, keyword3, keyword4);
    request.setAttribute("journeyRiders", journeyRiders);
    request.setAttribute("list", journeyRiderService.list());

    return "journeyRider/search2";

  }
}
