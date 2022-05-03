package com.zappts.magic.controllers;

import com.zappts.magic.customException.GameException;
import com.zappts.magic.models.Card;
import com.zappts.magic.requests.CardRequest;
import com.zappts.magic.services.CardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/card")
public class CardController {
    final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/new")
    public Card newCard(@RequestBody CardRequest cardRequest){
        return cardService.createCard(cardRequest);
    }

    @PutMapping("/update")
    public Card updateCard(@RequestBody Card card) throws GameException {
        return cardService.updateCard(card);
    }

    @GetMapping("/getAll")
    public List<Card> getAll() throws GameException {
        return cardService.getAllCards();
    }

    @GetMapping("/getByName/{cardName}")
    public List<Card> getByName(@PathVariable String cardName) throws GameException {
        return cardService.getCardByName(cardName);
    }

    @DeleteMapping("/delete/{cardId}")
    public String deleteCard(@PathVariable Integer cardId) throws GameException {
        return cardService.deleteCard(cardId);
    }
}
