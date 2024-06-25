package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.Content0;
import com.example.demo.domain.Content1;
import com.example.demo.domain.Logindata;
import com.example.demo.domain.Page;
import com.example.demo.domain.Param;
import com.example.demo.domain.UserVO;

@Mapper
public interface UserMapper {
	
	@Select("SELECT TO_CHAR(SYSDATE, 'yyyy-mm-dd') FROM DUAL")
	public String selectNow();
	
	public List<UserVO> selectUserList();
	
	public List getAgentList();
	
	public List<Map> getHumanList();
	
	public List<Map> getMetaList();
	
	public List getMetaString();
	
	public List getUserString(Logindata login);
	
	public Map getUserValidListTotal(Page page);
	public List<Map> getUserValidList1();
	public List<Content0> getUserValidList(Page page);
	public Map getUserChangedListTotal(Page page);
	public List<Map> getUserChangedList(Page page);
	
	public List<Content0> getUserValid();
	
	public List<Map> getPositionList();
	public Map getPositionListTotal(Page page);
	public List<Map> getResponsibilitieList();
	public Map getResponsibilitieListTotal(Page page);
	public List<Map> getValidOrgunitList();
	public Map getValidOrgunitListTotal(Page page);
	public List<Map> getChangedOrgunitList();
	public Map getChangedOrgunitListTotal(Page page);
	
	//public String insertUser();
}