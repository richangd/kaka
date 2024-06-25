package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Content;
import com.example.demo.domain.Content0;
import com.example.demo.domain.Content1;
import com.example.demo.domain.Content2;
import com.example.demo.domain.Content3;
import com.example.demo.domain.Logindata;
import com.example.demo.domain.MetadataVo;
import com.example.demo.domain.Page;
import com.example.demo.domain.Param;
import com.example.demo.domain.Player;
import com.example.demo.domain.Profile;
import com.example.demo.domain.Report;
import com.example.demo.domain.ReportVo;
import com.example.demo.domain.UserExtra;
import com.example.demo.domain.UserVO;
import com.example.demo.domain.Valid;
import com.example.demo.domain.ValidVo;
import com.example.demo.domain.agentVo;
import com.example.demo.domain.departments;
import com.example.demo.domain.editability;
import com.example.demo.domain.idreturn;
import com.example.demo.domain.more_telephones;
import com.example.demo.domain.more_telephones1;
import com.example.demo.domain.orgunit;
import com.example.demo.domain.synchronize_options;
import com.example.demo.domain.telephones;
import com.example.demo.exeption.MissingRequiredHeaderException;
import com.example.demo.orgunits.domain.ChangeOrgContent;
import com.example.demo.orgunits.domain.ChangeOrgVo;
import com.example.demo.orgunits.domain.PosiContent;
import com.example.demo.orgunits.domain.PositionVo;
import com.example.demo.orgunits.domain.ResponsContent;
import com.example.demo.orgunits.domain.ResponsibilVo;
import com.example.demo.orgunits.domain.VaContent;
import com.example.demo.orgunits.domain.ValidunitVo;
import com.example.demo.service.impl.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UserController {
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger("KAKAOWORK");
	
	@Autowired
	UserServiceImpl userServiceImpl;

	@GetMapping("user/list")
	public @ResponseBody List<UserVO> getUserList(){
		
		return userServiceImpl.getUserList();
	}
	
	@GetMapping("agent/Human")
	public List<Map> getHumanList(){
		
		return userServiceImpl.getHumanList();
	}
	@GetMapping("agent/list")
	public List getAgentList(){
		
		return userServiceImpl.getAgentList();
	}
	
	@GetMapping("agent/Meta")
	public List<Map> getMetaList(){
		
		return userServiceImpl.getMetaList();
	}	

	public Map getUserValidListTotal(Page page){
		
		return userServiceImpl.getUserValidListTotal(page);
	}

	public List<Content0> getUserValidList(Page page){
		
		return userServiceImpl.getUserValidList(page);
	}	
	
	public Map getUserChagedListTotal(Page page){
		
		return userServiceImpl.getUserChangedListTotal(page);
	}
	
	public List<Map> getUserChagedList(Page page){
		
		return userServiceImpl.getUserChangedList(page);
	}
	
	public List getMetaString(){
		
		return userServiceImpl.getMetaString();
	}		
	
	public List<Map> getPositionList(){
		
		return userServiceImpl.getPositionList();
	}
	
	public Map getPositionListTotal(Page page){
		
		return userServiceImpl.getPositionListTotal(page);
	}
	
	public List<Map> getResponsibilitieList(){
		
		return userServiceImpl.getResponsibilitieList();
	}
	
	public Map getResponsibilitieListTotal(Page page){
		
		return userServiceImpl.getResponsibilitieListTotal(page);
	}
		
	public List<Map> getValidOrgunitList(){
		
		return userServiceImpl.getValidOrgunitList();
	}
	
	public Map getValidOrgunitListTotal(Page page){
		
		return userServiceImpl.getValidOrgunitListTotal(page);
	}	
	
	public List<Map> getChangedOrgunitList(){
		
		return userServiceImpl.getChangedOrgunitList();
	}
	
	public Map getChangedOrgunitListTotal(Page page){
		
		return userServiceImpl.getChangedOrgunitListTotal(page);
	}
	
	public List getUserString(Logindata login) {
		
		return userServiceImpl.getUserString(login);
		
	}
	
	@GetMapping("getchanged")
	public String aga1(@RequestBody Param param) {
		
		Logindata lg = new Logindata("ADMIN");
		List k = getUserString(lg);
		String a = k.get(0).toString();
		String aa = null;
		if(param.getpassword().equals(a)) {
			aa = "로그인성공";
		}else {
			aa = "로그인실패";
		}
		
		return aa;
	}
	
	/*
	public String insertUser() {
		userServiceImpl.insertUser();
        return "DB에서 확인해보세요";
    }
	*/
	
	@PostMapping("/login/v0/identifyUser")
	   public idreturn post(@RequestBody Param param, @RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
		   logger.info("api/login/v0/identifyUser");
		   logger.info(param.getpassword());
		   logger.info(OrgLoginType);
		   
		   idreturn id = new idreturn();
		   Logindata lg = new Logindata("ADMIN");
		   List login = getUserString(lg);
		   String a = login.get(0).toString();
		   
		   String pw = param.getpassword();
		   
		   if (OrgLoginType == null) {
	           throw new MissingRequiredHeaderException("The required header is missing.");
	       }else if(a.equals(pw)){
	    	   id = new idreturn("SUCCESS", "AUTH_SUCCESS", 200, "OK");
	       }else {
	    	   id = new idreturn("FAILURE", "AUTH_FAIL", 401, "Unauthorized");    	   
	       }	   
		   
	       return id;
	   }
	
	@GetMapping("/agent/v0/getAgentCapabilities")
	public agentVo getAgentCapabilities(@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
    	
    	logger.info("api/agent/v0/getAgentCapabilities");
 	   	
    	agentVo ag = new agentVo();
    	
    	List agent = getAgentList();
    	ag = new agentVo(200, "ok", agent);
    	
    	return ag;
    }
	
	 @GetMapping("/user/v0/getUserMetadata")
	    public MetadataVo getUserMetadata(@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
	        
	    	logger.info("api/user/v0/getUserMetadata"); 		    	
	    	
	    	List<synchronize_options> sy= new ArrayList();
	    	
	    	
	    	List agent = getMetaString();
	    		    	
	    	agent.get(0);
	    	
	    	telephones te = new telephones(agent.get(4).toString(), agent.get(5).toString());
	    	editability ed = new editability(agent.get(0).toString(), agent.get(1).toString(), agent.get(2).toString(), agent.get(3).toString(), 
	    			te, agent.get(6).toString(), agent.get(7).toString(), agent.get(8).toString(), agent.get(9).toString());
	    	Profile pr = new Profile(ed);

	    	sy.add(new synchronize_options(agent.get(10).toString(), agent.get(11).toString()));
	    	
	    	
	    	
	    	MetadataVo ag = new MetadataVo(pr, sy);
	        
	        return ag;
	    }
	 
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
	
	
	@GetMapping("/user/v0/getValidUsers")
	public String getAgentCapabilit1(@RequestBody Valid val, @RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
	 	logger.info("api/user/v0/getValidUsers");
	 
	 	String jsonString = null;
    	ValidVo va = new ValidVo();
    	boolean first_page;
		boolean last_page;
		int page_number = val.getPage_number();					
		
		Page page = new Page(val.getPage_number(), val.getPage_size());
		
		Map valv = getUserValidListTotal(page);
		List<Content0> m1 = getUserValidList(page);
		
		int pp = Integer.parseInt(valv.getOrDefault("TOTAL_PAGE", "0").toString());
		
		if(page_number == 1) {
			first_page = true;
		}else {
			first_page = false;
		}
		
		if(page_number == pp) {
			last_page = true;
		}else {
			last_page = false;
		}	
    	
		if (OrgLoginType == null) {
            throw new MissingRequiredHeaderException("The required header is missing.");
        }else {
        	va = new ValidVo(200, "ok", Integer.parseInt(valv.getOrDefault("TOTAL_PAGE", "0").toString()), 
        			Integer.parseInt(valv.getOrDefault("TOTAL_COUNT", "0").toString()), 
        			val.getPage_size(), val.getPage_number(), m1.size(), last_page, first_page, m1);
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
	
	@GetMapping("/user/v0/getChangedUsers")
    public String getgetChangedUsers(@RequestBody Valid val, @RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
		logger.info("api/user/v0/getChangedUsers");
		
		String jsonString = null;
    	ValidVo va = new ValidVo();
    	boolean first_page;
		boolean last_page;
		int page_number = val.getPage_number();
		Page page = new Page(val.getPage_number(), val.getPage_size());
		List m1 = getUserChagedList(page);
		Map valv = getUserChagedListTotal(page);
		List<Content2> ct = new ArrayList();
		List mo = new ArrayList();		
		
		int pp = Integer.parseInt(valv.getOrDefault("TOTAL_PAGE", "0").toString());
		
		if(page_number == 1) {
			first_page = true;
		}else {
			first_page = false;
		}
		
		if(page_number == pp) {
			last_page = true;
		}else {
			last_page = false;
		}			
    	
		if (OrgLoginType == null) {
            throw new MissingRequiredHeaderException("The required header is missing.");
        }else {
        	va = new ValidVo(200, "ok", Integer.parseInt(valv.getOrDefault("TOTAL_PAGE", "0").toString()), 
        			Integer.parseInt(valv.getOrDefault("TOTAL_COUNT", "0").toString()), 
        			val.getPage_size(), val.getPage_number(), m1.size(), last_page, first_page, m1);
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
	 
	 @GetMapping("/orgunit/v0/getPositions")
	    public String getPositions(@RequestBody Valid val, @RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
	        
			logger.info("api/orgunit/v0/getPositions");
			
			String jsonString =null;
			ObjectMapper objectMapper = new ObjectMapper();
			boolean first_page;
			boolean last_page;
			int page_number = val.getPage_number();
			PositionVo Po = new PositionVo();
			
			Page page = new Page(val.getPage_number(), val.getPage_size());
			List Poc = getPositionList();		
			Map m = getPositionListTotal(page);
			
			int pp = Integer.parseInt(m.getOrDefault("TOTAL_PAGE", "0").toString());
			
			if(page_number == 1) {
				first_page = true;
			}else {
				first_page = false;
			}
			
			if(page_number == pp) {
				last_page = true;
			}else {
				last_page = false;
			}
			
			if (OrgLoginType == null) {
	            throw new MissingRequiredHeaderException("The required header is missing.");
	        }else {
	        	Po = new PositionVo(200, "ok", Integer.parseInt(m.getOrDefault("TOTAL_PAGE", "0").toString()), 
	        			Integer.parseInt(m.getOrDefault("TOTAL_COUNT", "0").toString()), val.getPage_size(), val.getPage_number(), 
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
	 
	 @GetMapping("/orgunit/v0/getResponsibilities")
	    public String getResponsibilities(@RequestBody Valid val, @RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
	        
			logger.info("api/orgunit/v0/getResponsibilities");
			
			String jsonString =null;
			ObjectMapper objectMapper = new ObjectMapper();
			
			ResponsibilVo Rev = new ResponsibilVo();
			boolean first_page;
			boolean last_page;
			int page_number = val.getPage_number();
			
			Page page = new Page(val.getPage_number(), val.getPage_size());
			List rco = getResponsibilitieList();		
			Map m = getResponsibilitieListTotal(page);

			int pp = Integer.parseInt(m.getOrDefault("TOTAL_PAGE", "0").toString());
			
			if(page_number == 1) {
				first_page = true;
			}else {
				first_page = false;
			}
			
			if(page_number == pp) {
				last_page = true;
			}else {
				last_page = false;
			}	
			
			if (OrgLoginType == null) {
	            throw new MissingRequiredHeaderException("The required header is missing.");
	        }else {
	        	Rev = new ResponsibilVo(200, "ok", Integer.parseInt(m.getOrDefault("TOTAL_PAGE", "0").toString()), 
	        			Integer.parseInt(m.getOrDefault("TOTAL_COUNT", "0").toString()), val.getPage_size(), val.getPage_number(), 
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
	 
	 @GetMapping("/orgunit/v0/getValidOrgunits")
	    public String getValidOrgunits(@RequestBody Valid val, @RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
	        
			logger.info("api/orgunit/v0/getValidOrgunits");
			
			ValidunitVo	va = new ValidunitVo();
			String jsonString =null;
			ObjectMapper objectMapper = new ObjectMapper();
			boolean first_page;
			boolean last_page;
			int page_number = val.getPage_number();
			
			Page page = new Page(val.getPage_number(), val.getPage_size());
			List co = getValidOrgunitList();		
			Map m = getValidOrgunitListTotal(page);
			
			int pp = Integer.parseInt(m.getOrDefault("TOTAL_PAGE", "0").toString());
			
			if(page_number == 1) {
				first_page = true;
			}else {
				first_page = false;
			}
			
			if(page_number == pp) {
				last_page = true;
			}else {
				last_page = false;
			}	
						
			if (OrgLoginType == null) {
	            throw new MissingRequiredHeaderException("The required header is missing.");
	        }else {
	        		va = new ValidunitVo(200, "ok", Integer.parseInt(m.getOrDefault("TOTAL_PAGE", "0").toString()), 
	        			Integer.parseInt(m.getOrDefault("TOTAL_COUNT", "0").toString()), val.getPage_size(), val.getPage_number(), 
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
	 
	 @GetMapping("/orgunit/v0/getChangedOrgunits")
	    public String getChangedOrgunits(@RequestBody Valid val, @RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
			
			logger.info("api/orgunit/v0/getChangedOrgunits");
			
			String jsonString =null;
			ObjectMapper objectMapper = new ObjectMapper();
			ChangeOrgVo chorg = new ChangeOrgVo();
			boolean first_page;
			boolean last_page;
			int page_number = val.getPage_number();
						
			Page page = new Page(val.getPage_number(), val.getPage_size());
			List chorgco = getChangedOrgunitList();		
			Map m = getChangedOrgunitListTotal(page);	
			
			int pp = Integer.parseInt(m.getOrDefault("TOTAL_PAGE", "0").toString());
			
			if(page_number == 1) {
				first_page = true;
			}else {
				first_page = false;
			}
			
			if(page_number == pp) {
				last_page = true;
			}else {
				last_page = false;
			}								
			
			if (OrgLoginType == null) {
	            throw new MissingRequiredHeaderException("The required header is missing.");
	        }else {
	        	chorg = new ChangeOrgVo(200, "ok", Integer.parseInt(m.getOrDefault("TOTAL_PAGE", "0").toString()), 
	        			Integer.parseInt(m.getOrDefault("TOTAL_COUNT", "0").toString()), val.getPage_size(), val.getPage_number(), 
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