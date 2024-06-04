package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Player;
import com.example.demo.domain.UserVO;
import com.example.demo.service.impl.UserServiceImpl;

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
}