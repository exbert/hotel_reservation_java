package org.myhotel;

import org.myhotel.controller.DateController;
import org.myhotel.models.Room;
import org.myhotel.models.RoomReservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean userOptionControl = false;
        int roomNumber;
        int[] controlledDates;
        Scanner scanner = new Scanner(System.in);
        /*
        Getting Number of Rooms
         */
        do {
            System.out.println("Welcome to MyHotel Reservation System.\nPlease enter number of the Rooms (Max 1000).\nDefault is 1.");
            roomNumber = scanner.nextInt();
        } while (roomNumber < 1 || roomNumber > 1000);

        /*
        Creating Room array and initialize it with the number of Rooms.
         */
        List<Room> roomList = new ArrayList<>();
        for (int i = 0; i < roomNumber; i++) {
            roomList.add(new Room(i));
        }
        /*
        User Menu Starts
         */
        while (!userOptionControl) {
            int userChoice = 0;
            boolean validInput = false;
            do {
                System.out.println("Please choose the action:");
                System.out.println("1- Make Reservation");
                System.out.println("2- See Reservations");
                System.out.println("3- Exit");
                /*
                User Menu input control
                 */
                if (scanner.hasNextInt()) {
                    userChoice = scanner.nextInt();
                    if (userChoice >= 1 && userChoice <= 3) {
                        validInput = true;
                    } else {
                        System.out.println("Enter a valid option (1-3)\n");
                    }
                } else {
                    System.out.println("Enter a valid Integer value\n");
                }
            } while (!validInput);
            /*
            Operation with taken User Menu Option 1-3
             */
            switch (userChoice) {
                case 1 -> {
                    /*
                    Asking User days input and controlling them in DateController.gateDateInput method

                     */
                    do {
                        controlledDates = DateController.getDateInput();
                    }while (controlledDates == null);

                    /*
                    Variable to track how many rooms controlled for reservation.
                    If it reached the maximum size We can say that
                    we couldn't find any empty room for specified dates
                     */
                    int controledRoomNumbers = 0;
                    for (Room room : roomList) {
                        /*
                        RoomReservation method for each room
                         */
                        int roomNumberIndex = roomList.indexOf(room) + 1; // Array first index 0 to see meaningfully set +1
                        RoomReservation roomReservation = new RoomReservation();
                        /*
                        By traversing rooms first check if the current room is empty for the given dates.
                        If it is not we will move to fallowing room.
                         */
                        if (room.isRoomAvailable(controlledDates)){
                            /*
                            Empty Room found now making Reservation with the room number and given dates.
                             */
                            roomReservation.makeReservation(roomNumberIndex, controlledDates);
                            /*
                            roomReservation holds the new made reservation object and
                            we are adding this object to room list object
                             */
                            room.getRoomReservations().add(roomReservation);
                            System.out.println("Reservation Accepted");
                            break;
                        } else {
                            /*
                            Control count for how many rooms have been checked to find empty room on the given dates
                             */
                            controledRoomNumbers++;
                        }
                    }
                    if (controledRoomNumbers == roomNumber) {
                        /*
                        All rooms checked but can not find empty room for the given dates
                         */
                        System.out.println("Reservation Declined");
                    }
                }
                case 2 -> {
                    /*
                    Extra Option
                    See the status of Hotel Reservations.
                    Room Number / Reservation Start Day / End Day / Booking number
                                                                        of this reservation (RoomNumber.StartDay.EndDay)
                     */
                    for (Room rm : roomList) {
                        for (RoomReservation roomReservation : rm.getRoomReservations()) {
                            roomReservation.printReservationInfo();
                        }
                    }
                }
                case 3 -> {
                    /*
                    Ends Hotel Reservation program.
                     */
                    System.out.println("Exit");
                    userOptionControl = true;
                }
            }
        }
    }
}


