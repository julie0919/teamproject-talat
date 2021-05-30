package com.talat.pms.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.Route;
import com.talat.pms.service.RouteService;


@SuppressWarnings("serial")
@WebServlet("/route/list")
public class RouteListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RouteService routeService = (RouteService) request.getServletContext().getAttribute("routeService");

    try {
      List<Route> routes = routeService.list();

      request.setAttribute("list", routes);

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/journey/list.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






