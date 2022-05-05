package com.zappts.magic.requests;

public class CardMovimentRequest {
    private Integer cardDeckId;
    private Integer CardId;

    public CardMovimentRequest() {
    }

    public CardMovimentRequest(Integer cardDeckId, Integer cardId) {
        this.cardDeckId = cardDeckId;
        CardId = cardId;
    }

    public Integer getCardDeckId() {
        return cardDeckId;
    }

    public void setCardDeckId(Integer cardDeckId) {
        this.cardDeckId = cardDeckId;
    }

    public Integer getCardId() {
        return CardId;
    }

    public void setCardId(Integer cardId) {
        CardId = cardId;
    }

    @Override
    public String toString() {
        return "CardMovimentRequest{" +
                "cardDeckId=" + cardDeckId +
                ", CardId=" + CardId +
                '}';
    }
}
