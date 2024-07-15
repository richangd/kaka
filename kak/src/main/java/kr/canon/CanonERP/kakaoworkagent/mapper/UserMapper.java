package kr.canon.CanonERP.kakaoworkagent.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.canon.CanonERP.kakaoworkagent.domain.Content0;
import kr.canon.CanonERP.kakaoworkagent.domain.Content1;
import kr.canon.CanonERP.kakaoworkagent.domain.Logindata;
import kr.canon.CanonERP.kakaoworkagent.domain.Page;
import kr.canon.CanonERP.kakaoworkagent.domain.Param;
import kr.canon.CanonERP.kakaoworkagent.domain.UserVO;

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
	
	public List<Map> getPositionList(Page page);
	public Map getPositionListTotal(Page page);
	public List<Map> getResponsibilitieList(Page page);
	public Map getResponsibilitieListTotal(Page page);
	public List<Map> getValidOrgunitList(Page page);
	public Map getValidOrgunitListTotal(Page page);
	public List<Map> getChangedOrgunitList(Page page);
	public Map getChangedOrgunitListTotal(Page page);
	
	//public String insertUser();
}