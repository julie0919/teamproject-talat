package com.talat.pms.domain;

import java.sql.Time;
import java.util.Date;

public class Chatting {
  int ctno;
  Journey journey;
  MemberRider rider;
  String chattingContent;
  Date chattingDate;
  Time chattingTime;
  int chattingType;

  @Override
  public String toString() {
    return "Chatting [ctno=" + ctno + ", journey=" + journey + ", rider=" + rider
        + ", chattingContent=" + chattingContent + ", chattingDate=" + chattingDate
        + ", chattingTime=" + chattingTime + ", chattingType=" + chattingType + "]";
  }

  public int getCtno() {
    return ctno;
  }

  public void setCtno(int ctno) {
    this.ctno = ctno;
  }

  public Journey getJourney() {
    return journey;
  }

  public void setJourney(Journey journey) {
    this.journey = journey;
  }

  public MemberRider getRider() {
    return rider;
  }

  public void setRider(MemberRider rider) {
    this.rider = rider;
  }

  public String getChattingContent() {
    return chattingContent;
  }

  public void setChattingContent(String chattingContent) {
    this.chattingContent = chattingContent;
  }

  public Date getChattingDate() {
    return chattingDate;
  }

  public void setChattingDate(Date chattingDate) {
    this.chattingDate = chattingDate;
  }

  public Time getChattingTime() {
    return chattingTime;
  }

  public void setChattingTime(Time chattingTime) {
    this.chattingTime = chattingTime;
  }

  public int getChattingType() {
    return chattingType;
  }

  public void setChattingType(int chattingType) {
    this.chattingType = chattingType;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((chattingContent == null) ? 0 : chattingContent.hashCode());
    result = prime * result + ((chattingDate == null) ? 0 : chattingDate.hashCode());
    result = prime * result + ((chattingTime == null) ? 0 : chattingTime.hashCode());
    result = prime * result + chattingType;
    result = prime * result + ctno;
    result = prime * result + ((journey == null) ? 0 : journey.hashCode());
    result = prime * result + ((rider == null) ? 0 : rider.hashCode());
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
    Chatting other = (Chatting) obj;
    if (chattingContent == null) {
      if (other.chattingContent != null)
        return false;
    } else if (!chattingContent.equals(other.chattingContent))
      return false;
    if (chattingDate == null) {
      if (other.chattingDate != null)
        return false;
    } else if (!chattingDate.equals(other.chattingDate))
      return false;
    if (chattingTime == null) {
      if (other.chattingTime != null)
        return false;
    } else if (!chattingTime.equals(other.chattingTime))
      return false;
    if (chattingType != other.chattingType)
      return false;
    if (ctno != other.ctno)
      return false;
    if (journey == null) {
      if (other.journey != null)
        return false;
    } else if (!journey.equals(other.journey))
      return false;
    if (rider == null) {
      if (other.rider != null)
        return false;
    } else if (!rider.equals(other.rider))
      return false;
    return true;
  }




}
