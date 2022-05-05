package com.zappts.magic.services;

import com.zappts.magic.customException.GameException;
import com.zappts.magic.repository.CardDeckRepository;
import com.zappts.magic.requests.CardDeckRequest;
import com.zappts.magic.requests.PlayerRequest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class CardDeckServiceTest {

    @Autowired
    CardDeckService cardDeckService;

    @Autowired
    CardDeckRepository cardDeckRepository;

    @Autowired
    PlayerService playerService;


    @Test
    @Order(1)
    void newDeck() throws GameException {
        PlayerRequest newPlayerToDeck = new PlayerRequest("Player To Deck", "playertodeck@teste.com");
        playerService.createPlayer(newPlayerToDeck);
        CardDeckRequest newCardDeck = new CardDeckRequest("Deck Test","Player To Deck");
        cardDeckService.newDeck(newCardDeck);

        assertEquals("Deck Test",cardDeckRepository.findById(1).get().getCardDeckName());

    }
    @Test
    @Order(2)
    void newDeckWithNonePlayer() {
        CardDeckRequest newCardDeck = new CardDeckRequest("Deck Test","none player");
       assertThrows(GameException.class, () -> { cardDeckService.newDeck(newCardDeck);});
    }

    @Test
    void getAll() {
        
    }

    @Test
    void deleteDeck() {
    }

    @Test
    void addCard() {
    }

    @Test
    void removeCard() {
    }

    @Test
    void obtainCardInOrder() {
    }
}