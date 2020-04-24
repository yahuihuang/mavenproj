package com.example.mavenproj;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MavenprojApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MavenprojApplicationTests {
	/**
	 * @LocalServerPort 提供了 @Value("${local.server.port}") 的代替
	 */
	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate restTemplate;

	@Before
	public void setUp() throws Exception {
		port = 8080;
		String url = String.format("http://localhost:%d/", port);
		System.out.println(String.format("port is : [%d]", port));
		this.base = new URL(url);
	}

	/*
	@Test
	void contextLoads() {
		System.out.println("base: " + base.toString());
		ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);
		assertThat(response.getBody(), equalTo("Hello Spring Boot"));
	}*/

	/**
	 * 向"/test"地址发送请求，并打印返回结果
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		ResponseEntity<String> response = this.restTemplate.getForEntity(
				this.base.toString(), String.class, "");
		System.out.println(String.format("測試結果：%s", response.getBody()));
	}
}
