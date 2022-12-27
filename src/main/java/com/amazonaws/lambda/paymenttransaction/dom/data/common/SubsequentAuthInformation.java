package com.amazonaws.lambda.paymenttransaction.dom.data.common;

import java.math.BigDecimal;

public class SubsequentAuthInformation {

	private String originalNetworkTransId;
	private BigDecimal originalAuthAmount;
	private String reason;
	
	public String getOriginalNetworkTransId() {
		return originalNetworkTransId;
	}
	public void setOriginalNetworkTransId(String originalNetworkTransId) {
		this.originalNetworkTransId = originalNetworkTransId;
	}
	public BigDecimal getOriginalAuthAmount() {
		return originalAuthAmount;
	}
	public void setOriginalAuthAmount(BigDecimal originalAuthAmount) {
		this.originalAuthAmount = originalAuthAmount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
