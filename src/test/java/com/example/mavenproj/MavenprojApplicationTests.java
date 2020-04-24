package com.example.mavenproj;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@SpringBootTest(classes = MavenprojApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MavenprojApplicationTests {
	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate template;

	@Before
	public void setup() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
	}

	@Test
	void contextLoads() {
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		assertThat(response.getBody(), equalTo("Hello Spring Boot"));
	}

}
