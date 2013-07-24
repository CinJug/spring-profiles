package trey.service;

import trey.model.Customer;

public interface CustomerService {

	/**
	 * Retrieves the given customer
	 * 
	 * @param custId
	 * @return
	 */
	Customer getCustomer(long custId);

	/**
	 * Updates the given customer's name.
	 * 
	 * @param custId
	 * @param first
	 * @param last
	 */
	void updateName(long custId, String first, String last);

	/**
	 * Updates the given customer's name.
	 * 
	 * @param custId
	 * @param zip
	 */
	void updateAddress(long custId, String zip);

}