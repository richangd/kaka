package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Content;
import com.example.demo.domain.Player;
import com.example.demo.domain.UserVO;
import com.example.demo.domain.ValidVo;
import com.example.demo.domain.agentVo;
import com.example.demo.domain.more_telephones;
import com.example.demo.domain.more_telephones1;
import com.example.demo.exeption.MissingRequiredHeaderException;
import com.example.demo.service.impl.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UserController {
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger("KAKAOWORK");
	
	@Autowired
	UserServiceImpl userServiceImpl;

	@GetMapping("user/list")
	public @ResponseBody List<UserVO> getUserList(){
		
		return userServiceImpl.getUserList();
	}
	
	@GetMapping("agent/list")
	public List<Map> getagentList(){
		
		return userServiceImpl.getAgentList();
	}
	
	@GetMapping("/agent/v0/getAgentCapabilities")
	public agentVo getAgentCapabilities(@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
    	
    	logger.info("api/agent/v0/getAgentCapabilities");
 	   	
    	agentVo ag = new agentVo();
    	if (OrgLoginType == null) {
            throw new MissingRequiredHeaderException("The required header is missing.");
        }else {
        	String g1 = "agent";
    		String g2 = "user";
    		String g3 = "login";
    		String g4 = "orgunit";
    		
        	ag = new agentVo(200, "ok", new String[]{g2, g4});
        }
        return ag;
    }    
	
}