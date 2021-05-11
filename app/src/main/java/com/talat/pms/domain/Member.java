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

  public Member(
      int mno,
      String mname,
      String email,
      String password,
      String tel,
      Date birth,
      int mType) {
    this.mno = mno;
    this.mname = mname;
    this.email = email;
    this.password = password;
    this.tel = tel;
    this.birth = birth;
    this.mType = mType;

  }

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

}
