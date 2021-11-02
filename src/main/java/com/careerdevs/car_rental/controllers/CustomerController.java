package com.careerdevs.car_rental.controllers;

import com.careerdevs.car_rental.entities.Car;
import com.careerdevs.car_rental.entities.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private Map<Long, Customer> customers = new HashMap<>();
    private AtomicLong idCounter = new AtomicLong();
//    private final EmployeeRepository repository;
//
//    public EmployeeController(EmployeeRepository repository) {
//        this.repository = repository;
//    }

    public CustomerController() {
        Long id = idCounter.incrementAndGet();
        customers.put(id, new Customer("Jim","Ford Pinto"));
    }


    //CRUD
    // Create - create one employee
    // Read - get one employee by id / get all employees
    // Update - update one employee by id
    // Destroy - delete by employee by id.

    @GetMapping
    public List<Customer> all() {
        return new ArrayList<Customer>(customers.values());
    }

    @PostMapping
    public Customer newEmployee(@RequestBody Customer newCustomer) {
        Long id = idCounter.incrementAndGet();
        newCustomer.setId(id);
        customers.put(id, newCustomer);
        return newCustomer;
    }

    @GetMapping("/{id}")
    public Customer employee(@PathVariable Long id) {
        return customers.get(id);
    }

    @PutMapping("/{id}")
    public Customer updateEmployee(@PathVariable Long id, @RequestBody Customer updateData){
        Customer cust = customers.get(id);

        if (cust == null) {
            return cust;
        }

        if(updateData.getName() != null) {
            cust.setName(updateData.getName());
        }
        if(updateData.getCarPurchased() != null) {
            cust.setCarPurchased(updateData.getCarPurchased());
        }


        return cust;
    }

    // Destroy - delete by employee by id.
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        customers.remove(id);
    }

}
