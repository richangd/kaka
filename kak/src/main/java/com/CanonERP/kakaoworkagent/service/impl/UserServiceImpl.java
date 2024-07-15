package com.CanonERP.kakaoworkagent.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CanonERP.kakaoworkagent.domain.Content0;
import com.CanonERP.kakaoworkagent.domain.Content1;
import com.CanonERP.kakaoworkagent.domain.Logindata;
import com.CanonERP.kakaoworkagent.domain.Page;
import com.CanonERP.kakaoworkagent.domain.Param;
import com.CanonERP.kakaoworkagent.domain.UserVO;
import com.CanonERP.kakaoworkagent.mapper.UserMapper;
import com.CanonERP.kakaoworkagent.service.UserService;

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
	public List<Map> getPositionList(Page page) {

		return userDao.getPositionList(page);
	}

	@Override
	public Map getPositionListTotal(Page page) {

		return userDao.getPositionListTotal(page);
	}
		
	@Override
	public List<Map> getResponsibilitieList(Page page) {

		return userDao.getResponsibilitieList(page);
	}
	
	@Override
	public Map getResponsibilitieListTotal(Page page) {

		return userDao.getResponsibilitieListTotal(page);
	}
	
	@Override
	public List<Map> getValidOrgunitList(Page page) {

		return userDao.getValidOrgunitList(page);
	}
	
	@Override
	public Map getValidOrgunitListTotal(Page page) {

		return userDao.getValidOrgunitListTotal(page);
	}
	
	@Override
	public List<Map> getChangedOrgunitList(Page page) {

		return userDao.getChangedOrgunitList(page);
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