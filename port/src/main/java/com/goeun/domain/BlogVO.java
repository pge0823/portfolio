package com.goeun.domain;

public class BlogVO
  extends Email
{
  private String title;
  private String blogName;
  private String backgroundImage;
  private String siteHeading;
  private String subHeading;
  private String copyright;
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setTitle(String title)
  {
    this.title = title;
  }
  
  public String getBlogName()
  {
    return this.blogName;
  }
  
  public void setBlogName(String blogName)
  {
    this.blogName = blogName;
  }
  
  public String getBackgroundImage()
  {
    return this.backgroundImage;
  }
  
  public void setBackgroundImage(String backgroundImage)
  {
    this.backgroundImage = backgroundImage;
  }
  
  public String getSiteHeading()
  {
    return this.siteHeading;
  }
  
  public void setSiteHeading(String siteHeading)
  {
    this.siteHeading = siteHeading;
  }
  
  public String getSubHeading()
  {
    return this.subHeading;
  }
  
  public void setSubHeading(String subHeading)
  {
    this.subHeading = subHeading;
  }
  
  public String getCopyright()
  {
    return this.copyright;
  }
  
  public void setCopyright(String copyright)
  {
    this.copyright = copyright;
  }
  
  public String toString()
  {
    return 
    
      "BlogVO [email=" + this.email + ", title=" + this.title + ", blogName=" + this.blogName + ", backgroundImage=" + this.backgroundImage + ", siteHeading=" + this.siteHeading + ", subHeading=" + this.subHeading + ", copyright=" + this.copyright + "]";
  }
}