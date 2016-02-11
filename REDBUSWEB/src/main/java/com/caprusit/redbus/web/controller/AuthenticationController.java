package com.caprusit.redbus.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthenticationController {
	
	@RequestMapping(value="/hi")
	public @ResponseBody String getHome(){
		System.out.println("controller excuting fine");
		return "working fine";
	}

}
