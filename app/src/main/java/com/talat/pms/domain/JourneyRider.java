package com.talat.pms.domain;

import java.util.List;

public class JourneyRider {
  private int journeyRiderNo;
  private int matchingStatus;
  private String matchingContent;
  private double driverStar;
  private double riderStar;
  private Journey journey;
  private List<Journey> journeys;
  private Member driver;
  private Member rider;
  private Route route;


  @Override
  public String toString() {
    return "JourneyRider [journeyRiderNo=" + journeyRiderNo + ", matchingStatus=" + matchingStatus
        + ", matchingContent=" + matchingContent + ", driverStar=" + driverStar + ", riderStar="
        + riderStar + ", journey=" + journey + ", journeys=" + journeys + ", driver=" + driver
        + ", rider=" + rider + ", route=" + route + "]";
  }

  public int getMatchingStatus() {
    return matchingStatus;
  }

  public void setMatchingStatus(int matchingStatus) {
    this.matchingStatus = matchingStatus;
  }

  public String getMatchingContent() {
    return matchingContent;
  }

  public void setMatchingContent(String matchingContent) {
    this.matchingContent = matchingContent;
  }

  public int getJourneyRiderNo() {
    return journeyRiderNo;
  }

  public void setJourneyRiderNo(int journeyRiderNo) {
    this.journeyRiderNo = journeyRiderNo;
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

  public Journey getJourney() {
    return journey;
  }

  public void setJourney(Journey journey) {
    this.journey = journey;
  }

  public List<Journey> getJourneys() {
    return journeys;
  }

  public void setJourneys(List<Journey> journeys) {
    this.journeys = journeys;
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

  public Route getRoute() {
    return route;
  }

  public void setRoute(Route route) {
    this.route = route;
  }


}
