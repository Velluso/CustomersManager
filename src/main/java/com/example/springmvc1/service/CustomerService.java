package com.example.springmvc1.service;

import com.example.springmvc1.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

   public void saveCustomer(Customer theCustomer);


    Customer getCustomer(int id);

    Customer deleteCustomer(int id);
}
