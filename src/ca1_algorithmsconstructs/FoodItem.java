/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1_algorithmsconstructs;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a food item in the storage system.
 * Stores details about each food item including name, weight, dates.
 * 
 * @author james
 */
public class FoodItem {
    // Food item properties
    private String name;
    private double weightInGrams;
    private LocalDate bestBeforeDate;
    private LocalDateTime placementTime;

    /**
     * Creates a new food item with all required details.
     */
    public FoodItem(String name, double weightInGrams, LocalDate bestBeforeDate, LocalDateTime placementTime) {
        this.name = name;
        this.weightInGrams = weightInGrams;
        this.bestBeforeDate = bestBeforeDate;
        this.placementTime = placementTime;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getWeightInGrams() {
        return weightInGrams;
    }

    public LocalDate getBestBeforeDate() {
        return bestBeforeDate;
    }

    public LocalDateTime getPlacementTime() {
        return placementTime;
    }

    /**
     * Returns a formatted string of the food item details.
     */
    @Override
    public String toString() {
        // Format dates for better readability
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        
        return String.format("%-10s | Weight: %6.0fg | Best Before: %s | Added: %s",
                name,
                weightInGrams,
                bestBeforeDate.format(dateFormat),
                placementTime.format(timeFormat));
    }
}
