package com.talat.pms.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.service.JourneyRiderService;
import com.talat.pms.service.JourneyService;

// 나의 여정 내역
@Controller
public class JourneyRiderMyJourneyListHandler {

  JourneyRiderService journeyRiderService;
  JourneyService journeyService;

  public JourneyRiderMyJourneyListHandler(JourneyRiderService journeyRiderService, JourneyService journeyService) {
    this.journeyRiderService = journeyRiderService;
    this.journeyService = journeyService;
  }

  @RequestMapping("/journey/rider/my_journey_list")
  public String execuet(HttpServletRequest request, HttpServletResponse response) throws Exception {

    List<JourneyRider> journeyRiders = journeyRiderService.list();

    request.setAttribute("journeyRiders", journeyRiders);
    request.setAttribute("journey", journeyService.list());


    return "/jsp/journeyRider/my_journey_list.jsp";

  } 
}






