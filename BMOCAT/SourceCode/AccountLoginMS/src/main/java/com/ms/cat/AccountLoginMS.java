package com.ms.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ms.cat.entity.ERole;
import com.ms.cat.entity.Role;
import com.ms.cat.repository.RoleRepository;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
@EnableFeignClients
public class AccountLoginMS {
	
	@Autowired
	RoleRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(AccountLoginMS.class, args);
	}
	
	

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
			return args -> {
				Role r = new Role(ERole.ROLE_CATADMIN);
				repo.save(r);
	            r = new Role(ERole.ROLE_CATUSR);
				repo.save(r);
	            r = new Role(ERole.ROLE_CATREAD);
				repo.save(r);		
				r = new Role(ERole.ROLE_CATUP);
				repo.save(r);		

			};
	}

}
