package com.goeun.persistence;

import com.goeun.domain.BlogVO;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BlogDAOImpl implements BlogDAO
{
  private String namespace = "com.goeun.mapper.BlogMapper";
  
  
  @Inject
  private SqlSession session;
  
  public BlogVO getBlogInformation(String email) throws Exception
  {
	  return this.session.selectOne(namespace + ".getBlogInformation", email);
  }
  
  public void setDefaultInformation(String email) throws Exception
  {
	  session.insert(namespace + ".setDefaultInformation", email);
  }
  
  public void updateBlogInformation(BlogVO vo) throws Exception
  {
	  session.update(namespace + ".updateBlogInformation", vo);
  }
}
