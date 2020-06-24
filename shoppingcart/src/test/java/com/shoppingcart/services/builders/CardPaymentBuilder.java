package com.shoppingcart.services.builders;

import com.shoppingcart.services.CardPayment;

public final class CardPaymentBuilder {
    private String nameOnCard;
    private String accountNumber;
    private String bankName;
    private boolean paymentStatus;

    public CardPaymentBuilder withPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
        return this;
    }

    public CardPaymentBuilder withNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
        return this;
    }

    public CardPaymentBuilder withAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public CardPaymentBuilder withBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }
     public CardPayment build() {
        CardPayment cardPayment = new CardPayment();
        cardPayment.setPaymentStatus(paymentStatus);
        cardPayment.setAccountNumber(accountNumber);
        cardPayment.setBankName(bankName);
        cardPayment.setNameOnCard(nameOnCard);
        return cardPayment;
     }
}
