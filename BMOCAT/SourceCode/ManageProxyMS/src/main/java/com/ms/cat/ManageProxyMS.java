package com.ms.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ms.cat.entity.ProxyDefinitionDetails;
import com.ms.cat.repository.ProxyDefinitionRepo;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard
@EnableFeignClients
public class ManageProxyMS {

	
	@Autowired
	ProxyDefinitionRepo repo;
	
	public static void main(String[] args) {
		SpringApplication.run(ManageProxyMS.class, args);
	}

	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
			return args -> {
				
				ProxyDefinitionDetails proxyDefDetObj = new ProxyDefinitionDetails(1,"01","02","03");
				repo.save(proxyDefDetObj);
				proxyDefDetObj = new ProxyDefinitionDetails(2,"11","12","13");
				repo.save(proxyDefDetObj);	
				proxyDefDetObj = new ProxyDefinitionDetails(3,"21","22","23");
				repo.save(proxyDefDetObj);	

			};
	}
}
