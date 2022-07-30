package org.myhotel.models;

public class RoomReservation {
    private int startDay;
    private int endDay;
    private String bookingNumber;

    /*
    RoomReservation object is filled. Booking number is generated using the roomnNumber, startDay, endDay
     */
    public void makeReservation(int roomNumberIndex, int[] dates) {
        startDay = dates[0];
        endDay = dates[1];
        bookingNumber = "" + roomNumberIndex + "." + dates[0] + "." + dates[1];
    }
    /*
    Printing the reservation of current status.
     */
    public void printReservationInfo() {
        System.out.println("Room " + bookingNumber.charAt(0) +" Start Day: " + startDay + " End Day: " + endDay + " Booking Number: " + bookingNumber  );
    }
}
