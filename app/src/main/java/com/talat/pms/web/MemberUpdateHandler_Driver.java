package com.talat.pms.web;

import java.sql.Date;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class MemberUpdateHandler_Driver {

  MemberDriverService memberDriverService;

  public MemberUpdateHandler_Driver(MemberDriverService memberDriverService) {
    this.memberDriverService = memberDriverService;
  }

  @RequestMapping("/member/Dupdate")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    String uploadDir = request.getServletContext().getRealPath("/upload");

    int no = Integer.parseInt(request.getParameter("mno"));

    MemberDriver oldMember = memberDriverService.get(no);

    Member m = new Member();
    m.setMno(oldMember.getMno());
    m.setMname(request.getParameter("mname"));
    m.setEmail(request.getParameter("email"));
    m.setTel(request.getParameter("tel"));
    m.setBirth(Date.valueOf(request.getParameter("birth")));

    MemberRider mr = new MemberRider();
    mr.setRmno(oldMember.getMno());
    mr.setNickName(request.getParameter("nickName"));
    mr.setPostNo(request.getParameter("postNo"));
    mr.setBasicAddress(request.getParameter("basicAddress"));
    mr.setDetailAddress(request.getParameter("detailAddress"));

    Part photoPart = request.getPart("profile");
    if (photoPart.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      photoPart.write(uploadDir + "/" + filename);
      mr.setProfile(filename);
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
    mr.setPreferenceGender(Integer.parseInt(request.getParameter("preferenceGender")));

    MemberDriver md = new MemberDriver();
    md.setLicenseNo(request.getParameter("licenseNo"));
    md.setLicenseType(Integer.parseInt(request.getParameter("licenseType")));
    md.setLicenseRenewal(Date.valueOf(request.getParameter("licenseRenewal")));
    md.setLicenseVerfNo(Integer.parseInt(request.getParameter("licenseVerfNo")));
    md.setCarNo(request.getParameter("carNo"));
    md.setCarModel(request.getParameter("carModel"));
    md.setCarColor(request.getParameter("carColor"));
    md.setCarYear(request.getParameter("carYear"));
    md.setCarOwner(request.getParameter("carOwner"));

    Part photoPart1 = request.getPart("licensePhoto");
    if (photoPart1.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      photoPart1.write(uploadDir + "/" + filename);
      md.setLicensePhoto(filename);
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
      md.setInsurancePhoto(filename);
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
    Part photoPart3 = request.getPart("insurancePhoto");
    if (photoPart3.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      photoPart3.write(uploadDir + "/" + filename);
      md.setCarPhoto(filename);
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
      md.setCorporationPhoto(filename);
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

    memberDriverService.update(md, mr, m);

    return "redirect:list";
  }
}






