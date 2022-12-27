package com.amazonaws.lambda.paymenttransaction.dom.data.common;

import java.math.BigDecimal;
import java.util.List;

public class TransactionRequest {
	
	private String transactionType;
	private BigDecimal amount;
	private Payment payment;
	private List<LineItem> lineItems;
	private Amount tax;
	private Amount duty;
	private Amount shipping;
	private String poNumber;
	private CustomerData customer;
	private Address billTo;
	private Address shipTo;
	private String customerIP;
	private TransactionSettings transactionSettings;
	private UserField userFields;
	private ProcessingOptions processingOptions;
	private SubsequentAuthInformation subsequentAuthInformation;
	private AuthorizationIndicatorType authorizationIndicatorType;
	
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public List<LineItem> getLineItems() {
		return lineItems;
	}
	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	public Amount getTax() {
		return tax;
	}
	public void setTax(Amount tax) {
		this.tax = tax;
	}
	public Amount getDuty() {
		return duty;
	}
	public void setDuty(Amount duty) {
		this.duty = duty;
	}
	public Amount getShipping() {
		return shipping;
	}
	public void setShipping(Amount shipping) {
		this.shipping = shipping;
	}
	public String getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	public CustomerData getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerData customer) {
		this.customer = customer;
	}
	public Address getBillTo() {
		return billTo;
	}
	public void setBillTo(Address billTo) {
		this.billTo = billTo;
	}
	public Address getShipTo() {
		return shipTo;
	}
	public void setShipTo(Address shipTo) {
		this.shipTo = shipTo;
	}
	public String getCustomerIP() {
		return customerIP;
	}
	public void setCustomerIP(String customerIP) {
		this.customerIP = customerIP;
	}
	public TransactionSettings getTransactionSettings() {
		return transactionSettings;
	}
	public void setTransactionSettings(TransactionSettings transactionSettings) {
		this.transactionSettings = transactionSettings;
	}
	public UserField getUserFields() {
		return userFields;
	}
	public void setUserFields(UserField userFields) {
		this.userFields = userFields;
	}
	public ProcessingOptions getProcessingOptions() {
		return processingOptions;
	}
	public void setProcessingOptions(ProcessingOptions processingOptions) {
		this.processingOptions = processingOptions;
	}
	public SubsequentAuthInformation getSubsequentAuthInformation() {
		return subsequentAuthInformation;
	}
	public void setSubsequentAuthInformation(SubsequentAuthInformation subsequentAuthInformation) {
		this.subsequentAuthInformation = subsequentAuthInformation;
	}
	public AuthorizationIndicatorType getAuthorizationIndicatorType() {
		return authorizationIndicatorType;
	}
	public void setAuthorizationIndicatorType(AuthorizationIndicatorType authorizationIndicatorType) {
		this.authorizationIndicatorType = authorizationIndicatorType;
	}

}
