package com.talat.pms.web;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.talat.pms.domain.DriverQnA;
import com.talat.pms.domain.QnA;
import com.talat.pms.service.DriverQnAService;

@Controller
public class DriverQnAAdd3Handler {

  DriverQnAService driverQnAService;

  public DriverQnAAdd3Handler(DriverQnAService driverQnAService) {
    this.driverQnAService = driverQnAService;
  }

  @RequestMapping("/qna/driver/add3")
  public String execute(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttrs) throws Exception {
    if (request.getMethod().equals("GET")) {
      return "driverQnA/form3";
    }

    HttpSession session = request.getSession();

    DriverQnA dq = new DriverQnA();
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
    dq.setQtype(q);
    dq.setqContent(request.getParameter("qContent"));
    dq.setJno(Integer.parseInt(String.valueOf(session.getAttribute("myJno"))));

    Part photoPart = request.getPart("file");
    if (photoPart.getSize() > 0) {
      // 파일을 선택해서 업로드 했다면,
      String filename = UUID.randomUUID().toString();
      photoPart.write(uploadDir + "/" + filename);
      dq.setFile(filename);
    }

    driverQnAService.add(dq);
    redirectAttrs.addFlashAttribute("msg","reqSuccess");

    return "redirect:../../journey/list";
  }
}








