package com.mvc.gvplights.service;

import java.util.List;

import com.mvc.gvplights.model.Customers;

public interface CustomersService {
	
	public Customers save(Customers cusObj);
	
	//public String update();
	
	//Delete
	public void delete(Integer cid);
	
	//public String getCusId();
	
	//List of customers
	public List<Customers> listAllCustomers();

}
