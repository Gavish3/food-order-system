package com.example.foodorderingsystem.strategy;

import com.example.foodorderingsystem.model.Order;
import com.example.foodorderingsystem.model.Restaurant;

import java.util.Map;

public class LowestCostStrategy implements SelectionStrategy {
    public String selectRestaurant(Map<String, Restaurant> restaurants, Order order) {
        String selectedRestaurant = null;
        int minCost = Integer.MAX_VALUE;

        for (Map.Entry<String, Restaurant> entry : restaurants.entrySet()) {
            Restaurant restaurant = entry.getValue();
            int totalCost = 0;
            boolean canFulfill = true;

            for (Map.Entry<String, Integer> item : order.getItems().entrySet()) {
                if (!restaurant.getMenu().containsKey(item.getKey())) {
                    canFulfill = false;
                    break;
                }
                totalCost += restaurant.getMenu().get(item.getKey()) * item.getValue();
            }

            if (canFulfill && totalCost < minCost && restaurant.getCurrentOrders() < restaurant.getMaxOrders()) {
                minCost = totalCost;
                selectedRestaurant = entry.getKey();
            }
        }

        return selectedRestaurant;
    }
}
