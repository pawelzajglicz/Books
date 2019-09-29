package com.zajglicz.books.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController
{

	@RequestMapping("/")
	public String home(Model theModel)
	{
		
		return "home/home";
	}
	
}
