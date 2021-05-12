package com.talat.pms.domain;

import java.sql.Date;

public class Member {
  private int mno;
  private String mname;
  private String email;
  private String password;
  private String tel;
  private Date birth;
  private int mType;

  private String nicName;
  private int gender;
  private String postNo;
  private String basicAddress;
  private String detailAddress;
  private String profile;
  private int preferenceGender;
  private Date registeredDate;
  private double starAverage;

  public int getMno() {
    return mno;
  }

  public void setMno(int mno) {
    this.mno = mno;
  }

  public String getMname() {
    return mname;
  }

  public void setMname(String mname) {
    this.mname = mname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public Date getBirth() {
    return birth;
  }

  public void setBirth(Date birth) {
    this.birth = birth;
  }

  public int getmType() {
    return mType;
  }

  public void setmType(int mType) {
    this.mType = mType;
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