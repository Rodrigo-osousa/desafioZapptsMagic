package com.zappts.magic.requests;

public class CardRequest {
    private String cardName;
    private String cardEdition;
    private String cardLanguage;
    private Boolean cardFoil;
    private Double cardAmount;



    public CardRequest() {
    }

    public CardRequest(String cardName, String cardEdition, String cardLanguage, Boolean cardFoil, Double cardAmount) {
        this.cardName = cardName;
        this.cardEdition = cardEdition;
        this.cardLanguage = cardLanguage;
        this.cardFoil = cardFoil;
        this.cardAmount = cardAmount;

    }



    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardEdition() {
        return cardEdition;
    }

    public void setCardEdition(String cardEdition) {
        this.cardEdition = cardEdition;
    }

    public String getCardLanguage() {
        return cardLanguage;
    }

    public void setCardLanguage(String cardLanguage) {
        this.cardLanguage = cardLanguage;
    }

    public Boolean getCardFoil() {
        return cardFoil;
    }

    public void setCardFoil(Boolean cardFoil) {
        this.cardFoil = cardFoil;
    }

    public Double getCardAmount() {
        return cardAmount;
    }

    public void setCardAmount(Double cardAmount) {
        this.cardAmount = cardAmount;
    }



    @Override
    public String toString() {
        return "CardRequest{" +
                "cardName='" + cardName + '\'' +
                ", cardEdition='" + cardEdition + '\'' +
                ", cardLanguage='" + cardLanguage + '\'' +
                ", cardFoil=" + cardFoil +
                ", cardAmount=" + cardAmount +
                '}';
    }
}
