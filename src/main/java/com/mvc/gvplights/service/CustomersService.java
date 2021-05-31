package com.mvc.gvplights.service;

import java.util.List;

import com.mvc.gvplights.model.Customers;

public interface CustomersService {
	
	//Save
	public Customers save(Customers cusObj);
	
	//Update
	public Customers update(Integer cid);
	
	//Delete
	public void delete(Integer cid);
	
	//List of customers
	public List<Customers> listAllCustomers();

}
