package com.ms.cat.dto;

public class ManageProxyDTO {
	private String prxy_cd;
	   
	private String crt_usr_id;
	private String prxy_stat_tp_cd;
	
	
	public ManageProxyDTO() {};
	
	public ManageProxyDTO(String prxy_cd, String crt_usr_id, String prxy_stat_tp_cd) {
		super();
		this.prxy_cd = prxy_cd;
		this.crt_usr_id = crt_usr_id;
		this.prxy_stat_tp_cd = prxy_stat_tp_cd;

	}
	
	public String getPrxy_cd() {
		return prxy_cd;
	}

	public void setPrxy_cd(String prxy_cd) {
		this.prxy_cd = prxy_cd;
	}

	public String getCrt_usr_id() {
		return crt_usr_id;
	}

	public void setCrt_usr_id(String crt_usr_id) {
		this.crt_usr_id = crt_usr_id;
	}

	public String getPrxy_stat_tp_cd() {
		return prxy_stat_tp_cd;
	}

	public void setPrxy_stat_tp_cd(String prxy_stat_tp_cd) {
		this.prxy_stat_tp_cd = prxy_stat_tp_cd;
	}
	

}

