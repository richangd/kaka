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
import com.example.demo.orgunits.domain.PosiContent;
import com.example.demo.orgunits.domain.PositionVo;
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
			
			ct.add(new Content1("ACTIVE", li ,"김창범", "Kim.Changbeom@kr.canon", "VERIFIED"));
			
			g1 = "관리자";
			g2 = "10377788";
			g3 = "sdmail@kr.canon";
			
			li = new String[]{g1, g2, g3};
			
			mo.add(new more_telephones("FIXED_LINE", "+82 31-2222-5555", "031-2222-5555", "TOVERIFY"));
			mo.add(new more_telephones1("IPT", "개발 2팀", "987654321"));
			
			ct.add(new Content1("ACTIVE", li ,"관리자", "sdmail@kr.canon", "VERIFIED"));
			
			g1 = "김대진";
			g2 = "10405313";
			g3 = "Kim.DaeJin@kr.canon";
			
			li = new String[]{g1, g2, g3};
			ct.add(new Content1("ACTIVE", li ,"김대진", "Kim.DaeJin@kr.canon", "VERIFIED"));
			
			g1 = "박응수";
			g2 = "10414705";
			g3 = "espark@kr.canon";
			
			li = new String[]{g1, g2, g3};
			ct.add(new Content1("ACTIVE", li ,"박응수", "espark@kr.canon", "VERIFIED"));
	    	
			if (OrgLoginType == null) {
	            throw new MissingRequiredHeaderException("The required header is missing.");
	        }else {
	        	va = new ValidVo(200, "ok", 1, 5, 10, 1, 10, true, true, ct);
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
		
		ct.add(new Content1("REGISTERED", li ,"김창범", "Kim.Changbeom@kr.canon", "TO_VERIFY"));
		
		g1 = "관리자";
		g2 = "10377788";
		g3 = "sdmail@kr.canon";
		
		li = new String[]{g1, g2, g3};
		
		mo.add(new more_telephones("FIXED_LINE", "+82 31-2222-5555", "031-2222-5555", "TOVERIFY"));
		mo.add(new more_telephones1("IPT", "개발 2팀", "987654321"));
		
		ct.add(new Content1("REGISTERED", li ,"관리자", "sdmail@kr.canon", "VERIFIED"));
		
		g1 = "김대진";
		g2 = "10405313";
		g3 = "Kim.DaeJin@kr.canon";
		
		li = new String[]{g1, g2, g3};
		ct.add(new Content1("REGISTERED", li ,"김대진", "Kim.DaeJin@kr.canon", "VERIFIED"));
		
		g1 = "박응수";
		g2 = "10414705";
		g3 = "espark@kr.canon";
		
		li = new String[]{g1, g2, g3};
		ct.add(new Content1("REGISTERED", li ,"박응수", "espark@kr.canon", "VERIFIED"));
		
		
		g1 = "테스트";
		g3 = "kimncbv@naver.com";
		
		li = new String[]{g1, g3};
		
		ct.add(new Content1("REGISTERED", li ,"테스트", "kimncbv@naver.com", "VERIFY"));
		
    	
		if (OrgLoginType == null) {
            throw new MissingRequiredHeaderException("The required header is missing.");
        }else {
        	va = new ValidVo(200, "ok", 1, 5, 10, 1, 10, true, true, ct);
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
		
		chorgco.add(new ChangeOrgContent("REGISTERED", "21", "캐논코리아", "#", false, 0));
		chorgco.add(new ChangeOrgContent("REGISTERED", "22", "카카오게임즈", "21", false, 0));
		chorgco.add(new ChangeOrgContent("REGISTERED", "MTSM", "MTS마케팅", "21", false, 0));
		
		
		if (OrgLoginType == null) {
            throw new MissingRequiredHeaderException("The required header is missing.");
        }else {
        	chorg = new ChangeOrgVo(200, "ok", 1, 10, 500, 1, 500, true, true, chorgco);
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
		
		
		if (OrgLoginType == null) {
            throw new MissingRequiredHeaderException("The required header is missing.");
        }else {
        	va = new ValidunitVo(200, "ok", 1, 1, 10, 1, 10, true, true, co);
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
		
		rco.add(new ResponsContent("1", 1, "이사장"));
		rco.add(new ResponsContent("2", 2, "병원장"));
		rco.add(new ResponsContent("3", 3, "부원장"));
		rco.add(new ResponsContent("4", 4, "관리부장"));
		rco.add(new ResponsContent("5", 5, "간호부장"));
		rco.add(new ResponsContent("6", 6, "진료부장"));
		rco.add(new ResponsContent("7", 7, "내과과장"));
		rco.add(new ResponsContent("8", 8, "정형외과과장"));
		rco.add(new ResponsContent("9", 9, "신경외과과장"));
		rco.add(new ResponsContent("10", 10, "성형외과과장"));
		rco.add(new ResponsContent("11", 11, "산부인과과장"));
		rco.add(new ResponsContent("12", 12, "소아과과장"));
		rco.add(new ResponsContent("13", 13, "안과과장"));
		rco.add(new ResponsContent("14", 14, "내시경과장"));
		rco.add(new ResponsContent("15", 15, "응급의학과과장"));
		rco.add(new ResponsContent("16", 16, "마취통증의학과과장"));
		rco.add(new ResponsContent("17", 17, "진단방사선과과장"));
		rco.add(new ResponsContent("18", 18, "진단검사의학과과장"));
		rco.add(new ResponsContent("19", 19, "외과과장"));
		
		
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
    public String getPositions(@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
        
		String jsonString = null;		
		ObjectMapper objectMapper = new ObjectMapper();
		PositionVo Po = new PositionVo();
		List<PosiContent> Poc = new ArrayList();		
		
		Poc.add(new PosiContent("1", 1, "과장"));
		Poc.add(new PosiContent("2", 2, "기획조정실장"));
		Poc.add(new PosiContent("3", 3, "병원장"));
		Poc.add(new PosiContent("4", 4, "부원장"));
		Poc.add(new PosiContent("5", 5, "부장"));
		Poc.add(new PosiContent("6", 6, "사원"));
		Poc.add(new PosiContent("7", 7, "센터장"));
		Poc.add(new PosiContent("8", 8, "소장"));
		Poc.add(new PosiContent("9", 9, "수간호사"));
		Poc.add(new PosiContent("10", 10, "수술부장"));
		Poc.add(new PosiContent("11", 11, "실장"));
		Poc.add(new PosiContent("12", 12, "약사"));
		Poc.add(new PosiContent("13", 13, "이사"));
		Poc.add(new PosiContent("14", 14, "이사장"));
		Poc.add(new PosiContent("15", 15, "주임"));
		Poc.add(new PosiContent("16", 16, "주임조무사"));
		Poc.add(new PosiContent("17", 17, "진료과장"));
		Poc.add(new PosiContent("18", 18, "진료부장"));
		Poc.add(new PosiContent("19", 19, "책임간호사1"));
		Poc.add(new PosiContent("20", 20, "직위"));
		Poc.add(new PosiContent("21", 21, "책임"));
		Poc.add(new PosiContent("22", 22, "팀장"));
		Poc.add(new PosiContent("23", 23, "차장"));
		Poc.add(new PosiContent("24", 24, "수간호사"));
		Poc.add(new PosiContent("25", 25, "파트장"));
		Poc.add(new PosiContent("26", 26, "본부장"));
		Poc.add(new PosiContent("27", 27, "원장"));
		Poc.add(new PosiContent("28", 28, "상무이사"));
		Poc.add(new PosiContent("29", 29, "국장"));
		Poc.add(new PosiContent("30", 30, "2본부장"));
		
		
		
		if (OrgLoginType == null) {
            throw new MissingRequiredHeaderException("The required header is missing.");
        }else {
        	Po = new PositionVo(200, "ok", 1, 2, 10, 1, 10, true, true, Poc);
        }
		
		try {
            // 객체를 JSON 문자열로 변환
            jsonString  = objectMapper.writeValueAsString(Po);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    	
        return jsonString;
    }
}

