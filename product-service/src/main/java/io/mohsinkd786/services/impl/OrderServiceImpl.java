package io.mohsinkd786.services.impl;

public class OrderServiceImpl {

    public double processOrder(int quantity) {
        double basePrice = 10;
        double discount = 5;
        double sellingPrice = 12;
        boolean itemInStock = isItemInStock("SAMPLE");

        if (itemInStock) {
            if (quantity > 3) {

            }

        }
        return 0;
    }

    private boolean isItemInStock(String itemCode) {
        return true;
    }
}
