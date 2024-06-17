package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.UserVO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userDao;

	@Override
	public String getNow() {

		return userDao.selectNow();
	}

	@Override
	public List<UserVO> getUserList() {

		return userDao.selectUserList();
	}
	
	@Override
	public List<Map> getAgentList() {

		return userDao.getAgentList();
	}
	
	@Override
	public List getMetaList() {

		return userDao.getMetaList();
	}

}