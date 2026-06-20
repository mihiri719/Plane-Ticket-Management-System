package com.airline;

public class Customer extends User {

    public Customer(String username,
                    String password) {

        super(username, password);
    }

    public void displayCustomerMenu() {

        System.out.println("\n===== CUSTOMER MENU =====");
        System.out.println("1. View Flights");
        System.out.println("2. Book Ticket");
        System.out.println("3. Cancel Ticket");
        System.out.println("4. View My Booking");
        System.out.println("5. Logout");
    }
}