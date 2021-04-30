package com.mvc.gvplights.controller;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.gvplights.enums.Gender;
import com.mvc.gvplights.model.Customers;
import com.mvc.gvplights.service.CustomersService;

@Controller
@RequestMapping("/customer")
public class CustomersController {

	private static final Logger log = LoggerFactory.getLogger(CustomersController.class);

	@Autowired
	private CustomersService cusService;
	
	@GetMapping("/reg")
	public String register() {
		log.info("Entered Controller :: CustomersController :: register()");
		return "customersReg";
	}

	@RequestMapping("/save")
	public String save(@ModelAttribute Customers cusObj, Model model) {

		log.info("Started Controller :: CustomersController :: save()");
		
		Customers cus = cusService.save(cusObj);
		String msg = "Hi"+cus.getFname()+"Successfully created your account";
		model.addAttribute("message", msg);
		log.info("Ended Controller :: CustomersController :: save()");
        return "welcome";

	}

}
