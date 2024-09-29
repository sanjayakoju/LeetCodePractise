package designPatterns.solid.openClosed;

/**
 * Definition: Classes should be open for extension but closed for modification.
 * In other words, you should be able to add new functionality without changing the existing code.
 *
 * Example: Let's design a notification system where we might need to add new types of notifications
 */

// Violating OCP (modifying class to add new behavior)
public class NotificationService {
    public void sendEmailNotification(String message) {
        System.out.println("Email: " + message);
    }
}

