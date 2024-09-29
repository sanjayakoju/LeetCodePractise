package designPatterns.solid.SingleResponsibilityPrinciple;

/**
 * Definition: A class should have only one reason to change, meaning it should have only one responsibility.
 *
 * Example: Let's design a class for handling book details.
 * It should only handle the book-related data and not printing logic.
 */

// Violating SRP (mixing book data and print responsibilities)
//public class Book {
//    private String title;
//    private String author;
//
//    public Book(String title, String author) {
//        this.title = title;
//        this.author = author;
//    }
//
//    public void printBookDetails() {
//        System.out.println("Title: " + title + ", Author: " + author);
//    }
//}

// Correct - SRP applied
public class Book {
    public String title;
    public String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Only responsibility is managing book data
}

