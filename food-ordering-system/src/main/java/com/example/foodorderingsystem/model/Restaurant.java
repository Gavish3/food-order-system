package com.example.foodorderingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private String name;
    private int maxOrders;
    private Map<String, Integer> menu = new HashMap<>();
    private double rating;
    private int currentOrders;
    private Set<Integer> activeOrderIds = new HashSet<>();

}
