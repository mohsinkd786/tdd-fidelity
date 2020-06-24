package com.shoppingcart.dtos;

import com.shoppingcart.services.Payment;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private boolean status;
    private double totalPrice;
    private int quantity;
    private String paymentMode;
    private Payment paymentDetail;
    public List<Product> products = new ArrayList();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public void setPaymentDetail(Payment paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    public Payment getPaymentDetail() {
        return paymentDetail;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }
}
