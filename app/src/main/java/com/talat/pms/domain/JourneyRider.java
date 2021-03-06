package com.talat.pms.domain;

import java.util.List;

public class JourneyRider {
  private int journeyRiderNo;
  private int matchingStatus;
  private String matchingContent;
  private Journey journey;
  private List<Journey> journeys;
  private MemberDriver driver;
  private Member rider;
  private Route departure;
  private Route arrival;
  private Route spot;
  private List<Route> spots;
  private int jno;

  @Override
  public String toString() {
    return "JourneyRider [journeyRiderNo=" + journeyRiderNo + ", matchingStatus=" + matchingStatus
        + ", matchingContent=" + matchingContent + ", journey=" + journey + ", journeys=" + journeys
        + ", driver=" + driver + ", rider=" + rider + ", departure=" + departure + ", arrival="
        + arrival + ", spot=" + spot + ", spots=" + spots + ", jno=" + jno + "]";
  }

  public int getJourneyRiderNo() {
    return journeyRiderNo;
  }

  public void setJourneyRiderNo(int journeyRiderNo) {
    this.journeyRiderNo = journeyRiderNo;
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

  public MemberDriver getDriver() {
    return driver;
  }

  public void setDriver(MemberDriver driver) {
    this.driver = driver;
  }

  public Member getRider() {
    return rider;
  }

  public void setRider(Member rider) {
    this.rider = rider;
  }

  public Route getDeparture() {
    return departure;
  }

  public void setDeparture(Route departure) {
    this.departure = departure;
  }

  public Route getArrival() {
    return arrival;
  }

  public void setArrival(Route arrival) {
    this.arrival = arrival;
  }

  public Route getSpot() {
    return spot;
  }

  public void setSpot(Route spot) {
    this.spot = spot;
  }

  public List<Route> getSpots() {
    return spots;
  }

  public void setSpots(List<Route> spots) {
    this.spots = spots;
  }

  public int getJno() {
    return jno;
  }

  public void setJno(int jno) {
    this.jno = jno;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((arrival == null) ? 0 : arrival.hashCode());
    result = prime * result + ((departure == null) ? 0 : departure.hashCode());
    result = prime * result + ((driver == null) ? 0 : driver.hashCode());
    result = prime * result + jno;
    result = prime * result + ((journey == null) ? 0 : journey.hashCode());
    result = prime * result + journeyRiderNo;
    result = prime * result + ((journeys == null) ? 0 : journeys.hashCode());
    result = prime * result + ((matchingContent == null) ? 0 : matchingContent.hashCode());
    result = prime * result + matchingStatus;
    result = prime * result + ((rider == null) ? 0 : rider.hashCode());
    result = prime * result + ((spot == null) ? 0 : spot.hashCode());
    result = prime * result + ((spots == null) ? 0 : spots.hashCode());
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
    JourneyRider other = (JourneyRider) obj;
    if (arrival == null) {
      if (other.arrival != null)
        return false;
    } else if (!arrival.equals(other.arrival))
      return false;
    if (departure == null) {
      if (other.departure != null)
        return false;
    } else if (!departure.equals(other.departure))
      return false;
    if (driver == null) {
      if (other.driver != null)
        return false;
    } else if (!driver.equals(other.driver))
      return false;
    if (jno != other.jno)
      return false;
    if (journey == null) {
      if (other.journey != null)
        return false;
    } else if (!journey.equals(other.journey))
      return false;
    if (journeyRiderNo != other.journeyRiderNo)
      return false;
    if (journeys == null) {
      if (other.journeys != null)
        return false;
    } else if (!journeys.equals(other.journeys))
      return false;
    if (matchingContent == null) {
      if (other.matchingContent != null)
        return false;
    } else if (!matchingContent.equals(other.matchingContent))
      return false;
    if (matchingStatus != other.matchingStatus)
      return false;
    if (rider == null) {
      if (other.rider != null)
        return false;
    } else if (!rider.equals(other.rider))
      return false;
    if (spot == null) {
      if (other.spot != null)
        return false;
    } else if (!spot.equals(other.spot))
      return false;
    if (spots == null) {
      if (other.spots != null)
        return false;
    } else if (!spots.equals(other.spots))
      return false;
    return true;
  }


}
