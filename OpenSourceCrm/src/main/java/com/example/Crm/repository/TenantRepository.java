package com.example.Crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Crm.bean.Tenant;
@Repository
public interface TenantRepository extends JpaRepository<Tenant, Integer> {
	@Query(value = "SELECT TENANTID FROM TENANT WHERE TENANTNAME = :name", nativeQuery = true)
    Integer findTenantIdByName(@Param("name") String tenantName);
	
}
