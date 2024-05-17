package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.UserVo;
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
	public List<UserVo> getUserList() {

		return userDao.selectUserList();
	}

}
