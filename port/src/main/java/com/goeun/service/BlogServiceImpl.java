package com.goeun.service;

import com.goeun.domain.BlogVO;
import com.goeun.persistence.BlogDAO;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl
  implements BlogService
{
  @Inject
  private BlogDAO dao;
  
  public BlogVO getBlogInformation(String email)
    throws Exception
  {
    return this.dao.getBlogInformation(email);
  }
  
  public void setDefaultInformation(String email)
    throws Exception
  {
    this.dao.setDefaultInformation(email);
  }
  
  public void updateBlogInformation(BlogVO vo)
    throws Exception
  {
    this.dao.updateBlogInformation(vo);
  }
}
