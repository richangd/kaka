package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVo {

	private String userId;
	private String userName;
	private String phoneNumber;
}
