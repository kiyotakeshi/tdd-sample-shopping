package com.kiyotakeshi.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingTest {

    private Product firstProduct;
    private Product secondProduct;
    private Checkout checkout;

    @BeforeEach
    @DisplayName("Given 2 products in the shopping cart")
    void setUp() {
         firstProduct = new Product(1, "Readable Code", "how to write readable and clean code for all developers", 18);
         secondProduct = new Product(2, "Clean Architecture", "how to design scalable and easy to fix architecture", 30);
         checkout = new Checkout();
         checkout.addToCart(firstProduct);
         checkout.addToCart(secondProduct);
    }

    @Test
    @DisplayName("Test products added to shopping cart successfully")
    void testItemsAddedToShoppingCart() {
        // Given 2 products in the shopping cart

        // When
        Product thirdProduct = new Product(3, "Extreme Programing", "how to work for developer", 19);
        checkout.addToCart(thirdProduct);

        // Then
        assertEquals(3, checkout.getItems().size());
    }

    @Test
    @DisplayName("Test shopping cart total amount is calculated correctly")
    void testShoppingCartAmount() {
        // Given 2 products in the shopping cart

        // Then
        assertEquals(2, checkout.getItems().size());
        assertEquals(48, checkout.getTotalAmount());
    }

    @Test
    @DisplayName("Test due amount is calculated correctly")
    void testDueAmountCalculation() {
        // Given 2 products in the shopping cart

        // When
        checkout.pay(45);

        // Then
        assertEquals(3, checkout.getPaymentDue());
    }

    @Test
    @DisplayName("Test product removed from shopping cart correctly")
    void testProductRemovalFromCart() {
        // Given 2 products in the shopping cart

        // When
        checkout.removeFromCart(firstProduct);

        // Then
        assertEquals(1, checkout.getItems().size());
        assertEquals(30, checkout.getTotalAmount());
    }

    @Test
    @DisplayName("Test payment status is correct")
    void testPaymentStatusIsDoneCorrect() {
        // Given 2 products in the shopping cart

        // When
        checkout.pay(48);
        checkout.complete();

        assertEquals(Checkout.PaymentStatus.DONE, checkout.getPaymentStatus());
    }

    @Test
    @DisplayName("Test payment status is correct")
    void testPaymentStatusIsDueCorrect() {
        // Given 2 products in the shopping cart

        // When
        checkout.pay(45);
        checkout.complete();

        assertEquals(Checkout.PaymentStatus.DUE, checkout.getPaymentStatus());
    }
}