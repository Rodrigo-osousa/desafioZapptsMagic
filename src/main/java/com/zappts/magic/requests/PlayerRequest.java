package com.zappts.magic.requests;


public class PlayerRequest {
    private String playerNickName;
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
