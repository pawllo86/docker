package com.example.orderservice.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient(name = "customer-service")
//@RequestMapping(path = "/customers")
@FeignClient(name = "zuul-api-gateway")
@RequestMapping(path = "/customer-service/customers")
public interface CustomerServiceProxy {

    @GetMapping(path ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Customer findCustomer(@PathVariable Long id);
}
