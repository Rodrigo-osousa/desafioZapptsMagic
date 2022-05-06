package com.zappts.magic.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class CardDeck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardDeckId;
    private String cardDeckName;
    private Integer totalCardsFoils;
    private Integer totalCardsNotFoils;

    @ManyToOne
    private Player player;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Card> cards;

    public CardDeck() {
    }

    public CardDeck(Integer cardDeckId, String cardDeckName, Integer totalCardsFoils, Integer totalCardsNotFoils, Player player, List<Card> cards) {
        this.cardDeckId = cardDeckId;
        this.cardDeckName = cardDeckName;
        this.totalCardsFoils = totalCardsFoils;
        this.totalCardsNotFoils = totalCardsNotFoils;
        this.player = player;
        this.cards = cards;
    }

    public Integer getCardDeckId() {
        return cardDeckId;
    }

    public void setCardDeckId(Integer cardDeckId) {
        this.cardDeckId = cardDeckId;
    }

    public String getCardDeckName() {
        return cardDeckName;
    }

    public void setCardDeckName(String cardDeckName) {
        this.cardDeckName = cardDeckName;
    }

    public Integer getTotalCardsFoils() {
        return totalCardsFoils;
    }

    public void setTotalCardsFoils(Integer totalCardsFoils) {
        this.totalCardsFoils = totalCardsFoils;
    }

    public Integer getTotalCardsNotFoils() {
        return totalCardsNotFoils;
    }

    public void setTotalCardsNotFoils(Integer totalCardsNotFoils) {
        this.totalCardsNotFoils = totalCardsNotFoils;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCard(List<Card> cards) {
        this.cards = cards;
    }
}


