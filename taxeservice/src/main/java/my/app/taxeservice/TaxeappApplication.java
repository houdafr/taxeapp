package my.app.taxeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
//@EnableEurekaClient
public class TaxeappApplication {

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	@Bean
	public WebClient webClient(){
		return  WebClient.builder().build();
	}


	public static void main(String[] args) {
		SpringApplication.run(TaxeappApplication.class, args);
	}

}
