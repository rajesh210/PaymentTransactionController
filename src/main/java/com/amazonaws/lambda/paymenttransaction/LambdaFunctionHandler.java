package com.amazonaws.lambda.paymenttransaction;

import java.io.IOException;

import com.amazonaws.lambda.paymenttransaction.dom.data.request.AuthCreditCardRequest;
import com.amazonaws.lambda.paymenttransaction.dom.data.response.AuthCreditCardResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.authorize.Environment;
import net.authorize.api.controller.base.ApiOperationBase;

public class LambdaFunctionHandler implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);
        
        ObjectMapper mapper = new ObjectMapper().configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        AuthCreditCardRequest apiRequest = null;
		try {
			String request = mapper.writeValueAsString(input);
			context.getLogger().log("request: " + request);
			apiRequest = mapper.readValue(request, AuthCreditCardRequest.class);
			context.getLogger().log("apiRequest: " + apiRequest);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			context.getLogger().log("JsonParseException: " + e.getMessage());
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			context.getLogger().log("JsonMappingException: " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			context.getLogger().log("IOException: " + e.getMessage());
		}

        // TODO: implement your handler
        //return "Hello from Lambda!";
        ApiOperationBase.setEnvironment(Environment.SANDBOX);
        PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
        AuthCreditCardResponse response = paymentTransactionImpl.authorizeCreditCard(apiRequest);
        String responseStr = null;
		try {
			responseStr = mapper.writeValueAsString(response);
			context.getLogger().log("responseStr: " + responseStr);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			context.getLogger().log("JsonParseException: " + e.getMessage());
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			context.getLogger().log("JsonMappingException: " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			context.getLogger().log("IOException: " + e.getMessage());
		}

        return responseStr;
    }

}
