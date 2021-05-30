package com.talat.pms.domain;

import java.sql.Date;
import java.util.List;

public class ReviewRider {
  private int rjno; // 라이더 여정신청 번호
  private List<Review> reviews;
  private Member rwriter;
  private Member dpartner;
  private int dstar;
  private Date rRevRegisteredDate;
  private int rRevStat;

  // 리뷰 목록에서 리뷰메세지를 추출하여 문자열로 리턴한다.
  public String getReviewMessages() {
    if (reviews == null || reviews.size() == 0) {
      return null;
    }

    StringBuilder strBuilder = new StringBuilder();
    for (Review r : reviews) {
      if (strBuilder.length() > 0) {
        strBuilder.append(",");
      }
      strBuilder.append("[" + r.getReview() + "]");
    }
    return strBuilder.toString();
  }

  @Override
  public String toString() {
    return "ReviewRider [rjno=" + rjno + ", reviews=" + reviews + ", rwriter=" + rwriter
        + ", dpartner=" + dpartner + ", dstar=" + dstar + ", rRevRegisteredDate="
        + rRevRegisteredDate + ", rRevStat=" + rRevStat + "]";
  }

  public int getRjno() {
    return rjno;
  }

  public void setRjno(int rjno) {
    this.rjno = rjno;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }

  public Member getRwriter() {
    return rwriter;
  }

  public void setRwriter(Member rwriter) {
    this.rwriter = rwriter;
  }

  public Member getDpartner() {
    return dpartner;
  }

  public void setDpartner(Member dpartner) {
    this.dpartner = dpartner;
  }

  public int getDstar() {
    return dstar;
  }

  public void setDstar(int dstar) {
    this.dstar = dstar;
  }

  public Date getrRevRegisteredDate() {
    return rRevRegisteredDate;
  }

  public void setrRevRegisteredDate(Date rRevRegisteredDate) {
    this.rRevRegisteredDate = rRevRegisteredDate;
  }

  public int getrRevStat() {
    return rRevStat;
  }

  public void setrRevStat(int rRevStat) {
    this.rRevStat = rRevStat;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((dpartner == null) ? 0 : dpartner.hashCode());
    result = prime * result + dstar;
    result = prime * result + ((rRevRegisteredDate == null) ? 0 : rRevRegisteredDate.hashCode());
    result = prime * result + rRevStat;
    result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
    result = prime * result + rjno;
    result = prime * result + ((rwriter == null) ? 0 : rwriter.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ReviewRider other = (ReviewRider) obj;
    if (dpartner == null) {
      if (other.dpartner != null)
        return false;
    } else if (!dpartner.equals(other.dpartner))
      return false;
    if (dstar != other.dstar)
      return false;
    if (rRevRegisteredDate == null) {
      if (other.rRevRegisteredDate != null)
        return false;
    } else if (!rRevRegisteredDate.equals(other.rRevRegisteredDate))
      return false;
    if (rRevStat != other.rRevStat)
      return false;
    if (reviews == null) {
      if (other.reviews != null)
        return false;
    } else if (!reviews.equals(other.reviews))
      return false;
    if (rjno != other.rjno)
      return false;
    if (rwriter == null) {
      if (other.rwriter != null)
        return false;
    } else if (!rwriter.equals(other.rwriter))
      return false;
    return true;
  }


}
