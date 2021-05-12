package com.talat.pms.domain;

import java.math.BigDecimal;
import java.sql.Time;

public class Route {
  private int rno;
  private int spotOrder;
  private BigDecimal latitude;
  private BigDecimal longitude;  
  private String spotName;
  private Time spotTime;


  public int getRno() {
    return rno;
  }
  public void setRno(int rno) {
    this.rno = rno;
  }
  public int getSpotOrder() {
    return spotOrder;
  }
  public void setSpotOrder(int spotOrder) {
    this.spotOrder = spotOrder;
  }
  public BigDecimal getLatitude() {
    return latitude;
  }
  public void setLatitude(BigDecimal latitude) {
    this.latitude = latitude;
  }
  public BigDecimal getLongitude() {
    return longitude;
  }
  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }
  public String getSpotName() {
    return spotName;
  }
  public void setSpotName(String spotName) {
    this.spotName = spotName;
  }
  public Time getSpotTime() {
    return spotTime;
  }
  public void setSpotTime(Time spotTime) {
    this.spotTime = spotTime;
  }


  //  @Override
  //  public String toString() {
  //    return "Route [no=" + no + ", spotOrder=" + spotOrder + ", latitude=" + latitude
  //        + ", longitude=" + longitude + ", spotName=" + spotName + ", spotTime=" + spotTime + "]";
  //  }



  // HashCode, Equals
}