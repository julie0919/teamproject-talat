package com.talat.pms.domain;

import java.sql.Date;

public class DriverQnA {
  private int no;
  private QnA qtype;
  private int jno;
  private Member writer;
  private Member partner;
  private Date registeredDate;
  private int status;
  private String qContent;
  private String aContent;
  private String file;

  @Override
  public String toString() {
    return "DriverQnA [no=" + no + ", qtype=" + qtype + ", jno=" + jno + ", writer=" + writer
        + ", partner=" + partner + ", registeredDate=" + registeredDate + ", status=" + status
        + ", qContent=" + qContent + ", aContent=" + aContent + ", file=" + file + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public QnA getQtype() {
    return qtype;
  }
  public void setQtype(QnA qtype) {
    this.qtype = qtype;
  }
  public int getJno() {
    return jno;
  }
  public void setJno(int jno) {
    this.jno = jno;
  }
  public Member getWriter() {
    return writer;
  }
  public void setWriter(Member writer) {
    this.writer = writer;
  }
  public Member getPartner() {
    return partner;
  }
  public void setPartner(Member partner) {
    this.partner = partner;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }
  public String getqContent() {
    return qContent;
  }
  public void setqContent(String qContent) {
    this.qContent = qContent;
  }
  public String getaContent() {
    return aContent;
  }
  public void setaContent(String aContent) {
    this.aContent = aContent;
  }
  public String getFile() {
    return file;
  }
  public void setFile(String file) {
    this.file = file;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((aContent == null) ? 0 : aContent.hashCode());
    result = prime * result + ((file == null) ? 0 : file.hashCode());
    result = prime * result + jno;
    result = prime * result + no;
    result = prime * result + ((partner == null) ? 0 : partner.hashCode());
    result = prime * result + ((qContent == null) ? 0 : qContent.hashCode());
    result = prime * result + ((qtype == null) ? 0 : qtype.hashCode());
    result = prime * result + ((registeredDate == null) ? 0 : registeredDate.hashCode());
    result = prime * result + status;
    result = prime * result + ((writer == null) ? 0 : writer.hashCode());
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
    DriverQnA other = (DriverQnA) obj;
    if (aContent == null) {
      if (other.aContent != null)
        return false;
    } else if (!aContent.equals(other.aContent))
      return false;
    if (file == null) {
      if (other.file != null)
        return false;
    } else if (!file.equals(other.file))
      return false;
    if (jno != other.jno)
      return false;
    if (no != other.no)
      return false;
    if (partner == null) {
      if (other.partner != null)
        return false;
    } else if (!partner.equals(other.partner))
      return false;
    if (qContent == null) {
      if (other.qContent != null)
        return false;
    } else if (!qContent.equals(other.qContent))
      return false;
    if (qtype == null) {
      if (other.qtype != null)
        return false;
    } else if (!qtype.equals(other.qtype))
      return false;
    if (registeredDate == null) {
      if (other.registeredDate != null)
        return false;
    } else if (!registeredDate.equals(other.registeredDate))
      return false;
    if (status != other.status)
      return false;
    if (writer == null) {
      if (other.writer != null)
        return false;
    } else if (!writer.equals(other.writer))
      return false;
    return true;
  }

}
