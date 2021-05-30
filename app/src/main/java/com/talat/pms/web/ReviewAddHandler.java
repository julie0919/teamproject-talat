package com.talat.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Review;
import com.talat.pms.service.ReviewService;

@Controller
public class ReviewAddHandler {

  ReviewService reviewService;

  public ReviewAddHandler(ReviewService reviewService) {
    this.reviewService = reviewService;
    System.out.println("ReviewAddHandler 객체 생성됨!");
  }

  @RequestMapping("/review/add")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    if (request.getMethod().equals("GET")) {
      return "/jsp/review/reviewData/reviewData_form.jsp";
    }

    Review r = new Review();
    r.setReview(request.getParameter("reivew"));

    reviewService.add(r);

    return "/jsp/review/reviewData/reviewData_sucess.jsp";
    // response.setHeader("Refresh", "1;url=review/list");

  }
}






