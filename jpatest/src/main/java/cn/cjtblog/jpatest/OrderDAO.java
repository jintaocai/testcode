package cn.cjtblog.jpatest;

import java.util.List;

public interface OrderDAO {
	void add(Order order);
	void update(Order order);
	void delete(Order order);
	Order getById(long id);
	List<Order> getAll();
	List<Order> getListByPage(int offset, int maxResults);
}
