package com.cg.main.service;

import java.util.List;


import com.cg.main.model.Customer;
/**
 * 
 * ICustomerService class provide customer services like
 *  add, update, delete and view data 
 *  also validates the customer input
 */
public interface ICustomerService {
    
	Customer addCustomer(Customer customer);

	List<Customer> deleteCustomer(int id);

	List<Customer> getAllCustomersByName(String fName);

	Customer getCustomer(int id);

	List<Customer> getAllCustomers();

	Customer updateCustomer(Customer customer);


}
