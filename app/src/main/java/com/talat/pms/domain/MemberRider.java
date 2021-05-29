package com.talat.pms.domain;

import java.sql.Date;

public class MemberRider extends Member{
  private int rmno;
  private String nickName;
  private int gender;
  private String postNo;
  private String basicAddress;
  private String detailAddress;
  private String profile;
  private int preferenceGender;
  private Date registeredDate;
  private double starAverage;
  private int reviewAverage;

  public int getRmno() {
    return rmno;
  }
  public void setRmno(int rmno) {
    this.rmno = rmno;
  }
  public String getNickName() {
    return nickName;
  }
  public void setNickName(String nickName) {
    this.nickName = nickName;
  }
  public int getGender() {
    return gender;
  }
  public void setGender(int gender) {
    this.gender = gender;
  }
  public String getPostNo() {
    return postNo;
  }
  public void setPostNo(String postNo) {
    this.postNo = postNo;
  }
  public String getBasicAddress() {
    return basicAddress;
  }
  public void setBasicAddress(String basicAddress) {
    this.basicAddress = basicAddress;
  }
  public String getDetailAddress() {
    return detailAddress;
  }
  public void setDetailAddress(String detailAddress) {
    this.detailAddress = detailAddress;
  }
  public String getProfile() {
    return profile;
  }
  public void setProfile(String profile) {
    this.profile = profile;
  }
  public int getPreferenceGender() {
    return preferenceGender;
  }
  public void setPreferenceGender(int preferenceGender) {
    this.preferenceGender = preferenceGender;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public double getStarAverage() {
    return starAverage;
  }
  public void setStarAverage(double starAverage) {
    this.starAverage = starAverage;
  }
  public int getReviewAverage() {
    return reviewAverage;
  }
  public void setReviewAverage(int reviewAverage) {
    this.reviewAverage = reviewAverage;
  }
  @Override
  public String toString() {
    return "MemberRider [rmno=" + rmno + ", nickName=" + nickName + ", gender=" + gender
        + ", postNo=" + postNo + ", basicAddress=" + basicAddress + ", detailAddress="
        + detailAddress + ", profile=" + profile + ", preferenceGender=" + preferenceGender
        + ", registeredDate=" + registeredDate + ", starAverage=" + starAverage + ", reviewAverage="
        + reviewAverage + ", getMno()=" + getMno() + ", getMname()=" + getMname() + ", getEmail()="
        + getEmail() + ", getPassword()=" + getPassword() + ", getTel()=" + getTel()
        + ", getBirth()=" + getBirth() + ", getmType()=" + getmType() + "]";
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((basicAddress == null) ? 0 : basicAddress.hashCode());
    result = prime * result + ((detailAddress == null) ? 0 : detailAddress.hashCode());
    result = prime * result + gender;
    result = prime * result + rmno;
    result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
    result = prime * result + ((postNo == null) ? 0 : postNo.hashCode());
    result = prime * result + preferenceGender;
    result = prime * result + ((profile == null) ? 0 : profile.hashCode());
    result = prime * result + ((registeredDate == null) ? 0 : registeredDate.hashCode());
    result = prime * result + reviewAverage;
    long temp;
    temp = Double.doubleToLongBits(starAverage);
    result = prime * result + (int) (temp ^ (temp >>> 32));
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
    MemberRider other = (MemberRider) obj;
    if (basicAddress == null) {
      if (other.basicAddress != null)
        return false;
    } else if (!basicAddress.equals(other.basicAddress))
      return false;
    if (detailAddress == null) {
      if (other.detailAddress != null)
        return false;
    } else if (!detailAddress.equals(other.detailAddress))
      return false;
    if (gender != other.gender)
      return false;
    if (rmno != other.rmno)
      return false;
    if (nickName == null) {
      if (other.nickName != null)
        return false;
    } else if (!nickName.equals(other.nickName))
      return false;
    if (postNo == null) {
      if (other.postNo != null)
        return false;
    } else if (!postNo.equals(other.postNo))
      return false;
    if (preferenceGender != other.preferenceGender)
      return false;
    if (profile == null) {
      if (other.profile != null)
        return false;
    } else if (!profile.equals(other.profile))
      return false;
    if (registeredDate == null) {
      if (other.registeredDate != null)
        return false;
    } else if (!registeredDate.equals(other.registeredDate))
      return false;
    if (reviewAverage != other.reviewAverage)
      return false;
    if (Double.doubleToLongBits(starAverage) != Double.doubleToLongBits(other.starAverage))
      return false;
    return true;
  }

}