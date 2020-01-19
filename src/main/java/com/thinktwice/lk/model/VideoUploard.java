package com.thinktwice.lk.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VIDEOS")
public class VideoUploard {

  private Long pid;
  private String vName;
  private String vFormat;
  private Long vSize;
  private String vPath;
  private Date uDate;

  public VideoUploard() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PID",length = 100)
  public Long getPid() {
    return pid;
  }

  public void setPid(Long pid) {
    this.pid = pid;
  }

  @Column(name = "NAME",length = 255,nullable = false)
  public String getvName() {
    return vName;
  }

  public void setvName(String vName) {
    this.vName = vName;
  }

  @Column(name = "VIDEO_FORMAT",length = 255,nullable = false)
  public String getvFormat() {
    return vFormat;
  }

  public void setvFormat(String vFormat) {
    this.vFormat = vFormat;
  }

  @Column(name = "VIDEO_SIZE",length = 255)
  public Long getvSize() {
    return vSize;
  }

  public void setvSize(Long vSize) {
    this.vSize = vSize;
  }

  @Column(name = "VIDEO_PATH",nullable = false,length = 255)
  public String getvPath() {
    return vPath;
  }

  public void setvPath(String vPath) {
    this.vPath = vPath;
  }

  @Column(name = "UPLOAD_DATE",nullable = false,length = 255)
  public Date getuDate() {
    return uDate;
  }

  public void setuDate(Date uDate) {
    this.uDate = uDate;
  }
}
