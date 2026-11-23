package com.ritik.wishlist.ui;

import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner = new Scanner(System.in);
    public String readText(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
    public int readInt(String prompt) {
        while (true) {
            try { return Integer.parseInt(readText(prompt)); }
            catch (NumberFormatException e) { System.out.println("Please enter a valid whole number."); }
        }
    }
    public double readDouble(String prompt) {
        while (true) {
            try { return Double.parseDouble(readText(prompt)); }
            catch (NumberFormatException e) { System.out.println("Please enter a valid number."); }
        }
    }
}
