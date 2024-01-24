package com.example.newdemo.entity;

import jakarta.persistence.OneToOne;

public enum SeatClass {
    ECONOMY("Economy Class"),
    BUSINESS("Business Class"),
    FIRST_CLASS("First Class");

    @OneToOne
    private Passengers passenger;

    private final String description;

    SeatClass(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "description='" + description + '\'' +
                '}';
    }
}
