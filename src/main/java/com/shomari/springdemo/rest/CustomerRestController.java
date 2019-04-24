package com.shomari.springdemo.rest;


import com.shomari.springdemo.entity.Customer;
import com.shomari.springdemo.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

  // autowire customer service to inject dependency
  @Autowired
  private CustomerService customerService;

  // add get mapping for /customers
  @GetMapping("/customers")
  public List<Customer> getCustomer(){
    return customerService.getCustomers();
  }

}
