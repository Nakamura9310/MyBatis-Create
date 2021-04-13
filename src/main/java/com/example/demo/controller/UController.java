package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;
import com.example.demo.service.UService;

import java.util.List;


@Controller
@RequestMapping("/users")
public class UController {
	
	@Autowired
	private UService service;
	
	
	//select全件表示
	@GetMapping("/list")
	public String getEList(Model m) {
		List<User> userList =  service.getList();
		m.addAttribute("users", userList);
		return "users/list";
	}	
	
	//トップページ top.html表示
	@GetMapping("")
	public String top(Model m, @ModelAttribute User u) {
		m.addAttribute("users", service.getList()) ;
		return "users/top";
	}
	
	//top→[新規作成ボタン]押下 th:hrefにより生成されたURLをGETで表示
	@GetMapping("/register")
	public String registerUser(@ModelAttribute User u) {
		return "users/register";
	}
	
	//register.html内の <form method="post"> で↓へ飛ぶ
	@PostMapping("/register")
	public String create(@Validated @ModelAttribute User u, BindingResult result) {
		if (result.hasErrors()) {
			return "users/register";
		}
		
		service.insertOne(u);
		return "redirect:/users";
	}
		
}
