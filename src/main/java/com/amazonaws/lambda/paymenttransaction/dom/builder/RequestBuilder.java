package com.amazonaws.lambda.paymenttransaction.dom.builder;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.lambda.paymenttransaction.dom.data.common.Address;
import com.amazonaws.lambda.paymenttransaction.dom.data.common.Amount;
import com.amazonaws.lambda.paymenttransaction.dom.data.common.CreditCard;
import com.amazonaws.lambda.paymenttransaction.dom.data.common.CustomerData;
import com.amazonaws.lambda.paymenttransaction.dom.data.common.KeyValue;
import com.amazonaws.lambda.paymenttransaction.dom.data.common.LineItem;
import com.amazonaws.lambda.paymenttransaction.dom.data.common.MerchantAuthentication;
import com.amazonaws.lambda.paymenttransaction.dom.data.common.Payment;
import com.amazonaws.lambda.paymenttransaction.dom.data.common.TransactionRequest;
import com.amazonaws.lambda.paymenttransaction.dom.data.common.UserField;

import net.authorize.api.contract.v1.ArrayOfLineItem;
import net.authorize.api.contract.v1.AuthIndicatorEnum;
import net.authorize.api.contract.v1.AuthorizationIndicatorType;
import net.authorize.api.contract.v1.CreditCardType;
import net.authorize.api.contract.v1.CustomerAddressType;
import net.authorize.api.contract.v1.CustomerDataType;
import net.authorize.api.contract.v1.ExtendedAmountType;
import net.authorize.api.contract.v1.LineItemType;
import net.authorize.api.contract.v1.MerchantAuthenticationType;
import net.authorize.api.contract.v1.MerchantInitTransReasonEnum;
import net.authorize.api.contract.v1.PaymentType;
import net.authorize.api.contract.v1.ProcessingOptions;
import net.authorize.api.contract.v1.SubsequentAuthInformation;
import net.authorize.api.contract.v1.TransactionRequestType;
import net.authorize.api.contract.v1.TransactionRequestType.UserFields;

public abstract class RequestBuilder {

	protected MerchantAuthenticationType getMerchantAuthentication(MerchantAuthentication request) {
		MerchantAuthenticationType merchantAuthentication = null;
		if(request != null) {
			merchantAuthentication = new MerchantAuthenticationType();
			merchantAuthentication.setName(request.getName());
			merchantAuthentication.setTransactionKey(request.getTransactionKey());
		}
		return merchantAuthentication;		
	}

	protected TransactionRequestType getTransactionType(TransactionRequest request) {
		TransactionRequestType transactionReqType = null;
		if(request != null) {
			transactionReqType = new TransactionRequestType();
			transactionReqType.setTransactionType(request.getTransactionType());
			transactionReqType.setAmount(request.getAmount());
			transactionReqType.setPayment(getPaymentType(request.getPayment()));
			transactionReqType.setLineItems(getLineItems(request.getLineItems()));
			transactionReqType.setTax(getAmount(request.getTax()));
			transactionReqType.setDuty(getAmount(request.getDuty()));
			transactionReqType.setShipping(getAmount(request.getShipping()));
			transactionReqType.setPoNumber(request.getPoNumber());
			transactionReqType.setCustomer(getCustomerData(request.getCustomer()));
			transactionReqType.setBillTo(getAddress(request.getBillTo()));
			transactionReqType.setShipTo(getAddress(request.getShipTo()));
			transactionReqType.setCustomerIP(request.getCustomerIP());
			transactionReqType.setUserFields(getUserFields(request.getUserFields()));
			transactionReqType.setProcessingOptions(getProcessingOptions(request.getProcessingOptions()));
			transactionReqType.setSubsequentAuthInformation(getSubsequentAuthInformation(request.getSubsequentAuthInformation()));
			transactionReqType.setAuthorizationIndicatorType(getAuthorizationIndicatorType(request.getAuthorizationIndicatorType()));
		}
		return transactionReqType;
	}
	
	protected AuthorizationIndicatorType getAuthorizationIndicatorType(com.amazonaws.lambda.paymenttransaction.dom.data.common.AuthorizationIndicatorType type) {
		AuthorizationIndicatorType authorizationIndicatorType = null;
		if(type != null) {
			authorizationIndicatorType = new AuthorizationIndicatorType();
			authorizationIndicatorType.setAuthorizationIndicator(AuthIndicatorEnum.fromValue(type.getAuthorizationIndicator()));
		}
		return authorizationIndicatorType;				
	}
	
	protected SubsequentAuthInformation getSubsequentAuthInformation(com.amazonaws.lambda.paymenttransaction.dom.data.common.SubsequentAuthInformation authInformation) {
		SubsequentAuthInformation subsequentAuthInformation = null;
		if(authInformation != null) {
			subsequentAuthInformation = new SubsequentAuthInformation();
			subsequentAuthInformation.setOriginalNetworkTransId(authInformation.getOriginalNetworkTransId());
			subsequentAuthInformation.setOriginalAuthAmount(authInformation.getOriginalAuthAmount());
			subsequentAuthInformation.setReason(MerchantInitTransReasonEnum.fromValue(authInformation.getReason()));
		}
		return subsequentAuthInformation;
	}
	protected ProcessingOptions getProcessingOptions(com.amazonaws.lambda.paymenttransaction.dom.data.common.ProcessingOptions options) {
		ProcessingOptions processingOptions = null;
		if(options != null) {
			processingOptions = new ProcessingOptions();
			processingOptions.setIsFirstSubsequentAuth(options.getSubsequentAuth());
		}
		return processingOptions;
	}
	
	protected UserFields getUserFields(UserField field) {
		UserFields fields = null;
		if(field != null) {
			List<KeyValue> keyValueArray = field.getUserField();
			if(keyValueArray != null) {
				fields = new UserFields();
				for (KeyValue keyValue : keyValueArray) {
					net.authorize.api.contract.v1.UserField userField = new net.authorize.api.contract.v1.UserField();
					userField.setName(keyValue.getName());
					userField.setValue(keyValue.getValue());
					fields.getUserField().add(userField);
				}
			}			
		}
		return fields;
	}
	
	protected CustomerAddressType getAddress(Address address) {
		CustomerAddressType customerAddress = null;
		if(address != null) {
			customerAddress = new CustomerAddressType();
			customerAddress.setFirstName(address.getFirstName());
			customerAddress.setLastName(address.getLastName());
			customerAddress.setCompany(address.getAddress());
			customerAddress.setAddress(address.getAddress());
			customerAddress.setCity(address.getCity());
			customerAddress.setState(address.getState());
			customerAddress.setZip(address.getZip());
			customerAddress.setCountry(address.getCountry());
		}
		return customerAddress;
	}
	protected CustomerDataType getCustomerData(CustomerData customerData) {
		CustomerDataType customerDataType = null;
		if(customerData != null) {
			customerDataType = new CustomerDataType();
			customerDataType.setId(customerData.getId());
		}
		return customerDataType;
		
	}
	
	protected PaymentType getPaymentType(Payment payment) {
		PaymentType paymentType = null;
		if(payment != null) {
			paymentType = new PaymentType();
			paymentType.setCreditCard(getCreditCard(payment.getCreditCard()));
		}
		return paymentType;
	}
	
	protected CreditCardType getCreditCard(CreditCard creditCard) {
		CreditCardType cardType = null;
		if(creditCard != null) {
			cardType = new CreditCardType();
			cardType.setCardNumber(creditCard.getCardNumber());
			cardType.setExpirationDate(creditCard.getExpirationDate());
			cardType.setCardCode(creditCard.getCardCode());
		}
		return cardType;
	}
	
	protected ArrayOfLineItem getLineItems(List<LineItem> lineItems) {
		ArrayOfLineItem lineItemArray = null;
		if(lineItems != null && lineItems.size() != 0) {
			lineItemArray = new ArrayOfLineItem();
			List<LineItemType> lineItemTypes = new ArrayList<>();
			for (LineItem lineItem : lineItems) {
				LineItemType lineItemType = new LineItemType();
				lineItemType.setItemId(lineItem.getItemId());
				lineItemType.setName(lineItem.getName());
				lineItemType.setDescription(lineItem.getDesciption());
				lineItemType.setQuantity(lineItem.getQuantity());
				lineItemType.setUnitPrice(lineItem.getUnitPrice());
				lineItemTypes.add(lineItemType);
			}
		}
		return lineItemArray;
	}
	
	protected ExtendedAmountType getAmount(Amount amount) {
		ExtendedAmountType amountType = null;
		if(amount != null) {
			amountType = new ExtendedAmountType();
			amountType.setAmount(amount.getAmount());
			amountType.setName(amount.getName());
			amountType.setDescription(amount.getDescription());
		}
		return amountType;
	}

}
