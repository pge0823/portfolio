package com.goeun.persistence;

import com.goeun.domain.BlogBoardVO;
import com.goeun.domain.SearchCriteria;
import java.util.List;

public interface BlogBoardDAO
{
  public List<BlogBoardVO> list(SearchCriteria paramSearchCriteria) throws Exception;
  
  public BlogBoardVO read(BlogBoardVO paramBlogBoardVO) throws Exception;
  
  public void create(BlogBoardVO paramBlogBoardVO) throws Exception;
  
  public void update(BlogBoardVO paramBlogBoardVO) throws Exception;
  
  public void delete(BlogBoardVO paramBlogBoardVO) throws Exception;
  
  public int totalCount(SearchCriteria paramSearchCriteria) throws Exception;
  
  public void updateViewCnt(BlogBoardVO paramBlogBoardVO) throws Exception;
  
  public List<BlogBoardVO> topThreePopularPost(String paramString) throws Exception;
  
  public int upperBnoCount(Object paramObject) throws Exception;
}