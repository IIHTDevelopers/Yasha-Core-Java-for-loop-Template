package com.yaksha.assignment;

import java.util.Scanner;

public class ForLoopAssignment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Task 1: Repeat user input until valid response
        int userInput;
        for (;;) {
            System.out.print("Enter a positive integer: ");
            userInput = scanner.nextInt();
            if (userInput <= 0) {
                System.out.println("Please enter a positive integer.");
            } else {
                break;
            }
        }
        System.out.println("Thank you! You entered: " + userInput);

        // Task 2: Reverse a given string
        System.out.print("Enter a string to reverse: ");
        String inputString = scanner.next();
        String reversedString = "";
        for (int i = inputString.length() - 1; i >= 0; i--) {
            reversedString += inputString.charAt(i);
        }
        System.out.println("Reversed string: " + reversedString);

        // Task 3: Validate password
        String password;
        boolean validPassword;
        for (;;) {
            System.out.print("Enter a password: ");
            password = scanner.next();
            validPassword = isValidPassword(password);
            if (!validPassword) {
                System.out.println("Password must be at least 8 characters long, contain at least one digit, and one special character.");
            } else {
                break;
            }
        }
        System.out.println("Password accepted.");

        // Task 4: Number guessing game
        int numberToGuess = (int) (Math.random() * 100) + 1;
        int guess;
        for (;;) {
            System.out.print("Guess the number (1-100): ");
            guess = scanner.nextInt();
            if (guess > numberToGuess) {
                System.out.println("Too high, try again!");
            } else if (guess < numberToGuess) {
                System.out.println("Too low, try again!");
            } else {
                break;
            }
        }
        System.out.println("Correct! You guessed the number.");

        // Task 5: Print multiplication table of a number
        System.out.print("Enter a number for multiplication table: ");
        int number = scanner.nextInt();
        for (int multiplier = 1; multiplier <= 10; multiplier++) {
            System.out.println(number + " x " + multiplier + " = " + (number * multiplier));
        }
    }

    // Helper method to check password validity
    private static boolean isValidPassword(String password) {
        return password.length() >= 8 && password.matches(".*\\d.*") && password.matches(".*[!@#$%^&*()].*");
    }
}
