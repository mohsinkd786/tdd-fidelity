package io.mohsinkd786.services.impl;

import org.springframework.stereotype.Component;

@Component
public class ProcessOrderServiceImpl {
    private double basePrice = 10;
    private double discount = 5;
    private double sellingPrice = 12;

    public double calculateOrderCost(final int quantity) {
        double finalPrice = 0;
        if (quantity > 3) {
            finalPrice = sellingPrice - discount;
            if (finalPrice < basePrice) {
                finalPrice = basePrice;
            }
        }
        return finalPrice;
    }
}
