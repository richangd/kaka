package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.UserVo;


public interface UserService {

	public String getNow();
	
	public List<UserVo> getUserList();
}