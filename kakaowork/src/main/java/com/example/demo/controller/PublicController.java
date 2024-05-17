package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.UserVo;
import com.example.demo.service.UserServiceImpl;



@Controller
public class PublicController {

	 @Autowired
		UserServiceImpl userServiceImpl;

		
		@GetMapping("user/list")
		public @ResponseBody List<UserVo> getUserList(){
			
			return userServiceImpl.getUserList();
		}
}
