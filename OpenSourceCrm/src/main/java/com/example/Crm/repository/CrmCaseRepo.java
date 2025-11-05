package com.example.Crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Crm.bean.CrmCase;

public interface CrmCaseRepo extends JpaRepository<CrmCase, Integer> {

	@Query(value = "SELECT * FROM CRM_CASE WHERE TENANT_NAME = :tenantName AND CUSTOMER_ID = :customerId", nativeQuery = true)
	List<CrmCase> findCasesByTenantAndCustomer(@Param("tenantName") String tenantName, @Param("customerId") String customerId);

}
