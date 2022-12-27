package com.amazonaws.lambda.paymenttransaction.dom.builder;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.lambda.paymenttransaction.dom.data.common.KeyValue;
import com.amazonaws.lambda.paymenttransaction.dom.data.common.ResponseMessage;
import com.amazonaws.lambda.paymenttransaction.dom.data.common.TransactionResponse;

public abstract class ResponseBuilder {

	protected TransactionResponse getTransactionResponse(net.authorize.api.contract.v1.TransactionResponse response) {
		TransactionResponse transactionResponse = null;
		if(response != null) {
			transactionResponse = new TransactionResponse();
			transactionResponse.setResponseCode(response.getResponseCode());
			transactionResponse.setAuthCode(response.getAuthCode());
			transactionResponse.setAvsResultCode(response.getAvsResultCode());
			transactionResponse.setCvvResultCode(response.getCvvResultCode());
			transactionResponse.setCavvResultCode(response.getCavvResultCode());
			transactionResponse.setTransId(response.getTransId());
			transactionResponse.setTransHash(response.getTransHash());
			transactionResponse.setAccountNumber(response.getAccountNumber());
			transactionResponse.setAccountType(response.getAccountType());
			transactionResponse.setMessages(getMessages(response.getMessages()));
			transactionResponse.setUserFields(getUserFields(response.getUserFields()));
			transactionResponse.setNetworkTransId(response.getNetworkTransId());
		}
		return transactionResponse;
	}

	protected List<KeyValue> getUserFields(net.authorize.api.contract.v1.TransactionResponse.UserFields fields) {
		List<KeyValue> userFields = null;
		if(fields != null) {
			List<net.authorize.api.contract.v1.UserField> fieldsList = fields.getUserField();
			if(fieldsList != null) {
				userFields = new ArrayList<KeyValue>();
				for (net.authorize.api.contract.v1.UserField field : fieldsList) {
					KeyValue keyValue = new KeyValue();
					keyValue.setName(field.getName());
					keyValue.setValue(field.getValue());
					userFields.add(keyValue);
				}
			}
		}
		return userFields;
	}
	
	protected List<ResponseMessage> getMessages(net.authorize.api.contract.v1.TransactionResponse.Messages msgs) {
		List<ResponseMessage> messages = null;
		if(msgs != null) {
			messages = new ArrayList<ResponseMessage>();
			List<net.authorize.api.contract.v1.TransactionResponse.Messages.Message> msgList = msgs.getMessage();
			for (net.authorize.api.contract.v1.TransactionResponse.Messages.Message msg : msgList) {
				ResponseMessage message = new ResponseMessage();
				message.setCode(msg.getCode());
				message.setDescription(msg.getDescription());
				messages.add(message);
			}
		}
		return messages;
	}

}
