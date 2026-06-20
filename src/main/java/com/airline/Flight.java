package com.airline;

public class Flight {

    private int id;
    private String flightNo;
    private String source;
    private String destination;
    private double price;

    public Flight(
            int id,
            String flightNo,
            String source,
            String destination,
            double price) {

        this.id = id;
        this.flightNo = flightNo;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {

        return "ID: " + id +
                " | Flight: " + flightNo +
                " | From: " + source +
                " | To: " + destination +
                " | Price: $" + price;
    }
}