package com.cg.main.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.main.model.Customer;
/**
 * 
 * @author dishani
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	/**
	 * view Customer data
	 * @param id
	 * @return
	 */
	List<Customer> findAllByFirstName(String fName);

}
