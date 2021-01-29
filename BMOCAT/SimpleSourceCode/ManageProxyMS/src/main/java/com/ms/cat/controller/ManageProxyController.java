package com.ms.cat.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//import com.ms.bootcamp.jwt.JwtUtils;
import com.ms.cat.entity.ProxyDefinitionDetails;
import com.ms.cat.exception.NODataFoundException;
import com.ms.cat.model.MessageResponse;
import com.ms.cat.service.ProxyDefinitionService;


@RestController
@RequestMapping("/proxydef")
@PreAuthorize("hasRole('ROLE_CATADMIN') or hasRole('ROLE_CATUSR') or hasRole('ROLE_CATREAD')")
public class ManageProxyController {
Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ProxyDefinitionService proxyDefinitionService;
	
	
	
	//Boolean isValid = false;
	
	private static final String SUCCESS_RESOURCECREATED_MESSAGE = "successfully added";
	private static final String SUCCESS_RESOURCEUPDATED_MESSAGE = "successfully updated";

	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/addProxyDef") //create new Product
	public MessageResponse addProxyDef(@RequestBody ProxyDefinitionDetails proxyDefDetObj)
	{
		proxyDefinitionService.addProxyDefinition(proxyDefDetObj);
		return new MessageResponse(HttpStatus.CREATED.toString(), SUCCESS_RESOURCECREATED_MESSAGE,
				proxyDefDetObj);
	}
	
	@PutMapping("/updateProxyDef") //update existing product
	public ProxyDefinitionDetails updateProxyDef(@RequestBody ProxyDefinitionDetails proxyDefDetObj) throws NODataFoundException
	{
		return proxyDefinitionService.updateProxyDefinition(proxyDefDetObj);
	
	}
	
	@GetMapping("/getProxyDef") //List all products
	public List<ProxyDefinitionDetails> getProxyDef()
	{
		return proxyDefinitionService.getProxyDefinition();
	
	}
	

	@GetMapping("/getProxyDefById/{id}") //List given product
	public  ProxyDefinitionDetails  getProxyDefById(@PathVariable int id) throws NODataFoundException
	{
		log.info("----------getProductById----------"+id);
		System.out.println("id"+id);
		return proxyDefinitionService.getProxyDefById(id);
	
	}
	
	@DeleteMapping("/deleteProxyDef/{name}")
	public void deleteProxyDef(@PathVariable String name) throws NODataFoundException
	{
		proxyDefinitionService.deleteProxyDef(name);
	}
	
}
