package com.talat.pms.web;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
public class MemberAddDriverHandler1 {

  @RequestMapping("/member/addd1")
  public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    String uploadDir = request.getServletContext().getRealPath("/upload");

    HttpSession session = request.getSession();

    session.setAttribute("nicName", request.getParameter("nicName"));
    session.setAttribute("gender", request.getParameter("gender"));
    session.setAttribute("postNo", request.getParameter("postNo"));
    Part photoPart = request.getPart("profile");
    if (photoPart.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      photoPart.write(uploadDir + "/" + filename);
      session.setAttribute("profile", filename);

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
    session.setAttribute("basicAddress", request.getParameter("basicAddress"));
    session.setAttribute("detailAddress", request.getParameter("detailAddress"));
    session.setAttribute("preferenceGender", request.getParameter("preferenceGender"));
    session.setAttribute("starAverage", request.getParameter("starAverage"));
    session.setAttribute("reviewAverage", request.getParameter("reviewAverage"));

    return "member/form3";
  }
}