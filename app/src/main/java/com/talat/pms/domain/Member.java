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

  @Override
  public String toString() {
    return "Member [mno=" + mno + ", mname=" + mname + ", email=" + email + ", password=" + password
        + ", tel=" + tel + ", birth=" + birth + ", mType=" + mType + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((birth == null) ? 0 : birth.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + mType;
    result = prime * result + ((mname == null) ? 0 : mname.hashCode());
    result = prime * result + mno;
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
    Member other = (Member) obj;
    if (birth == null) {
      if (other.birth != null)
        return false;
    } else if (!birth.equals(other.birth))
      return false;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (mType != other.mType)
      return false;
    if (mname == null) {
      if (other.mname != null)
        return false;
    } else if (!mname.equals(other.mname))
      return false;
    if (mno != other.mno)
      return false;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    if (tel == null) {
      if (other.tel != null)
        return false;
    } else if (!tel.equals(other.tel))
      return false;
    return true;
  }


}