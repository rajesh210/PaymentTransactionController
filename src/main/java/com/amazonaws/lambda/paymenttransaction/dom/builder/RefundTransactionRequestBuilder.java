package com.amazonaws.lambda.paymenttransaction.dom.builder;

import com.amazonaws.lambda.paymenttransaction.dom.data.request.RefundTransactionRequest;

public class RefundTransactionRequestBuilder extends RequestBuilder {

	public net.authorize.api.contract.v1.CreateTransactionRequest getRefundTransactionRequest(RefundTransactionRequest request) {
		net.authorize.api.contract.v1.CreateTransactionRequest apiRequest = new net.authorize.api.contract.v1.CreateTransactionRequest();
		if(request != null) {
			apiRequest.setRefId(request.getRefId());
			apiRequest.setClientId(request.getClientId());
			apiRequest.setMerchantAuthentication(getMerchantAuthentication(request.getMerchantAuthentication()));
			apiRequest.setTransactionRequest(getTransactionType(request.getTransactionRequest()));
		}
		return apiRequest;
	}
	
}
