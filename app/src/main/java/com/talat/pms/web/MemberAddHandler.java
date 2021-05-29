package com.talat.pms.web;

import java.sql.Date;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Member;
import com.talat.pms.domain.MemberRider;
import com.talat.pms.service.MemberRiderService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
public class MemberAddHandler {

  MemberRiderService memberRiderService;

  public MemberAddHandler(MemberRiderService memberRiderService) {
    this.memberRiderService = memberRiderService;
  }

  @RequestMapping("/member/add")
  public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    String uploadDir = request.getServletContext().getRealPath("/upload");

    HttpSession session = request.getSession();

    Member m = new Member();
    m.setMname((String)session.getAttribute("mname"));
    m.setEmail((String)session.getAttribute("email"));
    m.setPassword((String) session.getAttribute("password"));
    m.setTel((String)session.getAttribute("tel"));
    m.setBirth(Date.valueOf((String) session.getAttribute("birth")));
    m.setmType(Integer.parseInt((String)session.getAttribute("mType")));

    MemberRider m2 = new MemberRider();
    m2.setNickName(request.getParameter("nicName"));
    m2.setGender(Integer.parseInt(request.getParameter("gender")));
    m2.setPostNo(request.getParameter("postNo"));
    m2.setBasicAddress(request.getParameter("basicAddress"));
    m2.setDetailAddress(request.getParameter("detailAddress"));

    Part photoPart = request.getPart("profile");
    if (photoPart.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      photoPart.write(uploadDir + "/" + filename);
      m2.setProfile(filename);

      System.out.println(filename);

      Thumbnails.of(uploadDir + "/" + filename)
      .size(120, 120)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_120x120";
        }
      });
    }

    m2.setPreferenceGender(Integer.parseInt(request.getParameter("preferenceGender")));
    m2.setStarAverage(Double.valueOf(request.getParameter("starAverage")));
    m2.setReviewAverage(Integer.parseInt(request.getParameter("reviewAverage")));

    System.out.println((String)session.getAttribute("mname"));
    System.out.println((String)session.getAttribute("email"));
    System.out.println((String) session.getAttribute("password"));
    System.out.println((String)session.getAttribute("tel"));
    System.out.println((String) session.getAttribute("birth"));
    System.out.println((String)session.getAttribute("mType"));
    System.out.println(request.getParameter("profile"));
    System.out.println(request.getParameter("nicName"));
    System.out.println(request.getParameter("postNo"));
    System.out.println(request.getParameter("basicAddress"));
    System.out.println(request.getParameter("detailAddress"));
    System.out.println(request.getParameter("preferenceGender"));
    System.out.println(request.getParameter("starAverage"));
    System.out.println(request.getParameter("reviewAverage"));

    memberRiderService.add(m, m2);

    return "redirect:list";
  }
}