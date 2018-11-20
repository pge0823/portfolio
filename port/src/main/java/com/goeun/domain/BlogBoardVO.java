package com.goeun.domain;

import java.util.Date;

public class BlogBoardVO
  extends Email
{
  private Integer bno;
  private String title;
  private String content;
  private String writer;
  private Date regdate;
  private Integer viewcnt;
  
  public String toString()
  {
    return 
      "BlogBoardVO [bno=" + this.bno + ", title=" + this.title + ", content=" + this.content + ", writer=" + this.writer + ", regdate=" + this.regdate + ", viewcnt=" + this.viewcnt + ", email=" + this.email + "]";
  }
  
  public Integer getBno()
  {
    return this.bno;
  }
  
  public void setBno(Integer bno)
  {
    this.bno = bno;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setTitle(String title)
  {
    this.title = title;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public void setContent(String content)
  {
    this.content = content;
  }
  
  public String getWriter()
  {
    return this.writer;
  }
  
  public void setWriter(String writer)
  {
    this.writer = writer;
  }
  
  public Date getRegdate()
  {
    return this.regdate;
  }
  
  public void setRegdate(Date regdate)
  {
    this.regdate = regdate;
  }
  
  public Integer getViewcnt()
  {
    return this.viewcnt;
  }
  
  public void setViewcnt(Integer viewcnt)
  {
    this.viewcnt = viewcnt;
  }
}