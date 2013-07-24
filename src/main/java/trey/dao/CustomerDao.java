package trey.dao;

import trey.model.Customer;

public interface CustomerDao {

	/**
	 * Fetches the customer for the given id.
	 * 
	 * @param custId
	 * @return
	 */
	Customer getCustomerById(long custId);

	/**
	 * Update the customer's first and last name.
	 * 
	 * @param custId
	 * @param first
	 * @param last
	 */
	void updateName(long custId, String first, String last);

	/**
	 * Update the customer's zip.
	 * 
	 * @param custId
	 * @param zip
	 */
	void updateAddress(long custId, String zip);

}
