package com.example.Crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Crm.bean.Tenant;
import com.example.Crm.repository.TenantRepository;

@Service
public class TenantService {
	
	@Autowired
	private TenantRepository tenantRepository;
	public Integer getIdbyTenantName(String tenantName) {
	        return tenantRepository.findTenantIdByName(tenantName);
	    }
	@SuppressWarnings("deprecation")
	public Tenant getTenantName(int tenantId)
	{
		return tenantRepository.getById(tenantId);
	}
}
