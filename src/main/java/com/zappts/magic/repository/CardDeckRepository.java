package com.zappts.magic.repository;

import com.zappts.magic.models.CardDeck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardDeckRepository extends CrudRepository<CardDeck, Integer> {
    Optional<CardDeck> findByCardDeckName(String cardDeckName);

}
