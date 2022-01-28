package com.sinensia.demo;

import org.assertj.core.api.AbstractStringAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class DemoProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void rootTest(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate.getForObject("/", String.class)).isEqualTo("Good morning team!");
	}

	@Test
	void helloTestDefault(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate.getForObject("/hello", String.class)).isEqualTo("Hello World!");
	}

	@Test
	void helloTestName(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate.getForObject("/hello?name=Mai", String.class)).isEqualTo("Hello Mai!");
	}

	@Test
	void canAdd(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate.getForObject("/add?a=1&b=2", String.class)).isEqualTo("3");
	}
}
