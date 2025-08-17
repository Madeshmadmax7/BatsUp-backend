// com/example/cricket_backend/dto/RegisterRequestDTO.java
package com.example.cricket_backend.dto;

public class RegisterRequestDTO {
    private String username;
    private String password;
    private String email;
    private String role;

    private String playerName;
    private String playerCity;
    private String phone;
    private String playedIn;
    private String playerType;
    private String lastPlayedFor;

    private String name;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }

    public String getPlayerCity() { return playerCity; }
    public void setPlayerCity(String playerCity) { this.playerCity = playerCity; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPlayedIn() { return playedIn; }
    public void setPlayedIn(String playedIn) { this.playedIn = playedIn; }

    public String getPlayerType() { return playerType; }
    public void setPlayerType(String playerType) { this.playerType = playerType; }

    public String getLastPlayedFor() { return lastPlayedFor; }
    public void setLastPlayedFor(String lastPlayedFor) { this.lastPlayedFor = lastPlayedFor; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
}
