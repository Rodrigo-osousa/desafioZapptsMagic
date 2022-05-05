package com.zappts.magic.services;

import com.zappts.magic.customException.GameException;
import com.zappts.magic.models.Player;
import com.zappts.magic.repository.PlayerRepository;
import com.zappts.magic.requests.PlayerRequest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class PlayerServiceTest {
    @Autowired
    PlayerService playerService;

    @Autowired
    PlayerRepository playerRepository;

    @Test
    @Order(1)
    void createPlayer() throws GameException {
        PlayerRequest newPlayer = new PlayerRequest("Player Teste","email@teste.com");

        playerService.createPlayer(newPlayer);
        assertTrue(playerRepository.findByPlayerNickName("Player Teste").isPresent());
    }
    @Test
    @Order(2)
    void createPlayerWithNameAndEmailRepeated() throws GameException {
        PlayerRequest newPlayer = new PlayerRequest("Player Teste","email@teste.com");

        assertThrows(GameException.class, () -> {
            playerService.createPlayer(newPlayer);
        });
    }

    @Test
    @Order(3)
    void updatePlayer() throws GameException {
        Player upPlayer = new Player(1,"Player Teste Updated","email@teste.com");
        playerService.updatePlayer(upPlayer);
        assertEquals(playerRepository.findByPlayerNickName("Player Teste Updated").get().getPlayerNickName(), "Player Teste Updated");

    }
    @Test
    @Order(4)
    void updateNonexistentPlayer() throws GameException {
        Player upPlayer = new Player(99,"Player Teste Updated","email@teste.com");

        assertThrows(GameException.class, () -> {
            playerService.updatePlayer(upPlayer);
        });

    }

    @Test
    @Order(5)
    void findAllPlayers() {
      List<Player> allPlayers = (List<Player>) playerService.findAllPlayers();
        assertTrue(allPlayers.size() > 0 );
    }

    @Test
    @Order(6)
    void findPlayerByNickName() throws GameException {
        Optional<Player> findByName = playerService.findPlayerByNickName("Player Teste Updated");
        assertTrue(findByName.isPresent());
    }
    @Test
    @Order(7)
    void findPlayerByNickNameNonexistent() throws GameException {
        assertThrows(GameException.class, () -> {playerService.findPlayerByNickName("no name");});
    }


    @Test
    @Order(8)
    void gameOverPlayer() throws GameException {
        playerService.gameOverPlayer("Player Teste Updated");
        assertTrue(playerRepository.findByPlayerNickName("Player Teste Updated").isEmpty());
    }
}