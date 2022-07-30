package org.myhotel.models;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Room {
    private int roomNo;
    private int startDay;
    private int endDay;
    private List<RoomReservation> roomReservations = new ArrayList<>();
    private List<Integer> reservedDays = new ArrayList();

    public Room(int i) {
        this.roomNo = i;
    }
    public List<RoomReservation> getRoomReservations() {
        return roomReservations;
    }

    public List<Integer> getReservedDays() {
        return reservedDays;
    }

    public void setReservedDays(List<Integer> reservedDays) {
        this.reservedDays = reservedDays;
    }

    public boolean isRoomAvailable(int[] dates) {
        if (reservedDays.isEmpty()){
            for (int writeDate = dates[0]; writeDate <= dates[1]; writeDate++ ){
                reservedDays.add(writeDate);
                Collections.sort(reservedDays);
            }
            return true;
        } else if (!freeDaysCheck(reservedDays, dates)) {
            for (int writeDate = dates[0]; writeDate <= dates[1]; writeDate++ ){
                reservedDays.add(writeDate);
                Collections.sort(reservedDays);
            }
            return true;
        } else {

            return false;
        }
    }
    public static boolean freeDaysCheck(final List<Integer> reservedDays, final int[] dates) {
        boolean checkContains = false;
        for (int i = dates[0]; i <= dates[1]; i++) {
            int currentDate = i;
            checkContains = reservedDays.stream().anyMatch(n -> n == currentDate);
        }
        return checkContains;
    }
}



