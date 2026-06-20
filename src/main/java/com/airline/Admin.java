package com.airline;

public class Admin extends User {

    public Admin(String username,
                 String password) {

        super(username, password);
    }

    public void displayAdminMenu() {

        System.out.println("\n===== ADMIN MENU =====");
        System.out.println("1. Add Flight");
        System.out.println("2. View Flights");
        System.out.println("3. Search Flight");
        System.out.println("4. Delete Flight");
        System.out.println("5. Logout");
    }
}