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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to MyHotel Reservation System.\nPlease enter number of the Rooms (Max 1000).\nDefault is 1.");
        roomNumber = scanner.nextInt();
        List<Room> roomList = new ArrayList<>();
        for (int i = 0; i < roomNumber; i++) {
            roomList.add(new Room(i));
        }

        while (!userOptionControl) {
            int userChoice = 0;
            boolean validInput = false;
            do {
                System.out.println("Please choose the action:");
                System.out.println("1- Make Reservation");
                System.out.println("2- See Reservations");
                System.out.println("3- Exit");
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

            switch (userChoice) {
                case 1 -> {
                    int[] dates = DateController.checkDateInput();
                    int controledRoomNumbers = 0;
                    for (Room room : roomList) {
                        int roomNumberIndex = roomList.indexOf(room) + 1;
                        RoomReservation roomReservation = new RoomReservation();
                        if (room.isRoomAvailable(dates)){
                            roomReservation.makeReservation(roomNumberIndex, dates);
                            room.getRoomReservations().add(roomReservation);
                            System.out.println("Reservation Completed");
                            break;
                        } else {
                            controledRoomNumbers++;
                        }
                    }
                    if (controledRoomNumbers == roomNumber) {
                        System.out.println("No available Room for dates entered.");
                    }
                }
                case 2 -> {
                    for (Room rm : roomList) {
                        for (RoomReservation roomReservation : rm.getRoomReservations()) {
                            roomReservation.printReservationInfo();
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Exit");
                    userOptionControl = true;
                }
            }
        }
    }
}


