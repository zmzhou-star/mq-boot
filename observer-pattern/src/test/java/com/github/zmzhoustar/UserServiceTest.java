package com.github.zmzhoustar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.zmzhoustar.common.UserVo;

@SpringBootTest
class UserServiceTest {
	@Autowired
	private UserService userService;

	@Test
	void addUser() {
		UserVo user = UserVo.builder()
			.id(System.currentTimeMillis())
			.name("publishEvent").build();
		userService.addUser(user);
	}
}
