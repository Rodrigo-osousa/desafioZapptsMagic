package com.zappts.magic.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CardRequest {
    @NotNull(message = "Nome da Carta não pose ser nullo!")
    @NotBlank(message = "Nome da Carta ficar em branco!")
    private String cardName;
    @NotNull(message = "Edição da Carta não pose ser nullo!")
    @NotBlank(message = "Edição da Carta ficar em branco!")
    private String cardEdition;
    @NotNull(message = "Linguagem da Carta não pose ser nullo!")
    @NotBlank(message = "Linguagem da Carta ficar em branco!")
    private String cardLanguage;
    @NotNull(message = "Carta laminada não pose ser nullo, favor inserir true ou false!")
    @NotBlank(message = "Carta laminada  não pode ficar em branco!")
    private Boolean cardFoil;
    @NotNull(message = "Valor da Carta não pose ser nullo!")
    @NotBlank(message = "Valor da Carta ficar em branco!")
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
