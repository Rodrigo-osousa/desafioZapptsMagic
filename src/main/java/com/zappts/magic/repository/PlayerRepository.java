package com.zappts.magic.repository;

import com.zappts.magic.models.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
    Optional<Player> findByPlayerNickName(String nickName);
    Optional<Player> findByPlayerEmail(String playerEmail);
}
