/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1_algorithmsconstructs;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
     * Returns a readable string of the food item details.
     */
    @Override
    public String toString() {
        return "FoodItem{" +
               "name='" + name + '\'' +
               ", weight=" + weightInGrams + "g" +
               ", bestBefore=" + bestBeforeDate +
               ", placedAt=" + placementTime +
               '}';
    }
}
