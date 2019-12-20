package com.example.orderservice.order;

import com.example.orderservice.customer.Customer;
import com.example.orderservice.customer.CustomerServiceProxy;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
class OrderService {
    private static final AtomicLong INDEX = new AtomicLong(1);

    private CustomerServiceProxy proxy;

    public OrderService(CustomerServiceProxy proxy) {
        this.proxy = proxy;
    }

    Order createOrder(Order order) {
        Customer customer = proxy.findCustomer(order.getCustomerId());

        if (customer.getBalance() < order.getPrice()) {
            throw new OrderCreationException("To less money!");
        }
        return new Order(INDEX.getAndIncrement(), order.getPrice(), order.getName(), customer.getId(), customer.getName());
    }
}
