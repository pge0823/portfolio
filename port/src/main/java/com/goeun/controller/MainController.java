package com.goeun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController
{
  private final Logger logger = LoggerFactory.getLogger(MainController.class);
  
  @RequestMapping(value={"/"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String main(Model model)
    throws Exception
  {
    this.logger.info("call main.....");
    return "main/main";
  }
}