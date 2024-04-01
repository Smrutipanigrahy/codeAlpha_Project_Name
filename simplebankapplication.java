package Practice1;

import java.util.Scanner;

	public class simplebankapplication 
	{
	    private static Scanner scanner = new Scanner(System.in);
	    private static double balance = 0;

	    public static void main(String[] args) 
	    {
	        boolean isRunning = true;
	        while (isRunning) {
	            displayMenu();
	            int choice = getUserChoice();
	            switch (choice) {
	                case 1:
	                    deposit();
	                    break;
	                case 2:
	                    withdraw();
	                    break;
	                case 3:
	                    checkBalance();
	                    break;
	                case 4:
	                    exitProgram();
	                    isRunning = false;
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
	            }
	        }
	        scanner.close();
	    }

	    private static void displayMenu() {
	        System.out.println("1. Deposit");
	        System.out.println("2. Withdraw");
	        System.out.println("3. Check Balance");
	        System.out.println("4. Exit");
	        System.out.print("Enter your choice: ");
	    }

	    private static int getUserChoice() {
	        String choiceStr = scanner.nextLine();
	        if (!isNumeric(choiceStr)) {
	            System.out.println("Invalid input. Please enter a number.");
	            return -1;
	        }
	        return Integer.parseInt(choiceStr);
	    }

	    private static void deposit() {
	        System.out.print("Enter deposit amount: ");
	        double depositAmount = Double.parseDouble(scanner.nextLine());
	        balance += depositAmount;
	        System.out.println("Deposit successful.");
	    }

	    private static void withdraw() {
	        System.out.print("Enter withdrawal amount: ");
	        double withdrawAmount = Double.parseDouble(scanner.nextLine());
	        if (withdrawAmount > balance) {
	            System.out.println("Insufficient funds.");
	        } else {
	            balance -= withdrawAmount;
	            System.out.println("Withdrawal successful.");
	        }
	    }

	    private static void checkBalance() {
	        System.out.println("Your current balance is: " + balance);
	    }

	    private static void exitProgram() {
	        System.out.println("Exiting the program. Thank you!");
	    }

	    // Method to check if a string is numeric
	    private static boolean isNumeric(String str) {
	        if (str == null) {
	            return false;
	        }
	        try {
	            double d = Double.parseDouble(str);
	        } catch (NumberFormatException nfe) {
	            return false;
	        }
	        return true;
	    }
	}



