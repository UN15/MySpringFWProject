package mylab.customer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mylab.customer.dao.mapper.CustomerMapper;
import mylab.customer.vo.CustomerVO;

@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private CustomerMapper customerMapper;	
	

	public List<CustomerVO> selectAllCustomer() {
		List<CustomerVO> customerList = customerMapper.selectAllCustomer();
		return customerList;
	}
	
	public CustomerVO selectCustomer(int id) {
		CustomerVO customer = customerMapper.selectCustomerById(id);
		return customer;
	}

	public void insertCustomer(CustomerVO customer) {
		customerMapper.insertCustomer(customer);
		System.out.println("등록된 Record CustomerId=" + customer.getId() + 
				" Name=" + customer.getName());
	}
	
}
