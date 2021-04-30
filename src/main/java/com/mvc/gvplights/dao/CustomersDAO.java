package com.mvc.gvplights.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.gvplights.model.Customers;

public interface CustomersDAO extends JpaRepository<Customers, Integer> {
	
    //Automatically CRUD operations
	
}
