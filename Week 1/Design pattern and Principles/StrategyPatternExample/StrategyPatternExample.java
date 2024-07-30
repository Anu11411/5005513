public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Using Credit Card Payment Strategy
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234 5678 9012 3456", "Sanskruti Sharma ", "123",
                "12/25");
        context.setPaymentStrategy(creditCardPayment);
        context.executePayment(150.0);

        // Using PayPal Payment Strategy
        PaymentStrategy payPalPayment = new PayPalPayment("sans.sh@example.com", "password123");
        context.setPaymentStrategy(payPalPayment);
        context.executePayment(200.0);
    }
}
