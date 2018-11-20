package com.goeun.service;

import com.goeun.domain.BlogVO;

public interface BlogService
{
  public BlogVO getBlogInformation(String paramString) throws Exception;
  
  public void setDefaultInformation(String paramString) throws Exception;
  
  public void updateBlogInformation(BlogVO paramBlogVO) throws Exception;
}
