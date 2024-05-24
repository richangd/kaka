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
import com.example.demo.domain.more_telephones;
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
    public ValidVo getValidUsers() {
            	
		ValidVo vd = new ValidVo();
    	
        return vd;
    }
	
	@GetMapping("/user/v0/getChangedUsers")
    public ValidVo getgetChangedUsers(@RequestBody Valid Valid) {
        
		more_telephones ph =  new more_telephones();
		Content ct = new Content(ph);
    	
    	
    	ValidVo va = new ValidVo(200, "ok",12, 5555, 500, 2, 500, false, false ,ct);
    	
        return va;
    }

}

