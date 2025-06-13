/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movie_ticket;

import java.util.Scanner;


public class Seats {
    private String room;
    private int seatsCount;
    public String seats_number;    
    public Seats(String room) {
        this.room = room;
    }
  
    public void reserveSeats() {
        String[][] seats = {
            {"A1", "A2", "A3", "A4", "A5", "A6", "A7"},
            {"B1", "B2", "B3", "B4", "B5", "B6", "B7"},
            {"C1", "C2", "C3", "C4", "C5", "C6", "C7"},
            {"D1", "D2", "D3", "D4", "D5", "D6", "D7"}
        };
      
        Scanner input = new Scanner(System.in);
        System.out.print("How many seats would you like to reserve? ");
        int numSeats = input.nextInt();
        while (numSeats <= 0) {
            System.out.print("Please enter a positive integer: ");
            numSeats = input.nextInt();
        }
        seatsCount = numSeats;

        for (int i = 0; i < numSeats; i++) {
            printSeats(seats);
            String seatName = getSeatName(input, seats);
            reserveSeat(seats, seatName);
        }
      
        System.out.println("Thank you for choosing our cinema!");
    }
  
    private void printSeats(String[][] seats) {
    System.out.println("-------------------------------------");
    for (int i = 0; i < seats.length; i++) {
        for (int j = 0; j < seats[i].length; j++) {
            System.out.print(seats[i][j] + "\t");
        }
        System.out.println();
    }
}
  
    private String getSeatName(Scanner input, String[][] seats) {
    String seatName = "";
    
    boolean validSeat = false;
    while (!validSeat) {
        System.out.print("Enter the name of the seat you would like to reserve: ");
        seatName = input.next();
        validSeat = isValidSeat(seatName, seats);
        if (!validSeat) {
            System.out.println("Invalid seat name. Please try again.");
        }
    }
    
    if (seats_number == null) {
        seats_number = seatName;
    } else if (seats_number.isEmpty()) {
        seats_number += seatName;
    } else {
        seats_number += " " + seatName;
    }
    
    return seatName;
}
  
    private boolean isValidSeat(String seatName, String[][] seats) {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seatName.equals(seats[i][j]) && !seats[i][j].equals("[--]")) {
                    return true;
                }
            }
        }
        return false;
    }
  
    private void reserveSeat(String[][] seats, String seatName) {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seatName.equals(seats[i][j])) {
                    seats[i][j] = "[--]";
                    return;
                }
            }
        }
    }

    public int getSeatsCount() {
        return seatsCount;
    }
    
    
}
