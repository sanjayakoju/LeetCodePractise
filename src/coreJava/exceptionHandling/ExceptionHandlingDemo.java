package coreJava.exceptionHandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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

    // throw new
    public static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be at least 18");
        } else {
            System.out.println("Access granted.");
        }
    }

    // throws
    public static void readFile(String filePath) throws IOException {
        FileReader file = new FileReader(filePath);
        BufferedReader fileInput = new BufferedReader(file);
//        throw new IOException("File not found");  // Simulate an IOException
    }

    // Throw new vs Throw ex
    public static void processFile(String fileName) throws FileNotFoundException {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                throw new FileNotFoundException("File not found");
            }
            // Further file processing logic
        } catch (FileNotFoundException ex) {
            System.out.println("Logging exception: " + ex.getMessage());
            throw ex;  // Re-throwing the exception after logging
        }
    }

    public static void main(String[] args) {
        tryCatch();

        try {
            processFile("nonexistentfile.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Caught in main: " + e.getMessage());
        }

       checkAge(12);

        try {
            readFile("nonexistentfile.txt");
        } catch (IOException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
