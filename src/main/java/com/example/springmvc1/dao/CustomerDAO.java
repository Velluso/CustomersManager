package com.example.springmvc1.dao;

import com.example.springmvc1.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();


    void saveCustomer(Customer theCustomer);


    Customer getCustomer(int id);


    Customer deleteCustomer(int id);
}
