package com.ap.exam.exam.controller;

import java.util.ArrayList;

import com.ap.exam.exam.redis.RedisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EightballController {

	@Autowired
	private RedisService service;

   @GetMapping("/askquestion")
   public String getAskForm(Model model) {

	   return "askQuestion";
   }


  
}
