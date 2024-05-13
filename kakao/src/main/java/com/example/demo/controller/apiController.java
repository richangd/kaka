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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Hello;
import com.example.demo.domain.MetadataVo;
import com.example.demo.domain.Param;
import com.example.demo.domain.agentVo;
import com.example.demo.domain.editability;
import com.example.demo.domain.idreturn;
import com.example.demo.domain.synchronize_options;
import com.example.demo.domain.telephones;
import com.example.demo.model.Userprofiles;

@RestController
@RequestMapping(value = "api")
public class apiController {
   private Map<String, Userprofiles> userMap;
   
   @PostMapping("/login/v0/identifyUser")
   public idreturn post(@RequestBody Param param) {
	   idreturn idreturn = new idreturn("Success", "AUTH_SUCCESS", 200, "OK");   

       return idreturn;
   }
   
   @GetMapping("/login/v0")
   public List<Userprofiles> getuserprofilesList() {
	   return new ArrayList<Userprofiles>(userMap.values());
   }
   
   

    @GetMapping("/agent/v0/getAgentCapabilities")
    public agentVo getAgentCapabilities() {
        
    	agentVo ag = new agentVo();
    	
        return ag;
    }
    
    @GetMapping("/user/v0/getUserMetadata")
    public MetadataVo getUserMetadata() {
        
    	telephones te = new telephones();
    	List<synchronize_options> sy= new ArrayList<>();
    	
    	editability ed = new editability(te); 
        
    	sy.add(new synchronize_options("정직원 제외", "except_full_time_employee"));
    	sy.add(new synchronize_options("계약 제외", "except_contract"));
    	sy.add(new synchronize_options("협력업체 제외", "except_subcontract"));
        
    	MetadataVo ag = new MetadataVo(ed, sy);
    	
        return ag;
    }

}

