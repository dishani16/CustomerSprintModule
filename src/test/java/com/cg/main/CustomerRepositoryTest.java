package com.cg.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.main.model.Customer;
import com.cg.main.repository.CustomerRepository;
/**
 * 
 * @author Dishani
 *class to test customer repository using junit
 */
@SpringBootTest
public class CustomerRepositoryTest {
	@Autowired
	private CustomerRepository custRepository;
	/**
	 * testing repository layer method to view all the customers present in database using
	 * customer name
	 * 
	 */
	@Test
	void testGetAllByName() {
		List<Customer> customers = custRepository.findAllByFirstName("Dishani");
		String name = customers.get(0).getFirstName();
		assertEquals("Dishani", name);
	}

}
