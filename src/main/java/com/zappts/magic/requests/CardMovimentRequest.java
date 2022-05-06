package com.zappts.magic.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CardMovimentRequest {
    @NotNull(message = "DeckId não pose ser nullo!")
    @NotBlank(message = "DeckId não pode ficar em branco!")
    private Integer cardDeckId;
    @NotNull(message = "CardId não pose ser nullo!")
    @NotBlank(message = "CardId não pode ficar em branco!")
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
