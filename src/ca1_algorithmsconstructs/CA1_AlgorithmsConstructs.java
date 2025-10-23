/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1_algorithmsconstructs;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Main class for Food Storage System.
 * Provides menu-driven interface for managing food items in storage.
 * 
 * @author James
 */
public class CA1_AlgorithmsConstructs {

    public static void main(String[] args) {
        // Create storage queue and scanner
        FoodStorageQueue storage = new FoodStorageQueue();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("====================================");
        System.out.println("   Food Storage Management System");
        System.out.println("====================================");
        
        boolean running = true;
        
        // Main menu loop
        while (running) {
            displayMenu();
            
            System.out.print("Enter your choice (1-7): ");
            int choice = getValidIntInput(scanner, 1, 7);
            
            switch (choice) {
                case 1:
                    addFoodItem(storage, scanner);
                    break;
                    
                case 2:
                    removeFoodItem(storage);
                    break;
                    
                case 3:
                    displayTopItem(storage);
                    break;
                    
                case 4:
                    storage.display();
                    break;
                    
                case 5:
                    searchFoodItem(storage, scanner);
                    break;
                    
                case 6:
                    displayQueueInfo(storage);
                    break;
                    
                case 7:
                    System.out.println("\nThank you for using Food Storage System!");
                    System.out.println("Exiting...");
                    running = false;
                    break;
            }
            
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    /**
     * Display the main menu options.
     */
    private static void displayMenu() {
        System.out.println("\n========== MENU ==========");
        System.out.println("1. Add Food Item");
        System.out.println("2. Remove Food Item");
        System.out.println("3. View Top Item");
        System.out.println("4. Display All Items");
        System.out.println("5. Search Food Item");
        System.out.println("6. Check Storage Status");
        System.out.println("7. Exit");
        System.out.println("==========================");
    }
    
    /**
     * Add a new food item to storage with immediate validation.
     */
    private static void addFoodItem(FoodStorageQueue storage, Scanner scanner) {
        System.out.println("\n--- Add Food Item ---");
        
        // Check if storage is full first
        if (storage.isFull()) {
            System.out.println("Storage is full. Cannot add more items.");
            return;
        }
        
        // Get and validate food name
        String name = "";
        while (name.trim().isEmpty()) {
            System.out.print("Enter food name (Burger/Pizza/Fries/Sandwich/Hotdog): ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Error: Food name cannot be empty. Please try again.");
            }
        }
        
        // Get and validate weight
        double weight = 0;
        boolean validWeight = false;
        while (!validWeight) {
            System.out.print("Enter weight in grams: ");
            if (scanner.hasNextDouble()) {
                weight = scanner.nextDouble();
                scanner.nextLine(); // Clear buffer
                if (weight <= 0) {
                    System.out.println("Error: Weight must be positive. Please try again.");
                } else {
                    validWeight = true;
                }
            } else {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        
        // Get and validate best before date
        LocalDate bestBeforeDate = null;
        LocalDate today = LocalDate.now();
        LocalDate maxDate = today.plusWeeks(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        while (bestBeforeDate == null) {
            System.out.print("Enter best before date (yyyy-MM-dd): ");
            try {
                String dateStr = scanner.nextLine().trim();
                LocalDate inputDate = LocalDate.parse(dateStr, formatter);
                
                if (inputDate.isBefore(today)) {
                    System.out.println("Error: Best before date cannot be in the past. Please try again.");
                } else if (inputDate.isAfter(maxDate)) {
                    System.out.println("Error: Date cannot be more than 2 weeks from today. Please try again.");
                } else {
                    bestBeforeDate = inputDate;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Error: Invalid date format. Please use yyyy-MM-dd (e.g., 2025-11-01).");
            }
        }
        
        // Create and add food item
        FoodItem item = new FoodItem(name, weight, bestBeforeDate, LocalDateTime.now());
        storage.enqueue(item);
    }
    
    /**
     * Remove food item from storage.
     */
    private static void removeFoodItem(FoodStorageQueue storage) {
        System.out.println("\n--- Remove Food Item ---");
        FoodItem removed = storage.dequeue();
        if (removed != null) {
            System.out.println("Removed item details:");
            System.out.println(removed);
        }
    }
    
    /**
     * Display the top item without removing it.
     */
    private static void displayTopItem(FoodStorageQueue storage) {
        System.out.println("\n--- Top Item in Storage ---");
        FoodItem top = storage.peek();
        if (top != null) {
            System.out.println(top);
        }
    }
    
    /**
     * Search for a food item by name.
     */
    private static void searchFoodItem(FoodStorageQueue storage, Scanner scanner) {
        System.out.println("\n--- Search Food Item ---");
        System.out.print("Enter food name to search: ");
        String searchName = scanner.nextLine().trim();
        storage.search(searchName);
    }
    
    /**
     * Display storage status information.
     */
    private static void displayQueueInfo(FoodStorageQueue storage) {
        System.out.println("\n--- Storage Status ---");
        System.out.println("Empty: " + (storage.isEmpty() ? "Yes" : "No"));
        System.out.println("Full: " + (storage.isFull() ? "Yes" : "No"));
    }
    
    /**
     * Get valid integer input within a range from user.
     */
    private static int getValidIntInput(Scanner scanner, int min, int max) {
        int value = 0;
        boolean valid = false;
        
        while (!valid) {
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                if (value >= min && value <= max) {
                    valid = true;
                } else {
                    System.out.print("Please enter a number between " + min + " and " + max + ": ");
                }
            } else {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next(); // Clear invalid input
            }
        }
        return value;
    }
}
