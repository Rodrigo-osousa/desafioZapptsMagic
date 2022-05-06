package com.zappts.magic.services;

import com.zappts.magic.customException.GameException;
import com.zappts.magic.models.Card;
import com.zappts.magic.models.CardDeck;
import com.zappts.magic.repository.CardDeckRepository;
import com.zappts.magic.repository.CardRepository;
import com.zappts.magic.requests.CardDeckRequest;
import com.zappts.magic.requests.CardMovimentRequest;
import com.zappts.magic.requests.CardRequest;
import com.zappts.magic.requests.PlayerRequest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)

class CardDeckServiceTest {

    @Autowired
    CardDeckService cardDeckService;

    @Autowired
    CardDeckRepository cardDeckRepository;

    @Autowired
    PlayerService playerService;

    @Autowired
    CardService cardService;

    @Autowired
    CardRepository cardRepository;


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
    @Order(3)
    void getAll() {
        List<CardDeck> allDecks = cardDeckService.getAll();
        assertTrue(allDecks.size() > 0);

    }

    @Test
    @Order(13)
    void deleteDeck() throws GameException {
        cardDeckService.deleteDeck(1);
        assertTrue(cardDeckRepository.findByCardDeckName("Deck Test").isEmpty());
    }
    @Test
    @Order(11)
    void deleteDeckNonExistent() throws GameException {
      assertThrows(GameException.class, ()-> {
          cardDeckService.deleteDeck(6);
      });

    }

    @Test
    @Order(4)
    void addCard() throws GameException {
        CardRequest newCard = new CardRequest();
        newCard.setCardName("Card Rare");
        newCard.setCardEdition("New");
        newCard.setCardFoil(true);
        newCard.setCardLanguage("portuguese");
        newCard.setCardAmount(200.00);
        cardService.createCard(newCard);


        CardMovimentRequest addNewCard = new CardMovimentRequest(1,1);
        cardDeckService.addCard(addNewCard);

        Optional<CardDeck> findCardDeck = cardDeckRepository.findById(1);
        int allCards = findCardDeck.get().getCards().size();

        assertTrue(allCards > 0);

    }
    @Test
    @Order(5)
    void addCardNonExistent() {
        CardMovimentRequest addNewCardNonExistent = new CardMovimentRequest(1,999);
        assertThrows(GameException.class, ()-> {
          cardDeckService.addCard(addNewCardNonExistent);
        });
    }
    @Test
    @Order(6)
    void addCardNonExistentDeck() {
        CardMovimentRequest addNewCardNonExistent = new CardMovimentRequest(999,1);
        assertThrows(GameException.class, ()-> {
            cardDeckService.addCard(addNewCardNonExistent);
        });
    }

    @Test
    @Order(8)
    void removeCardNonexistent() throws GameException {
        CardMovimentRequest removeCardByDeck = new CardMovimentRequest(1,333);
       assertThrows(GameException.class, ()-> {
           cardDeckService.removeCard(removeCardByDeck);
       });
    }

    @Test
    @Order(12)
    void removeCard() throws GameException {
        CardMovimentRequest removeCardByDeck = new CardMovimentRequest(1,1);
        cardDeckService.removeCard(removeCardByDeck);

        Optional<CardDeck> findCardDeck = cardDeckRepository.findById(1);
        int allCards = findCardDeck.get().getCards().size();

        assertEquals(0, allCards);
    }

    @Test
    @Order(7)
    void obtainCardInOrder() throws GameException {
        List<Card> allCards = cardDeckService.obtainCardInOrder("Deck Test");
        assertTrue(allCards.size() > 0);

    }

    @Test
    @Order(9)
    void obtainCardInOrderWithNoneNameDeck() throws GameException {
        assertThrows(GameException.class, ()-> {
            cardDeckService.obtainCardInOrder("none");
        });
    }


}