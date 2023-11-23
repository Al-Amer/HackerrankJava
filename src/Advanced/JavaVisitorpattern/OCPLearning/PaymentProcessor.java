package OCP;

public class PaymentProcessor {

    void processPayment (IPay iPay){
        iPay.acceptPayment();
    }

    /*
    public void processPayment(PaymentMode paymentMode){
        if(paymentMode == PaymentMode.CASH){
            CashPayment cashPayment = new CashPayment();
            cashPayment.acceptPayment();
        } else if (paymentMode == PaymentMode.CREDUIT_CARD) {
            CreditCardPayment creditCardPayment = new CreditCardPayment();
            creditCardPayment.acceptPayment();
        }else if (paymentMode == PaymentMode.Gift_Card) {
            GiftCardPayment giftCardPayment=new GiftCardPayment();
            giftCardPayment.acceptPayment();
        }
    }
     */

}
