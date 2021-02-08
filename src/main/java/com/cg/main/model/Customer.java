package com.cg.main.model;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/**
 * @author DISHANI BASAK customer class where all the required variables ,
 *         constructors, getters and setters and toString function are declared
 */
@Entity
@Table(name = "Customer_Table")
public class Customer{
	/**
	 * all the required variables for the address class functionality are declared
	 * below
	 */
	@Id
	@GeneratedValue
	@Column(name = "customerid")
	private int customerId;
	@Column(name = "firstname")
	@NotEmpty(message = "First name should not be empty")
	@Size(min = 3, message = "min 3 chars required")
	private String firstName;
	@Column(name = "lastname")
	@NotEmpty(message = "Last name should not be empty")
	private String lastName;
	@Pattern(regexp = "[a-zA-Z0-9-._]{1,}[@]{1}[a-zA-Z]{1,}[.]{1}[a-zA-Z]{1,}",message = "enter valid email id")
	@Column(name = "email")
	private String email;
	//one to one mapping with address table
	@OneToOne(cascade = CascadeType.ALL)
	//taking address id as foreign key
	@JoinColumn(name = "add_id")
	Address address;
    //declare constructors
	public Customer() {
		super();
	}
	/**
	 * parameterized constructor
	 * @param customerId
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param address
	 */
	public Customer(int customerId, String firstName, String lastName, String email, Address address) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
	}
	/**
	 * parameterized constructor
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param address
	 */
	public Customer(String firstName, String lastName, String email, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
	}
    //declare getters & setters
	/**
	 * @return
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 */
	public void setAdress(Address address) {
		this.address = address;
	}
    //override toString 
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", address=" + address + "]";
	}

}
