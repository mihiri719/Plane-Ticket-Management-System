package com.airline;

public class Seat {

    private String seatNo;
    private boolean booked;

    public Seat(String seatNo) {
        this.seatNo = seatNo;
        this.booked = false;
    }

    public void reserveSeat() {

        if (!booked) {
            booked = true;
            System.out.println("Seat Reserved");
        }
        else {
            System.out.println("Already Reserved");
        }
    }
}