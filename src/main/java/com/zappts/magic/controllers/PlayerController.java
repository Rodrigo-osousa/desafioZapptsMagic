package com.zappts.magic.controllers;

import com.zappts.magic.customException.GameException;
import com.zappts.magic.models.Player;
import com.zappts.magic.requests.PlayerRequest;
import com.zappts.magic.services.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/player")
public class PlayerController {

    final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/new")
    public Player createPlayer(@RequestBody PlayerRequest playerRequest) throws GameException {
        return playerService.createPlayer(playerRequest);
    }

    @PutMapping("/update")
    public Player updatePlayer(@RequestBody Player player) throws GameException {
        return playerService.updatePlayer(player);
    }

    @GetMapping("/getAll")
    public Iterable<Player> getAllPlayers(){
        return playerService.findAllPlayers();
    }

    @GetMapping("/getByNickName/{nickName}")
    public Optional<Player> getByNickName(@PathVariable String nickName) throws GameException {
        return playerService.findPlayerByNickName(nickName);
    }

    @DeleteMapping("/deletePlayer/{nickName}")
    public String deletePlayer(@PathVariable String nickName) throws GameException {
        return playerService.gameOverPlayer(nickName);
    }
}
