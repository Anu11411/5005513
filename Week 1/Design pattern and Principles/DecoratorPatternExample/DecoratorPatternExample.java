public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Create an EmailNotifier
        Notifier notifier = new EmailNotifier();

        // Decorate it with SMSNotifierDecorator
        notifier = new SMSNotifierDecorator(notifier);

        // Further decorate it with SlackNotifierDecorator
        notifier = new SlackNotifierDecorator(notifier);

        // Send a notification
        notifier.send("This is a test message.");
    }
}
