package com.ms.cat.remoteservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ms.cat.dto.ManageProxyDTO;
import com.ms.cat.model.ManageProxyRepsonse;

@Component
public class ManageProxyMSFallBack implements ManageProxyService {

	@Override
	public ManageProxyRepsonse addProxyDef(String token,ManageProxyDTO proxyDefObj) {
		// TODO Auto-generated method stub
		return new ManageProxyRepsonse("Failed","manageproxyms not available for addProxyDef",proxyDefObj);
	}

	@Override
	public ManageProxyDTO updateProxyDef(String token,ManageProxyDTO proxyDefObj) throws NODataFoundException {
		// TODO Auto-generated method stub
		return new ManageProxyDTO("00","00","00");
	}

	@Override
	public List<ManageProxyDTO> getProxyDef(String token) {
		// TODO Auto-generated method stub
		ManageProxyDTO pDTO = new ManageProxyDTO("00","00","00");
		List<ManageProxyDTO> proxyDefList = new ArrayList<ManageProxyDTO>();
		proxyDefList.add(pDTO);
		return proxyDefList;
	}

	@Override
	public ManageProxyDTO getProxyDefById(String token,int id) throws NODataFoundException {
		// TODO Auto-generated method stub
		return new ManageProxyDTO("00","00","00");
	}

	@Override
	public String deleteProxyDef(String token,String name) throws NODataFoundException {
		// TODO Auto-generated method stub
		return "manageproxyms is not available for deleting proxydefinitions";
	}

}
