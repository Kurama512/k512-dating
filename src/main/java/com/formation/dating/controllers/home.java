package com.formation.dating.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class home {
	
	@GetMapping("/dating/index")
	public String getIndex(ModelMap model){	
		return ("/index");
	}

}
