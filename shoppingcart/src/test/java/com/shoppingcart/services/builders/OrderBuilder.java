package com.shoppingcart.services.builders;

import com.shoppingcart.dtos.Order;
import com.shoppingcart.services.Payment;

public final class OrderBuilder {

    private int id;
    private boolean status;
    private double totalPrice;
    private int quantity;
    private String paymentMode;
    private Payment paymentDetail;

    public static Order withSeed(int seed){
        return new OrderBuilder()
                .withId(seed)
                .withStatus(false)
                .withPaymentMode("CARD" + seed)
                .withQuantity(seed)
                .withTotalPrice(seed)
                .build();
    }
    public OrderBuilder withId(int id){
        this.id = id;
        return this;
    }

    public OrderBuilder withStatus(boolean status){
        this.status = status;
        return this;
    }

    public OrderBuilder withTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public OrderBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderBuilder withPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
        return this;
    }

    public OrderBuilder withPaymentDetail( Payment paymentDetail){
        this.paymentDetail = paymentDetail;
        return this;
    }

    public Order build() {
        Order order = new Order();
        order.setId(id);
        order.setPaymentMode(paymentMode);
        order.setQuantity(quantity);
        order.setStatus(status);
        order.setTotalPrice(totalPrice);
        order.setPaymentDetail(paymentDetail);
        return order;
    }
}
