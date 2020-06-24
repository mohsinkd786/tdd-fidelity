package com.shoppingcart.services;

import com.shoppingcart.dtos.Order;

public class CardPayment extends Payment {
    private String nameOnCard;
    private String accountNumber;
    private String bankName;

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public Order makePayment(Order order) {
        setPaymentStatus(true);
        order.setPaymentMode("CARD");
        order.setPaymentDetail(this);
        return order;
    }
}
