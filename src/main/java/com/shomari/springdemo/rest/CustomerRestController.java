package com.shomari.springdemo.rest;


import com.shomari.springdemo.entity.Customer;
import com.shomari.springdemo.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public List<Customer> getCustomers(){
    return customerService.getCustomers();
  }

  // add get mapping for /customers/customerId
  @GetMapping("/customers/{customerId}")
  public Customer getCustomer(@PathVariable int customerId){
    Customer customer = customerService.getCustomer(customerId);

    // throw exception if customer is null - nothing returned from db
    if(customer ==  null){
      throw new CustomerNotFoundException("Customer id not found: - " + customerId);
    }

    return customer;
  }

}
