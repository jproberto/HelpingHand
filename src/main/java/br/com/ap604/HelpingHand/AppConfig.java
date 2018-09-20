package br.com.ap604.HelpingHand;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableJpaAuditing
@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
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
