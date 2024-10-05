package coreJava.exceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionHandlingDemo {

    private static void tryCatch() {
        int[] numbers = {1, 2, 3};
        try {
            // This will throw ArrayIndexOutOfBoundsException
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is out of bounds!");
        } finally {
            System.out.println("Finally block executed.");
        }
    }

    public static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be at least 18");
        } else {
            System.out.println("Access granted.");
        }
    }

    public static void readFile(String filePath) throws IOException {
        FileReader file = new FileReader(filePath);
        BufferedReader fileInput = new BufferedReader(file);
//        throw new IOException("File not found");  // Simulate an IOException
    }

    public static void main(String[] args) {
        tryCatch();

        try {
            checkAge(15);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        try {
            readFile("nonexistentfile.txt");
        } catch (IOException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
