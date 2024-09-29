package designPatterns.solid.SingleResponsibilityPrinciple;

public class BookPrinter {
    public void printBookDetails(Book book) {
        System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
    }
}
