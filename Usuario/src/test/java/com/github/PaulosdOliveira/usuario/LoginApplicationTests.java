package com.github.PaulosdOliveira.usuario;

import com.github.PaulosdOliveira.usuario.jwt.ChaveSecreta;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginApplicationTests {

	@Autowired
	private ChaveSecreta cave;

	@Test
	void contextLoads() {
	}


	@Test
	public void test(){
		System.out.println(cave.getSecret());
	}

}
