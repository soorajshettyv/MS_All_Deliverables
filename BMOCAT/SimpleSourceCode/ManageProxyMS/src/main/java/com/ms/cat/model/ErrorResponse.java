package com.ms.cat.model;

public class ErrorResponse {

	String status;
	String msg;
	
	public ErrorResponse()
	{
		
	}
			
	public ErrorResponse(String status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}