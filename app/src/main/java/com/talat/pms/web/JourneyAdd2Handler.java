package com.talat.pms.web;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JourneyAdd2Handler {

  class CarRoute {
    int seqNo;
    double latitude;
    double longitude;
    String location;
    public CarRoute(int seqNo, String location, double latitude, double longitude) {
      this.seqNo = seqNo;
      this.location = location;
      this.latitude = latitude;
      this.longitude = longitude;
    }
  }

  @RequestMapping("/journey/add2")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession();
    int maxNo = Integer.parseInt(request.getParameter("indx"));
    int startNo = 1;
    int routeSeqNo = 1;
    ArrayList<CarRoute> routes = new ArrayList<>();
    routes.add(new CarRoute(routeSeqNo++, request.getParameter("bname"+ startNo),37.621930705941516,127.07873319407591
        /*, 
        new BigDecimal(request.getParameter("lt1")), 
        new BigDecimal(request.getParameter("lg1")))*/));

    for (int i = 2; i < maxNo; i++) {
      routes.add(new CarRoute(routeSeqNo++, request.getParameter("bname" + i),37.621930705941516,127.07873319407591
          /*, 
          new BigDecimal(request.getParameter("lt" + i)), 
          new BigDecimal(request.getParameter("lg" + i))*/));
      //request.setAttribute("bname" + i, request.getParameter("bname" + i));
      System.out.println(request.getParameter("bname" + i));
    }

    routes.add(new CarRoute(100, request.getParameter("bname" + maxNo),37.621930705941516,127.07873319407591
        /*, 
        new BigDecimal(request.getParameter("lt" + Integer.parseInt(request.getParameter("indx")))), 
        new BigDecimal(request.getParameter("lg" + Integer.parseInt(request.getParameter("indx"))))*/));
    System.out.println(request.getParameter("bname" + maxNo));
    //    int no = 1;
    //    while (true) {
    //      String route = request.getParameter("route" + no);
    //      if (route == null) {
    //        break;
    //      }
    //
    //      routes.add(new CarRoute(routeSeqNo++, route, 
    //          new BigDecimal(request.getParameter("lt")), 
    //          new BigDecimal(request.getParameter("lg"))));
    //      request.setAttribute("route"+ no++, route);
    //    }
    //
    //    routes.add(new CarRoute(100, request.getParameter("arrival"), 
    //        new BigDecimal(request.getParameter("lt")), 
    //        new BigDecimal(request.getParameter("lg"))));
    //
    session.setAttribute("routes", routes);

    request.setAttribute("departure", request.getParameter("bname1"));
    request.setAttribute("arrival", request.getParameter("bname" + maxNo));
    session.setAttribute("journeyDate", request.getParameter("journeyDate"));
    session.setAttribute("journeyTime", request.getParameter("journeyTime"));

    return "/jsp/journey/form2.jsp";
  }

}






