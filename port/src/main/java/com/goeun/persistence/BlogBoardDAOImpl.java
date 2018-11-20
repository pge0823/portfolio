package com.goeun.persistence;

import com.goeun.domain.BlogBoardVO;
import com.goeun.domain.SearchCriteria;
import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BlogBoardDAOImpl implements BlogBoardDAO
{
  @Inject SqlSession session;
  
  private String namespace = "com.goeun.mapper.BlogBoardMapper";
  
  public List<BlogBoardVO> list(SearchCriteria cri) throws Exception
  {
	  return session.selectList(namespace + ".boardList", cri);
  }
  
  public BlogBoardVO read(BlogBoardVO vo)throws Exception
  {
	  return session.selectOne(namespace + ".read", vo);
  }
  
  public void create(BlogBoardVO vo)throws Exception
  {
	  session.insert(namespace + ".create", vo);
  }
  
  public void update(BlogBoardVO vo) throws Exception
  {
	  session.update(namespace + ".update", vo);
  }
  
  public void delete(BlogBoardVO vo) throws Exception
  {
	  session.delete(this.namespace + ".delete", vo);
  }
  
  public int totalCount(SearchCriteria cri) throws Exception
  {
	  return session.selectOne(namespace + ".totalCount", cri);
  }
  
  public void updateViewCnt(BlogBoardVO vo) throws Exception
  {
	  session.update(namespace + ".updateViewCnt", vo);
  }
  
  public List<BlogBoardVO> topThreePopularPost(String email) throws Exception
  {
	  return session.selectList(namespace + ".topThreePopularPost", email);
  }
  
  public int upperBnoCount(Object obj) throws Exception
  {
	  return this.session.selectOne(this.namespace + ".upperBnoCount", obj);
  }
}
