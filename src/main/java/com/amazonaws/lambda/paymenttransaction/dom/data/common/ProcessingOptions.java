package com.amazonaws.lambda.paymenttransaction.dom.data.common;

public class ProcessingOptions {
	
	private boolean isSubsequentAuth;

	public boolean getSubsequentAuth() {
		return isSubsequentAuth;
	}

	public void setSubsequentAuth(boolean isSubsequentAuth) {
		this.isSubsequentAuth = isSubsequentAuth;
	}

}
