package com.goeun.controller;

import com.goeun.domain.BlogVO;
import com.goeun.domain.UserVO;
import com.goeun.service.BlogBoardService;
import com.goeun.service.BlogService;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"/blog"})
public class BlogController
{
  private static final Logger logger = LoggerFactory.getLogger(BlogController.class);
  @Inject
  private BlogService service;
  @Inject
  private BlogBoardService blogBoardSvc;
  
  @RequestMapping(value={"/{emailHeader}.{emailFooter}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String blog(@PathVariable("emailHeader") String emailHeader, @PathVariable("emailFooter") String emailFooter, Model model)
    throws Exception
  {
    String email = emailHeader + "." + emailFooter;
    BlogVO vo = this.service.getBlogInformation(email);
    model.addAttribute("blogVO", vo);
    
    return "blog/myblog";
  }
  
  @RequestMapping(value={"/setting"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public void blogSetting(Model model, HttpSession session, @RequestParam(required=false) String msg, RedirectAttributes rttr)
    throws Exception
  {
    UserVO uservo = (UserVO)session.getAttribute("login");
    if (uservo != null)
    {
      logger.info(uservo.toString());
      String email = uservo.getEmail();
      BlogVO vo = this.service.getBlogInformation(email);
      model.addAttribute("blogVO", vo);
    }
    rttr.addFlashAttribute("msg", msg);
  }
  
  @RequestMapping(value={"/setting"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String blogSetting(BlogVO vo, Model model) throws Exception
  {
    logger.info("blogSetting POST");
    logger.info(vo.toString());
    
    
    
    service.updateBlogInformation(vo);
    model.addAttribute("msg", "SUCCESS");
    
    return "/blog/setting";
  }
}