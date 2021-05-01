package com.mvc.gvplights.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.gvplights.dao.CustomersDAO;
import com.mvc.gvplights.model.Customers;
import com.mvc.gvplights.service.CustomersService;

@Service
public class CustomersServiceImpl implements CustomersService {

	private static final Logger log = LoggerFactory.getLogger(CustomersServiceImpl.class);
	
	@Autowired
	private CustomersDAO cusDao;

	@Override
	public Customers save(Customers cusObj) {
		log.info("Started ServiceImpl :: CustomersServiceImpl :: save()");
		Customers cus = cusDao.save(cusObj);
		log.info("Ended ServiceImpl :: CustomersServiceImpl :: save()");
		return cus;
	}

	@Override
	public List<Customers> listAllCustomers() {
		log.info("Started ServiceImpl :: CustomersServiceImpl :: listAllCustomers()");
		List<Customers> cuslist = cusDao.findAll();
		log.info("Ended ServiceImpl :: CustomersServiceImpl :: listAllCustomers()");
		return cuslist;
	}

	@Override
	public void delete(Integer cid) {
		log.info("Started ServiceImpl :: CustomersServiceImpl :: delete()");
		cusDao.deleteById(cid);;
		log.info("Ended ServiceImpl :: CustomersServiceImpl :: delete()");
	}

}
