import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;

public class HotelReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Variables
        String customerName;
        int roomChoice;
        int days;
        int pricePerDay = 0;
        int totalBill;
        double gst;
        double discount = 0;
        double finalBill;

        // Booking Details
        Random random = new Random();
        int bookingId = 1000 + random.nextInt(9000);
        LocalDate today = LocalDate.now();
        String status = "CONFIRMED";

        // Heading
        System.out.println("=========================================");
        System.out.println("        HOTEL RESERVATION SYSTEM");
        System.out.println("=========================================");

        // Customer Name
        System.out.print("Enter Customer Name : ");
        customerName = sc.nextLine();

        // Room Menu
        System.out.println("\nAvailable Rooms");
        System.out.println("1. Single Room  - Rs.1000/day");
        System.out.println("2. Double Room  - Rs.1800/day");
        System.out.println("3. Deluxe Room  - Rs.3000/day");

        // Room Choice
        System.out.print("\nEnter Room Choice : ");
        roomChoice = sc.nextInt();

        switch (roomChoice) {

            case 1:
                pricePerDay = 1000;
                break;

            case 2:
                pricePerDay = 1800;
                break;

            case 3:
                pricePerDay = 3000;
                break;

            default:
                System.out.println("Invalid Room Choice!");
                sc.close();
                return;
        }

        // Days
        System.out.print("Enter Number of Days : ");
        days = sc.nextInt();

        // Bill Calculation
        totalBill = pricePerDay * days;
        gst = totalBill * 0.18;

        if (totalBill > 10000) {
            discount = totalBill * 0.05;
        }

        finalBill = totalBill + gst - discount;

        // Receipt
        System.out.println("\n=========================================");
        System.out.println("          HOTEL BOOKING RECEIPT");
        System.out.println("=========================================");

        System.out.println("Booking ID     : HTL" + bookingId);
        System.out.println("Booking Date   : " + today);
        System.out.println("Customer Name  : " + customerName);

        if (roomChoice == 1) {
            System.out.println("Room Type      : Single Room");
        } else if (roomChoice == 2) {
            System.out.println("Room Type      : Double Room");
        } else {
            System.out.println("Room Type      : Deluxe Room");
        }

        System.out.println("Number of Days : " + days);

        System.out.println("-----------------------------------------");
        System.out.println("Room Charge    : Rs." + totalBill);
        System.out.println("GST (18%)      : Rs." + gst);
        System.out.println("Discount       : Rs." + discount);
        System.out.println("-----------------------------------------");
        System.out.println("Final Bill     : Rs." + finalBill);
        System.out.println("-----------------------------------------");
        System.out.println("Booking Status : " + status);
        System.out.println("=========================================");
        System.out.println(" THANK YOU FOR CHOOSING OUR HOTEL ");
        System.out.println("=========================================");

        sc.close();
    }
}