package org.example;

import org.example.dto.SignInRequest;
import org.example.dto.SignUpRequest;
import org.example.services.UserService;
import org.example.services.impl.UserServiceImpl;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        Scanner scanner = new Scanner(System.in);
        String token = null;

        while (true) {
            if (token == null) {
                System.out.println("Welcome! Please choose an option:");
                System.out.println("1. Sign Up");
                System.out.println("2. Sign In");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                if (choice == 1) {
                    System.out.println("Enter your email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter your password:");
                    String password = scanner.nextLine();
                    System.out.println("Enter your nickname:");
                    String nickname = scanner.nextLine();

                    var response = userService.signUp(new SignUpRequest(email, password, nickname));
                    System.out.println(response.getStatusDesc());
                } else if (choice == 2) {
                    System.out.println("Enter your email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter your password:");
                    String password = scanner.nextLine();

                    var response = userService.signIn(new SignInRequest(email, password));
                    if (response.getStatus() == 0) {
                        token = response.getUser().getToken();
                        System.out.println("Login successful! Your token: " + token);
                    } else {
                        System.out.println(response.getStatusDesc());
                    }
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("Token authenticated. What would you like to do?");
                System.out.println("1. Perform an operation (e.g., view cars)");
                System.out.println("2. Logout");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                if (choice == 1) {
                    var response = userService.signInByToken(token);
                    if (response.getStatus() == 0) {
                        System.out.println("Operation successful! Token usage remaining: " + response.getUser().getTokenUsage());
                    } else {
                        System.out.println(response.getStatusDesc());
                        token = null; // Reset token if expired or invalid
                    }
                } else if (choice == 2) {
                    token = null;
                    System.out.println("Logged out successfully.");
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
            // UserService userService = new UserServiceImpl();

            //System.out.println(userService.signUp(new SignUpRequest("ha1@1", "1234", "3")));
            //System.out.println(userService.signIn(new SignInRequest("1teach.gusev@mail.ru", "aB1111")));
            //System.out.println(userService.signInByToken("275719d2-70cf-4e81-81db-7e2293388d89"));




        }
    }
}


