package org.myhotel.models;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Room {
    // Room class holds its Reservations in List
    private final List<RoomReservation> roomReservations = new ArrayList<>();

    // Room holds its reserved day information. Not a 365 long array to save memory
    private final List<Integer> reservedDays = new ArrayList();

    public Room(int i) {
    }
    public List<RoomReservation> getRoomReservations() {
        return roomReservations;
    }

    /*
    Dates received and here checks if the room is suitable for the given dates.
     */
    public boolean isRoomAvailable(int[] dates) {
        // Checks if reservedDays empty So there is no reservation yet.
        if (reservedDays.isEmpty()){
            // Given days entered to reservedDays 1,2,3,4 or 15,16,17
            for (int writeDate = dates[0]; writeDate <= dates[1]; writeDate++ ){
                //Days all added to reservedDays List
                reservedDays.add(writeDate);
                /*
                If there was 1,2,3,4 days reserved if 15,17 comes reservedDays
                becomes 1,2,3,4,15,16,17 and sorted . After this if 10,12 comes
                becomes 1,2,3,4,10,11,12,15,16,17 and sorted.
                 */
                Collections.sort(reservedDays);
            }
            return true;
        } else if (!freeDaysCheck(reservedDays, dates)) {
            /*
            For the room , reservedDays is not empty so send the current days and new dates to freeDaysCheck
            if the dates are empty continues from here.
             */
            for (int writeDate = dates[0]; writeDate <= dates[1]; writeDate++ ){
                //Days all added to reservedDays List
                reservedDays.add(writeDate);
                /*
                If there was 1,2,3,4 days reserved if 15,17 comes reservedDays
                becomes 1,2,3,4,15,16,17 and sorted . After this if 10,12 comes
                becomes 1,2,3,4,10,11,12,15,16,17 and sorted.
                 */
                Collections.sort(reservedDays);
            }
            return true;
        } else {
            /*
            freeDaysCheck couldn't find the given dates empty
            so returning false to look other rooms or end reservation.
             */
            return false;
        }
    }
    /*
    Receive Rooms reservedDays and new Dates to control if it is empty or not
     */
    private boolean freeDaysCheck(final List<Integer> reservedDays, final int[] dates) {
        boolean checkContains = false;
        for (int i = dates[0]; i <= dates[1]; i++) {
            int currentDate = i;
            checkContains = reservedDays.stream().anyMatch(n -> n == currentDate);
            if (checkContains) {
                break;
            }
        }
        return checkContains;
    }
}



