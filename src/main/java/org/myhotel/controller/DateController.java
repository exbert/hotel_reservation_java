package org.myhotel.controller;

import java.util.Arrays;
import java.util.Scanner;

public class DateController {

    public static int[] checkDateInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the dates");
        String[] datesInput = scanner.nextLine().split(",");
        return Arrays.stream(datesInput).mapToInt(Integer::parseInt).toArray();
    }
}
