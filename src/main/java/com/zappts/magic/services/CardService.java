package com.zappts.magic.services;

import com.zappts.magic.customException.GameException;
import com.zappts.magic.models.Card;
import com.zappts.magic.repository.CardRepository;
import com.zappts.magic.requests.CardRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card createCard(CardRequest cardRequest) {
        Card newCard = new Card();
        newCard.setCardName(cardRequest.getCardName());
        newCard.setCardEdition(cardRequest.getCardEdition());
        newCard.setCardLanguage(cardRequest.getCardLanguage());
        newCard.setCardAmount(cardRequest.getCardAmount());
        newCard.setCardFoil(cardRequest.getCardFoil());

        return cardRepository.save(newCard);
    }

    public Card updateCard(Card card) throws GameException {
        Optional<Card> findCardInDb = cardRepository.findById(card.getCardId());
        if (findCardInDb.isEmpty()) {
            throw new GameException("Carta não localizada!");
        }
        Card upCard = new Card();
        upCard.setCardId(findCardInDb.get().getCardId());
        upCard.setCardName(card.getCardName());
        upCard.setCardEdition(card.getCardEdition());
        upCard.setCardLanguage(card.getCardLanguage());
        upCard.setCardAmount(card.getCardAmount());
        upCard.setCardFoil(card.getCardFoil());

        return cardRepository.save(upCard);
    }

    public List<Card> getCardByName(String cardName) throws GameException {
        List<Card> existsCards = cardRepository.findByCardName(cardName);
        if (existsCards.isEmpty()) {
            throw new GameException("Nenhuma carta com o nome de " + cardName +" foi encontrada!");
        }
        return existsCards;
    }

    public List<Card> getAllCards() throws GameException {
        List<Card> findAll = (List<Card>) cardRepository.findAll();
        if(findAll.isEmpty()) {
            throw new GameException("Nenhuma carta cadastrada!");
        }
        return findAll;
    }

    public String deleteCard(Integer cardId) throws GameException {
        Optional<Card> findToDelete = cardRepository.findById(cardId);
        if(findToDelete.isEmpty()){
            throw new GameException("Carta não localizada!");
        }
        cardRepository.deleteById(cardId);
        return "Carta " + findToDelete.get().getCardName() +" deletada com sucesso!";
    }
}
