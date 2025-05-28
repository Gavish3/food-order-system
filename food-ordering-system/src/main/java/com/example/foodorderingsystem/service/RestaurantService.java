package com.example.foodorderingsystem.service;

import com.example.foodorderingsystem.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RestaurantService {
    private Map<String, Restaurant> restaurants = new HashMap<>();

    public void onboardRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getName(), restaurant);
    }

    public void updateMenu(String restaurantName, Map<String, Integer> updates) {
        Restaurant restaurant = restaurants.get(restaurantName);
        if (restaurant != null) {
            restaurant.getMenu().putAll(updates);
        }
    }

    public Restaurant getRestaurant(String name) {
        return restaurants.get(name);
    }

    public Map<String, Restaurant> getAllRestaurants() {
        return restaurants;
    }

    public void markOrderComplete(String restaurantName, int orderId) {
        Restaurant restaurant = restaurants.get(restaurantName);
        if (restaurant != null) {
            restaurant.getActiveOrderIds().remove(orderId);
            restaurant.setCurrentOrders(restaurant.getCurrentOrders() - 1);
        }
    }
}
