package com.zappts.magic.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CardId;
    private String cardName;
    private String cardEdition;
    private String cardLanguage;
    private Boolean cardFoil;
    private Double cardAmount;

    public Card() {
    }

    public Card(Integer cardId, String cardName, String cardEdition, String cardLanguage, Boolean cardFoil, Double cardAmount) {
        CardId = cardId;
        this.cardName = cardName;
        this.cardEdition = cardEdition;
        this.cardLanguage = cardLanguage;
        this.cardFoil = cardFoil;
        this.cardAmount = cardAmount;

    }

    public Integer getCardId() {
        return CardId;
    }

    public void setCardId(Integer cardId) {
        CardId = cardId;
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
        return "Card{" +
                "CardId=" + CardId +
                ", cardName='" + cardName + '\'' +
                ", cardEdition='" + cardEdition + '\'' +
                ", cardLanguage='" + cardLanguage + '\'' +
                ", cardFoil=" + cardFoil +
                ", cardAmount=" + cardAmount +
                '}';
    }
}
