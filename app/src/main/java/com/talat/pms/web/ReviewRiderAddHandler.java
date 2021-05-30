package com.talat.pms.web;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Member;
import com.talat.pms.domain.Review;
import com.talat.pms.domain.ReviewRider;
import com.talat.pms.service.ReviewRiderService;
import com.talat.pms.service.ReviewService;

@Controller
public class ReviewRiderAddHandler {

  ReviewRiderService reviewRiderService;
  ReviewService reviewService;

  public ReviewRiderAddHandler(ReviewRiderService reviewRiderService, ReviewService reviewService) {
    this.reviewRiderService = reviewRiderService;
    this.reviewService = reviewService;
    System.out.println("ReviewRiderAddHandler 객체 생성됨!");
  }

  @RequestMapping("/review/rider/add")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    if (request.getMethod().equals("GET")) {
      List<Review> reviews = reviewService.list();
      request.setAttribute("reviews", reviews);

      return "/jsp/review/review_form.jsp";
    }

    ReviewRider rr = new ReviewRider();

    rr.setDstar(Integer.parseInt(request.getParameter("star")));

    // 리뷰메세지 정보는 파라미터에 있다.
    String[] values = request.getParameterValues("review");
    ArrayList<Review> reviewList = new ArrayList<>();
    if (values != null) {
      for (String value : values) {
        Review review = new Review();
        review.setRevNo(Integer.parseInt(value));
        reviewList.add(review);
      }
    }
    rr.setReviews(reviewList);
    rr.setrRevStat(1);

    // 작성자는 로그인 사용자이다.
    HttpServletRequest httpRequest = request;
    Member loginUser = (Member) httpRequest.getSession().getAttribute("loginUser");
    rr.setRwriter(loginUser);

    reviewRiderService.add(rr);

    return "/jsp/review/review_success.jsp";
    // response.sendRedirect("list");
  }
}
