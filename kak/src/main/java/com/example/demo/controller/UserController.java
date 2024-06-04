package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.example.demo.domain.Player;
import com.example.demo.domain.UserVO;
import com.example.demo.domain.ValidVo;
import com.example.demo.domain.agentVo;
import com.example.demo.domain.more_telephones;
import com.example.demo.domain.more_telephones1;
import com.example.demo.exeption.MissingRequiredHeaderException;
import com.example.demo.service.impl.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@RequestMapping(value = "/user/now", method = RequestMethod.GET)
    public @ResponseBody String getNow(Model model) {

		return userServiceImpl.getNow();
    }
	
	@GetMapping("user/list")
	public @ResponseBody List<UserVO> getUserList(){
		
		return userServiceImpl.getUserList();
	}
	
	@GetMapping("agent/list")
	public @ResponseBody List<UserVO> getagentList(){
		
		return userServiceImpl.getAgentList();
	}
	/*
	@PostMapping("player")
	public String postOnePlayer(@RequestBody Player player) {
	    //String response = String.format("<선수 정보>\n이름 : %s\n등번호 : %d\n나이 : %d",
	    //        player.getName(), player.getBackNumber(), player.getAge());
	    
	    String response = player.getName();
	    return response;
	}
	*/
	@GetMapping("player")
	public Player getOnePlayer() {
	    Player player1 = new Player("Son Heungmin", 7, 30);
	    return player1;
	}

	@GetMapping("/players")
	public ArrayList<Player> getAllPlayer() {
	    Player player1 = new Player("Son Heungmin", 7, 30);
	    Player player2 = new Player("Harry Kane", 10, 29);
	    Player player3 = new Player("Hugo Lloris", 1, 36);

	    ArrayList<Player> players = new ArrayList<>();
	    players.add(player1);
	    players.add(player2);
	    players.add(player3);

	    return players;
	}
	
	@PostMapping("/player")
	public String postOnePlayer(@RequestBody Player player) {
	    String response = String.format("<선수 정보>\n이름 : %s\n등번호 : %d\n나이 : %d",
	            player.getName(), player.getBackNumber(), player.getAge());
	    return response;
	}
	
	@PostMapping("/players")
	public String postPlayers(@RequestBody List<Player> players) {
	    String response = "<선수단 정보>\n";

	    int i = 1;
	    for (Player player : players) {
	        response += String.format("선수%d: 이름 : %s\t등번호 : %d\t나이 : %d\n",
	                i, player.getName(), player.getBackNumber(), player.getAge());
	        i ++;
	    }

	    return response;
	}
	
	 @GetMapping("/user/v0/getValidUsers")
	 public String getAgentCapabilit(@RequestHeader(value = "Kep-OrgLoginType", required = false) String OrgLoginType) {
	    	agentVo ag = new agentVo();
	    	String jsonString = null;
	    	
	    	if (OrgLoginType == null) {
	            throw new MissingRequiredHeaderException("The required header is missing.");
	        }else {
	        	String g1 = "agent";
	    		String g2 = "user";
	    		String g3 = "login";
	    		String g4 = "orgunit";
	    		
	        	ag = new agentVo(200, "ok", new String[]{g1, g2});
	        }
	    	
	    	ValidVo va = new ValidVo();
			
			String g1 = "test.kim";
			String g2 = "10405312";
			String g3 = "Kim.Changbeom@kr.canon";
			
			String[] li = new String[]{g1, g2, g3};
			List<Content> ct = new ArrayList();
			List mo = new ArrayList();
			
			List<more_telephones> ph = new ArrayList();
			
			ph.add(new more_telephones("MOBILE", "+82 10-1111-2222", "010-1111-2222", "TOVERIFY"));
			
			ct.add(new Content("ACTIVE", li ,"테스트", "테스트", "Kim.Changbeom@kr.canon", "TO_VERIFY", "+82 10-1234-5678", "010-1234-5678 내선 5", "TO_VERIFY", ph, "01-01", "MALE", false, ""));
			
			g1 = "관리자";
			g2 = "10377788";
			g3 = "sdmail@kr.canon";
			
			li = new String[]{g1, g2, g3};
			
			mo.add(new more_telephones("FIXED_LINE", "+82 31-2222-5555", "031-2222-5555", "TOVERIFY"));
			mo.add(new more_telephones1("IPT", "개발 2팀", "987654321"));
			
			ct.add(new Content("ACTIVE", li ,"관리자", "admin_canon", "sdmail@kr.canon", "TO_VERIFY", "+82 10-8765-4321", "010-8765-4321 휴대용", "TO_VERIFY", mo, "01-01", "FEMALE", false, ""));
			
	    	
			if (OrgLoginType == null) {
	            throw new MissingRequiredHeaderException("The required header is missing.");
	        }else {
	        	va = new ValidVo(200, "ok", 12, 5555, 500, 1, 500, false, true, ct);
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
}