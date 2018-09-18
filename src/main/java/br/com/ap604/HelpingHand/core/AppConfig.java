package br.com.ap604.HelpingHand.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class AppConfig {

	@Value("${ambiente.ativo}")
	private String ambiente;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AppConfig.class, args);
	}

	@RequestMapping("/")
	String index() {
		System.out.println(ambiente);
		return ambiente;
	}

}
