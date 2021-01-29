package com.ms.cat.remoteservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ms.cat.dto.ManageProxyDTO;
import com.ms.cat.model.MessageResponse;
import com.ms.cat.model.ManageProxyRepsonse;
import com.ms.cat.remoteservice.ManageProxyMSFallBack;

@FeignClient(name= "manageproxyms" , fallback = ManageProxyMSFallBack.class)
public interface ManageProxyService {
	
	@PostMapping("/proxydef/addProxyDef") //create new proxydef
	public ManageProxyRepsonse addProxyDef(@RequestHeader("Authorization") String authorizationToken,@RequestBody ManageProxyDTO product);

        @PutMapping("/proxydef/updateProxyDef") //update existing proxydef
	public ManageProxyDTO updateProxyDef(@RequestHeader("Authorization") String authorizationToken,@RequestBody ManageProxyDTO product) throws NODataFoundException;

        @GetMapping("/proxydef/getProxyDef") //List all proxydef
	public List<ManageProxyDTO> getProxyDef(@RequestHeader("Authorization") String authorizationToken);

        @GetMapping("/proxydef/getProxyDefById/{id}") //List given proxydef
	public  ManageProxyDTO  getProxyDefById(@RequestHeader("Authorization") String authorizationToken,@PathVariable int id) throws NODataFoundException;

        @DeleteMapping("/proxydef/deleteProxyDef/{name}")
	public String deleteProxyDef(@RequestHeader("Authorization") String authorizationToken,@PathVariable String name) throws NODataFoundException;

}
