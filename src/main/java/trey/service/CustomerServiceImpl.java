package trey.service;

import trey.dao.CustomerDao;
import trey.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;

	public Customer getCustomer(long custId) {
		return customerDao.getCustomerById(custId);
	}

	public void updateName(long custId, String first, String last) {
		customerDao.updateName(custId, first, last);
	}

	public void updateAddress(long custId, String zip) {
		customerDao.updateAddress(custId, zip);
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

}
