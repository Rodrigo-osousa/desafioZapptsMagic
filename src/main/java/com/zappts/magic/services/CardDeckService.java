package com.zappts.magic.services;

import com.zappts.magic.customException.GameException;
import com.zappts.magic.models.Card;
import com.zappts.magic.models.CardDeck;
import com.zappts.magic.models.Player;
import com.zappts.magic.repository.CardDeckRepository;
import com.zappts.magic.repository.CardRepository;
import com.zappts.magic.repository.PlayerRepository;
import com.zappts.magic.requests.CardDeckRequest;
import com.zappts.magic.requests.CardMovimentRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CardDeckService {

    final CardDeckRepository cardDeckRepository;
    final PlayerService playerService;
    final PlayerRepository playerRepository;
    final CardService cardService;
    final CardRepository cardRepository;

    public CardDeckService(CardDeckRepository cardDeckRepository, PlayerService playerService, PlayerRepository playerRepository, CardService cardService, CardRepository cardRepository) {
        this.cardDeckRepository = cardDeckRepository;
        this.playerService = playerService;
        this.playerRepository = playerRepository;
        this.cardService = cardService;
        this.cardRepository = cardRepository;
    }

    public CardDeck newDeck(CardDeckRequest cardDeckRequest) throws GameException {
        Optional<CardDeck> findExistentDeck = cardDeckRepository.findByCardDeckName(cardDeckRequest.getCardDeckName());
        Optional<Player> findPlayerIdDb = playerRepository.findByPlayerNickName(cardDeckRequest.getPlayerName());
             if(findPlayerIdDb.isEmpty()) {
            throw new GameException("Jogador não localizado!");
        } else if(findExistentDeck.isPresent()) {
            throw new GameException("Já existe um Deck com este nome!");
        }
        CardDeck newCardDeck = new CardDeck();
        newCardDeck.setCardDeckName(cardDeckRequest.getCardDeckName());
        newCardDeck.setPlayer(findPlayerIdDb.get());
        newCardDeck.setTotalCardsFoils(0);
        newCardDeck.setTotalCardsNotFoils(0);

        return cardDeckRepository.save(newCardDeck);
    }

    public List<CardDeck> getAll() {
       return (List<CardDeck>) cardDeckRepository.findAll();
    }



    public String deleteDeck(Integer cardDeckId) throws GameException {
        Optional<CardDeck> findDeckToDelete = cardDeckRepository.findById(cardDeckId);
        if(findDeckToDelete.isEmpty()){
            throw new GameException("Deck não localizado!");
        }
        cardDeckRepository.deleteById(findDeckToDelete.get().getCardDeckId());
        return "Deck "+ findDeckToDelete.get().getCardDeckName() + " deletado com sucesso!";
    }

    public CardDeck addCard(CardMovimentRequest cardMovimentRequest) throws GameException {
        Optional<CardDeck> findDeck = cardDeckRepository.findById(cardMovimentRequest.getCardDeckId());
        Optional<Card> findCard = cardRepository.findById(cardMovimentRequest.getCardId());
        if(findCard.isEmpty()){
            throw new GameException("Carta  não localizada!");
        } else if (findDeck.isEmpty()){
            throw new GameException("Deck de cartas não localizado!");
        }
        List<Card> cards = new ArrayList<>(findDeck.get().getCards());
        cards.add(findCard.get());
        if(findCard.get().getCardFoil().equals(true)){
            int foilsSum = findDeck.get().getTotalCardsFoils() + 1;
            findDeck.get().setTotalCardsFoils(foilsSum);
        }else {
            int notFoilsSum = findDeck.get().getTotalCardsNotFoils() + 1;
            findDeck.get().setTotalCardsNotFoils(notFoilsSum);
        }

        findDeck.get().setCard(cards);
        return cardDeckRepository.save(findDeck.get());
    }

    public CardDeck removeCard(CardMovimentRequest cardMovimentRequest) throws GameException {
        Optional<CardDeck> findDeck = cardDeckRepository.findById(cardMovimentRequest.getCardDeckId());
         if (findDeck.isEmpty()){
            throw new GameException("Deck de cartas não localizado!");
        }

        List<Card> cards = new ArrayList<>(findDeck.get().getCards());
         if((cardMovimentRequest.getCardId() - 1) < 0 || (cardMovimentRequest.getCardId() - 1) > cards.size()){
             throw new GameException("Carta no deck não encontrada!");
         } else if(cards.get(cardMovimentRequest.getCardId() - 1).getCardFoil().equals(true)){
             int foilsSum = findDeck.get().getTotalCardsFoils() - 1;
             findDeck.get().setTotalCardsFoils(foilsSum);
         }else {
             int notFoilsSum = findDeck.get().getTotalCardsNotFoils() - 1;
             findDeck.get().setTotalCardsNotFoils(notFoilsSum);
         }
        cards.remove(cardMovimentRequest.getCardId()-1);
        findDeck.get().setCard(cards);
        return cardDeckRepository.save(findDeck.get());

    }

    public List<Card> obtainCardInOrder(String cardDeckName) throws GameException {
        Optional<CardDeck> findListOfCards = cardDeckRepository.findByCardDeckName(cardDeckName);
        if(findListOfCards.isEmpty()){
            throw new GameException("Deck não localizado!");
        }
        List<Card> cards = new ArrayList<>(findListOfCards.get().getCards());
        if(cards.size() > 0) {
            Collections.sort(cards, new Comparator<Card>() {
                @Override
                public int compare(Card o1, Card o2) {
                    return o1.getCardName().compareTo(o2.getCardName());
                }
            });
        }

        return cards;
    }

}
