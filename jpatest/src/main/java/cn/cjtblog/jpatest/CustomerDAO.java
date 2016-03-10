package cn.cjtblog.jpatest;

import java.util.List;

public interface CustomerDAO {
	void add(Customer customer);
	void update(Customer customer);
	void delete(Customer customer);
	Customer getById(long id);
	List<Customer> getAll();
	List<Customer> getListByPage(int offset, int maxResults);
}
