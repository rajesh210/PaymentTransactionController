package com.amazonaws.lambda.paymenttransaction.dom.data.common;

import java.util.List;

public class Messages {

	private String resultCode;
	private List<Message> message;
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public List<Message> getMessage() {
		return message;
	}
	public void setMessage(List<Message> message) {
		this.message = message;
	}
		
}
