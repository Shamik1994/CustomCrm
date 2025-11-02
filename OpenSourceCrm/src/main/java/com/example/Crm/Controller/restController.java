package com.example.Crm.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Crm.bean.CrmCase;
import com.example.Crm.bean.UserDetail;
import com.example.Crm.model.CrmCaseModel;
import com.example.Crm.model.UserModel;
import com.example.Crm.service.CrmCaseService;
import com.example.Crm.service.TenantService;
import com.example.Crm.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class restController {

	@Autowired
	CrmCaseService crmCaseService;
	@Autowired
	private ObjectMapper objmapper;
	@Autowired
	private TenantService tenantService;
	@Autowired
	private UserService userService;

	@PostMapping
	@RequestMapping("/api/createCase/v1")
	public ResponseEntity<Map<String, Object>> createCase(@RequestBody String reqJson)
			throws JsonMappingException, JsonProcessingException {
		CrmCaseModel crmCaseModel = objmapper.readValue(reqJson, CrmCaseModel.class);
		System.out.println("crmCase" + crmCaseModel.toString());
		int tenantId = tenantService.getIdbyTenantName(crmCaseModel.getTenantName());
		CrmCase crm = new CrmCase();
		crm.setCustomerId(crmCaseModel.getCustomerId());
		crm.setCustomerComment(crmCaseModel.getCustomerComment());
		crm.setIssueDescription(crmCaseModel.getIssueDescription());
		crm.setStage(crmCaseModel.getStage());
		crm.setTenantId(tenantId);
		crm.setDateCretaed(LocalDate.now());
		Map<String, Object> response = new HashMap<>();
		crm = crmCaseService.insertCaseCrm(crm);
		response.put("caseId", crm.getCaseId());
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	@RequestMapping("/api/cases/v1")
	public List<CrmCase> getCasesByTenantAndCustomer(@RequestParam int tenantId, @RequestParam String customerId) {
		List<CrmCase> crmCase = new ArrayList<>();
		crmCase = crmCaseService.getCasebyTenantCustomer(tenantId, customerId);
		// System.out.println("crmCase"+crmCase);
		return crmCase;
	}

	@PostMapping
	@RequestMapping("/api/createUser/v1")
	public ResponseEntity<Map<String, String>> createUser(@RequestBody String reqJson) throws JsonMappingException, JsonProcessingException {
		UserModel userModel = objmapper.readValue(reqJson, UserModel.class);
		UserDetail user = new UserDetail();
		//user.setUserId(5);
		user.setUserName(userModel.getUserName());
		user.setPassWord(userModel.getPassword());
		user.setUserType(userModel.getUseratype());
		userService.createUser(user);
		Map<String, String> response = new HashMap<>();
		response.put("Status", "User Created");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping
	@RequestMapping("/api/validateUser/v1")
	public ResponseEntity<Map<String, Object>> validateUser(@RequestParam String userName, @RequestParam String password) {
		List<UserDetail> user=userService.validateUser(userName, password);
		Map<String, Object> response = new HashMap<>();
		if(user.size()>0)
		{
			response.put("Status", "User Validated");
		}
		else
		{
			response.put("Status", "No user found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
