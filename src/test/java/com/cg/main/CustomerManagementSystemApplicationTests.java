package com.cg.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.main.controller.MyController;
//import com.cg.main.model.Address;
import com.cg.main.model.Customer;
import com.cg.main.service.CustomerService;
/**
 * 
 * @author Dishani
 *class to test controller class
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class CustomerManagementSystemApplicationTests {
	@Autowired
	private MyController controller;
	/**
	 * mehtod for testing the controller
	 */
	@Test
	void contextLoads() {
		boolean result=true;
		if(controller.equals(null)) {
		result =false;
		}
		assertTrue(result);
	}
}
