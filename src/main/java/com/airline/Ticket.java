package com.airline;

public class Ticket {

    private int ticketId;
    private Booking booking;

    public Ticket(int ticketId, Booking booking) {

        this.ticketId = ticketId;
        this.booking = booking;
    }

    public void printTicket() {

        System.out.println("\n======================");
        System.out.println("     AIRLINE TICKET");
        System.out.println("======================");

        System.out.println("Ticket ID : " + ticketId);
        System.out.println("Passenger : "
                + booking.getPassengerName());

        System.out.println("Flight : "
                + booking.getFlight().getFlightNo());

        System.out.println("Seat : "
                + booking.getSeatNo());

        System.out.println("Amount : $"
                + booking.getFlight().getPrice());

        System.out.println("======================");
    }
}