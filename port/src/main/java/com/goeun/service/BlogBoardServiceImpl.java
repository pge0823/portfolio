package com.goeun.service;

import com.goeun.domain.BlogBoardVO;
import com.goeun.domain.SearchCriteria;
import com.goeun.persistence.BlogBoardDAO;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlogBoardServiceImpl
  implements BlogBoardService
{
  @Inject
  BlogBoardDAO dao;
  
  public List<BlogBoardVO> listBoard(SearchCriteria cri)
    throws Exception
  {
    return this.dao.list(cri);
  }
  
  @Transactional
  public BlogBoardVO read(BlogBoardVO vo)
    throws Exception
  {
    this.dao.updateViewCnt(vo);
    return this.dao.read(vo);
  }
  
  public int getTotalBoardCount(SearchCriteria cri)
    throws Exception
  {
    return this.dao.totalCount(cri);
  }
  
  public void createNewPage(BlogBoardVO vo)
    throws Exception
  {
    this.dao.create(vo);
  }
  
  public void updatePage(BlogBoardVO vo)
    throws Exception
  {
    this.dao.update(vo);
  }
  
  public void deletePage(BlogBoardVO vo)
    throws Exception
  {
    this.dao.delete(vo);
  }
  
  public List<BlogBoardVO> topThreePopularPost(String email)
    throws Exception
  {
    return this.dao.topThreePopularPost(email);
  }
  
  public int upperBnoCount(Object obj)
    throws Exception
  {
    return this.dao.upperBnoCount(obj);
  }
}
