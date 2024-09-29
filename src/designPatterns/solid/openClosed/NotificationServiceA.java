package designPatterns.solid.openClosed;

// New types can be added without modifying existing code
public class NotificationServiceA {
    public void sendNotification(Notification notification, String message) {
        notification.send(message);
    }
}
