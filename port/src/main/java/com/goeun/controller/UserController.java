package com.goeun.controller;

import com.goeun.domain.UserVO;
import com.goeun.dto.LoginDTO;
import com.goeun.service.UserService;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

@Controller
@RequestMapping({"/user"})
public class UserController
{
  private final Logger logger = LoggerFactory.getLogger(UserController.class);
  @Inject
  UserService service;
  
  @RequestMapping(value={"/register"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String register()
    throws Exception
  {
    return "user/register";
  }
  
  @RequestMapping(value={"/register"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String register(UserVO vo)
    throws Exception
  {
    this.logger.info(vo.toString() + "�������� ����");
    this.service.register(vo);
    return "redirect:/";
  }
  
  @RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String loginGET()
  {
    return "user/login";
  }
  
  @RequestMapping(value={"/loginPost"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public void loginPost(LoginDTO dto, HttpSession session, Model model)
    throws Exception
  {
    logger.info("loginPost.....");
    UserVO vo = this.service.login(dto);
    if (vo == null) {
      return;
    }
    model.addAttribute("userVO", vo);
    
    if(dto.isUseCookie()) {
    	int amount = 60*60*24*7;
    	
    	Date sessionLimit = new Date(System.currentTimeMillis()+(1000*amount));
    	
    	service.keepLogin(vo.getEmail(), session.getId(), sessionLimit);
    }
  }
  
  @RequestMapping(value={"/logout"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception
  {
    Object obj = session.getAttribute("login");
    
    if(obj!=null) {
    	UserVO vo = (UserVO) obj;
    	
    	session.removeAttribute("login");
    	session.invalidate();
    	
    	Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
    	
    	if(loginCookie!=null) {
    		loginCookie.setPath("/");
    		loginCookie.setMaxAge(0);
    		response.addCookie(loginCookie);
    		service.keepLogin(vo.getEmail(), session.getId(), new Date());
    	}
    	
    }
	  
    logger.info("logout..........");
    return "redirect:/";
  }
  
  @RequestMapping(value={"/loginFail"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String loginFail(RedirectAttributes rttr) throws Exception
  {
    this.logger.info("loginFail........");
    rttr.addFlashAttribute("loginFail", "FAIL");
    return "redirect:/user/login";
  }
}