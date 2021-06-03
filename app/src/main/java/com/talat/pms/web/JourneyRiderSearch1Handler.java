package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 여정 검색 1
@Controller
public class JourneyRiderSearch1Handler {

  @RequestMapping("/journey/rider/search1")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    return "journeyRider/search1";
  }
}
