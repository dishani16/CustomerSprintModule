package com.cg.main.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.main.model.Customer;
import com.cg.main.repository.CustomerRepository;
/**
 * 
 * CustomerService class provide customer services like
 *  add, update, delete and view data and it implements interface ICustomerService
 *
 */
@Service
@Transactional
public class CustomerService implements ICustomerService{
	@Autowired
	CustomerRepository repository;
	@Override
	public Customer addCustomer(Customer customer) {
		return repository.save(customer);
	}
	@Override
	public Customer updateCustomer(Customer customer) {
		return repository.save(customer);
	}
	@Override
	public List<Customer> deleteCustomer(int id) {
			repository.deleteById(id);
		return repository.findAll();
	}
	@Override
	public List<Customer> getAllCustomersByName(String fName) {
		return repository.findAllByFirstName(fName);
	}
	@Override
	public Customer getCustomer(int id) {
		return repository.findById(id).orElse(null);
	}
	@Override
	public List<Customer> getAllCustomers() {
		return repository.findAll();
	}
	
}
