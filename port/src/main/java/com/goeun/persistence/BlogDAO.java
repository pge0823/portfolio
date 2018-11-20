package com.goeun.persistence;

import com.goeun.domain.BlogVO;

public interface BlogDAO
{
  public BlogVO getBlogInformation(String paramString) throws Exception;
  
  public void setDefaultInformation(String paramString) throws Exception;
  
  public void updateBlogInformation(BlogVO paramBlogVO) throws Exception;
}