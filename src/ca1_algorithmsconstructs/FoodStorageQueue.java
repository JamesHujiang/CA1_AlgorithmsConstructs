/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1_algorithmsconstructs;

import java.time.LocalDate;

/**
 * Queue implementation for food storage system.
 * Uses circular array-based FIFO structure with max capacity of 8 items.
 * 
 * @author james
 */
public class FoodStorageQueue implements StorageOperations {
    
    // Array to store food items
    private FoodItem[] queue;
    
    // Index of the front element
    private int front;
    
    // Index of the rear element
    private int rear;
    
    // Current number of items in queue
    private int size;
    
    // Maximum capacity (8 items as per requirement)
    private final int CAPACITY = 8;
    
    /**
     * Constructor to initialize the queue.
     */
    public FoodStorageQueue() {
        this.queue = new FoodItem[CAPACITY];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }
    
    /**
     * Add a food item to the rear of the queue.
     * Time Complexity: O(1) - constant time operation
     */
    @Override
    public void enqueue(FoodItem item) {
        // Check if queue is full
        if (isFull()) {
            System.out.println("Storage is full. Cannot add more items.");
            return;
        }
        
        // Add item to queue using circular approach
        rear = (rear + 1) % CAPACITY;
        queue[rear] = item;
        size++;
        System.out.println(item.getName() + " added to storage.");
    }
    
    /**
     * Remove and return the front food item.
     * Time Complexity: O(1) - constant time operation
     */
    @Override
    public FoodItem dequeue() {
        // Check if queue is empty
        if (isEmpty()) {
            System.out.println("Storage is empty. Cannot remove items.");
            return null;
        }
        
        FoodItem item = queue[front];
        queue[front] = null; // Clear reference
        front = (front + 1) % CAPACITY;
        size--;
        
        System.out.println(item.getName() + " removed from storage.");
        return item;
    }
    
    /**
     * View the front item without removing it.
     * Time Complexity: O(1) - constant time operation
     */
    @Override
    public FoodItem peek() {
        if (isEmpty()) {
            System.out.println("Storage is empty. No items to view.");
            return null;
        }
        return queue[front];
    }
    
    /**
     * Display all items in storage.
     * Time Complexity: O(n) - linear time, where n is number of items
     */
    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println("Storage is empty.");
            return;
        }
        
        System.out.println("\n=== Food Storage Contents ===");
        int count = 0;
        int index = front;
        
        while (count < size) {
            System.out.println((count + 1) + ". " + queue[index]);
            index = (index + 1) % CAPACITY;
            count++;
        }
        System.out.println("Total items: " + size + "/" + CAPACITY);
    }
    
    /**
     * Check if storage is empty.
     * Time Complexity: O(1)
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Check if storage is full.
     * Time Complexity: O(1)
     */
    @Override
    public boolean isFull() {
        return size == CAPACITY;
    }
    
    /**
     * Search for a food item by name.
     * Time Complexity: O(n) - linear search through all items
     * Best case: O(1) if item is at front
     * Worst case: O(n) if item is at end or not found
     */
    @Override
    public FoodItem search(String name) {
        if (isEmpty()) {
            System.out.println("Storage is empty. No items to search.");
            return null;
        }
        
        int count = 0;
        int index = front;
        
        while (count < size) {
            if (queue[index].getName().equalsIgnoreCase(name)) {
                System.out.println("Found: " + queue[index]);
                return queue[index];
            }
            index = (index + 1) % CAPACITY;
            count++;
        }
        
        System.out.println(name + " not found in storage.");
        return null;
    }
}
