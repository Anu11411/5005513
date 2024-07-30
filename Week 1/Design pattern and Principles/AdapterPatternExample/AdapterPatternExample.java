public class AdapterPatternExample {
    public static void main(String[] args) {
        // PayPal payment
        PayPalGateway payPalGateway = new PayPalGateway();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalGateway);
        payPalProcessor.processPayment(100.0);

        // Stripe payment
        StripeGateway stripeGateway = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);
        stripeProcessor.processPayment(200.0);

        // Square payment
        SquareGateway squareGateway = new SquareGateway();
        PaymentProcessor squareProcessor = new SquareAdapter(squareGateway);
        squareProcessor.processPayment(300.0);
    }
}
