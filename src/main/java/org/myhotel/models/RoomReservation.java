package org.myhotel.models;

public class RoomReservation {

    private int startDay;
    private int endDay;
    private String bookingNumber;


    public String getBookingNumber() {
        return bookingNumber;
    }

    public void makeReservation(int roomNumberIndex, int[] dates) {
        startDay = dates[0];
        endDay = dates[1];
        bookingNumber = "" + roomNumberIndex + "." + dates[0] + "." + dates[1];
        // System.out.println("MakeReservation output: " + startDay + " " + endDay + " " + bookingNumber);

    }

    public void printReservationInfo() {
        System.out.println("Room " + bookingNumber.charAt(0) +" Start Day: " + startDay + " End Day: " + endDay + " Booking Number: " + bookingNumber  );

    }


}
