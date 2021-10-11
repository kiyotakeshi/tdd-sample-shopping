package com.kiyotakeshi.tdd;

import java.util.Date;

public class Checkout extends Cart {
    private int paymentAmount = 0;
    private int paymentDue = 0;
    private Date paymentDate;

    public enum PaymentStatus {
        DUE, DONE
    }
    private PaymentStatus paymentStatus;

    public void pay(int payment) {
        paymentAmount = payment;
        paymentDue = getTotalAmount() - paymentAmount;
        paymentDate = new Date();
    }

    public int getPaymentDue() {
        return paymentDue;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    private void confirmOrder() {
        if(paymentDue == 0) {
            paymentStatus = PaymentStatus.DONE;
            System.out.println("Payment is completed, Thank you your order.");
        } else if (paymentDue > 0) {
            paymentStatus = PaymentStatus.DUE;
            System.out.printf("Payment is failure, Remaining $%d", paymentDue);
        }
    }

    public void complete() {
        printCartDetails();
        confirmOrder();
    }
}
