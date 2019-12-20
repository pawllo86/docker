package com.example.orderservice.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    private static final Map<Long, Order> ORDERS = new HashMap<>();

    private OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Order createOrder(@RequestBody Order input) {
        Order order = service.createOrder(input);
        ORDERS.put(order.getId(), order);

        return order;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Order> orders() {
        return ORDERS.values();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order findOrder(@PathVariable Long id) {
        return ORDERS.get(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(OrderCreationException.class)
    public String handleException(OrderCreationException exception) {
        return exception.getMessage();
    }
}
