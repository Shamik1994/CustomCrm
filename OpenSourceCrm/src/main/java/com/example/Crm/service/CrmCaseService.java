package com.example.Crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Crm.bean.CrmCase;
import com.example.Crm.repository.CrmCaseRepo;

@Service
public class CrmCaseService {

	@Autowired
	CrmCaseRepo crmCaseRepo;

	public CrmCase insertCaseCrm(CrmCase crmCase) {
		return crmCaseRepo.save(crmCase);
	}
	
	public List<CrmCase> getCasebyTenantCustomer(int tenantId, String customerId) {
		return crmCaseRepo.findCasesByTenantAndCustomer(tenantId, customerId);
	}
	public List<CrmCase> getAllCase()
	{
		return crmCaseRepo.findAll();
	}

}
