package com.example.demo.controller;


import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import com.example.demo.domain.synchronize_options;
import com.example.demo.domain.telephones;


@RestController
@RequestMapping(value = "api")
public class apiController {
   
   
   @PostMapping("/login/v0/identifyUser")
   public idreturn post(@RequestBody Param param) {
	   idreturn idreturn = new idreturn("Success", "AUTH_SUCCESS", 200, "OK");   

       return idreturn;
   }

    @GetMapping("/agent/v0/getAgentCapabilities")
    public agentVo getAgentCapabilities(@RequestHeader("Kep-OrgLoginType") String OrgLoginType) {
    	agentVo ag = new agentVo();
    	if(OrgLoginType !=null && OrgLoginType.equals("ID 299989")) {
    		String g1 = "agent";
    		String g2 = "user";
    		String g3 = "Login";
    		String g4 = "orgUnit";
    		
        	ag = new agentVo(200, "ok", new String[]{g1,g2,g3,g4});
        }else {
        	ag = new agentVo(400, "Kep-OrgLoginType is not present.");
        }
    	
        return ag;
    }
    
    @GetMapping("/user/v0/getUserMetadata")
    public MetadataVo getUserMetadata() {
        
    	telephones te = new telephones();
    	List<synchronize_options> sy= new ArrayList<>();
    	
    	editability ed = new editability(te);
    	Profile pr = new Profile(ed);

        
    	sy.add(new synchronize_options("정직원 제외", "except_full_time_employee"));
        
    	MetadataVo ag = new MetadataVo(pr, sy);
    	
        return ag;
    }
    
    @PostMapping("/agent/v0/reportError")
    public ReportVo post(@RequestBody Report report, @RequestHeader("Kep-OrgLoginType") String OrgLoginType) {
    	ReportVo re = new ReportVo();
    	if(OrgLoginType != null && OrgLoginType.equals("ID 299989")) {    	
    		re = new ReportVo(200, "ok");
    	}else {
    		re = new ReportVo(400, "Kep-OrgLoginType is not present.");
    	}
        return re;
    }    

	@GetMapping("/user/v0/getValidUsers")
    public String getValidUsers() {
            	
    	String jsonString = "{"
                + "\"_code\": 200,"
                + "\"_message\": \"ok\","
                + "\"total_pages\": 12,"
                + "\"total_elements\": 5555,"
                + "\"size\": 500,"
                + "\"number\": 2,"
                + "\"number_of_elements\": 500,"
                + "\"is_last\": false,"
                + "\"is_first\": false,"
                + "\"contents\": ["
                + "    {"
                + "        \"status\": \"ACTIVE\","
                + "        \"identifiers\": [\"test.kim\", \"087217\", \"test.kim@dktechin.com\"],"
                + "        \"name\": \"테스트\","
                + "        \"nickname\": \"테스트\","
                + "        \"email\": \"test.kim@dktechin.com\","
                + "        \"email_verification\": \"TO_VERIFY\","
                + "        \"telephone_international\": \"+82 10-1234-5678\","
                + "        \"telephone_for_display\": \"010-1234-5678 내선 5\","
                + "        \"telephone_verification\": \"TO_VERIFY\","
                + "        \"more_telephones\": ["
                + "            {"
                + "                \"type\": \"MOBILE\","
                + "                \"international\": \"+82 10-1111-2222\","
                + "                \"display\": \"010-1111-2222\","
                + "                \"verification\": \"TOVERIFY\""
                + "            },"
                + "            {"
                + "                \"type\": \"FIXED_LINE\","
                + "                \"international\": \"+82 31-3333-4444\","
                + "                \"display\": \"031-3333-4444\","
                + "                \"verification\": \"TOVERIFY\""
                + "            },"
                + "            {"
                + "                \"type\": \"IPT_MOBILE\","
                + "                \"international\": \"+82 10-5555-6666\","
                + "                \"display\": \"010-5555-6666\","
                + "                \"verification\": \"TOVERIFY\""
                + "            },"
                + "            {"
                + "                \"type\": \"IPT\","
                + "                \"display\": \"개발 1팀\","
                + "                \"number\": \"123456789\""
                + "            },"
                + "            \"...\""
                + "        ],"
                + "        \"birthday\": \"01-01\","
                + "        \"gender\": \"MALE\","
                + "        \"is_lunar\": false,"
                + "        \"photo_url\": \"\""
                + "    },"
                + "    {"
                + "        \"status\": \"ACTIVE\","
                + "        \"identifiers\": [\"test.park\", \"012345\", \"test.park@dktechin.com\"],"
                + "        \"name\": \"테스트\","
                + "        \"nickname\": \"테스트\","
                + "        \"email\": \"test.park@dktechin.com\","
                + "        \"email_verification\": \"TO_VERIFY\","
                + "        \"telephone_international\": \"+82 10-8765-4321\","
                + "        \"telephone_for_display\": \"010-8765-4321 휴대용\","
                + "        \"telephone_verification\": \"TO_VERIFY\","
                + "        \"more_telephones\": ["
                + "            {"
                + "                \"type\": \"FIXED_LINE\","
                + "                \"international\": \"+82 31-2222-5555\","
                + "                \"display\": \"031-2222-5555\","
                + "                \"verification\": \"TOVERIFY\""
                + "            },"
                + "            {"
                + "                \"type\": \"IPT\","
                + "                \"display\": \"개발 2팀\","
                + "                \"number\": \"987654321\""
                + "            },"
                + "            \"...\""
                + "        ],"
                + "        \"birthday\": \"01-01\","
                + "        \"gender\": \"FEMALE\","
                + "        \"is_lunar\": false,"
                + "        \"photo_url\": \"\""
                + "    },"
                + "    \"...\""
                + "]"
                + "}";
    	
        return jsonString;
    }
	
	@GetMapping("/user/v0/getChangedUsers")
    public ValidVo getgetChangedUsers(@RequestBody Valid Valid) {
        
    	Content ct = new Content();
    	
    	ValidVo va = new ValidVo(200, "ok",12, 5555, 500, 2, 500, false, false ,ct);
    	
        return va;
    }

}

