package com.zappts.magic.services;

import com.zappts.magic.customException.GameException;
import com.zappts.magic.models.Player;
import com.zappts.magic.repository.PlayerRepository;
import com.zappts.magic.requests.PlayerRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {


    final
    PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player createPlayer(PlayerRequest playerRequest) throws GameException {
        Optional<Player> emailExistsInDb = playerRepository.findByPlayerEmail(playerRequest.getPlayerEmail());
        Optional<Player> nickNameExistInDb = playerRepository.findByPlayerNickName(playerRequest.getPlayerNickName());
        if(emailExistsInDb.isPresent() && nickNameExistInDb.isPresent()) {
            throw new GameException("Nick Name e E-mail já castrados!");
        } else if (nickNameExistInDb.isPresent()){
            throw new GameException("Nick Name já castrado!");
        }else if(emailExistsInDb.isPresent()) {
            throw new GameException("E-mail já castrado!");
        }
        Player newPlayer = new Player();
        newPlayer.setPlayerNickName(playerRequest.getPlayerNickName());
        newPlayer.setPlayerEmail(playerRequest.getPlayerEmail());

        return playerRepository.save(newPlayer);
    }

    public Player updatePlayer(Player player) throws GameException {
        Optional<Player> findPlayerInDb = playerRepository.findById(player.getPlayerId());
        if (findPlayerInDb.isEmpty()) {
            throw new GameException("Jogador não localizado!");
        }
        Player upPlayer = new Player();
        upPlayer.setPlayerId(player.getPlayerId());
        upPlayer.setPlayerNickName(player.getPlayerNickName());
        upPlayer.setPlayerEmail(player.getPlayerEmail());

        return playerRepository.save(upPlayer);
    }

    public Iterable<Player> findAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> findPlayerByNickName(String nickNameExistInDb) throws GameException {
        Optional<Player> playerInDbExist = playerRepository.findByPlayerNickName(nickNameExistInDb);
        if(playerInDbExist.isEmpty()) {
            throw new GameException("Jogador não localizado!");
        }
        return playerInDbExist;
    }

    public String gameOverPlayer(String nickNameExistInDb) throws GameException {
        Optional<Player> playerInDbExist = playerRepository.findByPlayerNickName(nickNameExistInDb);
        if(playerInDbExist.isEmpty()) {
            throw new GameException("Jogador não localizado!");
        }
        playerRepository.delete(playerInDbExist.get());
        return "O Jogador " + nickNameExistInDb + " perdeu todos os seus pontos de vida!";
    }
}
