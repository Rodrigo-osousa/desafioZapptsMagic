package com.zappts.magic.requests;

public class CardDeckRequest {
    private String cardDeckName;
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
