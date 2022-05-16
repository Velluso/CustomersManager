package com.example.springmvc1.service;

import com.example.springmvc1.dao.CustomerDAO;
import com.example.springmvc1.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        customerDAO.saveCustomer(theCustomer);
    }

    @Override
    public Customer getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }

    @Override
    public Customer deleteCustomer(int id) {
        return customerDAO.deleteCustomer(id);
    }
}
