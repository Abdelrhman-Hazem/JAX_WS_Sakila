package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.Inventory;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link Inventory} entity
 */
@XmlRootElement
public class InventoryDto implements Serializable {
    private Integer inventoryId;
    private StoreDtoSimple store;
    private FilmDtoSimple film;
    private Timestamp lastUpdate;
    private Set<RentalDtoSimple> rentals;

    public InventoryDto() {
    }

    public InventoryDto(Integer inventoryId, StoreDtoSimple store, FilmDtoSimple film, Timestamp lastUpdate, Set<RentalDtoSimple> rentals) {
        this.inventoryId = inventoryId;
        this.store = store;
        this.film = film;
        this.lastUpdate = lastUpdate;
        this.rentals = rentals;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public void setStore(StoreDtoSimple store) {
        this.store = store;
    }

    public void setFilm(FilmDtoSimple film) {
        this.film = film;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setRentals(Set<RentalDtoSimple> rentals) {
        this.rentals = rentals;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public StoreDtoSimple getStore() {
        return store;
    }

    public FilmDtoSimple getFilm() {
        return film;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public Set<RentalDtoSimple> getRentals() {
        return rentals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryDto entity = (InventoryDto) o;
        return Objects.equals(this.inventoryId, entity.inventoryId) &&
                Objects.equals(this.store, entity.store) &&
                Objects.equals(this.film, entity.film) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate) &&
                Objects.equals(this.rentals, entity.rentals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId, store, film, lastUpdate, rentals);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "inventoryId = " + inventoryId + ", " +
                "store = " + store + ", " +
                "film = " + film + ", " +
                "lastUpdate = " + lastUpdate + ", " +
                "rentals = " + rentals + ")";
    }
}