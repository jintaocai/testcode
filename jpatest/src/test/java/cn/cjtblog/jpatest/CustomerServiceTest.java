package cn.cjtblog.jpatest;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerServiceTest{
	private CustomerService customerService;
	private ApplicationContext applicationContext;
	@Before
	public void init(){
		applicationContext=new ClassPathXmlApplicationContext("spring.xml");
		
		customerService=(CustomerService)applicationContext.getBean("customerService");

	}
	@Test
	public void testCreateCustomer(){
		Customer customer=customerService.createCustomer("tom");
		Assert.assertNotNull(customer);
		Assert.assertTrue(customer.getId()>0);
		
	}
	@Test
	public void testCreateOrderForCustomer(){
		Customer customer=customerService.createCustomer("tom");
		Order order=customerService.createOrderForCustomer(11, customer);
		Assert.assertNotNull(order);
		Assert.assertTrue(order.getId()>0);
		Assert.assertSame(order.getCustomer().getId(), customer.getId());
	}
	@Test
	public void testGetCustomerList(){
		for(int i=0;i<5;i++){
			customerService.createCustomer("name"+i);
		}
		List<Customer> customerList=customerService.getCustomerList();
		Assert.assertTrue(customerList.size()>=5);
	}
	

}
