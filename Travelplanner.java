package Practice1;

	import java.util.Scanner;

	public class Travelplanner {
	    private static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        System.out.println("Welcome to the Travel Itinerary Planner!");

	        // Get destination details from the user
	        String destination = getDestination();
	        String startDate = getStartDate();
	        String endDate = getEndDate();
	        double budget = getBudget();

	        // Get user preferences
	        boolean includeMapping = getPreference("mapping");
	        boolean includeWeather = getPreference("weather");

	        // Generate itinerary
	        generateItinerary(destination, startDate, endDate, budget, includeMapping, includeWeather);

	        scanner.close();
	    }

	    private static String getDestination() {
	        System.out.print("Enter your destination: ");
	        return scanner.nextLine();
	    }

	    private static String getStartDate() {
	        System.out.print("Enter start date (YYYY-MM-DD): ");
	        return scanner.nextLine();
	    }

	    private static String getEndDate() {
	        System.out.print("Enter end date (YYYY-MM-DD): ");
	        return scanner.nextLine();
	    }

	    private static double getBudget() {
	        System.out.print("Enter your budget for the trip: ");
	        return scanner.nextDouble();
	    }

	    private static boolean getPreference(String feature) {
	        System.out.print("Do you want to include " + feature + "? (yes/no): ");
	        return scanner.nextLine().equalsIgnoreCase("yes");
	    }

	    private static void generateItinerary(String destination, String startDate, String endDate, double budget,
	                                          boolean includeMapping, boolean includeWeather) {
	        // Display itinerary details
	        System.out.println("\n--- Your Travel Itinerary ---");
	        System.out.println("Destination: " + destination);
	        System.out.println("Start Date: " + startDate);
	        System.out.println("End Date: " + endDate);
	        System.out.println("Budget: $" + budget);

	        // Calculate duration of the trip
	        int tripDuration = calculateTripDuration(startDate, endDate);
	        System.out.println("Trip Duration: " + tripDuration + " days");

	        // Calculate budget per day
	        double budgetPerDay = budget / tripDuration;
	        System.out.println("Budget Per Day: ruppees " + String.format("%.2f", budgetPerDay));

	        // Include mapping if requested
	        if (includeMapping) {
	            System.out.println("Mapping: Mapping feature included.");
	        }

	        // Include weather information if requested
	        if (includeWeather) {
	            System.out.println("Weather Information: Weather forecast included.");
	        }
	    }

	    private static int calculateTripDuration(String startDate, String endDate) {
	        // Calculate the duration of the trip in days
	        // This is a simplified implementation, assuming dates are provided in the correct format
	        return Math.toIntExact(Math.abs(java.time.temporal.ChronoUnit.DAYS.between(java.time.LocalDate.parse(startDate), java.time.LocalDate.parse(endDate))));
	    }
	}



