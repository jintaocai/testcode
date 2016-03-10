package cn.cjtblog.jpatest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Component
@Transactional
public class CustomerService {
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private CustomerDAO customerDAO;
	
	public Customer createCustomer(String name){
		Customer customer=new Customer();
		customer.setName(name);
		customerDAO.add(customer);
		return customer;
	}
	
	public Order createOrderForCustomer(double price,Customer customer){
		Order order=new Order();
		order.setCustomer(customer);
		orderDAO.add(order);
		return order;
	}
	//设置事务的readOnly属性为只读，这样可以有利于调优
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Customer> getCustomerList() {
		// TODO Auto-generated method stub
		return customerDAO.getAll();
	}
}
