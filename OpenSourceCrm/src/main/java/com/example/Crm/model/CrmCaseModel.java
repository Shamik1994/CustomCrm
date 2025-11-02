package com.example.Crm.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CrmCaseModel {
	
	public String customerId;
	public String tenantName;
	public String stage;
	public String issueDescription;
	public String customerComment;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getIssueDescription() {
		return issueDescription;
	}
	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}
	public String getCustomerComment() {
		return customerComment;
	}
	public void setCustomerComment(String customerComment) {
		this.customerComment = customerComment;
	}
	@Override
	public String toString() {
		return "CrmCaseModel [customerId=" + customerId + ", tenantName=" + tenantName + ", stage=" + stage
				+ ", issueDescription=" + issueDescription + ", customerComment=" + customerComment + "]";
	}
	
	
	

}
