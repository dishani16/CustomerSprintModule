package com.cg.main.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * @author DISHANI BASAK Address class where all the required variables ,
 *         constructors, getters and setters and toString function are declared
 */
@Entity
@Table(name="cust_address")
public class Address {
	/**
	 * all the required variables for the address class functionality are declared
	 * below
	 */
	@Id
	@GeneratedValue
	@Column(name="add_id")
	private int addressId;
	@Column(name="house_no")
	private String houseNo;
	@Column(name="colony")
	private String colony;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="pincode")
	private int pincode;
	@OneToOne(mappedBy = "address")
	private Customer customer;
	/**
	 * default or no argument constructor
	 */
	public Address() {
	}

	/**
	 * paramertized constructor
	 * 
	 * @param houseNo
	 * @param colony
	 * @param city
	 * @param state
	 * @param pincode
	 */
	public Address(String houseNo, String colony, String city, String state, int pincode) {
		super();
		this.houseNo = houseNo;
		this.colony = colony;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	/**
	 * paramertized constructor
	 * 
	 * @param addressId
	 * @param houseNo
	 * @param colony
	 * @param city
	 * @param state
	 * @param pincode
	 */
	public Address(int addressId, String houseNo, String colony, String city, String state, int pincode) {
		super();
		this.addressId = addressId;
		this.houseNo = houseNo;
		this.colony = colony;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	/**
	 * getter and setter fro address id
	 * 
	 * @return
	 */
	public int getAddressId() {
		return addressId;
	}

	/**
	 * setter for address id
	 * 
	 * @param addressId
	 */
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	/**
	 * getter for house no
	 * 
	 * @return
	 */
	public String getHouseNo() {
		return houseNo;
	}

	/**
	 * setter for house no
	 * 
	 * @param houseNo
	 */
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	/**
	 * getter for colony
	 * 
	 * @return
	 */
	public String getColony() {
		return colony;
	}

	/**
	 * setter for colony
	 * 
	 * @param colony
	 */
	public void setColony(String colony) {
		this.colony = colony;
	}

	/**
	 * getter for city
	 * 
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * setter for city
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * getter for state
	 * 
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * setter for state
	 * 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * getter for pincode
	 * 
	 * @return
	 */
	public int getPincode() {
		return pincode;
	}

	/**
	 * setter for pincode
	 * 
	 * @param pincode
	 */
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", houseNo=" + houseNo + ", colony=" + colony + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + "]";
	}

}
