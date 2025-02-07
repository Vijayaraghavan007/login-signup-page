package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class control {
	@Autowired
	agent a;
		@RequestMapping("signup")
		String signup() {
			return"signup";
		}
		
		@RequestMapping("/add")
		String add(@RequestParam String name, String email, String phnum, String password) {
			getset t = new getset();
			t.setName(name);
			t.setEmail(email);
			t.setPhnum(phnum);
			t.setPassword(password);
			a.save(t);
			return"login";
		}
		@RequestMapping("login")
		String login() {
			return"login";
		}
		
		@RequestMapping("log")
		String log(@RequestParam String email, String password, Model model)
		{
			getset e = a.findByEmail(email);
			if(e.getPassword().equals(password))
			{
				model.addAttribute("user", e);
				return "sucess";
			}
			else {
				model.addAttribute("msg", "Your login details is Worng");
				return "login";
			}
			
		}
}









