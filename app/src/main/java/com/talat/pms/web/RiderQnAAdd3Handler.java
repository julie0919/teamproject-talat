package com.talat.pms.web;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.talat.pms.domain.QnA;
import com.talat.pms.domain.RiderQnA;
import com.talat.pms.service.RiderQnAService;

@Controller
public class RiderQnAAdd3Handler {

  RiderQnAService riderQnAService;

  public RiderQnAAdd3Handler(RiderQnAService riderQnAService) {
    this.riderQnAService = riderQnAService;
  }

  @RequestMapping("/qna/rider/add3")
  public String add3(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttrs) throws Exception {
    if (request.getMethod().equals("GET")) {
      return "riderQnA/form3";
    }

    HttpSession session = request.getSession();

    RiderQnA rq = new RiderQnA();
    QnA q = new QnA();
    String uploadDir = request.getServletContext().getRealPath("/upload");

    q.setNo(Integer.parseInt(request.getParameter("qtype")));
    if (q.getNo() == 1) {
      q.setTypeTitle("분실물 문의");
    } else if (q.getNo() == 2) {
      q.setTypeTitle("안전문제보고");
    } else if (q.getNo() == 3) {
      q.setTypeTitle("파트너의 의견 제공");
    } else if (q.getNo() == 4) {
      q.setTypeTitle("여정 관련 고객지원");
    }
    rq.setQtype(q);
    rq.setqContent(request.getParameter("qContent"));
    rq.setRjno(Integer.parseInt(String.valueOf(session.getAttribute("myRjno"))));

    Part photoPart = request.getPart("file");
    if (photoPart.getSize() > 0) {
      // 파일을 선택해서 업로드 했다면,
      String filename = UUID.randomUUID().toString();
      photoPart.write(uploadDir + "/" + filename);
      rq.setFile(filename);
    }

    riderQnAService.add(rq);
    redirectAttrs.addFlashAttribute("msg","reqSuccess");

    return "redirect:../../journey/rider/my_journey_list";
  }
}








