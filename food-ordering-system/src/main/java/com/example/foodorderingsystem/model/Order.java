package com.example.foodorderingsystem.model;

import com.example.foodorderingsystem.model.enums.OrderStatus;
import com.example.foodorderingsystem.model.enums.SelectionStrategyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private int id;
    private String user;
    private Map<String, Integer> items = new HashMap<>();
    private OrderStatus status;
    private SelectionStrategyType strategyType;
    private String assignedRestaurant;
}
