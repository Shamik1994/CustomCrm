package com.example.Crm.bean;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CrmCase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int caseId;
	private int tenantId;
	private String customerId;
	private LocalDate dateCretaed;
	private Date dateUpdated;
	private String stage;
	private String issueDescription;
	private String customerComment;
	private String resolutionComment;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "tenantId") private Tenant tenant;
	 */
	public int getCaseId() {
		return caseId;
	}

	/*
	 * public Tenant getTenant() { return tenant; } public void setTenant(Tenant
	 * tenant) { this.tenant = tenant; }
	 */
	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public LocalDate getDateCretaed() {
		return dateCretaed;
	}

	public void setDateCretaed(LocalDate dateCretaed) {
		this.dateCretaed = dateCretaed;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
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

	public String getResolutionComment() {
		return resolutionComment;
	}

	public void setResolutionComment(String resolutionComment) {
		this.resolutionComment = resolutionComment;
	}

	public int getTenantId() {
		return tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	@Override
	public String toString() {
		return "CrmCase [caseId=" + caseId + ", tenantId=" + tenantId + ", customerId=" + customerId + ", dateCretaed="
				+ dateCretaed + ", dateUpdated=" + dateUpdated + ", stage=" + stage + ", issueDescription="
				+ issueDescription + ", customerComment=" + customerComment + ", resolutionComment=" + resolutionComment
				+ "]";
	}

}
