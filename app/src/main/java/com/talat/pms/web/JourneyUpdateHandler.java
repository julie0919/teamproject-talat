package com.talat.pms.web;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Journey;
import com.talat.pms.domain.Route;
import com.talat.pms.service.JourneyService;

@Controller
public class JourneyUpdateHandler {

  JourneyService journeyService;

  public JourneyUpdateHandler(JourneyService journeyService) {
    this.journeyService = journeyService;
  }

  class CarRoute {
    int seqNo;
    BigDecimal latitude;
    BigDecimal longitude;
    String location;
    public CarRoute(int seqNo, String location, BigDecimal latitude, BigDecimal longitude) {
      this.seqNo = seqNo;
      this.location = location;
      this.latitude = latitude;
      this.longitude = longitude;
    }
  } 

  @SuppressWarnings("unchecked")
  @RequestMapping("/journey/update")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession();

    int no = Integer.parseInt(request.getParameter("jno"));

    Journey oldJourney = journeyService.get(no);
    if (oldJourney== null) {
      throw new Exception("해당 번호의 여정이 없습니다.");
    } 

    Journey j = new Journey();
    Route r = new Route();
    Route departure = new Route();
    Route arrival = new Route();

    j.setJno(oldJourney.getJno());

    int routeSeqNo = 1;
    ArrayList<CarRoute> routes = new ArrayList<>();
    routes.add(new CarRoute(routeSeqNo++, request.getParameter("departure"), 
        new BigDecimal(request.getParameter("lt")), 
        new BigDecimal(request.getParameter("lg"))));

    int routeOrder = 1;
    while (true) {
      String route = request.getParameter("route" + routeOrder);
      if (route == null) {
        break;
      }

      routes.add(
          new CarRoute(routeSeqNo++, route, 
              new BigDecimal(request.getParameter("lt")), 
              new BigDecimal(request.getParameter("lg"))));
      request.setAttribute("route"+ routeOrder++, route);
    }

    routes.add(
        new CarRoute(100, request.getParameter("arrival"), 
            new BigDecimal(request.getParameter("lt")), 
            new BigDecimal(request.getParameter("lg"))));

    session.setAttribute("routes", routes);

    j.setRoutes((List<Route>) session.getAttribute("routes"));

    j.setJourneyDate(Date.valueOf(request.getParameter("journeyDate")));
    j.setJourneyTime(Time.valueOf(request.getParameter("journeyTime")+":00"));
    j.setSeatPassenger(Integer.parseInt(request.getParameter("seatPassenger")));
    j.setSeatRear(Integer.parseInt(request.getParameter("seatRear")));
    j.setPet(Integer.parseInt(request.getParameter("pet")));
    j.setFee(Integer.parseInt(request.getParameter("fee")));
    j.setContent(request.getParameter("content"));

    journeyService.update(j, (List<Route>) session.getAttribute("routes"));

    return "redirect:list";
  }
}






