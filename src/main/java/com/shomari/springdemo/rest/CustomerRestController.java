package com.shomari.springdemo.rest;


import com.shomari.springdemo.entity.Customer;
import com.shomari.springdemo.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  // add post mapping for /customers
  @PostMapping("/customers")
  public Customer addCustomer(@RequestBody Customer theCustomer){

    // set id to 0 to ensure hibernate treats it as new record for db
    theCustomer.setId(0);

    // hibernate will auto set id of customer object to reflect the actual id that it was given
    // in the db
    customerService.saveCustomer(theCustomer);

    return theCustomer;
  }

  // add mapping four put /customers/customerId - update an existing customer
  @PutMapping("/customers")
  public Customer updateCustomer(@RequestBody Customer theCustomer){
    int id = theCustomer.getId();
    Customer tempCustomer =  customerService.getCustomer(theCustomer.getId());

    // throw exception if customer is null - nothing returned from db
    if(tempCustomer ==  null){
      throw new CustomerNotFoundException("Customer id not found: - " + id);
    }

    customerService.saveCustomer(theCustomer);

    return theCustomer;
  }

  // add delete mapping for /customers/customerId
  @DeleteMapping("/customers/{customerId}")
  public String deleteCustomer(@PathVariable int customerId){

    Customer tempCustomer =  customerService.getCustomer(customerId);

    // throw exception if customer is null - nothing returned from db
    if(tempCustomer ==  null){
      throw new CustomerNotFoundException("Customer id not found: - " + customerId);
    }

    customerService.deleteCustomer(customerId);

    return "Deleted customer id - " + customerId;
  }

}
