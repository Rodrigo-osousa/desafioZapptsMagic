package com.zappts.magic.controllers;

import com.zappts.magic.customException.GameException;
import com.zappts.magic.models.Card;
import com.zappts.magic.models.CardDeck;
import com.zappts.magic.requests.CardDeckRequest;
import com.zappts.magic.requests.CardMovimentRequest;
import com.zappts.magic.services.CardDeckService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cardDeck")

public class CardDeckController {
    final CardDeckService cardDeckService;

    public CardDeckController(CardDeckService cardDeckService) {
        this.cardDeckService = cardDeckService;
    }

    @PostMapping("/new")
    public CardDeck newDeck(@Valid  @RequestBody CardDeckRequest cardDeckRequest) throws GameException {
        return cardDeckService.newDeck(cardDeckRequest);
    }

    @GetMapping("/getAll")
    public List<CardDeck> allDecks() {
        return cardDeckService.getAll();
    }

    @PostMapping("/cardAdd")
    public CardDeck cardAdd(@Valid @RequestBody CardMovimentRequest cardMovimentRequest) throws GameException {
        return cardDeckService.addCard(cardMovimentRequest);
    }

    @PostMapping("/cardRemove")
    public CardDeck cardRemove(@Valid @RequestBody CardMovimentRequest cardMovimentRequest) throws GameException {
        return cardDeckService.removeCard(cardMovimentRequest);
    }

    @GetMapping("/getAllCardsInOrder")
    public List<Card> getAll(@RequestParam String cardDeckName) throws GameException {
        return cardDeckService.obtainCardInOrder(cardDeckName);
    }

    @DeleteMapping("/deleteDeck/{cardDeckId}")
    public String deleteCardDeck(@RequestParam Integer cardDeckId) throws GameException {
        return cardDeckService.deleteDeck(cardDeckId);
    }
}

