package com.example.switterv1;

import com.example.switterv1.domain.User;
import com.example.switterv1.repos.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SwitterV1ApplicationTests {
	@Autowired
	public  UserRepo userRepo;

	@Test
	void contextLoads() {
		List<User> user = userRepo.findUserCustom("f");
		System.out.println(user);
	}

}
