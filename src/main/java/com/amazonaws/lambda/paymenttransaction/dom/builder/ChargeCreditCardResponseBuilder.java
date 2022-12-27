package com.amazonaws.lambda.paymenttransaction.dom.builder;

import com.amazonaws.lambda.paymenttransaction.dom.data.response.ChargeCreditCardResponse;

import net.authorize.api.contract.v1.CreateTransactionResponse;

public class ChargeCreditCardResponseBuilder extends ResponseBuilder {

	public ChargeCreditCardResponse getChargeCreditCardResponse(CreateTransactionResponse response) {
		ChargeCreditCardResponse chargeCCResponse = null;
		if(response != null) {
			chargeCCResponse = new ChargeCreditCardResponse();
			chargeCCResponse.setTransactionResponse(getTransactionResponse(response.getTransactionResponse()));
			chargeCCResponse.setRefId(response.getRefId());
		}
		return chargeCCResponse;
	}
	
}
