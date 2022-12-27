package com.amazonaws.lambda.paymenttransaction.dom.data.common;

import java.util.List;

public class TransactionResponse {

	private String responseCode;
	private String authCode;
	private String avsResultCode;
	private String cvvResultCode;
	private String cavvResultCode;
	private String transId;
	private String refTransID;
	private String transHash;
	private String testRequest;
	private String accountNumber;
	private String accountType;
	private List<ResponseMessage> messages;
	private List<KeyValue> userFields;
	private String transHashSha2;
	private String supplementalDataQualificationIndicator;
	private String networkTransId;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public String getAvsResultCode() {
		return avsResultCode;
	}
	public void setAvsResultCode(String avsResultCode) {
		this.avsResultCode = avsResultCode;
	}
	public String getCvvResultCode() {
		return cvvResultCode;
	}
	public void setCvvResultCode(String cvvResultCode) {
		this.cvvResultCode = cvvResultCode;
	}
	public String getCavvResultCode() {
		return cavvResultCode;
	}
	public void setCavvResultCode(String cavvResultCode) {
		this.cavvResultCode = cavvResultCode;
	}
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	public String getRefTransID() {
		return refTransID;
	}
	public void setRefTransID(String refTransID) {
		this.refTransID = refTransID;
	}
	public String getTransHash() {
		return transHash;
	}
	public void setTransHash(String transHash) {
		this.transHash = transHash;
	}
	public String getTestRequest() {
		return testRequest;
	}
	public void setTestRequest(String testRequest) {
		this.testRequest = testRequest;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public List<ResponseMessage> getMessages() {
		return messages;
	}
	public void setMessages(List<ResponseMessage> messages) {
		this.messages = messages;
	}
	public List<KeyValue> getUserFields() {
		return userFields;
	}
	public void setUserFields(List<KeyValue> userFields) {
		this.userFields = userFields;
	}
	public String getTransHashSha2() {
		return transHashSha2;
	}
	public void setTransHashSha2(String transHashSha2) {
		this.transHashSha2 = transHashSha2;
	}
	public String getSupplementalDataQualificationIndicator() {
		return supplementalDataQualificationIndicator;
	}
	public void setSupplementalDataQualificationIndicator(String supplementalDataQualificationIndicator) {
		this.supplementalDataQualificationIndicator = supplementalDataQualificationIndicator;
	}
	public String getNetworkTransId() {
		return networkTransId;
	}
	public void setNetworkTransId(String networkTransId) {
		this.networkTransId = networkTransId;
	}
	
}
