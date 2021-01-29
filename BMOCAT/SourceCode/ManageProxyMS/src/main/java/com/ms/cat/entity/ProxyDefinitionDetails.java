package com.ms.cat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proxyDefinitionDetails")
public class ProxyDefinitionDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer prxy_id;

	@Column(name = "prxy_cd")
	private String prxy_cd;
	@Column(name = "crt_usr_id")
	private String crt_usr_id;
	@Column(name = "prxy_stat_tp_cd")
	private String prxy_stat_tp_cd;

	public ProxyDefinitionDetails() {
		super();
	}

	public ProxyDefinitionDetails(Integer prxy_id, String prxy_cd, String crt_usr_id, String prxy_stat_tp_cd) {
		super();
		this.prxy_id = prxy_id;
		this.prxy_cd = prxy_cd;
		this.crt_usr_id = crt_usr_id;
		this.prxy_stat_tp_cd = prxy_stat_tp_cd;
	}

	public ProxyDefinitionDetails(String prxy_cd, String crt_usr_id, String prxy_stat_tp_cd) {
		super();
		this.prxy_cd = prxy_cd;
		this.crt_usr_id = crt_usr_id;
		this.prxy_stat_tp_cd = prxy_stat_tp_cd;
	}

	public Integer getPrxy_id() {
		return prxy_id;
	}

	public String getPrxy_cd() {
		return prxy_cd;
	}

	public String getCrt_usr_id() {
		return crt_usr_id;
	}

	public String getPrxy_stat_tp_cd() {
		return prxy_stat_tp_cd;
	}

	public void setPrxy_id(Integer prxy_id) {
		this.prxy_id = prxy_id;
	}

	public void setPrxy_cd(String prxy_cd) {
		this.prxy_cd = prxy_cd;
	}

	public void setCrt_usr_id(String crt_usr_id) {
		this.crt_usr_id = crt_usr_id;
	}

	public void setPrxy_stat_tp_cd(String prxy_stat_tp_cd) {
		this.prxy_stat_tp_cd = prxy_stat_tp_cd;
	}

}
