package yepp.bankingcase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import yepp.bankingcase.model.Customer;
import yepp.bankingcase.service.CustomerService;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customer/{uid}")
    public Customer getCustomer(@PathVariable int uid) {
        return this.customerService.getCustomerById(uid);
    }

    @PostMapping(value = "/customers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer createCustomer(@RequestBody Customer newCustomer) {
        if (newCustomer != null) {
            this.customerService.createCustomer(newCustomer);
            return newCustomer;
        }
        return null;
    }

    @PutMapping(value = "/customer/{uid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer updateCustomer(@PathVariable int uid, @RequestBody Customer newCustomer) {
        if (newCustomer != null) {
            return this.customerService.updateCustomer(uid, newCustomer);
        }
        return null;
    }

    @DeleteMapping(value = "/customer/{uid}")
    public void deleteCustomer(@PathVariable int uid) {
        this.customerService.deleteCustomer(uid);
    }
}
