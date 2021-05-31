package com.mvc.gvplights.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.gvplights.model.Customers;
import com.mvc.gvplights.service.CustomersService;
import com.mvc.gvplights.service.MailService;

@Controller
@RequestMapping("/customers")
public class CustomersController {

	private static final Logger log = LoggerFactory.getLogger(CustomersController.class);

	@Autowired
	private CustomersService cusService;
	
	@Autowired
	private MailService mailService;
	
	String mailTo= "vndprasadgrandhi@gmail.com";
	
	@GetMapping("/register")
	public String register() {
		log.info("Entered Controller :: CustomersController :: register()");
		return "customers/customersReg";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Customers cusObj, Model model) {
        log.info("Started Controller :: CustomersController :: save()");
		
		Customers cus = cusService.save(cusObj);
		String subject = "Welcome GVP Lights";
		String desc = "Hi"+cus.getFname()+"Successfully created your account";
		
	    //Email purpose
		mailService.send(mailTo, null, null, subject, desc, null);
		
		//Webpage purpose
		model.addAttribute("message", desc);
		
		log.info("Ended Controller :: CustomersController :: save()");
		return "redirect:list";

	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("cid") Integer cid, Model model) {
	   log.info("Started Controller :: CustomersController :: delete()");
	   cusService.delete(cid);
	   model.addAttribute("msg", "Deleted Successfull !");
		
	   log.info("Ended Controller :: CustomersController :: delete()");
	   return "redirect:list";	
	}
	
	/*
	 * @RequestMapping(value = "/delete/{cid}") public String
	 * delete(@PathVariable("cid") Integer cid, Model model) {
	 * log.info("Started Controller :: CustomersController :: delete()");
	 * cusService.delete(cid); model.addAttribute("msg", "Deleted Successfull !");
	 * 
	 * log.info("Ended Controller :: CustomersController :: delete()"); return
	 * "redirect:list"; }
	 */
	
	@GetMapping("/list")
	public String listAllCustomers(Model model) {
		log.info("Started Controller :: CustomersController :: listAllCustomers()");
		List<Customers> custList = cusService.listAllCustomers();
		model.addAttribute("allCustomersList", custList);
		log.info("Ended Controller :: CustomersController :: listAllCustomers()");
		return "customers/customersList";		
	}
	
	@RequestMapping("/edit")
	public String update(@RequestParam("cid") Integer cid, Model model) {
		log.info("Started Controller :: CustomersController :: update()"+cid);
		Customers customer = cusService.update(cid);
		log.info("Started Controller :: CustomersController :: update()"+customer);
		model.addAttribute("customer", customer);
		return "customers/customersEdit";
	}
	
	

}
