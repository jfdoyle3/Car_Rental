package com.careerdevs.car_rental.controllers;

import com.careerdevs.car_rental.entities.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/cars")
public class CarHashMapController {

    private Map<Long, Car> cars = new HashMap<>();
    private AtomicLong idCounter = new AtomicLong();
//    private final EmployeeRepository repository;
//
//    public EmployeeController(EmployeeRepository repository) {
//        this.repository = repository;
//    }

    public CarHashMapController() {
        Long id = idCounter.incrementAndGet();
        cars.put(id, new Car("Ford", "Pinto","Hatchback",1972));
    }


    //CRUD
    // Create - create one employee
    // Read - get one employee by id / get all employees
    // Update - update one employee by id
    // Destroy - delete by employee by id.

    @GetMapping
    public List<Car> all() {
        return new ArrayList<Car>(cars.values());
    }

    @PostMapping
    public Car newEmployee(@RequestBody Car newCar) {
        Long id = idCounter.incrementAndGet();
        newCar.setId(id);
        cars.put(id, newCar);
        return newCar;
    }

    @GetMapping("/{id}")
    public Car employee(@PathVariable Long id) {
        return cars.get(id);
    }

    @PutMapping("/{id}")
    public Car updateEmployee(@PathVariable Long id, @RequestBody Car updateData){
        Car car = cars.get(id);

        if (car == null) {
            return car;
        }

        if(updateData.getName() != null) {
            car.setName(updateData.getName());
        }
        if(updateData.getBrand() != null) {
            car.setBrand(updateData.getBrand());
        }
        if(updateData.getYear() != null) {
            car.setYear(updateData.getYear());
        }

        return car;
    }

    // Destroy - delete by employee by id.
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        cars.remove(id);
    }

}
