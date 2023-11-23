package OCP;

public class Test {

    public static void main(String[] args) {

        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processPayment(new CreditCardPayment());


        /*
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processPayment(PaymentMode.CASH);
        paymentProcessor.processPayment(PaymentMode.CREDUIT_CARD);
        paymentProcessor.processPayment(PaymentMode.Gift_Card);
         */
    }

}
