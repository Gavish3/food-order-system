package com.example.foodorderingsystem.service;

import com.example.foodorderingsystem.model.Order;
import com.example.foodorderingsystem.model.Restaurant;
import com.example.foodorderingsystem.model.enums.OrderStatus;
import com.example.foodorderingsystem.model.enums.SelectionStrategyType;
import com.example.foodorderingsystem.strategy.HighestRatingStrategy;
import com.example.foodorderingsystem.strategy.LowestCostStrategy;
import com.example.foodorderingsystem.strategy.SelectionStrategy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {
    private int orderIdCounter = 1;
    private Map<Integer, Order> orders = new HashMap<>();
    private RestaurantService restaurantService;
    private Map<SelectionStrategyType, SelectionStrategy> strategies = Map.of(
            SelectionStrategyType.LOWEST_COST, new LowestCostStrategy(),
            SelectionStrategyType.HIGHEST_RATING, new HighestRatingStrategy()
    );

    public OrderService(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    public Order placeOrder(Order order) {
        String selectedRestaurant = strategies.get(order.getStrategyType())
                .selectRestaurant(restaurantService.getAllRestaurants(), order);

        if (selectedRestaurant != null) {
            Restaurant restaurant = restaurantService.getRestaurant(selectedRestaurant);
            restaurant.setCurrentOrders(restaurant.getCurrentOrders() + 1);
            restaurant.getActiveOrderIds().add(orderIdCounter);

            order.setId(orderIdCounter++);
            order.setStatus(OrderStatus.ACCEPTED);
            order.setAssignedRestaurant(selectedRestaurant);
            orders.put(order.getId(), order);
        }

        return order;
    }

    public void markOrderComplete(int orderId) {
        Order order = orders.get(orderId);
        if (order != null && order.getStatus() == OrderStatus.ACCEPTED) {
            order.setStatus(OrderStatus.COMPLETED);
            restaurantService.markOrderComplete(order.getAssignedRestaurant(), orderId);
        }
    }

    public Order getOrder(int orderId) {
        return orders.get(orderId);
    }
}
