// com/example/cricket_backend/dto/PlayerSummaryDTO.java
package com.example.cricket_backend.dto;

public class PlayerSummaryDTO {
    private Long id;
    private String name;
    private int jersey;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getJersey() { return jersey; }
    public void setJersey(int jersey) { this.jersey = jersey; }
}
