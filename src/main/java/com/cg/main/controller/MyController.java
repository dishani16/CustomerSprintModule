package com.cg.main.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.main.exception.CustomerNotFoundException;
import com.cg.main.model.Customer;
import com.cg.main.service.ICustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 
 * @author Dishani
 *create controller class for customer management
 */
@Api(value = "controller", description="handler methods related to customer module")
@RestController
@RequestMapping("/api")
public class MyController {
	@Autowired
	ICustomerService service;
	//method for add customer
	@ApiOperation(value = "click here to add new customer details")
	@PostMapping("/addCustomer_table")
	public Customer addCustomer(@Valid @RequestBody Customer customer) {
		return service.addCustomer(customer);
	}
	//method for update customer
	@ApiOperation(value = "click here to update exixting customer details")
	@PutMapping("/updateCustomer_table")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer) {
		Customer customerInfo = service.updateCustomer(customer);
		return new ResponseEntity<>(customerInfo, HttpStatus.OK);
	}
	//method for delete customer
	@ApiOperation(value = "click here to delete any customer details")
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable("id") int id) {
		Customer customer = service.getCustomer(id);
		if (customer == null) {
			throw new CustomerNotFoundException("No customer present to delete with the given id : " + id);
		}
		else {
		List<Customer> customers = service.deleteCustomer(id);
		return new ResponseEntity<>(customers, HttpStatus.OK);
		}
	}
	//method to get all customers searched by name
	@ApiOperation(value = "click here to get customer details base on first name")
	@GetMapping("/getCustomers/{firstName}")
	public ResponseEntity<List<Customer>> getCustomers(@PathVariable("firstName") String fName) {
		List<Customer> customers = service.getAllCustomersByName(fName);
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
	//method to get all customers searched by id
	@ApiOperation(value = "click here to get customer details based on ID")
    @GetMapping("/getCustomer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id) {
		Customer customer = service.getCustomer(id);
		if (customer == null) {
			throw new CustomerNotFoundException("No customer present with the given id: " + id);
		}
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
    //method to get all customer details
	@ApiOperation(value = "click here to get all customer details")
	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = service.getAllCustomers();
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
}
