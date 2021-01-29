package com.ms.cat.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.ms.cat.entity.ProxyDefinitionDetails;



@Component
public interface ProxyDefinitionRepo extends JpaRepository<ProxyDefinitionDetails, Integer>{

	//Optional<ProxyDefinitionDetails> findByPrxy_cd(String prxy_cd);
	@Query("SELECT pdd FROM ProxyDefinitionDetails pdd WHERE pdd.prxy_cd = :prxy_cd") 
	Optional<ProxyDefinitionDetails> findByPrxy_cd(String prxy_cd);
}