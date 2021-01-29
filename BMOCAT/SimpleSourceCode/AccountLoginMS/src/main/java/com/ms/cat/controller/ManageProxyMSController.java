package com.ms.cat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.cat.dto.ManageProxyDTO;
import com.ms.cat.jwt.JwtUtils;
import com.ms.cat.model.ManageProxyRepsonse;
import com.ms.cat.remoteservice.NODataFoundException;
import com.ms.cat.remoteservice.ManageProxyService;
import com.ms.cat.repository.RoleRepository;
import com.ms.cat.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/cat/manageProxy")
@PreAuthorize("hasRole('ROLE_CATADMIN')")
public class ManageProxyMSController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	ManageProxyService manageProxyService;
	

	
	@PostMapping("/proxydef/addProxyDef") //create new Product
	public ManageProxyRepsonse addProxyDef(@RequestHeader("Authorization") String authorizationToken,@RequestBody ManageProxyDTO manageProxDefObj) {
		ManageProxyRepsonse response =  manageProxyService.addProxyDef(authorizationToken,manageProxDefObj);
		return response;
		
	}

        @PutMapping("/proxydef/updateProxyDef") //update existing product
	public ManageProxyDTO updateProxyDef(@RequestHeader("Authorization") String authorizationToken,@RequestBody ManageProxyDTO manageProxDefObj) throws NODataFoundException{
		
        	ManageProxyDTO pDTO = manageProxyService.updateProxyDef(authorizationToken,manageProxDefObj);
        	return pDTO;
		
	}

        @GetMapping("/proxydef/getProxyDef") //List all products
	public List<ManageProxyDTO> getProxyDef(@RequestHeader("Authorization") String authorizationToken){
        	List<ManageProxyDTO> proxyDefList=	manageProxyService.getProxyDef(authorizationToken);
		return proxyDefList;
		
	}

        @GetMapping("/proxydef/{proxyDefId}") //List given product
	public  ManageProxyDTO  getProxyDefById(@RequestHeader("Authorization") String authorizationToken,@PathVariable int proxyDefId) throws NODataFoundException{
        	ManageProxyDTO pDTO = manageProxyService.getProxyDefById(authorizationToken,proxyDefId);
		 return pDTO;
        }

        
        @DeleteMapping("/proxydef/deleteProxyDef/{proxyDefName}")
	public String deleteProxyDef(@RequestHeader("Authorization") String authorizationToken,@PathVariable String proxyDefName) throws NODataFoundException {
        	try {
        		manageProxyService.deleteProxyDef(authorizationToken,proxyDefName);
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        	return "proxy definition deleted"+ proxyDefName;
        }
	
       
        
        
}
