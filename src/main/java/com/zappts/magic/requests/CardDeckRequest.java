package com.zappts.magic.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CardDeckRequest {
    @NotNull(message = "Nome do deck não pose ser nullo!")
    @NotBlank(message = "Nome do deck não pode ficar em branco!")
    private String cardDeckName;
    @NotNull(message = "Nome do jogador não pose ser nullo!")
    @NotBlank(message = "Nome do jogador não pode ficar em branco!")
    private String playerName;


    public CardDeckRequest() {
    }

    public CardDeckRequest(String cardDeckName, String playerName) {
        this.cardDeckName = cardDeckName;
        this.playerName = playerName;

    }

    public String getCardDeckName() {
        return cardDeckName;
    }

    public void setCardDeckName(String cardDeckName) {
        this.cardDeckName = cardDeckName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }



    @Override
    public String toString() {
        return "CardDeckRequest{" +
                "cardDeckName='" + cardDeckName + '\'' +
                ", playerName='" + playerName + '\'' +
                '}';
    }
}
