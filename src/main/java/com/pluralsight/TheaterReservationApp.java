package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Formattable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TheaterReservationApp {
    public static void main(String[] args) {
        ///
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter your name here!: ");
        String userName = sc.nextLine();

        String[] splitName = userName.split("\\s+");

        int nameArrayCount = splitName.length;

        while (nameArrayCount > 2 || nameArrayCount == 1) {
            System.out.print("Please only enter your first and last name here!: ");

            userName = sc.nextLine();
            splitName = userName.split("\\s+");
            nameArrayCount = splitName.length;
        }



        System.out.print("What date will you be coming (MM/dd/yyyy)?: ");
        String userDate = sc.nextLine().replaceAll("\\s+", "");

        userDate = userDate.replaceAll("/", "-");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        LocalDate userArrivalDate = LocalDate.parse("10-10-2025", format);

        while (true) {
            try {
                userArrivalDate = LocalDate.parse(userDate, format);
                break;
            }
            catch (DateTimeParseException e) {
                System.out.print("Invalid input please try again!: ");
                userDate = sc.nextLine().replaceAll("\\s+", "");
                userDate = userDate.replaceAll("/", "-");

            }
        }


        System.out.print("How many tickets would you like?: ");
        String userTicketAmount = sc.nextLine().replaceAll("\\s+", "");

        int finalTicketAmount = Integer.parseInt("1");

        while (true) {
            try {
                finalTicketAmount = Integer.parseInt(userTicketAmount);
                break;
            }
            catch (NumberFormatException e) {
                System.out.print("Invalid input please try again!: ");
                userTicketAmount = sc.nextLine().replaceAll("\\s+", "");
            }
        }
        if (finalTicketAmount > 1) {
            System.out.println(userTicketAmount + " tickets reserved for " + userArrivalDate + " under " + splitName[1] + ", " + splitName[0]);
        }
        else {
            System.out.println(userTicketAmount + " ticket reserved for " + userArrivalDate + " under " + splitName[1] + ", " + splitName[0]);
        }


    }
}
