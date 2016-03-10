package cn.cjtblog.jpatest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
     
    	ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
    		
    	CustomerService customerService=(CustomerService)context.getBean("customerService");
    	Customer customer=customerService.createCustomer("Tom");
    	customerService.createOrderForCustomer(22, customer);
    }
}
