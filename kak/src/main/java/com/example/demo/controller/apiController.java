package com.example.demo.controller;


import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import ch.qos.logback.classic.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Agent;
import com.example.demo.domain.ChangedUser;
import com.example.demo.domain.Content;
import com.example.demo.domain.Content1;
import com.example.demo.domain.Hello;
import com.example.demo.domain.MetadataVo;
import com.example.demo.domain.Param;
import com.example.demo.domain.Profile;
import com.example.demo.domain.Report;
import com.example.demo.domain.ReportVo;
import com.example.demo.domain.ValidUser;
import com.example.demo.domain.ValidVo;
import com.example.demo.domain.Valid;
import com.example.demo.domain.agentVo;
import com.example.demo.domain.editability;
import com.example.demo.domain.idreturn;
import com.example.demo.domain.more_telephones;
import com.example.demo.domain.more_telephones1;
import com.example.demo.domain.synchronize_options;
import com.example.demo.domain.telephones;
import com.example.demo.exeption.MissingRequiredHeaderException;
import com.example.demo.orgunits.domain.ChangeOrgContent;
import com.example.demo.orgunits.domain.ChangeOrgVo;
import com.example.demo.orgunits.domain.ResponsContent;
import com.example.demo.orgunits.domain.ResponsibilIo;
import com.example.demo.orgunits.domain.ResponsibilVo;
import com.example.demo.orgunits.domain.VaContent;
import com.example.demo.orgunits.domain.ValidunitIo;
import com.example.demo.orgunits.domain.ValidunitVo;


@RestController
@RequestMapping(value = "api")
@CrossOrigin("*")
public class apiController {
   
   private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

   @PostMapping("/login/v0/identifyUser")
   public idreturn post(@RequestBody Param param, @RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
	   
	   idreturn id = new idreturn();
	   
	   String pw = param.getpassword();
	   
	   if (OrgLoginType == null) {
           throw new MissingRequiredHeaderException("The required header is missing.");
       }else if(pw.equals("solrnd0803!@")){
    	   id = new idreturn("Success", "AUTH_SUCCESS", 200, "OK");
       }else {
    	   id = new idreturn("FAILURE", "AUTH_FAIL", 401, "Unauthorized");    	   
       }	   
	   
       return id;
   }

    @GetMapping("/agent/v0/getAgentCapabilities")
    public agentVo getAgentCapabilities(@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
    	agentVo ag = new agentVo();
    	logger.trace("getAgentCapabilities 테스트");
    	if (OrgLoginType == null) {
            throw new MissingRequiredHeaderException("The required header is missing.");
        }else {
        	String g1 = "agent";
    		String g2 = "user";
    		String g3 = "login";
    		String g4 = "orgunit";
    		
        	ag = new agentVo(200, "ok", new String[]{g2, g3, g4});
        }
        return ag;
    }    
    
    @GetMapping("/user/v0/getUserMetadata")
    public MetadataVo getUserMetadata(@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
        
    	MetadataVo ag = new MetadataVo();
    	telephones te = new telephones();
    	List<synchronize_options> sy= new ArrayList<>();
    	
    	editability ed = new editability(te);
    	Profile pr = new Profile(ed);

    	sy.add(new synchronize_options("정직원 제외", "except_full_time_employee"));
    	
    	
    	if (OrgLoginType == null) {
            throw new MissingRequiredHeaderException("The required header is missing.");
        }else {
        	ag = new MetadataVo(pr, sy);
        }
    	
        return ag;
    }
    
    @PostMapping("/agent/v0/reportError")
    public ReportVo post(@RequestBody Report report, @RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
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
	 public String getAgentCapabilit(@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
	    	String jsonString = null;
	    	ValidVo va = new ValidVo();
			
			String g1 = "김창범";
			String g2 = "10405312";
			String g3 = "Kim.Changbeom@kr.canon";
			
			String[] li = new String[]{g1, g2, g3};
			List<Content1> ct = new ArrayList();
			List mo = new ArrayList();
			
			List<more_telephones> ph = new ArrayList();
			
			ph.add(new more_telephones("MOBILE", "+82 10-1111-2222", "010-1111-2222", "TOVERIFY"));
			
			ct.add(new Content1("ACTIVE", li ,"김창범"));
			
			g1 = "관리자";
			g2 = "10377788";
			g3 = "sdmail@kr.canon";
			
			li = new String[]{g1, g2, g3};
			
			mo.add(new more_telephones("FIXED_LINE", "+82 31-2222-5555", "031-2222-5555", "TOVERIFY"));
			mo.add(new more_telephones1("IPT", "개발 2팀", "987654321"));
			
			ct.add(new Content1("ACTIVE", li ,"관리자"));
			
			g1 = "김대진";
			g2 = "10405313";
			g3 = "Kim.DaeJin@kr.canon";
			
			li = new String[]{g1, g2, g3};
			ct.add(new Content1("ACTIVE", li ,"김대진"));
			
			g1 = "박응수";
			g2 = "10414705";
			g3 = "espark@kr.canon";
			
			li = new String[]{g1, g2, g3};
			ct.add(new Content1("ACTIVE", li ,"박응수"));
	    	
			if (OrgLoginType == null) {
	            throw new MissingRequiredHeaderException("The required header is missing.");
	        }else {
	        	va = new ValidVo(200, "ok", 1, 4, 10, 1, 10, false, true, ct);
	        }
	    	
	    	ObjectMapper objectMapper = new ObjectMapper();
			
	        try {
	            // 객체를 JSON 문자열로 변환
	            jsonString = objectMapper.writeValueAsString(va);
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	        }
	        return jsonString;
	    }	
	
	@GetMapping("/user/v0/getChangedUsers")
    public String getgetChangedUsers(@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
        
		
		ValidVo va = new ValidVo();
		String jsonString = null;
		
		
		String g1 = "김창범";
		String g2 = "10405312";
		String g3 = "Kim.Changbeom@kr.canon";
		
		String[] li = new String[]{g1, g2, g3};		
		
		List<Content> ct = new ArrayList();
		List<more_telephones> ph = new ArrayList();
		
		ph.add(new more_telephones("MOBILE", "+82 10-1111-2222", "010-1111-2222", "TOVERIFY"));
		
		
		ct.add(new Content("UPDATED", li ,"테스트", "테스트", "Kim.Changbeom@kr.canon", "TO_VERIFY", "+82 10-1234-5678", "010-1234-5678 내선 5", "TO_VERIFY", ph, "01-01", "male", false, ""));    	
		
		if (OrgLoginType == null) {
            throw new MissingRequiredHeaderException("The required header is missing.");
        }else {
        	va = new ValidVo(200, "ok", 1, 4, 10, 1, 10, true, false ,ct);
        }    	
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		
        try {
            // 객체를 JSON 문자열로 변환
            jsonString = objectMapper.writeValueAsString(va);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        
        return jsonString;
		
		
    }

	/* 조직도 관련 API
	 * 
	 * */
	
	@GetMapping("/orgunit/v0/getChangedOrgunits")
    public String getChangedOrgunits(@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
        
		String jsonString =null;
		ChangeOrgVo chorg = new ChangeOrgVo();
		List<ChangeOrgContent> chorgco = new ArrayList();
		
		chorgco.add(new ChangeOrgContent("REGISTERED", "21", "카카오게임즈", "#", false, 0));
		chorgco.add(new ChangeOrgContent("UPDATED", "MTSM", "MTS마케팅", "21", false, 0));
		
		
		if (OrgLoginType == null) {
            throw new MissingRequiredHeaderException("The required header is missing.");
        }else {
        	chorg = new ChangeOrgVo(200, "ok", 12, 5555, 500, 2, 500, false, false, chorgco);
        }    	
    	
		ObjectMapper objectMapper = new ObjectMapper();
		
        
		try {
            // 객체를 JSON 문자열로 변환
            jsonString  = objectMapper.writeValueAsString(chorg);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    	
        return jsonString;
    }
	
		
	@GetMapping("/orgunit/v0/getValidOrgunits")
    public String getValidOrgunits(@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
        
		String jsonString =null;
		ValidunitVo va = new ValidunitVo();
		List<VaContent> co = new ArrayList();
		
		co.add(new VaContent("ACTIVE", "21", "캐논코리아", "#", false, 0));
		co.add(new VaContent("ACTIVE", "22", "캐주얼&광고사업본부", "21", false, 0));
		
		
		if (OrgLoginType == null) {
            throw new MissingRequiredHeaderException("The required header is missing.");
        }else {
        	va = new ValidunitVo(200, "ok", 12, 5555, 500, 2, 500, false, false, co);
        }    	
    	
		ObjectMapper objectMapper = new ObjectMapper();
		
        
		try {
            // 객체를 JSON 문자열로 변환
            jsonString  = objectMapper.writeValueAsString(va);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        
        return jsonString;
		
    }	
	
	@GetMapping("/orgunit/v0/getResponsibilities")
    public String getResponsibilities(@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
        
		
		ResponsibilVo Rev = new ResponsibilVo();
		List<ResponsContent> rco = new ArrayList();
		
		rco.add(new ResponsContent("1", 1, "대표이사"));
		rco.add(new ResponsContent("2", 2, "실장"));
		
		
		if (OrgLoginType == null) {
            throw new MissingRequiredHeaderException("The required header is missing.");
        }else {
        	Rev = new ResponsibilVo(200, "ok", 1, 2, 10, 1, 10, true, true, rco);
        }    	
    	
		
		ObjectMapper objectMapper = new ObjectMapper();
		
        
		String jsonString = null;
		
		try {
            // 객체를 JSON 문자열로 변환
            jsonString  = objectMapper.writeValueAsString(Rev);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        
        return jsonString;
    }
	
	@GetMapping("/orgunit/v0/getPositions")
    public ValidVo getPositions(@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
        
		
		ValidVo va = new ValidVo();
		
		
		
		if (OrgLoginType == null) {
            throw new MissingRequiredHeaderException("The required header is missing.");
        }else {
        	
        }    	
    	
        return va;
    }
}

