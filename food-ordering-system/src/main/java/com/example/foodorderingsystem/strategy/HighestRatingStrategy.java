package com.example.foodorderingsystem.strategy;

import com.example.foodorderingsystem.model.Order;
import com.example.foodorderingsystem.model.Restaurant;

import java.util.Map;

public class HighestRatingStrategy implements SelectionStrategy {
    public String selectRestaurant(Map<String, Restaurant> restaurants, Order order) {
        String selectedRestaurant = null;
        double maxRating = -1;

        for (Map.Entry<String, Restaurant> entry : restaurants.entrySet()) {
            Restaurant restaurant = entry.getValue();
            boolean canFulfill = true;

            for (String item : order.getItems().keySet()) {
                if (!restaurant.getMenu().containsKey(item)) {
                    canFulfill = false;
                    break;
                }
            }

            if (canFulfill && restaurant.getRating() > maxRating && restaurant.getCurrentOrders() < restaurant.getMaxOrders()) {
                maxRating = restaurant.getRating();
                selectedRestaurant = entry.getKey();
            }
        }

        return selectedRestaurant;
    }
}
