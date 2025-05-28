package com.example.foodorderingsystem.controller;

import com.example.foodorderingsystem.model.Order;
import com.example.foodorderingsystem.model.Restaurant;
import com.example.foodorderingsystem.service.OrderService;
import com.example.foodorderingsystem.service.RestaurantService;
//import com.foodorderingsystem.model.*;
//import com.foodorderingsystem.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class FoodOrderingController {

    private final RestaurantService restaurantService;
    private final OrderService orderService;

    public FoodOrderingController(RestaurantService restaurantService, OrderService orderService) {
        this.restaurantService = restaurantService;
        this.orderService = orderService;
    }

    @PostMapping("/restaurant")
    public ResponseEntity<?> onboardRestaurant(@RequestBody Restaurant restaurant) { /* logic */ }

    @PutMapping("/restaurant/{name}/menu")
    public ResponseEntity<?> updateMenu(@PathVariable String name, @RequestBody Map<String, Integer> updates)
    {
        /* logic */
    }

    @PostMapping("/order")
    public ResponseEntity<?> placeOrder(@RequestBody Order order) { /* logic */ }

    @PostMapping("/order/{id}/complete")
    public ResponseEntity<?> completeOrder(@PathVariable int id) { /* logic */ }

    @GetMapping("/order/{id}")
    public ResponseEntity<?> getOrder(@PathVariable int id) { /* logic */ }
}
