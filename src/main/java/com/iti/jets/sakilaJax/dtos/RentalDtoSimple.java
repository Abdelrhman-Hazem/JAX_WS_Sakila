package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.Rental;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * A DTO for the {@link Rental} entity
 */
@XmlRootElement
public class RentalDtoSimple implements Serializable {
    private final Integer rentalId;
    private final Timestamp rentalDate;
    private final Timestamp returnDate;
    private final Timestamp lastUpdate;

    public RentalDtoSimple(Integer rentalId, Timestamp rentalDate, Timestamp returnDate, Timestamp lastUpdate) {
        this.rentalId = rentalId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.lastUpdate = lastUpdate;
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public Timestamp getRentalDate() {
        return rentalDate;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalDtoSimple entity = (RentalDtoSimple) o;
        return Objects.equals(this.rentalId, entity.rentalId) &&
                Objects.equals(this.rentalDate, entity.rentalDate) &&
                Objects.equals(this.returnDate, entity.returnDate) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentalId, rentalDate, returnDate, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "rentalId = " + rentalId + ", " +
                "rentalDate = " + rentalDate + ", " +
                "returnDate = " + returnDate + ", " +
                "lastUpdate = " + lastUpdate + ")";
    }
}