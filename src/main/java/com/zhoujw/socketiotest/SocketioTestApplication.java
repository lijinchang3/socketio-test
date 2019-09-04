package com.zhoujw.socketiotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
@EnableAutoConfiguration
@ServletComponentScan
public class SocketioTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocketioTestApplication.class, args);
	}

	@RequestMapping("/jsp/test")
//	@ResponseBody
	public String test(){
		return "test";
	}
}
