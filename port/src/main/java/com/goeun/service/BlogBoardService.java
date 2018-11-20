package com.goeun.service;

import com.goeun.domain.BlogBoardVO;
import com.goeun.domain.SearchCriteria;
import java.util.List;

public interface BlogBoardService
{
  public List<BlogBoardVO> listBoard(SearchCriteria paramSearchCriteria) throws Exception;
  
  public int getTotalBoardCount(SearchCriteria paramSearchCriteria) throws Exception;
  
  public BlogBoardVO read(BlogBoardVO paramBlogBoardVO) throws Exception;
  
  public void createNewPage(BlogBoardVO paramBlogBoardVO) throws Exception;
  
  public void updatePage(BlogBoardVO paramBlogBoardVO) throws Exception;
  
  public void deletePage(BlogBoardVO paramBlogBoardVO) throws Exception;
  
  public List<BlogBoardVO> topThreePopularPost(String paramString) throws Exception;
  
  public int upperBnoCount(Object paramObject) throws Exception;
}