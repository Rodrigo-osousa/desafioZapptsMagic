package com.zappts.magic.services;

import com.zappts.magic.customException.GameException;
import com.zappts.magic.models.Card;
import com.zappts.magic.repository.CardRepository;
import com.zappts.magic.requests.CardRequest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CardServiceTest {

    @Autowired
    CardService cardService;

    @Autowired
    CardRepository cardRepository;

    @Test
    @Order(1)
    void createCard() {
        CardRequest newCard = new CardRequest("Teste","New","Pt",true,30.00);
        cardService.createCard(newCard);
        assertTrue(cardRepository.findById(1).isPresent());
    }

    @Test
    @Order(2)
    void updateCard() throws GameException {
        Card upCard = new Card(1,"Teste Updated","New","Pt",false,10.00);
        cardService.updateCard(upCard);
        assertEquals(10.00, cardRepository.findById(1).get().getCardAmount());
    }

    @Test
    @Order(3)
    void updateNoneExistCard() throws GameException {
        Card upCard = new Card(3333,"Teste Updated","New","Pt",false,10.00);
        assertThrows(GameException.class, ()-> { cardService.updateCard(upCard); });
    }

    @Test
    @Order(4)
    void getCardByName() throws GameException {
        List<Card> cards = cardService.getCardByName("Teste Updated");
        assertTrue(cards.size() > 0);
    }

    @Test
    @Order(5)
    void getAllCards() throws GameException {
        List<Card> allCards = cardService.getAllCards();
        assertTrue(allCards.size() > 0);
    }

    @Test
    @Order(6)
    void deleteCard() throws GameException {
        cardService.deleteCard(1);
        List<Card> emptyCards = (List<Card>) cardRepository.findAll();
        assertTrue(emptyCards.isEmpty());
    }

    @Test
    @Order(7)
    void getAllCardsEmpty() throws GameException {
        assertThrows(GameException.class, () -> {
            List<Card> allCards = cardService.getAllCards();
        });
    }
}