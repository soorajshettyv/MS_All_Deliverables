package com.ms.cat.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ms.cat.entity.ProxyDefinitionDetails;
import com.ms.cat.exception.NODataFoundException;
import com.ms.cat.repository.ProxyDefinitionRepo;

@Service
@Component
@Transactional
public class ProxyDefinitionService {
	
		
		@Autowired
		ProxyDefinitionRepo repo;

		public void addProxyDefinition(ProxyDefinitionDetails proxyDefDetailObj) {
			repo.save(proxyDefDetailObj);
			
		}

		public ProxyDefinitionDetails updateProxyDefinition(ProxyDefinitionDetails proxyDef) throws NODataFoundException {
		Optional<ProxyDefinitionDetails> proxyDefDetailObj =	repo.findByPrxy_cd(proxyDef.getPrxy_cd());
		
		if(proxyDefDetailObj.isPresent())
		{	
			ProxyDefinitionDetails	proxyDefDetObj = proxyDefDetailObj.get();
			proxyDefDetObj.setCrt_usr_id(proxyDef.getCrt_usr_id());
			proxyDefDetObj.setPrxy_stat_tp_cd(proxyDef.getPrxy_stat_tp_cd());
		
			return repo.save(proxyDefDetObj);
		}
		else
			throw new NODataFoundException("400", "Given proxy " +proxyDef.getPrxy_cd() +" details are not found. Please try again !!") ;

		}

		

		public List<ProxyDefinitionDetails> getProxyDefinition() {
			
			return repo.findAll();
		}
		public  ProxyDefinitionDetails  getProxyByName(String prxy_cd) throws NODataFoundException {
		
			Optional<ProxyDefinitionDetails> proxyDefDetObj =	repo.findByPrxy_cd(prxy_cd);
			
			if(proxyDefDetObj.isPresent())
			{
				return proxyDefDetObj.get();
			}
			else
				throw new NODataFoundException("400", "Given proxy " +prxy_cd +" details are not found. Please try again !!") ;
			
		}

		public void deleteProxyDef(String prxy_cd) throws NODataFoundException {
			ProxyDefinitionDetails proxyDefDetObj =	getProxyByName(prxy_cd);
			repo.delete(proxyDefDetObj);
			
		}

		public ProxyDefinitionDetails getProxyDefById(int id) throws NODataFoundException 
		{
			Optional<ProxyDefinitionDetails> proxyDefDetObj = repo.findById(id);
			if(proxyDefDetObj.isPresent())
			{
				System.out.println(proxyDefDetObj.get().getCrt_usr_id()+proxyDefDetObj.get().getPrxy_cd());
				return proxyDefDetObj.get();
			}
			else
				throw new NODataFoundException("400", "Given product id " +id +" details are not found. Please try again !!") ;
	
				
		}
		

	

}

