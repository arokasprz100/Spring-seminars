package com.javasampleapproach.springsecurity.jdbcauthentication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WebController {
   
	private static final Logger logger=LoggerFactory.getLogger(WebController.class);
	
    @RequestMapping(value="/")
    public String home(){
        return "home";
    }
   
    @RequestMapping(value="/user")
    public String user(){
        return "user";
    }
  
    @RequestMapping(value="/admin")
    public String admin(){
        return "admin";
    }
   
    @RequestMapping(value="/login")
    public String login(){
        return "login";
    }
   
    @RequestMapping(value="/403")
    public String Error403(){
    	logger.error("An error occured");
        return "403";
    }
}
