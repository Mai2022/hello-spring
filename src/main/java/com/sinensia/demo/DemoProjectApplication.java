package com.sinensia.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProjectApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/")
	public String nothing(@RequestParam(value = "name", defaultValue = "team") String name) {
	return String.format("Good morning %s!", name);
	}

	@GetMapping("/add")
	public Object add(
			@RequestParam(value="a", defaultValue = "0") Float a,
			@RequestParam(value="b", defaultValue = "0") Float b
	) {
		Float sum = a+b;
		Float decimals = sum - sum.intValue();
		if(decimals!=0) {
			return sum;
		}
		return Integer.valueOf(sum.intValue());
	}

}