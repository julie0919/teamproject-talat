package com.talat.pms.web;

import java.sql.Date;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.talat.pms.domain.Member;
import com.talat.pms.domain.MemberRider;
import com.talat.pms.service.MemberRiderService;
import com.talat.pms.service.MemberService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
public class MemberUpdateHandler_Rider {

  MemberRiderService memberRiderService;
  MemberService memberService;

  public MemberUpdateHandler_Rider(MemberRiderService memberRiderService, MemberService memberService) {
    this.memberRiderService = memberRiderService;
    this.memberService = memberService;
  }

  @RequestMapping("/member/Rupdate")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    String uploadDir = request.getServletContext().getRealPath("/upload");

    int no = Integer.parseInt(request.getParameter("mno"));

    MemberRider oldMember = memberRiderService.get(no);

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

    memberRiderService.update(m, mr);

    return "redirect:list";
  }
}






