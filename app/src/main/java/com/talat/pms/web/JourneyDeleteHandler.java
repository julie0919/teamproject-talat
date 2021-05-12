//package com.talat.pms.web;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.StringWriter;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import com.talat.pms.domain.Journey;
//
//@SuppressWarnings("serial")
//@WebServlet("/journey/delete")
//public class JourneyDeleteHandler extends HttpServlet {
//
//  @Override
//  protected void doGet(HttpServletRequest request, HttpServletResponse response)
//      throws ServletException, IOException {
//
//    JourneyService journeyService = (JourneyService) request.getServletContext().getAttribute("journeyService");
//
//    response.setContentType("text/html;charset=UTF-8");
//    PrintWriter out = response.getWriter();
//
//    out.println("<!DOCTYPE html>");
//    out.println("<html>");
//    out.println("<head>");
//    out.println("<title>여정 삭제</title>");
//
//    try {
//      int no = Integer.parseInt(request.getParameter("jno"));
//
//      Journey oldJourney = journeyService.get(no);
//      if (oldJourney == null) {
//        throw new Exception("해당 번호의 여정이 없습니다.");
//      }
//      //
//      //      MemberDriver loginUser = (MemberDriver) request.getSession().getAttribute("loginUser");
//      //      if (oldJourney.getDriver().getNo() != loginUser.getNo()) {
//      //        throw new Exception("삭제 권한이 없습니다!");
//      //      }
//      //
//      journeyService.delete(no);
//
//      out.println("<meta http-equiv='Refresh' content='1;url=list'>");
//      out.println("</head>");
//      out.println("<body>");
//      out.println("<h1>여정 삭제</h1>");
//      out.println("<p>여정을 삭제하였습니다.</p>");
//
//    } catch (Exception e) {
//      StringWriter strWriter = new StringWriter();
//      PrintWriter printWriter = new PrintWriter(strWriter);
//      e.printStackTrace(printWriter);
//
//      out.println("</head>");
//      out.println("<body>");
//      out.println("<h1>여정 삭제 오류</h1>");
//      out.printf("<p>%s</p>\n", e.getMessage());
//      out.printf("<pre>%s</pre>\n", strWriter.toString());
//      out.println("<p><a href='list'>목록</a></p>");
//    }
//
//    out.println("</body>");
//    out.println("</html>");
//  }
//}
//
//
//
//
//
//
