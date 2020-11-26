package com.ecommerce.service.order;

import com.ecommerce.data.model.Order;

import java.util.List;

public interface OrderService {

    public Order saveOrder(Order order);
    public Order findOrderById(Integer id);
    public void deleteOrderById(Integer id);
    public List<Order> findAllOrders();
    public Order updateOrder(Order order);
}
