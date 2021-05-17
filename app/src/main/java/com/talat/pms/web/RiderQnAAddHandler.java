package com.talat.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.Journey;
import com.talat.pms.domain.Member;
import com.talat.pms.domain.QnA;
import com.talat.pms.domain.RiderQnA;
import com.talat.pms.service.JourneyService;
import com.talat.pms.service.RiderQnAService;

@SuppressWarnings("serial")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/qna/rider/add")
public class RiderQnAAddHandler extends HttpServlet {

  //private String uploadDir;

  //  @Override
  //  public void init() throws ServletException {
  //    this.uploadDir = this.getServletContext().getRealPath("/upload");
  //  }

  SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
  SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyService journeyService = (JourneyService) request.getServletContext().getAttribute("journeyService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>새 라이더 문의</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>새 라이더 문의</h1>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Journey j = journeyService.get(no);
      if (j == null) {
        out.println("<p>해당 번호의 여정이 없습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      out.println("<form>");
      out.println("<table border='1'>");
      out.println("<tbody>");
      out.printf("<tr><th>번호</th>"
          + " <td><input type='text' name='jno' value='%d' readonly></td></tr>\n", j.getJno());
      out.printf("<tr><th>출발지</th>"
          + " <td><input name='departure' type='text' value='%s'></td></tr>\n", j.getDeparture());

      out.printf("<tr><th>도착지</th>"
          + " <td><input name='arrival' type='text' value='%s'></td></tr>\n", j.getArrival());
      out.printf("<tr><th>여정날짜</th> <td>%s</td></tr>\n", formatterDate.format(j.getJourneyDate()));
      out.printf("<tr><th>도착시간</th> <td>%s</td></tr>\n", formatterTime.format(j.getJourneyTime()));
      out.printf("<tr><th>보조석 인원</th> <td>%d명</td></tr>\n", j.getSeatPassenger());
      out.printf("<tr><th>뒷자석 인원</th> <td>%d명</td></tr>\n", j.getSeatRear());

      if (j.getPet() == 0) {
        out.println("<tr><th>반려동물 탑승</th>"
            + " <td>아니오</td></tr>");
      } else {
        out.println("<tr><th>반려동물 탑승</th>"
            + " <td>예</td></tr>");
      }
      out.printf("<tr><th>여정 설명</th>"
          + " <td><textarea name='content' rows='10' cols='60'>%s</textarea></td></tr>\n", j.getContent());

      out.println("</tbody>");

      out.println("</table>");
    } catch (Exception e) {
      throw new ServletException(e);    
    }

    out.println("<form action='add' method='post'>");

    out.println("<hr>");
    out.println("<select name='qtype'>");
    out.println("  <option value='0' selected disabled>-- 문의유형 --</option>");
    out.println("  <option value='1'>분실물 문의</option>");
    out.println("  <option value='2'>안전문제보고</option>");
    out.println("  <option value='3'>파트너의 의견 제공</option>");
    out.println("  <option value='4'>여정 관련 고객지원</option>");
    out.println("</select>");
    out.println("첨부파일: <br>");


    out.println("<hr>");
    out.println("문의내용: <textarea name='qContent' rows='10' cols='60'></textarea><br>");
    out.println("<p><input type='submit' value='등록'>");
    out.println("<a href='list'>목록</a></p>");

    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RiderQnAService riderQnAService = (RiderQnAService) request.getServletContext().getAttribute("riderQnAService");

    try {
      RiderQnA rq = new RiderQnA();
      QnA q = new QnA();

      q.setNo(Integer.parseInt(request.getParameter("qtype")));
      rq.setQtype(q);

      rq.setqContent(request.getParameter("qContent"));

      //      Part photoPart = request.getPart("file");
      //      if (photoPart.getSize() > 0) {
      //        // 파일을 선택해서 업로드 했다면,
      //        String filename = UUID.randomUUID().toString();
      //        photoPart.write(this.uploadDir + "/" + filename);
      //        rq.setPhoto(filename);
      //
      //        // 썸네일 이미지 생성
      //        Thumbnails.of(this.uploadDir + "/" + filename)
      //        .size(30, 30)
      //        .outputFormat("jpg")
      //        .crop(Positions.CENTER)
      //        .toFiles(new Rename() {
      //          @Override
      //          public String apply(String name, ThumbnailParameter param) {
      //            return name + "_30x30";
      //          }

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      rq.setWriter(loginUser);

      riderQnAService.add(rq);

      response.sendRedirect("list");

    } catch (Exception e) {
      throw new ServletException(e); 
    }
  }
}








