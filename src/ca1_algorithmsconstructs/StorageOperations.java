
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ca1_algorithmsconstructs;

import ca1_algorithmsconstructs.FoodItem;

/**
 * Interface defining operations for the food storage system.
 * Follows FIFO (First In First Out) queue behavior.
 * 
 * @author James
 */
public interface StorageOperations {
    
    // Add a food item to the storage
    void enqueue(FoodItem item);
    
    // Remove and return the front food item
    FoodItem dequeue();
    
    // View the front item without removing it
    FoodItem peek();
    
    // Display all items in storage
    void display();
    
    // Check if storage is empty
    boolean isEmpty();
    
    // Check if storage is full (max 8 items)
    boolean isFull();
    
    // Search for a food item by name
    FoodItem search(String name);
}
