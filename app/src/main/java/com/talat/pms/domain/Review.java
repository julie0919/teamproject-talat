package com.talat.pms.domain;

public class Review {
  private int revNo;
  private String review;
  @Override
  public String toString() {
    return "Review [revNo=" + revNo + ", review=" + review + "]";
  }
  public int getRevNo() {
    return revNo;
  }
  public void setRevNo(int revNo) {
    this.revNo = revNo;
  }
  public String getReview() {
    return review;
  }
  public void setReview(String review) {
    this.review = review;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + revNo;
    result = prime * result + ((review == null) ? 0 : review.hashCode());
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
    Review other = (Review) obj;
    if (revNo != other.revNo)
      return false;
    if (review == null) {
      if (other.review != null)
        return false;
    } else if (!review.equals(other.review))
      return false;
    return true;
  }
}
