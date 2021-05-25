package com.talat.pms.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.Member;
import com.talat.pms.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    request.getRequestDispatcher("/jsp/loginUser/login_form.jsp").include(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

    String email = request.getParameter("email");
    String password = request.getParameter("password");

    if (request.getParameter("saveEmail") != null) {
      Cookie cookie = new Cookie("email", email);
      cookie.setMaxAge(60); // 유효기간을 설정하지 않으면 웹브라우저가 실행되는 동안만 유지하라는 의미가 된다.
      response.addCookie(cookie);
    } else {
      Cookie cookie = new Cookie("email", "");
      cookie.setMaxAge(0);  // 유효기간(초)을 0으로 하면 웹브라우저는 email 이름으로 저장된 쿠키를 제거한다.
      response.addCookie(cookie);
    }

    try {
      Member member = memberService.get(email, password);
      response.setContentType("text/html;charset=UTF-8");

      if (member == null) {
        request.getSession().invalidate(); 
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/jsp/loginUser/login_fail.jsp").include(request, response);
        response.setHeader("Refresh", "1;url=login");

      } else {
        request.getSession().setAttribute("loginUser", member);
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/jsp/loginUser/login_success.jsp").include(request, response);
        response.setHeader("Refresh", "1;url=userInfo");
      }

    } catch (Exception e) {
      throw new ServletException(e);
    } 
  }
}






