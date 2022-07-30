package org.myhotel.controller;

import java.util.Arrays;
import java.util.Scanner;

public class DateController {

    public static int[] getDateInput() {
        Scanner scanner = new Scanner(System.in);

        int[] datesRangeContol; // Temporary int array to control entered dates data
        System.out.println("Please enter the dates in StartDay,EndDay format:");
        try {
            /*
            Parsing the entered dates 1,10 to 1 10 and stores in datesInput String array
             */
            String[] datesInput = scanner.nextLine().split(",");
            if(datesInput.length != 2) { // If only 1 number entered Controls here.
                throw new ArrayIndexOutOfBoundsException("Please enter Start Day and End Day in 1,10 format");
            }else {
                datesRangeContol = Arrays.stream(datesInput).mapToInt(Integer::parseInt).toArray();
                /*
                Controlling datesRangeControl to be 0 - 365 and also if startDay is bigger then endDay
                 */
                if (datesRangeContol[0] > datesRangeContol[1] || datesRangeContol[0] < 0 ||
                        datesRangeContol[0] > 365 || datesRangeContol[1] > 365) {
                    throw new ArrayIndexOutOfBoundsException("Please enter Start Day and End Day between 0 to 365");
                } else {
                    /*
                    Dates input Ok. Returning to Reservation process on Main
                     */
                    return datesRangeContol;
                }
            }
        } catch (Exception err) {
            /*
            Catches the non-numeric value
             */
            System.out.println("Please enter dates in 1,10 format");
            return null;
        }
    }
}
