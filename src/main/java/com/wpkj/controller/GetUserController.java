package com.wpkj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wpkj.domain.Usert;
import com.wpkj.service.UsertService;

@Controller
@RequestMapping("/ZyxxController")
public class GetUserController {
	public UsertService usertService;
	@Autowired
	public void setUsertService(UsertService usertService) {
		this.usertService = usertService;
	}
	@RequestMapping("/showUser")
	public String index(HttpServletRequest request,Model model) {
		int userid=Integer.parseInt(request.getParameter("id"));
		Usert ser=usertService.getEntity(userid);
		System.out.println("controller");
		model.addAttribute("user", ser);
		return "user1";  
	}
}
