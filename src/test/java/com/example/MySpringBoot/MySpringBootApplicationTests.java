package com.example.MySpringBoot;

import com.example.MySpringBoot.Service.JwtService;
import com.example.MySpringBoot.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MySpringBootApplicationTests {

	@Autowired
	private JwtService jwtService;
	@Test
	void contextLoads() {

//		User user = new User(1L,"prateek","prateek");
//		String Token = jwtService.generateToken(user);
//		System.out.println("Token=: "+Token);
//		Long id = jwtService.getUserIdFromToken(Token);
//		System.out.println("ID of the user : "+id);

	}

}
