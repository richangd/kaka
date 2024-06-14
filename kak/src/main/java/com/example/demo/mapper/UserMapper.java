package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.UserVO;

@Mapper
public interface UserMapper {
	
	@Select("SELECT TO_CHAR(SYSDATE, 'yyyy-mm-dd') FROM DUAL")
	public String selectNow();
	
	public List<UserVO> selectUserList();
	
	public List<Map> getAgentList();
}