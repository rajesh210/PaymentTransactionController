package com.amazonaws.lambda.paymenttransaction.dom.data.request;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.amazonaws.lambda.paymenttransaction.dom.data.common.MerchantAuthentication;
import com.amazonaws.lambda.paymenttransaction.dom.data.common.TransactionRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name="authCreditCardRequest")
@XmlType(name="authCreditCardRequest")
public class AuthCreditCardRequest {
	
	private MerchantAuthentication merchantAuthentication;
	private String clientId;
	private String refId;
	private TransactionRequest transactionRequest;

	public MerchantAuthentication getMerchantAuthentication() {
		return merchantAuthentication;
	}
	public void setMerchantAuthentication(MerchantAuthentication merchantAuthentication) {
		this.merchantAuthentication = merchantAuthentication;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	public TransactionRequest getTransactionRequest() {
		return transactionRequest;
	}
	public void setTransactionRequest(TransactionRequest transactionRequest) {
		this.transactionRequest = transactionRequest;
	}

}
