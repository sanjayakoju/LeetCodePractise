package designPatterns.solid.openClosed;

public class SmsNotification implements Notification {
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}
