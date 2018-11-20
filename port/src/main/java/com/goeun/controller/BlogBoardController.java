package com.goeun.controller;

import com.goeun.domain.BlogBoardVO;
import com.goeun.domain.BlogVO;
import com.goeun.domain.PageMaker;
import com.goeun.domain.SearchCriteria;
import com.goeun.service.BlogBoardService;
import com.goeun.service.BlogService;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/blog/{email:.+}/board"})
public class BlogBoardController
{
  private static final Logger logger = LoggerFactory.getLogger(BlogBoardController.class);
  @Inject
  private BlogService blogSvc;
  @Inject
  private BlogBoardService blogBoardSvc;
  
  @RequestMapping(value={"/readPage"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String readPage(@RequestParam int page, @RequestParam int bno, @PathVariable String email, @RequestParam String keyword, @RequestParam String searchType, Model model)
    throws Exception
  {
    logger.info("call readPage " + email);
    logger.info("keyword = " + keyword + " searchType = " + searchType);
    
    BlogVO blogVO = this.blogSvc.getBlogInformation(email);
    
    BlogBoardVO temp = new BlogBoardVO();
    temp.setBno(Integer.valueOf(bno));
    temp.setEmail(email);
    BlogBoardVO blogBoardVO = this.blogBoardSvc.read(temp);
    
    model.addAttribute("page", Integer.valueOf(page));
    model.addAttribute("blogVO", blogVO);
    model.addAttribute("keyword", keyword);
    model.addAttribute("searchType", searchType);
    model.addAttribute("blogBoardVO", blogBoardVO);
    
    return "blog/readPage";
  }
  
  @RequestMapping(value={"/register"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String register(@PathVariable("email") String email)
  {
    logger.info("call register GET " + email);
    
    return "blog/register";
  }
  
  @RequestMapping(value={"/register"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String register(@PathVariable("email") String email, BlogBoardVO board)
  {
    logger.info("call register POST " + email);
    
    return "redirect:";
  }
  
  @RequestMapping({""})
  public String board(@RequestParam(required=false) String page, @RequestParam(required=false) String keyword, @RequestParam(required=false) String searchType, @PathVariable("email") String email, Model model)
    throws Exception
  {
    logger.info("call board " + email);
    int pageNum = (page == null) || (Integer.parseInt(page) <= 0) ? 1 : Integer.parseInt(page);
    
    BlogVO vo = this.blogSvc.getBlogInformation(email);
    model.addAttribute("page", Integer.valueOf(pageNum));
    model.addAttribute("keyword", keyword);
    model.addAttribute("searchType", searchType);
    model.addAttribute("blogVO", vo);
    return "blog/board";
  }
  
  @ResponseBody
  @RequestMapping(value={"/list"}, method=RequestMethod.GET)
  public ResponseEntity<Map<String, Object>> boardList(@PathVariable("email") String email, @ModelAttribute SearchCriteria cri)
    throws Exception
  {
    logger.info("call list" + email);
    ResponseEntity<Map<String, Object>> entity = null;
    try
    {
      cri.setEmail(email);
      
      cri.setKeyword(decoding(cri.getKeyword()));
      
      PageMaker pageMaker = new PageMaker();
      pageMaker.setCri(cri);
      
      Map<String, Object> map = new HashMap<>();
      List<BlogBoardVO> list = blogBoardSvc.listBoard(cri);
      
      map.put("list", list);
      
      int boardCount = blogBoardSvc.getTotalBoardCount(cri);
      pageMaker.setTotalCount(boardCount);
      
      logger.info("boardCount = " + boardCount);
      logger.info("pageMaker = " +pageMaker.toString());
      
      
      map.put("pageMaker", pageMaker);
      
      
      entity = new ResponseEntity<>(map, HttpStatus.OK);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return entity;
  }
  
  @RequestMapping(value={"/newPage"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String newPage(@PathVariable String email, Model model)
    throws Exception
  {
    logger.info("call newPage GET " + email);
    BlogVO vo = this.blogSvc.getBlogInformation(email);
    
    model.addAttribute("blogVO", vo);
    return "blog/newPage";
  }
  
  @RequestMapping(value={"/newPage"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String registNewPage(@PathVariable String email, BlogBoardVO vo)
    throws Exception
  {
    logger.info("call newPage POST " + email);
    vo.setEmail(email);
    this.blogBoardSvc.createNewPage(vo);
    return "redirect:/blog/" + email + "/board";
  }
  
  @ResponseBody
  @RequestMapping(value={"/{bno}"}, method={org.springframework.web.bind.annotation.RequestMethod.PUT, org.springframework.web.bind.annotation.RequestMethod.PATCH})
  public ResponseEntity<String> updatePage(@PathVariable String email, @RequestBody BlogBoardVO vo)
    throws Exception
  {
    logger.info("call updatePage bno=" + vo.getBno());
    
    ResponseEntity<String> entity = null;
    try
    {
      vo.setEmail(email);
      
      this.blogBoardSvc.updatePage(vo);
      entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }
    catch (Exception e)
    {
      entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    return entity;
  }
  
  @ResponseBody
  @RequestMapping(value={"/{bno}"}, method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
  public ResponseEntity<String> deletePage(@PathVariable String email, @PathVariable int bno)
    throws Exception
  {
    logger.info("call deletePage bno=" + bno);
    ResponseEntity<String> entity = null;
    BlogBoardVO vo = new BlogBoardVO();
    vo.setBno(Integer.valueOf(bno));
    vo.setEmail(email);
    try
    {
      this.blogBoardSvc.deletePage(vo);
      entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }
    catch (Exception e)
    {
      entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    return entity;
  }
  
  @ResponseBody
  @RequestMapping(value={"/popularPost"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public ResponseEntity<Map<String, Object>> popularPost(@PathVariable String email)
    throws Exception
  {
    logger.info("call popularPost " + email);
    ResponseEntity<Map<String, Object>> entity = null;
    try
    {
      Map<String, Object> resultMap = new HashMap<>();
      
      List<BlogBoardVO> list = blogBoardSvc.topThreePopularPost(email);
      List<Integer> pageList = new ArrayList<>();
      for (int i = 0; i < list.size(); i++)
      {
        int bno = ((BlogBoardVO)list.get(i)).getBno().intValue();
        Map<String, Object> map = new HashMap<>();
        map.put("bno", Integer.valueOf(bno));
        map.put("email", email);
        
        int page = (int)Math.ceil(this.blogBoardSvc.upperBnoCount(map) / 10.0D);
        logger.info("������ pageNum : " + page + " ������ upperBnoCount" + blogBoardSvc.upperBnoCount(map));
        pageList.add(Integer.valueOf(page == 0 ? 1 : page));
      }
      resultMap.put("list", list);
      resultMap.put("pageList", pageList);
      
      entity = new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return entity;
  }
  
  private String decoding(String keyword)
  {
    if ((keyword == null) || (keyword.trim().length() == 0)) {
      return "";
    }
    try
    {
      return URLDecoder.decode(keyword, "UTF-8");
    }
    catch (UnsupportedEncodingException e) {}
    return "";
  }
}