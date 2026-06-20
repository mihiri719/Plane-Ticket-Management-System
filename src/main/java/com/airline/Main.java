package com.airline;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Flight> flights = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // Default Flights
        flights.add(new Flight(
                1,
                "UL101",
                "Colombo",
                "London",
                1500
        ));

        flights.add(new Flight(
                2,
                "UL102",
                "Colombo",
                "Dubai",
                900
        ));

        int choice;

        do {

            System.out.println("\n==============================");
            System.out.println(" PLANE TICKET MANAGEMENT");
            System.out.println("==============================");
            System.out.println("1. Add Flight");
            System.out.println("2. View Flights");
            System.out.println("3. Search Flight");
            System.out.println("4. Delete Flight");
            System.out.println("5. Book Ticket");
            System.out.println("6. View Bookings");
            System.out.println("7. Generate Ticket");
            System.out.println("8. Exit");
            System.out.print("Enter Choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    addFlight();
                    break;

                case 2:
                    viewFlights();
                    break;

                case 3:
                    searchFlight();
                    break;

                case 4:
                    deleteFlight();
                    break;

                case 5:
                    bookTicket();
                    break;

                case 6:
                    viewBookings();
                    break;

                case 7:
                    generateTicket();
                    break;

                case 8:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 8);
    }

    public static void addFlight() {

        System.out.print("Enter Flight ID: ");
        int id = input.nextInt();

        input.nextLine();

        System.out.print("Enter Flight Number: ");
        String flightNo = input.nextLine();

        System.out.print("Enter Source: ");
        String source = input.nextLine();

        System.out.print("Enter Destination: ");
        String destination = input.nextLine();

        System.out.print("Enter Price: ");
        double price = input.nextDouble();

        flights.add(
                new Flight(
                        id,
                        flightNo,
                        source,
                        destination,
                        price
                )
        );

        System.out.println("Flight Added Successfully!");
    }

    public static void viewFlights() {

        if (flights.isEmpty()) {

            System.out.println("No Flights Available!");
            return;
        }

        System.out.println("\n----- AVAILABLE FLIGHTS -----");

        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }

    public static void searchFlight() {

        input.nextLine();

        System.out.print("Enter Destination: ");
        String destination = input.nextLine();

        boolean found = false;

        for (Flight flight : flights) {

            if (flight.getDestination()
                    .equalsIgnoreCase(destination)) {

                System.out.println(flight);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Flights Found!");
        }
    }

    public static void deleteFlight() {

        System.out.print("Enter Flight ID: ");
        int id = input.nextInt();

        Flight removeFlight = null;

        for (Flight flight : flights) {

            if (flight.getId() == id) {

                removeFlight = flight;
                break;
            }
        }

        if (removeFlight != null) {

            flights.remove(removeFlight);

            System.out.println("Flight Deleted Successfully!");
        }
        else {

            System.out.println("Flight Not Found!");
        }
    }

    public static void bookTicket() {

        System.out.print("Enter Booking ID: ");
        int bookingId = input.nextInt();

        input.nextLine();

        System.out.print("Enter Passenger Name: ");
        String passengerName = input.nextLine();

        System.out.println("\nAvailable Flights:");

        for (Flight flight : flights) {
            System.out.println(flight);
        }

        System.out.print("\nEnter Flight ID: ");
        int flightId = input.nextInt();

        input.nextLine();

        System.out.print("Enter Seat Number (A1,A2,B1...): ");
        String seatNo = input.nextLine();

        for (Booking booking : bookings) {

            if (booking.getSeatNo()
                    .equalsIgnoreCase(seatNo)) {

                System.out.println(
                        "Seat Already Reserved!"
                );

                return;
            }
        }

        Flight selectedFlight = null;

        for (Flight flight : flights) {

            if (flight.getId() == flightId) {

                selectedFlight = flight;
                break;
            }
        }

        if (selectedFlight == null) {

            System.out.println("Flight Not Found!");
            return;
        }

        Booking booking = new Booking(
                bookingId,
                passengerName,
                selectedFlight,
                seatNo
        );

        bookings.add(booking);

        saveBookingToFile(booking);

        System.out.println("Booking Successful!");
    }

    public static void viewBookings() {

        if (bookings.isEmpty()) {

            System.out.println("No Bookings Found!");
            return;
        }

        System.out.println("\n----- BOOKINGS -----");

        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    public static void generateTicket() {

        if (bookings.isEmpty()) {

            System.out.println("No Booking Available!");
            return;
        }

        System.out.print("Enter Booking ID: ");
        int bookingId = input.nextInt();

        for (Booking booking : bookings) {

            if (booking.getBookingId() == bookingId) {

                Ticket ticket = new Ticket(
                        bookingId + 1000,
                        booking
                );

                ticket.printTicket();
                return;
            }
        }

        System.out.println("Booking Not Found!");
    }

    public static void saveBookingToFile(
            Booking booking) {

        try {

            FileWriter writer =
                    new FileWriter(
                            "bookings.txt",
                            true
                    );

            writer.write(
                    booking.getBookingId() + "," +
                            booking.getPassengerName() + "," +
                            booking.getFlight().getFlightNo() + "," +
                            booking.getSeatNo() + "\n"
            );

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Error Saving Booking!"
            );
        }
    }
}