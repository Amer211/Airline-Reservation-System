package com.example.newdemo.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "destinations")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "destination_id")
    private int destinationId;

    @Column(name = "destination_name")
    private String destinationName;

    public Destination() {
    }

    public Destination(int destinationId, String destinationName) {
        this.destinationId = destinationId;
        this.destinationName = destinationName;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Destination that = (Destination) o;

        if (destinationId != that.destinationId) return false;
        return Objects.equals(destinationName, that.destinationName);
    }

    @Override
    public int hashCode() {
        int result = destinationId;
        result = 31 * result + (destinationName != null ? destinationName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "destinationId=" + destinationId +
                ", destinationName='" + destinationName + '\'' +
                '}';
    }
}

