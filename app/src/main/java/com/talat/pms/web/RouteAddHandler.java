//package com.talat.pms.web;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import com.talat.pms.domain.Route;
//import com.talat.pms.service.RouteService;
//
//@SuppressWarnings("serial")
//@WebServlet("/route/add")
//public class RouteAddHandler extends HttpServlet {
//
//  @Override
//  protected void doGet(HttpServletRequest request, HttpServletResponse response)
//      throws ServletException, IOException {
//
//    response.setContentType("text/html;charset=UTF-8");
//    request.getRequestDispatcher("/jsp/journey/form1.jsp").include(request, response);
//  }
//
//  class CarRoute {
//    int seqNo;
//    //    BigDecimal latitude;
//    //    BigDecimal longitude;
//    String location;
//    public CarRoute(int seqNo, String location/*, BigDecimal latitude, BigDecimal longitude*/) {
//      this.seqNo = seqNo;
//      this.location = location;
//      //      this.latitude = latitude;
//      //      this.longitude = longitude;
//    }
//    public int getSeqNo() {
//      return seqNo;
//    }
//    public void setSeqNo(int seqNo) {
//      this.seqNo = seqNo;
//    }
//    public String getLocation() {
//      return location;
//    }
//    public void setLocation(String location) {
//      this.location = location;
//    }
//  }
//
//  @Override
//  protected void doPost(HttpServletRequest request, HttpServletResponse response)
//      throws ServletException, IOException {
//
//    HttpSession session = request.getSession();
//
//    RouteService routeService = (RouteService) request.getServletContext().getAttribute("routeService");
//
//    // 클라이언트가 POST 요청으로 보낸 데이터가 UTF-8임을 알려준다.
//    request.setCharacterEncoding("UTF-8");
//
//    try {
//      Route r = new Route();
//
//      // Map<Integer,String> routeInfo = new HashMap<>();
//
//
//      int routeSeqNo = 1;
//      //      routeInfo.put(routeSeqNo, request.getParameter("departure"));
//      //      r.setSpotOrder(routeSeqNo)
//      //      r.setSpotName(routeInfo.get(routeSeqNo));
//      // routeSeqNo++;
//      //      routeInfo.put(100, request.getParameter("arrival"));
//      //      r.setSpotOrder(100)
//      //      r.setSpotName(routeInfo.get(100));
//
//      r.setSpotOrder(new CarRoute(routeSeqNo, request.getParameter("departure")).getSeqNo());
//      r.setSpotName(new CarRoute(routeSeqNo, request.getParameter("departure")).getLocation());
//
//      int no = 1;
//      while (true) {
//        routeSeqNo++;
//        String route = request.getParameter("route" + no);
//        if (route == null) {
//          break;
//        }
//
//        //      routeInfo.put(routeSeqNo, request.getParameter("route"+ no++));
//        //      r.setSpotOrder(routeSeqNo)
//        //      r.setSpotName(routeInfo.get(routeSeqNo));
//        // routeSeqNo++;
//
//        r.setSpotOrder(new CarRoute(routeSeqNo, request.getParameter("route"+ no++)).getSeqNo());
//        r.setSpotName(new CarRoute(routeSeqNo, request.getParameter("route"+ no++)).getLocation());
//      }
//
//      routeSeqNo++;
//
//      r.setSpotOrder(new CarRoute(routeSeqNo, request.getParameter("arrival")).getSeqNo());
//      r.setSpotName(new CarRoute(routeSeqNo, request.getParameter("arrival")).getLocation());
//
//      session.setAttribute("departure", request.getParameter("departure"));
//      session.setAttribute("route1", request.getParameter("route1"));
//      session.setAttribute("route2", request.getParameter("route2"));
//      session.setAttribute("arrival", request.getParameter("arrival"));
//
//      response.setContentType("text/html;charset=UTF-8");
//      request.getRequestDispatcher("/jsp/journey/form2.jsp").include(request, response);
//
//      routeService.add(r);
//      response.sendRedirect("list");
//
//    } catch (Exception e) {
//      request.setAttribute("exception", e);
//      request.getRequestDispatcher("/error").forward(request, response);
//      return;
//    }
//  }
//}  
//
////r.setSpotName(request.getParameter("departure"));
////      r.setSpotName(request.getParameter("route1"));
////      r.setSpotName(request.getParameter("route2"));
////      r.setSpotName(request.getParameter("arrival"));
////
////      routeService.add(r);
////
////      response.sendRedirect("list");
////    } catch (Exception e) {
////      throw new ServletException(e);
////    }
//
////
////r.setLatitude(BigDecimal.valueOf(
////Double.parseDouble(request.getParameter("latitude"))));
////r.setLongitude(BigDecimal.valueOf(
////Double.parseDouble(request.getParameter("longitude"))));
////r.setSpotName(request.getParameter("spotName"));
////
//////
////    // 작성자는 로그인 사용자이다.
////    HttpServletRequest httpRequest = request;
////    MemberDriver loginUser = (MemberDriver) httpRequest.getSession().getAttribute("loginUser");
////    j.setDriver(loginUser);
//
//
//
//
//
//
