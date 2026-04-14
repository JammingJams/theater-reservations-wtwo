package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formattable;
import java.util.Scanner;

public class TheaterReservationApp {
    public static void main(String[] args) {
        //
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter your name here!: ");
        String userName = sc.nextLine();

        String[] splitName = userName.split("\\s+");



        System.out.print("What date will you be coming?: ");
        String userDate = sc.nextLine().replaceAll("\\s+", "");;

        userDate = userDate.replaceAll("/", "-");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        LocalDate userArrivalDate = LocalDate.parse(userDate, format);



        System.out.print("How many tickets would you like?: ");
        String userTicketAmount = sc.nextLine().replaceAll("\\s+", "");

        int finalTicketAmount = Integer.parseInt(userTicketAmount);


        if (finalTicketAmount > 1) {
            System.out.println(userTicketAmount + " tickets reserved for " + userArrivalDate + " under " + splitName[1] + ", " + splitName[0]);
        }
        else {
            System.out.println(userTicketAmount + " ticket reserved for " + userArrivalDate + " under " + splitName[1] + ", " + splitName[0]);
        }


    }
}
