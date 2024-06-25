package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Content0;
import com.example.demo.domain.Content1;
import com.example.demo.domain.Logindata;
import com.example.demo.domain.Page;
import com.example.demo.domain.Param;
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
	public List getAgentList() {

		return userDao.getAgentList();
	}
	
	@Override
	public List<Map> getHumanList() {

		return userDao.getHumanList();
	}
	
	@Override
	public List<Map> getMetaList() {

		return userDao.getMetaList();
	}
	
	@Override
	public List getMetaString() {

		return userDao.getMetaString();
	}
	
	@Override
	public List getUserString(Logindata login) {

		return userDao.getUserString(login);
	}

	@Override
	public Map getUserValidListTotal(Page page) {

		return userDao.getUserValidListTotal(page);
	}
	
	@Override
	public List<Map> getUserValidList1() {

		return userDao.getUserValidList1();
	}
	
	@Override
	public List<Content0> getUserValidList(Page page) {

		return userDao.getUserValidList(page);
	}

	@Override
	public Map getUserChangedListTotal(Page page) {

		return userDao.getUserChangedListTotal(page);
	}
	
	@Override
	public List<Map> getUserChangedList(Page page) {

		return userDao.getUserChangedList(page);
	}
	
	@Override
	public List<Content0> getUserValid() {

		return userDao.getUserValid();
	}
	
	@Override
	public List<Map> getPositionList() {

		return userDao.getPositionList();
	}

	@Override
	public Map getPositionListTotal(Page page) {

		return userDao.getPositionListTotal(page);
	}
		
	@Override
	public List<Map> getResponsibilitieList() {

		return userDao.getResponsibilitieList();
	}
	
	@Override
	public Map getResponsibilitieListTotal(Page page) {

		return userDao.getResponsibilitieListTotal(page);
	}
	
	@Override
	public List<Map> getValidOrgunitList() {

		return userDao.getValidOrgunitList();
	}
	
	@Override
	public Map getValidOrgunitListTotal(Page page) {

		return userDao.getValidOrgunitListTotal(page);
	}
	
	@Override
	public List<Map> getChangedOrgunitList() {

		return userDao.getChangedOrgunitList();
	}
	
	@Override
	public Map getChangedOrgunitListTotal(Page page) {

		return userDao.getChangedOrgunitListTotal(page);
	}
	
	/*
	@Override
	public String insertUser() {

		return userDao.insertUser();
	}
	*/
}