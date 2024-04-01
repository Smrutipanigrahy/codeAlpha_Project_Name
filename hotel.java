package HotelReservation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class hotel {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Room> rooms = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();
    private static int bookingCounter = 1;

    public static void main(String[] args) {
        initializeRooms();

        while (true) {
            displayMenu();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    displayAvailableRooms();
                    break;
                case 2:
                    int bookingId = makeReservation();
                    System.out.println("Your booking ID is: " + bookingId);
                    break;
                case 3:
                    viewBookingDetails();
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static void initializeRooms() {
        // Populate rooms (for example purposes)
        rooms.add(new Room(101, "Standard", true, 100));
        rooms.add(new Room(102, "Standard", true, 100));
        rooms.add(new Room(201, "Deluxe", true, 150));
        rooms.add(new Room(202, "Deluxe", true, 150));
    }

    private static void displayMenu() {
        System.out.println("\nHotel Reservation System Menu:");
        System.out.println("1. Search for Available Rooms");
        System.out.println("2. Make a Reservation");
        System.out.println("3. View Booking Details");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice() {
        return scanner.nextInt();
    }

    private static void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println("Room Number: " + room.getRoomNumber() + " | Category: " + room.getCategory() + " | Price: $" + room.getPrice());
            }
        }
    }

    private static int makeReservation() {
        System.out.print("Enter the room number you want to reserve: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter your name: ");
        String guestName = scanner.nextLine();

        System.out.print("Enter start date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();

        System.out.print("Enter end date (YYYY-MM-DD): ");
        String endDate = scanner.nextLine();

        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                room.setAvailable(false);
                double totalPrice = calculateTotalPrice(room.getPrice(), startDate, endDate);
                bookings.add(new Booking(bookingCounter, room, guestName, startDate, endDate, totalPrice));
                return bookingCounter++;
            }
        }
        System.out.println("Room not available for the given dates.");
        return -1; // Return -1 to indicate failure
    }

    private static void viewBookingDetails() {
        System.out.print("Enter booking ID: ");
        int bookingId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                System.out.println("Booking ID: " + booking.getBookingId());
                System.out.println("Guest Name: " + booking.getGuestName());
                System.out.println("Room Number: " + booking.getRoom().getRoomNumber());
                System.out.println("Category: " + booking.getRoom().getCategory());
                System.out.println("Start Date: " + booking.getStartDate());
                System.out.println("End Date: " + booking.getEndDate());
                System.out.println("Total Price: $" + booking.getTotalPrice());
                return;
            }
        }
        System.out.println("Booking not found.");
    }

    private static double calculateTotalPrice(double roomPrice, String startDate, String endDate) {
        // Simplified calculation based on duration
        int duration = calculateDuration(startDate, endDate);
        return roomPrice * duration;
    }

    private static int calculateDuration(String startDate, String endDate) {
        // Simplified method to calculate duration in days
        // Assumes valid date format and that endDate is after startDate
        return (int) java.time.temporal.ChronoUnit.DAYS.between(java.time.LocalDate.parse(startDate), java.time.LocalDate.parse(endDate));
    }
}
