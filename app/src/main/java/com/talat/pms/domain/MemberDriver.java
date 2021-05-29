package com.talat.pms.domain;

import java.sql.Date;

public class MemberDriver extends MemberRider {
  private int dmno;
  private String licenseNo;
  private int licenseType;
  private Date licenseRenewal; 
  private int licenseVerfNo;
  private String carNo;
  private String carModel;
  private String carColor; 
  private String carYear;
  private String carOwner;
  private String licensePhoto;
  private String insurancePhoto;
  private String carPhoto;
  private String corporationPhoto;
  private int approval;
  private Date approvalDate;
  private String approvalContent;


  public int getDmno() {
    return dmno;
  }
  public void setDmno(int dmno) {
    this.dmno = dmno;
  }
  public String getLicenseNo() {
    return licenseNo;
  }
  public void setLicenseNo(String licenseNo) {
    this.licenseNo = licenseNo;
  }
  public int getLicenseType() {
    return licenseType;
  }
  public void setLicenseType(int licenseType) {
    this.licenseType = licenseType;
  }
  public Date getLicenseRenewal() {
    return licenseRenewal;
  }
  public void setLicenseRenewal(Date licenseRenewal) {
    this.licenseRenewal = licenseRenewal;
  }
  public int getLicenseVerfNo() {
    return licenseVerfNo;
  }
  public void setLicenseVerfNo(int licenseVerfNo) {
    this.licenseVerfNo = licenseVerfNo;
  }
  public String getCarNo() {
    return carNo;
  }
  public void setCarNo(String carNo) {
    this.carNo = carNo;
  }
  public String getCarModel() {
    return carModel;
  }
  public void setCarModel(String carModel) {
    this.carModel = carModel;
  }
  public String getCarColor() {
    return carColor;
  }
  public void setCarColor(String carColor) {
    this.carColor = carColor;
  }
  public String getCarYear() {
    return carYear;
  }
  public void setCarYear(String carYear) {
    this.carYear = carYear;
  }
  public String getCarOwner() {
    return carOwner;
  }
  public void setCarOwner(String carOwner) {
    this.carOwner = carOwner;
  }
  public String getLicensePhoto() {
    return licensePhoto;
  }
  public void setLicensePhoto(String licensePhoto) {
    this.licensePhoto = licensePhoto;
  }
  public String getInsurancePhoto() {
    return insurancePhoto;
  }
  public void setInsurancePhoto(String insurancePhoto) {
    this.insurancePhoto = insurancePhoto;
  }
  public String getCarPhoto() {
    return carPhoto;
  }
  public void setCarPhoto(String carPhoto) {
    this.carPhoto = carPhoto;
  }
  public String getCorporationPhoto() {
    return corporationPhoto;
  }
  public void setCorporationPhoto(String corporationPhoto) {
    this.corporationPhoto = corporationPhoto;
  }
  public int getApproval() {
    return approval;
  }
  public void setApproval(int approval) {
    this.approval = approval;
  }
  public Date getApprovalDate() {
    return approvalDate;
  }
  public void setApprovalDate(Date approvalDate) {
    this.approvalDate = approvalDate;
  }
  public String getApprovalContent() {
    return approvalContent;
  }
  public void setApprovalContent(String approvalContent) {
    this.approvalContent = approvalContent;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + approval;
    result = prime * result + ((approvalContent == null) ? 0 : approvalContent.hashCode());
    result = prime * result + ((approvalDate == null) ? 0 : approvalDate.hashCode());
    result = prime * result + ((carColor == null) ? 0 : carColor.hashCode());
    result = prime * result + ((carModel == null) ? 0 : carModel.hashCode());
    result = prime * result + ((carNo == null) ? 0 : carNo.hashCode());
    result = prime * result + ((carOwner == null) ? 0 : carOwner.hashCode());
    result = prime * result + ((carPhoto == null) ? 0 : carPhoto.hashCode());
    result = prime * result + ((carYear == null) ? 0 : carYear.hashCode());
    result = prime * result + ((corporationPhoto == null) ? 0 : corporationPhoto.hashCode());
    result = prime * result + dmno;
    result = prime * result + ((insurancePhoto == null) ? 0 : insurancePhoto.hashCode());
    result = prime * result + ((licenseNo == null) ? 0 : licenseNo.hashCode());
    result = prime * result + ((licensePhoto == null) ? 0 : licensePhoto.hashCode());
    result = prime * result + ((licenseRenewal == null) ? 0 : licenseRenewal.hashCode());
    result = prime * result + licenseType;
    result = prime * result + licenseVerfNo;
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
    MemberDriver other = (MemberDriver) obj;
    if (approval != other.approval)
      return false;
    if (approvalContent == null) {
      if (other.approvalContent != null)
        return false;
    } else if (!approvalContent.equals(other.approvalContent))
      return false;
    if (approvalDate == null) {
      if (other.approvalDate != null)
        return false;
    } else if (!approvalDate.equals(other.approvalDate))
      return false;
    if (carColor == null) {
      if (other.carColor != null)
        return false;
    } else if (!carColor.equals(other.carColor))
      return false;
    if (carModel == null) {
      if (other.carModel != null)
        return false;
    } else if (!carModel.equals(other.carModel))
      return false;
    if (carNo == null) {
      if (other.carNo != null)
        return false;
    } else if (!carNo.equals(other.carNo))
      return false;
    if (carOwner == null) {
      if (other.carOwner != null)
        return false;
    } else if (!carOwner.equals(other.carOwner))
      return false;
    if (carPhoto == null) {
      if (other.carPhoto != null)
        return false;
    } else if (!carPhoto.equals(other.carPhoto))
      return false;
    if (carYear == null) {
      if (other.carYear != null)
        return false;
    } else if (!carYear.equals(other.carYear))
      return false;
    if (corporationPhoto == null) {
      if (other.corporationPhoto != null)
        return false;
    } else if (!corporationPhoto.equals(other.corporationPhoto))
      return false;
    if (dmno != other.dmno)
      return false;
    if (insurancePhoto == null) {
      if (other.insurancePhoto != null)
        return false;
    } else if (!insurancePhoto.equals(other.insurancePhoto))
      return false;
    if (licenseNo == null) {
      if (other.licenseNo != null)
        return false;
    } else if (!licenseNo.equals(other.licenseNo))
      return false;
    if (licensePhoto == null) {
      if (other.licensePhoto != null)
        return false;
    } else if (!licensePhoto.equals(other.licensePhoto))
      return false;
    if (licenseRenewal == null) {
      if (other.licenseRenewal != null)
        return false;
    } else if (!licenseRenewal.equals(other.licenseRenewal))
      return false;
    if (licenseType != other.licenseType)
      return false;
    if (licenseVerfNo != other.licenseVerfNo)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "MemberDriver [dmno=" + dmno + ", licenseNo=" + licenseNo + ", licenseType="
        + licenseType + ", licenseRenewal=" + licenseRenewal + ", licenseVerfNo=" + licenseVerfNo
        + ", carNo=" + carNo + ", carModel=" + carModel + ", carColor=" + carColor + ", carYear="
        + carYear + ", carOwner=" + carOwner + ", licensePhoto=" + licensePhoto
        + ", insurancePhoto=" + insurancePhoto + ", carPhoto=" + carPhoto + ", corporationPhoto="
        + corporationPhoto + ", approval=" + approval + ", approvalDate=" + approvalDate
        + ", approvalContent=" + approvalContent + ", getRmno()=" + getRmno() + ", getNickName()="
        + getNickName() + ", getGender()=" + getGender() + ", getPostNo()=" + getPostNo()
        + ", getBasicAddress()=" + getBasicAddress() + ", getDetailAddress()=" + getDetailAddress()
        + ", getProfile()=" + getProfile() + ", getPreferenceGender()=" + getPreferenceGender()
        + ", getRegisteredDate()=" + getRegisteredDate() + ", getStarAverage()=" + getStarAverage()
        + ", getReviewAverage()=" + getReviewAverage() + ", getMno()=" + getMno() + ", getMname()="
        + getMname() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
        + ", getTel()=" + getTel() + ", getBirth()=" + getBirth() + ", getmType()=" + getmType()
        + "]\n";
  }

}
