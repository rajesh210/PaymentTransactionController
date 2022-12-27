package com.amazonaws.lambda.paymenttransaction.dom.builder;

import com.amazonaws.lambda.paymenttransaction.dom.data.response.RefundTransactionResponse;

import net.authorize.api.contract.v1.CreateTransactionResponse;

public class RefundTransactionResponseBuilder extends ResponseBuilder {

	public RefundTransactionResponse getRefundTransactionResponse(CreateTransactionResponse apiResponse) {
		RefundTransactionResponse response = null;
		if(apiResponse != null) {
			response = new RefundTransactionResponse();
			response.setTransactionResponse(getTransactionResponse(apiResponse.getTransactionResponse()));
			response.setRefId(response.getRefId());
		}
		return response;
	}
	
}
