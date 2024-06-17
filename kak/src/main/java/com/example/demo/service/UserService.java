package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.domain.UserVO;

public interface UserService {

	public String getNow();
	
	public List<UserVO> getUserList();

	public List<Map> getAgentList();

	public List getMetaList();
}