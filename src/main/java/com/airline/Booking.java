package com.airline;

public class Booking {

    private int bookingId;
    private String passengerName;
    private Flight flight;
    private String seatNo;

    public Booking(int bookingId,
                   String passengerName,
                   Flight flight,
                   String seatNo) {

        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.flight = flight;
        this.seatNo = seatNo;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public Flight getFlight() {
        return flight;
    }

    public String getSeatNo() {
        return seatNo;
    }

    @Override
    public String toString() {

        return "\nBooking ID : " + bookingId +
                "\nPassenger : " + passengerName +
                "\nFlight : " + flight.getFlightNo() +
                "\nSeat : " + seatNo +
                "\nPrice : $" + flight.getPrice();
    }
}