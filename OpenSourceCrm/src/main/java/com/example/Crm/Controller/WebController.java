package com.example.Crm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Crm.bean.CrmCase;
import com.example.Crm.service.CrmCaseService;
import com.example.Crm.service.TenantService;

@Controller
public class WebController {
	@Autowired
	private CrmCaseService crmCaseService;
	@Autowired
	private TenantService tenantService;

	@GetMapping("/index")
	public String index() {
		return "index"; // refers to index.html
	}

	/*
	 * @RequestMapping("/searchCarrier") public String searchCarrier() { return
	 * "cases"; }
	 */
	@RequestMapping("/searchCarrier")
	    public String listCases(Model model) {
	        List<CrmCase> cases = crmCaseService.getAllCase();
	        model.addAttribute("cases", cases);
	        return "cases"; // Thymeleaf template name
	    }
}
