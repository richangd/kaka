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
import com.example.demo.domain.Param;
import com.example.demo.domain.idreturn;
import com.example.demo.model.Userprofiles;

@RestController
@RequestMapping(value = "api")
public class apiController {
   private Map<String, Userprofiles> userMap;
   
   @PostMapping("/login/v0")
   public idreturn post(@RequestBody Param param) {
	   idreturn idreturn = new idreturn("Success", "AUTH_SUCCESS", 200, "OK");   

       return idreturn;
   }
   
   @PostMapping("/login/v0/identifyUser")
   public idreturn posttest(@RequestBody idreturn param) {
	   
	   idreturn idreturn = new idreturn(param.getResult(), param.getReason(), param.get_code(), param.get_message());   

       return idreturn;
   }
   
   @GetMapping("/login/v0")
   public List<Userprofiles> getuserprofilesList() {
	   return new ArrayList<Userprofiles>(userMap.values());
   }
   
   

    @GetMapping("argsDefault")
    public Hello getArgsDefault(
            @RequestParam(value = "msg")String msg,
            @RequestParam(value = "msg2", required = false, defaultValue = "msg2Default")String msg2) {
        Hello hello = new Hello(msg);
        hello.setMsg(hello.getMsg() + ", " + msg2);

        return hello;
    }
/*
    @PostMapping()
    public Hello post(@RequestBody Param param) {
        String msg = "identifier : sdmail@kr.canon, password : solrnd0803!@";
        Hello hello = new Hello(msg);
        return hello;
    }
*/
    @PutMapping()
    public Hello put(@RequestParam(value = "param1")String param1) {
        Hello hello = new Hello("Put Request : " + param1);
        return hello;
    }

}

