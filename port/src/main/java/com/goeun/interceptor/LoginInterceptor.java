package com.goeun.interceptor;

import com.goeun.domain.UserVO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor
  extends HandlerInterceptorAdapter
{
  private static final String LOGIN = "login";
  private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
  
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
    throws Exception
  {
    HttpSession session = request.getSession();
    
    ModelMap modelMap = modelAndView.getModelMap();
    
    Object userVO = modelMap.get("userVO");
    String page = null;
    if (userVO != null)
    {
      logger.info("new login success");
      logger.info(((UserVO)userVO).getEmail());
      session.setAttribute(LOGIN, userVO);
      
      if(request.getParameter("useCookie") !=null) {
    	  logger.info("make Cookie !");
    	  Cookie loginCookie = new Cookie("loginCookie", session.getId());
    	  
    	  loginCookie.setPath("/");
    	  loginCookie.setMaxAge(60*60*24*7);
    	  response.addCookie(loginCookie);
      }
      
      
      page = (String)session.getAttribute("dest");
    }
    else
    {
      page = "/user/loginFail";
    }
    response.sendRedirect(page != null ? page : "/");
  }
  
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    throws Exception
  {
    HttpSession session = request.getSession();
    logger.info(request.getRequestURI() + "preHandle");
    if (session.getAttribute("login") != null)
    {
      logger.info("clear login data before");
      
      session.removeAttribute("login");
    }
    return true;
  }
}
