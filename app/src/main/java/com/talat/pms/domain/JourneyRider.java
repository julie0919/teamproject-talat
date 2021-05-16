package com.talat.pms.domain;

public class JourneyRider {
  private int journeyRiderNo;
  private int machingStatus;
  private String machingContent;
  private double driverStar;
  private double riderStar;
  private Journey journey;
  private Member driver;
  private Member rider;
  private Route route;

  @Override
  public String toString() {
    return "JourneyRider [journeyRiderNo=" + journeyRiderNo + ", machingStatus=" + machingStatus
        + ", machingContent=" + machingContent + ", driverStar=" + driverStar + ", riderStar="
        + riderStar + ", journey=" + journey + ", driver=" + driver + ", rider=" + rider
        + ", route=" + route + "]";
  }

  public Route getRoute() {
    return route;
  }

  public void setRoute(Route route) {
    this.route = route;
  }

  public int getJourneyRiderNo() {
    return journeyRiderNo;
  }

  public void setJourneyRiderNo(int journeyRiderNo) {
    this.journeyRiderNo = journeyRiderNo;
  }

  public Journey getJourney() {
    return journey;
  }

  public void setJourney(Journey journey) {
    this.journey = journey;
  }

  public int getMachingStatus() {
    return machingStatus;
  }

  public void setMachingStatus(int machingStatus) {
    this.machingStatus = machingStatus;
  }

  public String getMachingContent() {
    return machingContent;
  }

  public void setMachingContent(String machingContent) {
    this.machingContent = machingContent;
  }

  public double getDriverStar() {
    return driverStar;
  }

  public void setDriverStar(double driverStar) {
    this.driverStar = driverStar;
  }

  public double getRiderStar() {
    return riderStar;
  }

  public void setRiderStar(double riderStar) {
    this.riderStar = riderStar;
  }

  public Member getDriver() {
    return driver;
  }

  public void setDriver(Member driver) {
    this.driver = driver;
  }

  public Member getRider() {
    return rider;
  }

  public void setRider(Member rider) {
    this.rider = rider;
  }

}
