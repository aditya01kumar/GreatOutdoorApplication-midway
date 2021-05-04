package com.cg.goa.service;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.goa.exception.OrderException;
import com.cg.goa.model.OrderModel;

public interface IOrderService {

	public List<OrderModel> findOrdersByUserId(String userId);

	public List<OrderModel> findAllOrders();

	public OrderModel addOrder(OrderModel orderEntity) throws OrderException;

	public boolean deleteAllOrders() throws OrderException;

	public boolean deleteOrderById(Integer orderId) throws OrderException;

	public boolean updateDate(Integer orderId, LocalDateTime dispatchDate, LocalDateTime arrivalDate) throws OrderException;

}
