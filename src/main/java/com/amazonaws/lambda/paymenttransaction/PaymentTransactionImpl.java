package com.amazonaws.lambda.paymenttransaction;

import com.amazonaws.lambda.paymenttransaction.dom.builder.AuthCreditCardRequestBuilder;
import com.amazonaws.lambda.paymenttransaction.dom.builder.AuthCreditCardResponseBuilder;
import com.amazonaws.lambda.paymenttransaction.dom.builder.ChargeCreditCardRequestBuilder;
import com.amazonaws.lambda.paymenttransaction.dom.builder.ChargeCreditCardResponseBuilder;
import com.amazonaws.lambda.paymenttransaction.dom.builder.RefundTransactionRequestBuilder;
import com.amazonaws.lambda.paymenttransaction.dom.builder.RefundTransactionResponseBuilder;
import com.amazonaws.lambda.paymenttransaction.dom.data.request.AuthCreditCardRequest;
import com.amazonaws.lambda.paymenttransaction.dom.data.request.ChargeCreditCardRequest;
import com.amazonaws.lambda.paymenttransaction.dom.data.request.RefundTransactionRequest;
import com.amazonaws.lambda.paymenttransaction.dom.data.response.AuthCreditCardResponse;
import com.amazonaws.lambda.paymenttransaction.dom.data.response.ChargeCreditCardResponse;
import com.amazonaws.lambda.paymenttransaction.dom.data.response.RefundTransactionResponse;

import net.authorize.Environment;
import net.authorize.api.contract.v1.CreateTransactionResponse;
import net.authorize.api.controller.CreateTransactionController;
import net.authorize.api.controller.base.ApiOperationBase;

public class PaymentTransactionImpl {
	
	public AuthCreditCardResponse authorizeCreditCard(AuthCreditCardRequest request) {
        ApiOperationBase.setEnvironment(Environment.SANDBOX);
        AuthCreditCardRequestBuilder requestBuilder = new AuthCreditCardRequestBuilder();
        net.authorize.api.contract.v1.CreateTransactionRequest apiRequest = 
        		requestBuilder.getCreateTransactionRequest(request);
		CreateTransactionController controller = new CreateTransactionController(apiRequest);
		controller.execute();
		CreateTransactionResponse apiResponse = controller.getApiResponse();
		AuthCreditCardResponseBuilder responseBuilder = new AuthCreditCardResponseBuilder();
		AuthCreditCardResponse response = responseBuilder.getCreateTransactionResponse(apiResponse);
		return response;
	}
	
	public RefundTransactionResponse refundTrasanction(RefundTransactionRequest request) {
        ApiOperationBase.setEnvironment(Environment.SANDBOX);
        RefundTransactionRequestBuilder requestBuilder = new RefundTransactionRequestBuilder();
        net.authorize.api.contract.v1.CreateTransactionRequest apiRequest = 
        		requestBuilder.getRefundTransactionRequest(request);
		CreateTransactionController controller = new CreateTransactionController(apiRequest);
		controller.execute();
		CreateTransactionResponse apiResponse = controller.getApiResponse();
		RefundTransactionResponseBuilder responseBuilder = new RefundTransactionResponseBuilder();
        RefundTransactionResponse response = responseBuilder.getRefundTransactionResponse(apiResponse);
        return response;
	}
	
	public ChargeCreditCardResponse changeCreditCard(ChargeCreditCardRequest request) {
        ApiOperationBase.setEnvironment(Environment.SANDBOX);
        ChargeCreditCardRequestBuilder requestBuilder = new ChargeCreditCardRequestBuilder();
        net.authorize.api.contract.v1.CreateTransactionRequest apiRequest = 
        		requestBuilder.getChargeCreditCardRequest(request);
		CreateTransactionController controller = new CreateTransactionController(apiRequest);
		controller.execute();
		CreateTransactionResponse apiResponse = controller.getApiResponse();
		ChargeCreditCardResponseBuilder responseBuilder = new ChargeCreditCardResponseBuilder();
        ChargeCreditCardResponse response = responseBuilder.getChargeCreditCardResponse(apiResponse);
        return response;	
	}
}
