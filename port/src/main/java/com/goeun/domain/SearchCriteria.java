package com.goeun.domain;

public class SearchCriteria
  extends Criteria
{
  private String searchType;
  private String keyword;
  
  public String getSearchType()
  {
    return this.searchType;
  }
  
  public void setSearchType(String searchType)
  {
    this.searchType = searchType;
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public void setKeyword(String keyword)
  {
    this.keyword = keyword;
  }
  
  public String toString()
  {
    return super.toString() + " SearchCriteria [searchType=" + this.searchType + ", keyword=" + this.keyword + "]";
  }
}
