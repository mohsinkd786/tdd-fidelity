package io.mohsinkd786.checkout.builders;

import io.mohsinkd786.dtos.Order;

public final class OrderBuilder {

    private int id;
    private boolean status;
    private int quantity;
    private double totalPrice;
    private String paymentMode;


    public static Order withSeed(int seed) {
        return new OrderBuilder()
                .withId(seed)
                .withPaymentMode("CARD " + seed)
                .withQuantity(seed)
                .withTotalPrice(seed)
                .withStatus(true)
                .build();
    }

    public OrderBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public OrderBuilder withStatus(boolean status) {
        this.status = status;
        return this;
    }

    public OrderBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderBuilder withTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public OrderBuilder withPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
        return this;

    }

    public Order build() {
        Order order = new Order();
        order.setId(id);
        order.setStatus(status);
        order.setTotalPrice(totalPrice);
        order.setQuantity(quantity);
        order.setPaymentMode(paymentMode);

        return order;
    }
}
