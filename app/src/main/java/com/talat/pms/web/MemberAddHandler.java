package com.talat.pms.web;

import java.io.IOException;
import java.sql.Date;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.talat.pms.domain.Member;
import com.talat.pms.service.MemberService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@SuppressWarnings("serial")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/member/add")
public class MemberAddHandler extends HttpServlet {

  private String uploadDir;

  @Override
  public void init() throws ServletException {
    this.uploadDir = this.getServletContext().getRealPath("/upload");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

    HttpSession session = request.getSession();

    try {
      Member m = new Member();
      m.setMname((String)session.getAttribute("mname"));
      m.setEmail((String)session.getAttribute("email"));
      m.setPassword((String) session.getAttribute("password"));
      m.setTel((String)session.getAttribute("tel"));
      m.setBirth(Date.valueOf((String) session.getAttribute("birth")));
      m.setmType(Integer.parseInt((String)session.getAttribute("mType")));      
      memberService.add1(m);

      int idx = m.getMno();

      System.out.println("증가값 리턴 : " + idx);

      Member m2 = new Member();
      m2.setMno(idx);
      m2.setNickName(request.getParameter("nicName"));
      m2.setGender(Integer.parseInt(request.getParameter("gender")));
      m2.setPostNo(request.getParameter("postNo"));
      m2.setBasicAddress(request.getParameter("basicAddress"));
      m2.setDetailAddress(request.getParameter("detailAddress"));

      Part photoPart = request.getPart("profile");
      if (photoPart.getSize() > 0) {
        String filename = UUID.randomUUID().toString();
        photoPart.write(this.uploadDir + "/" + filename);
        m2.setProfile(filename);

        System.out.println(filename);

        Thumbnails.of(this.uploadDir + "/" + filename)
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
      m.setStarAverage(Double.valueOf(request.getParameter("starAverage")));
      m2.setReviewAverage(Integer.parseInt(request.getParameter("reviewAverage")));

      System.out.println((String) session.getAttribute("mname"));
      System.out.println((String) session.getAttribute("email"));
      System.out.println((String) session.getAttribute("password"));
      System.out.println((String) session.getAttribute("tel"));
      System.out.println((String) session.getAttribute("birth"));
      System.out.println((String) session.getAttribute("mType"));
      System.out.println(request.getParameter("nickName"));
      System.out.println(request.getParameter("gender"));
      System.out.println(request.getParameter("postNo"));
      System.out.println(request.getParameter("basicAddress"));
      System.out.println(request.getParameter("detailAddress"));
      System.out.println(request.getParameter("preferenceGender"));
      System.out.println(request.getParameter("starAverage"));
      System.out.println(request.getParameter("reviewAverage"));

      Part file = request.getPart("profile");
      System.out.println(file.getSubmittedFileName());

      memberService.add2(m2);

      response.sendRedirect("list");

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}