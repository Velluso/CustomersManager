package com.example.springmvc1.controller;

import com.example.springmvc1.dao.CustomerDAO;
import com.example.springmvc1.entity.Customer;
import com.example.springmvc1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private CustomerService customerService;


     @GetMapping("/list")
   // @PostMapping("/list")
    public String listCustomers(Model theModel) {

        List<Customer> clienti = customerDAO.getCustomers();

        theModel.addAttribute("customers", clienti);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

         customerService.saveCustomer(theCustomer);

         return "redirect:/customer/list";

    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model theModel) {

         Customer theCustomer = customerService.getCustomer(id);

         theModel.addAttribute("customer", theCustomer);

         return "customer-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int id, Model theModel) {

         Customer theCustomer = customerService.deleteCustomer(id);

         customerService.deleteCustomer(id);

        return "redirect:/customer/list";
    }

}
