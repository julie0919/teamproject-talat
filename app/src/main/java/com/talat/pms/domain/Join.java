package com.talat.pms.domain;

import java.sql.Date;

public class Join extends Member {
  private int no;
  private String nicName;
  private int gender;
  private String postNo;
  private String basicAddress;
  private String detailAddress;
  private String profile;
  private int preferenceGender;
  private Date registeredDate;
  private double starAverage;

  @Override
  public String toString() {
    return "Member [no=" + no + ", nicName=" + nicName + ", gender=" + gender + ", postNo=" + postNo
        + ", basicAddress=" + basicAddress + ", detailAddress=" + detailAddress + ", profile="
        + profile + ", preferenceGender=" + preferenceGender + ", registeredDate=" + registeredDate
        + ", starAverage=" + starAverage + "]";
  }

  @Override
  public int getNo() {
    return no;
  }

  @Override
  public void setNo(int no) {
    this.no = no;
  }

  public String getNicName() {
    return nicName;
  }

  public void setNicName(String nicName) {
    this.nicName = nicName;
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

}
