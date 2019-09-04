package com.ap.exam.exam.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

   @PostMapping("/askquestion")
	public String addQuestion(@RequestParam("question") String question, Model model) {

	if(this.service.exists("question")) {
		String answer = this.service.getKey(question);
	}
	else {
		Random rand = new Random();
		List<String> answers = Arrays.asList("It is certain","It is decidedly so","Without a doubt","Yes definitely","You may rely on it","As I see it, yes","Most likely","Outlook good","Yes","Signs point to yes","Reply hazy try again","Ask again later","Better not tell you now","Cannot predict now","Concentrate and ask again","Don't count on it","My reply is no","My sources say no","Outlook not so good","Very doubtful");
		int randomIndex = rand.nextInt(answers.size());
        String answer = answers.get(randomIndex);
		this.service.setKey("question", answer);
	}   
	return "redirect:answer";
	}

	@GetMapping("/answer")
   public String getAnswerForm(Model model) {
	   

	return "answer";
   }


}
