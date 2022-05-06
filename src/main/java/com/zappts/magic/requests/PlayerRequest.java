package com.zappts.magic.requests;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PlayerRequest {
    @NotNull(message = "Nome do Jogador não pose ser nullo!")
    @NotBlank(message = "Nome do Jogador ficar em branco!")
    private String playerNickName;
    @Email
    private String playerEmail;

    public PlayerRequest() {
    }

    public PlayerRequest(String playerNickName, String playerEmail) {
        this.playerNickName = playerNickName;
        this.playerEmail = playerEmail;
    }

    public String getPlayerEmail() {
        return playerEmail;
    }

    public void setPlayerEmail(String playerEmail) {
        this.playerEmail = playerEmail;
    }

    public String getPlayerNickName() {
        return playerNickName;
    }

    public void setPlayerNickName(String playerNickName) {
        this.playerNickName = playerNickName;
    }
}
