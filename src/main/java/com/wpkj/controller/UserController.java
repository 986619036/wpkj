package com.wpkj.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wpkj.domain.ResultMap;
import com.wpkj.domain.Usert;
import com.wpkj.service.UsertService;

@Controller
@RequestMapping("/user")
public class UserController {
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
		return "user";  
	}
	@ResponseBody
	@RequestMapping(value="/showUserList",method = { RequestMethod.GET,RequestMethod.POST})//,produces="/text/html;charset=UTF-8"
	public PageInfo<Usert> index1(@RequestParam(required=true,defaultValue="1") Integer page,Integer pageSize,HttpServletRequest request,Model model) {
		PageHelper.startPage(page, pageSize);
		List<Usert> list=usertService.userList();
		PageInfo<Usert> p=new PageInfo<Usert>(list);
		return p;  
	}
	@RequestMapping(value="insertUsert")
    public @ResponseBody Map<String, Object> insertUsert( Usert usert) throws Exception{
		
        return usertService.insertUsert(usert);
    }
	@RequestMapping(value="updateUsert")
    public @ResponseBody ResultMap updateUsert( Usert usert) throws Exception{
		ResultMap resultMap=new ResultMap();
		if(usertService.updateUsert(usert).get("state").equals("200")) {
			resultMap.setState("200");
		}
		
		
		
        return resultMap;
    }
	@RequestMapping(value="deleteUsert")
    public @ResponseBody Map<String, Object> deleteUsert( Usert usert) throws Exception{
		
        return usertService.deleteUsert(usert);
    }
}
