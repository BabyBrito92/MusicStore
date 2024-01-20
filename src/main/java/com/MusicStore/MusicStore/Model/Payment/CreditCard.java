package com.MusicStore.MusicStore.Model.Payment;

import java.util.List;

public class CreditCard implements Payment{

    private String cardType;
    private String cardNumber;
    private String cardExpirationDate;
    private String cardBillingAddress;

    public CreditCard(String cardType, String cardNumber, String cardExpirationDate, String cardBillingAddress) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cardExpirationDate = cardExpirationDate;
        this.cardBillingAddress = cardBillingAddress;
    }

    public CreditCard() {
    }

    @Override
    public String getPaymentType() {
        return "Credit Card";
    }

    @Override
    public List<String> getPaymentInfo() {
        return List.of(cardType, cardNumber, cardExpirationDate, cardBillingAddress);
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpirationDate() {
        return cardExpirationDate;
    }

    public void setCardExpirationDate(String cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }

    public String getCardBillingAddress() {
        return cardBillingAddress;
    }

    public void setCardBillingAddress(String cardBillingAddress) {
        this.cardBillingAddress = cardBillingAddress;
    }
}
