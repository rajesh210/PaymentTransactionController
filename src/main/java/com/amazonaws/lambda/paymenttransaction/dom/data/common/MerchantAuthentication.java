package com.amazonaws.lambda.paymenttransaction.dom.data.common;


public class MerchantAuthentication {
	
	private String name;
	private String transactionKey;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTransactionKey() {
		return transactionKey;
	}
	public void setTransactionKey(String transactionKey) {
		this.transactionKey = transactionKey;
	}

}
