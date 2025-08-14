package com.example.cricket_backend.dto;

import java.util.List;

public class FanDTO {
    private Long id;
    private String name;
    private String email;
    private List<Long> bookedMatchIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getBookedMatchIds() {
        return bookedMatchIds;
    }

    public void setBookedMatchIds(List<Long> bookedMatchIds) {
        this.bookedMatchIds = bookedMatchIds;
    }
}
