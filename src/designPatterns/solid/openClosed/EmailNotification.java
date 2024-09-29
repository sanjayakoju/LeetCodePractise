package designPatterns.solid.openClosed;

public class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}
