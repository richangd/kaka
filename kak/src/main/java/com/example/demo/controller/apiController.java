package com.example.demo.controller;


import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


@RestController
@RequestMapping(value = "api")
@CrossOrigin("*")
public class apiController {
   
   
   @PostMapping("/login/v0/identifyUser")
   public idreturn post(@RequestBody Param param) {
	   idreturn idreturn = new idreturn("Success", "AUTH_SUCCESS", 200, "OK");   

       return idreturn;
   }

    @GetMapping("/agent/v0/getAgentCapabilities")
    public agentVo getAgentCapabilities(@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
    	agentVo ag = new agentVo();
    	
    	if (OrgLoginType == null) {
            throw new MissingRequiredHeaderException("The required header is missing.");
        }else {
        	String g1 = "agent";
    		String g2 = "user";
    		String g3 = "login";
    		String g4 = "orgunit";
    		
        	ag = new agentVo(200, "ok", new String[]{g1,g2});
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
    
	@GetMapping("/user/v0/getValidUsers1")
	public String getValidUsers() {			
    	
        return "{"
				+ "  \"_code\": 200,"
				+ "\"_message\": \"ok\","
				+ "  \"total_pages\": 12,"
				+ "  \"total_elements\": 5555,"
				+ "  \"size\": 500,"
				+ "  \"number\": 1,"
				+ "  \"number_of_elements\": 500,"
				+ "  \"is_last\": false,"
				+ "  \"is_first\": true,"
				+ "  \"contents\": ["
				+ "    {"
				+ " \"status\": \"ACTIVE\","
				+ "      \"identifiers\": [\"test.kim\", \"10405312\", \"Kim.Changbeom@kr.canon\"],"
				+ "      \"name\": \"테스트\","
				+ "      \"nickname\": \"테스트\","
				+ "      \"email\": \"Kim.Changbeom@kr.canon\","
				+ "      \"email_verification\": \"TO_VERIFY\","
				+ "      \"telephone_international\": \"+82 10-1234-5678\","
				+ "      \"telephone_for_display\": \"010-1234-5678 내선 5\","
				+ "      \"telephone_verification\": \"TO_VERIFY\","
				+ "      \"more_telephones\": ["
				+ "        {"
				+ "          \"type\": \"MOBILE\","
				+ "          \"international\": \"+82 10-1111-2222\","
				+ "          \"display\": \"010-1111-2222\","
				+ "          \"verification\": \"TOVERIFY\""
				+ "        }"
				+ "      ],"
				+ "      \"birthday\": \"01-01\","
				+ "      \"gender\": \"MALE\","
				+ "      \"is_lunar\": false,"
				+ "      \"photo_url\": \"\""
				+ "          },"
				+ "    {"
				+ "      \"status\": \"ACTIVE\","
				+ "      \"identifiers\": [\"관리자\", \"10377788\", \"sdmail@kr.canon\"],"
				+ "      \"name\": \"관리자\","
				+ "      \"nickname\": \"admin_canon\","
				+ "      \"email\": \"sdmail@kr.canon\","
				+ "      \"email_verification\": \"TO_VERIFY\","
				+ "      \"telephone_international\": \"+82 10-8765-4321\","
				+ "      \"telephone_for_display\": \"010-8765-4321 휴대용\","
				+ "      \"telephone_verification\": \"TO_VERIFY\","
				+ "      \"more_telephones\": ["
				+ "        {"
				+ "          \"type\": \"FIXED_LINE\","
				+ "          \"international\": \"+82 31-2222-5555\","
				+ "          \"display\": \"031-2222-5555\","
				+ "          \"verification\": \"TOVERIFY\""
				+ "        },"
				+ "        {"
				+ "          \"type\": \"IPT\","
				+ "          \"display\": \"개발 2팀\","
				+ "          \"number\": \"987654321\""
				+ "        }"
				+ "      ],"
				+ "      \"birthday\": \"01-01\","
				+ "      \"gender\": \"FEMALE\","
				+ "      \"is_lunar\": false,"
				+ "      \"photo_url\": \"\""
				+ "    }"
				+ "  ]"
				+ "}"
				+ "";
	}
		
		
	

	@GetMapping("/user/v0/getValidUsers")
	public ValidVo getValidUsers(@RequestBody Valid Val, @RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
        
		ValidVo va = new ValidVo();
		
		
		String g1 = "test.kim";
		String g2 = "10405312";
		String g3 = "Kim.Changbeom@kr.canon";
		
		String[] li = new String[]{g1, g2, g3};
		List<Content> ct = new ArrayList();
		List mo = new ArrayList();
		
		List<more_telephones> ph = new ArrayList();
		
		ph.add(new more_telephones("MOBILE", "+82 10-1111-2222", "010-1111-2222", "TOVERIFY"));
		
		ct.add(new Content("ACTIVE", li ,"test", "test", "Kim.Changbeom@kr.canon", "TO_VERIFY", "+82 10-1234-5678", "010-1234-5678", "TO_VERIFY", ph, "01-01", "MALE", false, ""));
		
		g1 = "admin";
		g2 = "10377788";
		g3 = "sdmail@kr.canon";
		
		li = new String[]{g1, g2, g3};		
		
		mo.add(new more_telephones("FIXED_LINE", "+82 31-2222-5555", "031-2222-5555", "TOVERIFY"));
		mo.add(new more_telephones1("IPT", "sol 2", "987654321"));
		
		ct.add(new Content("ACTIVE", li ,"admin", "admin_canon", "sdmail@kr.canon", "TO_VERIFY", "+82 10-8765-4321", "010-8765-4321", "TO_VERIFY", mo, "01-01", "FEMALE", false, ""));
		
		Integer num = Val.getPage_number();
    	
		if (OrgLoginType == null || num <= 0) {
            throw new MissingRequiredHeaderException("The required header is missing.");
        }else {
        	va = new ValidVo(200, "ok", 12, 5555, 500, 1, 500, false, true, ct);
        }
    	
    	
        return va;
    }
	/*
	@GetMapping("/user/v0/getChangedUsers")
    public ValidVo getgetChangedUsers(@RequestBody ChangedUser Chu, @RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
        
		
		ValidVo va = new ValidVo();
		
		more_telephones ph =  new more_telephones();
		String g1 = "김창범";
		String g2 = "10405312";
		String g3 = "Kim.Changbeom@kr.canon";
		
		String[] li = new String[]{g1, g2, g3};		
		
		
		Content ct = new Content("ACTIVE", li ,"테스트", "테스트", "Kim.Changbeom@kr.canon", "TO_VERIFY", "+82 10-1234-5678", "010-1234-5678 내선 5", "TO_VERIFY", ph, "01-01", "male", false, "");
    	
		String tm = Chu.getBasis_time();
		Integer num = Chu.getPage_number();
		
		if (OrgLoginType == null || tm.length() == 0 || num <= 0) {
            throw new MissingRequiredHeaderException("The required header is missing.");
        }else {
        	va = new ValidVo(200, "ok",12, 5555, 500, 2, 500, false, false ,ct);
        }    	
    	
        return va;
    }
*/
}

