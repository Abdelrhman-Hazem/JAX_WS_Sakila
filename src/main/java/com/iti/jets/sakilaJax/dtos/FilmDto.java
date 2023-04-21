package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.Film;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link Film} entity
 */
@XmlRootElement
public class FilmDto implements Serializable {
    private final Short filmId;
    private final LanguageDto languageByLanguageId;
    private final LanguageDto languageByOriginalLanguageId;
    private final String title;
    private final String description;
    private final Date releaseYear;
    private final byte rentalDuration;
    private final BigDecimal rentalRate;
    private final Short length;
    private final BigDecimal replacementCost;
    private final String rating;
    private final String specialFeatures;
    private final Timestamp lastUpdate;
    private final Set<InventoryDto> inventories;
    private final Set<FilmActorDto> filmActors;
    private final Set<FilmCategoryDto> filmCategories;

    public FilmDto(Short filmId, LanguageDto languageByLanguageId, LanguageDto languageByOriginalLanguageId, String title, String description, Date releaseYear, byte rentalDuration, BigDecimal rentalRate, Short length, BigDecimal replacementCost, String rating, String specialFeatures, Timestamp lastUpdate, Set<InventoryDto> inventories, Set<FilmActorDto> filmActors, Set<FilmCategoryDto> filmCategories) {
        this.filmId = filmId;
        this.languageByLanguageId = languageByLanguageId;
        this.languageByOriginalLanguageId = languageByOriginalLanguageId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.specialFeatures = specialFeatures;
        this.lastUpdate = lastUpdate;
        this.inventories = inventories;
        this.filmActors = filmActors;
        this.filmCategories = filmCategories;
    }

    public Short getFilmId() {
        return filmId;
    }

    public LanguageDto getLanguageByLanguageId() {
        return languageByLanguageId;
    }

    public LanguageDto getLanguageByOriginalLanguageId() {
        return languageByOriginalLanguageId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public byte getRentalDuration() {
        return rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public Short getLength() {
        return length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public Set<InventoryDto> getInventories() {
        return inventories;
    }

    public Set<FilmActorDto> getFilmActors() {
        return filmActors;
    }

    public Set<FilmCategoryDto> getFilmCategories() {
        return filmCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmDto entity = (FilmDto) o;
        return Objects.equals(this.filmId, entity.filmId) &&
                Objects.equals(this.languageByLanguageId, entity.languageByLanguageId) &&
                Objects.equals(this.languageByOriginalLanguageId, entity.languageByOriginalLanguageId) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.releaseYear, entity.releaseYear) &&
                Objects.equals(this.rentalDuration, entity.rentalDuration) &&
                Objects.equals(this.rentalRate, entity.rentalRate) &&
                Objects.equals(this.length, entity.length) &&
                Objects.equals(this.replacementCost, entity.replacementCost) &&
                Objects.equals(this.rating, entity.rating) &&
                Objects.equals(this.specialFeatures, entity.specialFeatures) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate) &&
                Objects.equals(this.inventories, entity.inventories) &&
                Objects.equals(this.filmActors, entity.filmActors) &&
                Objects.equals(this.filmCategories, entity.filmCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, languageByLanguageId, languageByOriginalLanguageId, title, description, releaseYear, rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures, lastUpdate, inventories, filmActors, filmCategories);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "filmId = " + filmId + ", " +
                "languageByLanguageId = " + languageByLanguageId + ", " +
                "languageByOriginalLanguageId = " + languageByOriginalLanguageId + ", " +
                "title = " + title + ", " +
                "description = " + description + ", " +
                "releaseYear = " + releaseYear + ", " +
                "rentalDuration = " + rentalDuration + ", " +
                "rentalRate = " + rentalRate + ", " +
                "length = " + length + ", " +
                "replacementCost = " + replacementCost + ", " +
                "rating = " + rating + ", " +
                "specialFeatures = " + specialFeatures + ", " +
                "lastUpdate = " + lastUpdate + ", " +
                "inventories = " + inventories + ", " +
                "filmActors = " + filmActors + ", " +
                "filmCategories = " + filmCategories + ")";
    }
}