package com.example.orderservice.order;

class Order {

    private Long id;
    private Long price;
    private String name;
    private Long customerId;
    private String customerName;

    public Order(Long id, Long price, String name, Long customerId, String customerName) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
