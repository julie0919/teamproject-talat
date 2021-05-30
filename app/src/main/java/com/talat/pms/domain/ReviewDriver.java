package com.talat.pms.domain;

import java.sql.Date;
import java.util.List;

public class ReviewDriver {
  private int rjno; // 라이더 여정신청 번호
  private List<Review> reviews;
  private Member dwriter;
  private Member rpartner;
  private int rstar;
  private Date dRevRegisteredDate;
  private int dRevStat;

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
    return "ReviewDriver [rjno=" + rjno + ", reviews=" + reviews + ", dwriter=" + dwriter
        + ", rpartner=" + rpartner + ", rstar=" + rstar + ", dRevRegisteredDate="
        + dRevRegisteredDate + ", dRevStat=" + dRevStat + "]";
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

  public Member getDwriter() {
    return dwriter;
  }

  public void setDwriter(Member dwriter) {
    this.dwriter = dwriter;
  }

  public Member getRpartner() {
    return rpartner;
  }

  public void setRpartner(Member rpartner) {
    this.rpartner = rpartner;
  }

  public int getRstar() {
    return rstar;
  }

  public void setRstar(int rstar) {
    this.rstar = rstar;
  }

  public Date getdRevRegisteredDate() {
    return dRevRegisteredDate;
  }

  public void setdRevRegisteredDate(Date dRevRegisteredDate) {
    this.dRevRegisteredDate = dRevRegisteredDate;
  }

  public int getdRevStat() {
    return dRevStat;
  }

  public void setdRevStat(int dRevStat) {
    this.dRevStat = dRevStat;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((dRevRegisteredDate == null) ? 0 : dRevRegisteredDate.hashCode());
    result = prime * result + dRevStat;
    result = prime * result + ((dwriter == null) ? 0 : dwriter.hashCode());
    result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
    result = prime * result + rjno;
    result = prime * result + ((rpartner == null) ? 0 : rpartner.hashCode());
    result = prime * result + rstar;
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
    ReviewDriver other = (ReviewDriver) obj;
    if (dRevRegisteredDate == null) {
      if (other.dRevRegisteredDate != null)
        return false;
    } else if (!dRevRegisteredDate.equals(other.dRevRegisteredDate))
      return false;
    if (dRevStat != other.dRevStat)
      return false;
    if (dwriter == null) {
      if (other.dwriter != null)
        return false;
    } else if (!dwriter.equals(other.dwriter))
      return false;
    if (reviews == null) {
      if (other.reviews != null)
        return false;
    } else if (!reviews.equals(other.reviews))
      return false;
    if (rjno != other.rjno)
      return false;
    if (rpartner == null) {
      if (other.rpartner != null)
        return false;
    } else if (!rpartner.equals(other.rpartner))
      return false;
    if (rstar != other.rstar)
      return false;
    return true;
  }

}
