package com.talat.pms.web;

import java.io.IOException;
import java.sql.Date;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Member;
import com.talat.pms.domain.MemberDriver;
import com.talat.pms.domain.MemberRider;
import com.talat.pms.service.MemberDriverService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
public class MemberAddDriverHandler {

  MemberDriverService memberDriverService;

  public MemberAddDriverHandler(MemberDriverService memberDriverService) {  
    this.memberDriverService = memberDriverService;
  }

  @RequestMapping("/member/addd")
  public String excute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String uploadDir = request.getServletContext().getRealPath("/upload");

    HttpSession session = request.getSession();

    try {

      System.out.println((String)session.getAttribute("mname"));
      System.out.println((String)session.getAttribute("email"));
      System.out.println((String)session.getAttribute("password"));
      System.out.println((String)session.getAttribute("tel"));
      System.out.println((String)session.getAttribute("birth"));
      System.out.println((String)session.getAttribute("mType"));
      System.out.println((String)session.getAttribute("profile"));
      System.out.println((String)session.getAttribute("nicName"));
      System.out.println((String)session.getAttribute("postNo"));
      System.out.println((String)session.getAttribute("basicAddress"));
      System.out.println((String)session.getAttribute("detailAddress"));
      System.out.println((String)session.getAttribute("preferenceGender"));
      System.out.println((String)session.getAttribute("starAverage"));
      System.out.println((String)session.getAttribute("reviewAverage"));
      System.out.println(request.getParameter("licenseNo"));
      System.out.println(request.getParameter("licenseType"));
      System.out.println(request.getParameter("licenseRenewal"));
      System.out.println(request.getParameter("licenseVerfNo"));
      System.out.println(request.getParameter("carNo"));
      System.out.println(request.getParameter("carModel"));
      System.out.println(request.getParameter("carColor"));
      System.out.println(request.getParameter("carYear"));
      System.out.println(request.getParameter("carOwner"));
      System.out.println(request.getParameter("licensePhoto"));
      System.out.println(request.getParameter("insurancePhoto"));
      System.out.println(request.getParameter("carPhoto"));
      System.out.println(request.getParameter("corporationPhoto"));
      System.out.println(request.getParameter("approval"));

      Member m = new Member();
      m.setMname((String)session.getAttribute("mname"));
      m.setEmail((String)session.getAttribute("email"));
      m.setPassword((String) session.getAttribute("password"));
      m.setTel((String)session.getAttribute("tel"));
      m.setBirth(Date.valueOf((String) session.getAttribute("birth")));
      m.setmType(Integer.parseInt((String)session.getAttribute("mType")));

      MemberRider m2 = new MemberRider();
      m2.setNickName((String)session.getAttribute("nicName"));
      m2.setGender(Integer.parseInt((String)session.getAttribute("gender")));
      m2.setPostNo((String)session.getAttribute("postNo"));
      m2.setBasicAddress((String)session.getAttribute("basicAddress"));
      m2.setDetailAddress((String)session.getAttribute("detailAddress"));
      m2.setProfile((String)session.getAttribute("profile"));
      m2.setPreferenceGender(Integer.parseInt((String)session.getAttribute("preferenceGender")));
      m2.setStarAverage(Double.valueOf((String)session.getAttribute("starAverage")));
      m2.setReviewAverage(Integer.parseInt((String)session.getAttribute("reviewAverage")));

      MemberDriver m3 = new MemberDriver();
      m3.setLicenseNo(request.getParameter("licenseNo"));
      m3.setLicenseType(Integer.parseInt(request.getParameter("licenseType")));
      m3.setLicenseRenewal(Date.valueOf(request.getParameter("licenseRenewal")));
      m3.setLicenseVerfNo(Integer.parseInt(request.getParameter("licenseVerfNo")));
      m3.setCarNo(request.getParameter("carNo"));
      m3.setCarModel(request.getParameter("carModel"));
      m3.setCarColor(request.getParameter("carColor"));
      m3.setCarYear(request.getParameter("carYear"));
      m3.setCarOwner(request.getParameter("carOwner"));
      Part photoPart1 = request.getPart("licensePhoto");
      if (photoPart1.getSize() > 0) {
        String filename = UUID.randomUUID().toString();
        photoPart1.write(uploadDir + "/" + filename);
        m3.setLicensePhoto(filename);
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
      Part photoPart2 = request.getPart("insurancePhoto");
      if (photoPart2.getSize() > 0) {
        String filename = UUID.randomUUID().toString();
        photoPart2.write(uploadDir + "/" + filename);
        m3.setInsurancePhoto(filename);
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
      Part photoPart3 = request.getPart("carPhoto");
      if (photoPart3.getSize() > 0) {
        String filename = UUID.randomUUID().toString();
        photoPart3.write(uploadDir + "/" + filename);
        m3.setCarPhoto(filename);
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
      Part photoPart4 = request.getPart("corporationPhoto");
      if (photoPart4.getSize() > 0) {
        String filename = UUID.randomUUID().toString();
        photoPart4.write(uploadDir + "/" + filename);
        m3.setCorporationPhoto(filename);
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
      m3.setApproval(Integer.parseInt(request.getParameter("approval")));

      memberDriverService.add(m, m2, m3);

      return "redirect:list";

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
