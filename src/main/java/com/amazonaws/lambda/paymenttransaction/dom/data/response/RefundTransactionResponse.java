package com.amazonaws.lambda.paymenttransaction.dom.data.response;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.amazonaws.lambda.paymenttransaction.dom.data.common.Messages;
import com.amazonaws.lambda.paymenttransaction.dom.data.common.TransactionResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name="refundTransactionResponse")
@XmlType(name="refundTransactionResponse")
public class RefundTransactionResponse {

	private TransactionResponse transactionResponse;
	private String refId;
	private Messages messages;
	
	public TransactionResponse getTransactionResponse() {
		return transactionResponse;
	}
	public void setTransactionResponse(TransactionResponse transactionResponse) {
		this.transactionResponse = transactionResponse;
	}
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	public Messages getMessages() {
		return messages;
	}
	public void setMessages(Messages messages) {
		this.messages = messages;
	}

}
