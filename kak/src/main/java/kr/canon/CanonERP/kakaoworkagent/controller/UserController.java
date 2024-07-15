package kr.canon.CanonERP.kakaoworkagent.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.canon.CanonERP.kakaoworkagent.domain.Content;
import kr.canon.CanonERP.kakaoworkagent.domain.Content0;
import kr.canon.CanonERP.kakaoworkagent.domain.Content1;
import kr.canon.CanonERP.kakaoworkagent.domain.Content2;
import kr.canon.CanonERP.kakaoworkagent.domain.Content3;
import kr.canon.CanonERP.kakaoworkagent.domain.Logindata;
import kr.canon.CanonERP.kakaoworkagent.domain.MetadataVo;
import kr.canon.CanonERP.kakaoworkagent.domain.Page;
import kr.canon.CanonERP.kakaoworkagent.domain.Param;
import kr.canon.CanonERP.kakaoworkagent.domain.Player;
import kr.canon.CanonERP.kakaoworkagent.domain.Profile;
import kr.canon.CanonERP.kakaoworkagent.domain.Report;
import kr.canon.CanonERP.kakaoworkagent.domain.ReportVo;
import kr.canon.CanonERP.kakaoworkagent.domain.UserExtra;
import kr.canon.CanonERP.kakaoworkagent.domain.UserVO;
import kr.canon.CanonERP.kakaoworkagent.domain.Valid;
import kr.canon.CanonERP.kakaoworkagent.domain.ValidVo;
import kr.canon.CanonERP.kakaoworkagent.domain.agentVo;
import kr.canon.CanonERP.kakaoworkagent.domain.departments;
import kr.canon.CanonERP.kakaoworkagent.domain.editability;
import kr.canon.CanonERP.kakaoworkagent.domain.idreturn;
import kr.canon.CanonERP.kakaoworkagent.domain.more_telephones;
import kr.canon.CanonERP.kakaoworkagent.domain.more_telephones1;
import kr.canon.CanonERP.kakaoworkagent.domain.orgunit;
import kr.canon.CanonERP.kakaoworkagent.domain.synchronize_options;
import kr.canon.CanonERP.kakaoworkagent.domain.telephones;
import kr.canon.CanonERP.kakaoworkagent.exeption.MissingRequiredHeaderException;
import kr.canon.CanonERP.kakaoworkagent.orgunits.domain.ChangeOrgContent;
import kr.canon.CanonERP.kakaoworkagent.orgunits.domain.ChangeOrgVo;
import kr.canon.CanonERP.kakaoworkagent.orgunits.domain.PosiContent;
import kr.canon.CanonERP.kakaoworkagent.orgunits.domain.PositionVo;
import kr.canon.CanonERP.kakaoworkagent.orgunits.domain.ResponsContent;
import kr.canon.CanonERP.kakaoworkagent.orgunits.domain.ResponsibilVo;
import kr.canon.CanonERP.kakaoworkagent.orgunits.domain.VaContent;
import kr.canon.CanonERP.kakaoworkagent.orgunits.domain.ValidunitVo;
import kr.canon.CanonERP.kakaoworkagent.service.impl.UserServiceImpl;

@RequestMapping(value = "api")
@RestController
public class UserController {
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger("KAKAOWORK");
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	/* id/pw 관련 API
	 * 
	 * */
	
	@PostMapping("/login/v0/identifyUser")
	   public idreturn post(@RequestBody Param param, @RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
		   logger.info("api/login/v0/identifyUser");
		   logger.info(param.getpassword());
		   logger.info(param.getidentifier());
		   logger.info(OrgLoginType);
		   
		   idreturn id = new idreturn();
		   Logindata lg = new Logindata(param.getidentifier());
		   List login = userServiceImpl.getUserString(lg);
		   String a = login.get(0).toString();
		   String pw;
		   
		   if(param.getpassword() == null) {
			   pw = "1";
		   }else {
			   pw = param.getpassword();
		   }		   
		   
		   if (OrgLoginType == null) {
	           throw new MissingRequiredHeaderException("The required header is missing.");
	       }else if(a.equals(pw)){
	    	   id = new idreturn("SUCCESS", "AUTH_SUCCESS", 200, "OK");
	       }else {
	    	   id = new idreturn("FAILURE", "AUTH_FAIL", 401, "Unauthorized");    	   
	       }	   
		   
	       return id;
	   }
	
	/* Agent 구현 모듈에 대한 설정 API
	 * 
	 * */
	
	@GetMapping("/agent/v0/getAgentCapabilities")
	public agentVo getAgentCapabilities(@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
    	
    	logger.info("api/agent/v0/getAgentCapabilities");
 	   	
    	agentVo ag = new agentVo();
    	
    	List agent = userServiceImpl.getAgentList();
    	
    	if (OrgLoginType == null) {
            throw new MissingRequiredHeaderException("The required header is missing.");
        }else {
    	ag = new agentVo(200, "ok", agent);
        }
    	
    	return ag;
    }
	
	/* USER 메타정보 대한 설정 API
	 * 
	 * */
	 @GetMapping("/user/v0/getUserMetadata")
	    public MetadataVo getUserMetadata(@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
	        
	    	logger.info("api/user/v0/getUserMetadata"); 		    	
	    	
	    	List<synchronize_options> sy= new ArrayList();
	    	MetadataVo ag = new MetadataVo();
	    	
	    	List agent = userServiceImpl.getMetaString();
	    		    	
	    	agent.get(0);
	    	
	    	telephones te = new telephones(agent.get(4).toString(), agent.get(5).toString());
	    	editability ed = new editability(agent.get(0).toString(), agent.get(1).toString(), agent.get(2).toString(), agent.get(3).toString(), 
	    			te, agent.get(6).toString(), agent.get(7).toString(), agent.get(8).toString(), agent.get(9).toString());
	    	Profile pr = new Profile(ed);

	    	sy.add(new synchronize_options(agent.get(10).toString(), agent.get(11).toString()));
	    	
	    	
	    	if (OrgLoginType == null) {
	            throw new MissingRequiredHeaderException("The required header is missing.");
	        }else {
	        	 ag = new MetadataVo(pr, sy);
	        }
	        return ag;
	    }
	
	 /* 에러 발생에 대한 알림 API
		 * 
		 * */ 
	 
	@PostMapping("/agent/v0/reportError")
    public ReportVo post(@RequestBody Report report, @RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
    	logger.info("api/agent/v0/reportError");
 	   	logger.info(report.getCapability());
 	   	logger.info(report.getMessage());
    	
    	ReportVo re = new ReportVo();
    	String Capab = report.getCapability();
    	Integer Co = report.getCode();
    	
    	if (OrgLoginType == null || Capab.length() == 0 || Co <= 0) {
            throw new MissingRequiredHeaderException("The required header is missing.");
        }else {
        	re = new ReportVo(200, "ok");
        }
    	    	
        return re;
    }
	
	/* 사원정보에 대한 유효성 검증 API
	 * 
	 * */
	
	@GetMapping("/user/v0/getValidUsers")
	public String getAgentCapabilit1(@RequestParam(value = "page_number", defaultValue = "0") String page_number,
			@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
	 	logger.info("api/user/v0/getValidUsers");
	 
	 	String jsonString = null;
    	ValidVo va = new ValidVo();
    	boolean first_page;
		boolean last_page;
					
		
		Page page = new Page(page_number);
		
		Map valv = userServiceImpl.getUserValidListTotal(page);
		List<Content0> m1 = userServiceImpl.getUserValidList(page);
		
		String pp = valv.getOrDefault("TOTAL_PAGE", "0").toString();
		
		if(page_number.equals("1")) {
			first_page = true;
		}else {
			first_page = false;
		}
		
		if(page_number == pp) {
			last_page = true;
		}else {
			last_page = false;
		}	
    	
		if (OrgLoginType == null || page_number.equals("0")) {
            throw new MissingRequiredHeaderException("The required header is missing.");
        }else {
        	va = new ValidVo(200, "ok", Integer.parseInt(valv.getOrDefault("TOTAL_PAGE", "0").toString()), 
        			Integer.parseInt(valv.getOrDefault("TOTAL_COUNT", "0").toString()), 
        			200, page_number, m1.size(), last_page, first_page, m1);
        }
    	
    	ObjectMapper objectMapper = new ObjectMapper();
		
        try {
            // 객체를 JSON 문자열로 변환
            jsonString = objectMapper.writeValueAsString(va);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        
        logger.info(jsonString);
        
        return jsonString;
    }
	
	/* 사원정보에 대한 변경 데이터 적용 API
	 * 
	 * */
		
	@GetMapping("/user/v0/getChangedUsers")			
    public String getgetChangedUsers(@RequestParam(value = "page_number", defaultValue = "0") String page_number,     		
    		@RequestParam(value = "basis_time", defaultValue = "0") String basistime,
    		@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
		logger.info("api/user/v0/getChangedUsers");
		
		String jsonString = null;
    	ValidVo va = new ValidVo();
    	boolean first_page;
		boolean last_page;
					
		Page page = new Page(page_number);
		
		List m1 = userServiceImpl.getUserChangedList(page);
		Map valv = userServiceImpl.getUserChangedListTotal(page);		
		List mo = new ArrayList();		
		
		String pp = valv.getOrDefault("TOTAL_PAGE", "0").toString();
		
		if(page_number.equals("1")) {
			first_page = true;
		}else {
			first_page = false;
		}
		
		if(page_number == pp) {
			last_page = true;
		}else {
			last_page = false;
		}			
    	
		if (OrgLoginType == null || page_number.equals("0") || basistime.equals("0")) {
            throw new MissingRequiredHeaderException("The required header is missing.");
        }else {
        	va = new ValidVo(200, "ok", Integer.parseInt(valv.getOrDefault("TOTAL_PAGE", "0").toString()), 
        			Integer.parseInt(valv.getOrDefault("TOTAL_COUNT", "0").toString()), 
        			200, page_number, m1.size(), last_page, first_page, m1);
        }
    	
    	ObjectMapper objectMapper = new ObjectMapper();
		
        try {
            // 객체를 JSON 문자열로 변환
            jsonString = objectMapper.writeValueAsString(va);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        
        logger.info(jsonString);
        
        return jsonString;		
    }    
	
	
	/* 직위정보에 대한 API
	 * 데이터 삭제 후 다시 추가해주는 방식
	 * */
	
	 @GetMapping("/orgunit/v0/getPositions")
	    public String getPositions(@RequestParam(value = "page_number", defaultValue = "0") String page_number,
	    		@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
	        
			logger.info("api/orgunit/v0/getPositions");
			
			String jsonString =null;
			ObjectMapper objectMapper = new ObjectMapper();
			boolean first_page;
			boolean last_page;
			
			PositionVo Po = new PositionVo();
			
			Page page = new Page(page_number);
			List Poc = userServiceImpl.getPositionList(page);		
			Map m = userServiceImpl.getPositionListTotal(page);
			
			String pp = m.getOrDefault("TOTAL_PAGE", "0").toString();
			
			if(page_number.equals("1")) {
				first_page = true;
			}else {
				first_page = false;
			}
			
			if(page_number == pp) {
				last_page = true;
			}else {
				last_page = false;
			}
			
			if (OrgLoginType == null || page_number.equals("0")) {
	            throw new MissingRequiredHeaderException("The required header is missing.");
	        }else {
	        	Po = new PositionVo(200, "ok", Integer.parseInt(m.getOrDefault("TOTAL_PAGE", "0").toString()), 
	        			Integer.parseInt(m.getOrDefault("TOTAL_COUNT", "0").toString()), 200, page_number, 
	        			Poc.size(), last_page, first_page, Poc);
	        }
			
			try {
	            // 객체를 JSON 문자열로 변환
	            jsonString  = objectMapper.writeValueAsString(Po);
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	        }
			
			logger.info(jsonString);
			
	        return jsonString;
	    }
	 
	 /* 직책정보에 대한 API
		 * 데이터 삭제 후 다시 추가
		 * */
	
	 @GetMapping("/orgunit/v0/getResponsibilities")
	    public String getResponsibilities(@RequestParam(value = "page_number", defaultValue = "0") String page_number, 
	    		@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
	        
			logger.info("api/orgunit/v0/getResponsibilities");
			
			String jsonString =null;
			ObjectMapper objectMapper = new ObjectMapper();
			
			ResponsibilVo Rev = new ResponsibilVo();
			boolean first_page;
			boolean last_page;			
			
			Page page = new Page(page_number);
			List rco = userServiceImpl.getResponsibilitieList(page);		
			Map m = userServiceImpl.getResponsibilitieListTotal(page);

			String pp = m.getOrDefault("TOTAL_PAGE", "0").toString();
			
			if(page_number.equals("1")) {
				first_page = true;
			}else {
				first_page = false;
			}
			
			if(page_number == pp) {
				last_page = true;
			}else {
				last_page = false;
			}	
			
			if (OrgLoginType == null || page_number.equals("0")) {
	            throw new MissingRequiredHeaderException("The required header is missing.");
	        }else {
	        	Rev = new ResponsibilVo(200, "ok", Integer.parseInt(m.getOrDefault("TOTAL_PAGE", "0").toString()), 
	        			Integer.parseInt(m.getOrDefault("TOTAL_COUNT", "0").toString()), 200, page_number, 
	        			rco.size(), last_page, first_page, rco);
	        }
			
			try {
	            // 객체를 JSON 문자열로 변환
	            jsonString  = objectMapper.writeValueAsString(Rev);
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	        }
			
			logger.info(jsonString);
			
	        return jsonString;
	    }
	 /*
	 @GetMapping("/orgunit/v0/getChangedOrgunits")
	    public String getChangedOrgunits(@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
			
			logger.info("api/orgunit/v0/getChangedOrgunits");
			
			String jsonString =null;
			ChangeOrgVo chorg = new ChangeOrgVo();
			List<ChangeOrgContent> chorgco = new ArrayList();
			
			chorgco.add(new ChangeOrgContent("REGISTERED", "21", "캐논코리아", "#", false, 0));
			chorgco.add(new ChangeOrgContent("REGISTERED", "22", "카카오게임즈", "21", false, 0));
			chorgco.add(new ChangeOrgContent("REGISTERED", "MTS", "MTS마케팅", "21", false, 0));
			chorgco.add(new ChangeOrgContent("REGISTERED", "MTSM", "MTS마케팅", "MTS", false, 0));
			
			
			if (OrgLoginType == null) {
	            throw new MissingRequiredHeaderException("The required header is missing.");
	        }else {
	        	chorg = new ChangeOrgVo(200, "ok", 1, 10, 500, "1", 500, true, true, chorgco);
	        }    	
	    	
			ObjectMapper objectMapper = new ObjectMapper();
			
	        
			try {
	            // 객체를 JSON 문자열로 변환
	            jsonString  = objectMapper.writeValueAsString(chorg);
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	        }
			
			logger.info(jsonString);
			
	        return jsonString;
	    }
		
			
		@GetMapping("/orgunit/v0/getValidOrgunits")
	    public String getValidOrgunits(@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
	        
			logger.info("api/orgunit/v0/getValidOrgunits");
			
			String jsonString =null;
			ValidunitVo va = new ValidunitVo();
			List<VaContent> co = new ArrayList();
			
			co.add(new VaContent("ACTIVE", "21", "캐논코리아", "#", false, 0));
			
			
			if (OrgLoginType == null) {
	            throw new MissingRequiredHeaderException("The required header is missing.");
	        }else {
	        	va = new ValidunitVo(200, "ok", 1, 1, 10, "1", 10, true, true, co);
	        }    	
	    	
			ObjectMapper objectMapper = new ObjectMapper();
			
	        
			try {
	            // 객체를 JSON 문자열로 변환
	            jsonString  = objectMapper.writeValueAsString(va);
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	        }
			
			logger.info(jsonString);
			
	        return jsonString;
			
	    }	
	 
	 /* 조직도 대한 유효성 검증 API
		 * 
		 * */
	 
	 @GetMapping("/orgunit/v0/getValidOrgunits")
	    public String getValidOrgunits(@RequestParam(value = "page_number", defaultValue = "0") String page_number,
	    		@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
	        
			logger.info("api/orgunit/v0/getValidOrgunits");
			
			ValidunitVo	va = new ValidunitVo();
			String jsonString =null;
			ObjectMapper objectMapper = new ObjectMapper();
			boolean first_page;
			boolean last_page;
			
			
			
			Page page = new Page(page_number);
			List co = userServiceImpl.getValidOrgunitList(page);		
			Map m = userServiceImpl.getValidOrgunitListTotal(page);
			
			String pp = m.getOrDefault("TOTAL_PAGE", "0").toString();
			
			if(page_number.equals("1")) {
				first_page = true;
			}else {
				first_page = false;
			}
			
			if(page_number == pp) {
				last_page = true;
			}else {
				last_page = false;
			}	
						
			if (OrgLoginType == null || page_number.equals("0")) {
	            throw new MissingRequiredHeaderException("The required header is missing.");
	        }else {
	        		va = new ValidunitVo(200, "ok", Integer.parseInt(m.getOrDefault("TOTAL_PAGE", "0").toString()), 
	        			Integer.parseInt(m.getOrDefault("TOTAL_COUNT", "0").toString()), 200, page_number, 
	        			co.size(), last_page, first_page, co);
	        }   		    	
	        
			try {
	            // 객체를 JSON 문자열로 변환
	            jsonString  = objectMapper.writeValueAsString(va);
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	        }
			
			logger.info(jsonString);
			
	        return jsonString;			
	    }
	 
	 /* 조직도 대한 변동 데이터 적용 API
		 * 
		 * */
	 
	 @GetMapping("/orgunit/v0/getChangedOrgunits")
	    public String getChangedOrgunits(@RequestParam(value = "page_number", defaultValue = "0") String page_number,	    		 
	    		@RequestParam(value = "basis_time", defaultValue = "0") String basistime,
	    		@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
			
			logger.info("api/orgunit/v0/getChangedOrgunits");
			
			String jsonString =null;
			ObjectMapper objectMapper = new ObjectMapper();
			ChangeOrgVo chorg = new ChangeOrgVo();
			boolean first_page;
			boolean last_page;
			
						
			Page page = new Page(page_number);
			List chorgco = userServiceImpl.getChangedOrgunitList(page);		
			Map m = userServiceImpl.getChangedOrgunitListTotal(page);	
			
			String pp = m.getOrDefault("TOTAL_PAGE", "0").toString();
			
			if(page_number.equals("1")) {
				first_page = true;
			}else {
				first_page = false;
			}
			
			if(page_number == pp) {
				last_page = true;
			}else {
				last_page = false;
			}								
			
			if (OrgLoginType == null || page_number.equals("0") || basistime.equals("0")) {
	            throw new MissingRequiredHeaderException("The required header is missing.");
	        }else {
	        	chorg = new ChangeOrgVo(200, "ok", Integer.parseInt(m.getOrDefault("TOTAL_PAGE", "0").toString()), 
	        			Integer.parseInt(m.getOrDefault("TOTAL_COUNT", "0").toString()), 200, page_number, 
	        			chorgco.size(), last_page, first_page, chorgco);
	        }    		    		
	        
			try {
	            // 객체를 JSON 문자열로 변환
	            jsonString  = objectMapper.writeValueAsString(chorg);
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	        }
			
			logger.info(jsonString);
			
	        return jsonString;
	    }
	
}