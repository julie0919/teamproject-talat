package com.talat.pms.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Review;
import com.talat.pms.service.ReviewService;


@Controller
public class ReviewListHandler {

  ReviewService reviewService;

  public ReviewListHandler(ReviewService reviewService) {
    this.reviewService = reviewService;
    System.out.println("ReviewListHandler 객체 생성됨!");
  }

  @RequestMapping("/review/list")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    List<Review> reviews = null;

    reviews = reviewService.list();
    request.setAttribute("reviews", reviews);
    return "/jsp/review/reviewData/reviewData_list.jsp";
  }
}






