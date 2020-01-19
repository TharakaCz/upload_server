package com.thinktwice.lk.helper;


import java.util.Date;

public class VideoDTO {

  private Long pid;
  private String vName;
  private String vFormat;
  private Long vSize;
  private String vPath;
  private Date uDate;

  public VideoDTO() {
  }

  public Long getPid() {
    return pid;
  }

  public void setPid(Long pid) {
    this.pid = pid;
  }

  public String getvName() {
    return vName;
  }

  public void setvName(String vName) {
    this.vName = vName;
  }

  public String getvFormat() {
    return vFormat;
  }

  public void setvFormat(String vFormat) {
    this.vFormat = vFormat;
  }

  public Long getvSize() {
    return vSize;
  }

  public void setvSize(Long vSize) {
    this.vSize = vSize;
  }

  public String getvPath() {
    return vPath;
  }

  public void setvPath(String vPath) {
    this.vPath = vPath;
  }

  public Date getuDate() {
    return uDate;
  }

  public void setuDate(Date uDate) {
    this.uDate = uDate;
  }
}
