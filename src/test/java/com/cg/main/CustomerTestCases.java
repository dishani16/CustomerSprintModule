package com.cg.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.main.model.Address;
import com.cg.main.model.Customer;
import com.cg.main.service.CustomerService;
/**
 * 
 * @author Dishani
 *class test customer service methods 
 */
@SpringBootTest
public class CustomerTestCases {
	@Autowired
	private CustomerService service;
	/**
	 * testing service layer method to add customer
	 */
	@Test
	void testAddCustomer() {
		Address address=new Address(42,"flat-1/3A", "Patuli", "Kolkata", "West Bengal", 700084);
		Customer customer=service.addCustomer(new Customer(41,"Sayani", "Basak", "sb19@gmail.com", address));
	    assertEquals("Sayani", customer.getFirstName());
	}
	/**
	 * testing service layer method to update customer
	 */
	@Test
	void testUpdateCustomer() {
		Address address=new Address("Cosmopolis flat-1/3A", "Patuli", "Kolkata", "West Bengal", 700084);
		Customer customer = service.updateCustomer(new Customer("Dishani", "Basak", "db@gmail.com", address));
		assertEquals("Cosmopolis flat-1/3A", customer.getAddress().getHouseNo());
	}
	/**
	 * testing service layer method to delete customer using id
	 */
	@Test
	void testDeleteCustomer() {
		int id=43;
		Customer customer= service.getCustomer(id);
		if (customer==null) {
			assertNull(customer);	
		}
		else {
			List<Customer> customers = service.deleteCustomer(id);
			assertFalse(customers.isEmpty());
		}
	}
	/**
	 * testing service layer method to view customer using id
	 */
	@Test
	void testGetCustomer() {
		Customer customer= service.getCustomer(39);
		assertNotEquals("Sayan", customer.getFirstName());
	}

	/**
	 * testing service layer method to view all the customers present in database
	 *
	 */
	@Test
	void testgetAllPlants() {
		List<Customer> customers = service.getAllCustomers();
		boolean result = true;
		if (customers.isEmpty()) {
			result = false;
		}
		assertTrue(result);
	}

	/**
	 * testing service layer method to view all the customers present in database using
	 * customer first name
	 * 
	 */
	@Test
	void testGetAllByName() {
		List<Customer> customers = service.getAllCustomersByName("Dishani");
		String name = customers.get(0).getFirstName();
		assertEquals("Dishani", name);
	}
}
