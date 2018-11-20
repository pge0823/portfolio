package com.goeun.domain;

public class PageMaker
{
  private int totalCount;
  private int startPage;
  private int endPage;
  private boolean prev;
  private boolean next;
  private int displayPageNum = 10;
  private Criteria cri;
  
  public void setCri(Criteria cri)
  {
    this.cri = cri;
  }
  
  public void setTotalCount(int totalCount)
  {
    this.totalCount = totalCount;
    
    calcData();
  }
  
  private void calcData()
  {
    this.endPage = (int)(Math.ceil(cri.getPage() / (double)displayPageNum) * this.displayPageNum);
    
    this.startPage = (this.endPage - this.displayPageNum + 1);
    
    int tempEndPage = (int)Math.ceil(totalCount / (double)cri.getPerPageNum());
    if (this.endPage > tempEndPage) {
      this.endPage = tempEndPage;
    }
    this.prev = (this.startPage != 1);
    
    this.next = (this.endPage * this.cri.getPerPageNum() < this.totalCount);
  }
  
  public int getStartPage()
  {
    return this.startPage;
  }
  
  public void setStartPage(int startPage)
  {
    this.startPage = startPage;
  }
  
  public int getEndPage()
  {
    return this.endPage;
  }
  
  public void setEndPage(int endPage)
  {
    this.endPage = endPage;
  }
  
  public boolean isPrev()
  {
    return this.prev;
  }
  
  public void setPrev(boolean prev)
  {
    this.prev = prev;
  }
  
  public boolean isNext()
  {
    return this.next;
  }
  
  public void setNext(boolean next)
  {
    this.next = next;
  }
  
  public int getDisplayPageNum()
  {
    return this.displayPageNum;
  }
  
  public void setDisplayPageNum(int displayPageNum)
  {
    this.displayPageNum = displayPageNum;
  }
  
  public int getTotalCount()
  {
    return this.totalCount;
  }
  
  public Criteria getCri()
  {
    return this.cri;
  }
  
  public String toString()
  {
    return 
      "pageMaker [totalCount=" + this.totalCount + ", startPage=" + this.startPage + ", endPage=" + this.endPage + ", prev=" + this.prev + ", next=" + this.next + ", displayPageNum=" + this.displayPageNum + ", cri=" + this.cri + "]";
  }
}
