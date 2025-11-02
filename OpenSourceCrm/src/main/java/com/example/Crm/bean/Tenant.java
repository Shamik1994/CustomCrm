package com.example.Crm.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tenant")
public class Tenant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TENANTID")
	private int tenantId;
	@Column(name = "TENANTNAME")
	private String tenantName;

	// @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval =
	// true)
	// private List<CrmCase> cases = new ArrayList<>();
	public int getTenantId() {
		return tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	@Override
	public String toString() {
		return "Tenant [tenantId=" + tenantId + ", tenantName=" + tenantName + "]";
	}

}
