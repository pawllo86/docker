package com.example.customerservice.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private static final Map<Long, Customer> customers = new ConcurrentHashMap<>();

    @PostConstruct
    void init() {
        customers.put(1L, new Customer(1L, "Adam Małysz", 1000L));
        customers.put(2L, new Customer(2L, "Robert Lewandowski", 2000L));
        customers.put(3L, new Customer(3L, "Anrzej Gołota", 3000L));
        customers.put(4L, new Customer(4L, "Robert Kubica", 4000L));
        customers.put(5L, new Customer(5L, "Jerzy Dudek", 5000L));
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer createCustomer(@RequestBody Customer customer) {
        customers.put(customer.getId(), customer);
        return customer;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path ="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Customer> customers() {
        return customers.values();
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer findCustomer(@PathVariable Long id) {
        return customers.get(id);
    }
}
