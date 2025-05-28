package com.example.foodorderingsystem.strategy;

import com.example.foodorderingsystem.model.Order;
import com.example.foodorderingsystem.model.Restaurant;

import java.util.Map;

public interface SelectionStrategy {
    String selectRestaurant(Map<String, Restaurant> restaurants, Order order);
}
