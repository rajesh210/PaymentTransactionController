package com.amazonaws.lambda.paymenttransaction.dom.builder;

import com.amazonaws.lambda.paymenttransaction.dom.data.response.AuthCreditCardResponse;

import net.authorize.api.contract.v1.CreateTransactionResponse;

public class AuthCreditCardResponseBuilder extends ResponseBuilder {

	public AuthCreditCardResponse getCreateTransactionResponse(CreateTransactionResponse response) {
		AuthCreditCardResponse authResponse = null;
		if(response != null) {
			authResponse = new AuthCreditCardResponse();
			authResponse.setTransactionResponse(getTransactionResponse(response.getTransactionResponse()));
			authResponse.setRefId(response.getRefId());
		}
		return authResponse;
	}
	
}
