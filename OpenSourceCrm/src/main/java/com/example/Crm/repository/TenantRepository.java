package com.example.Crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Crm.bean.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Integer> {
	@Query(value = "SELECT TENANT_ID FROM TENANT WHERE TENANT_NAME = :name", nativeQuery = true)
    Integer findTenantIdByName(@Param("name") String tenantName);
}
