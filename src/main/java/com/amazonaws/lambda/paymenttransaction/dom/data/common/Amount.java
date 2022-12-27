package com.amazonaws.lambda.paymenttransaction.dom.data.common;

import java.math.BigDecimal;

public class Amount {

	private BigDecimal amount;
	private String name;
	private String description;
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
