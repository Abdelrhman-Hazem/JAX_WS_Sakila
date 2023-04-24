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
    private Short filmId;
    private LanguageDto languageByLanguageId;
    private LanguageDto languageByOriginalLanguageId;
    private String title;
    private String description;
    private Date releaseYear;
    private byte rentalDuration;
    private BigDecimal rentalRate;
    private Short length;
    private BigDecimal replacementCost;
    private String rating;
    private String specialFeatures;
    private Timestamp lastUpdate;
    private Set<InventoryDto> inventories;
    private Set<FilmActorDto> filmActors;
    private Set<FilmCategoryDto> filmCategories;

    public FilmDto() {
    }

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

    public void setFilmId(Short filmId) {
        this.filmId = filmId;
    }

    public void setLanguageByLanguageId(LanguageDto languageByLanguageId) {
        this.languageByLanguageId = languageByLanguageId;
    }

    public void setLanguageByOriginalLanguageId(LanguageDto languageByOriginalLanguageId) {
        this.languageByOriginalLanguageId = languageByOriginalLanguageId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setRentalDuration(byte rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setInventories(Set<InventoryDto> inventories) {
        this.inventories = inventories;
    }

    public void setFilmActors(Set<FilmActorDto> filmActors) {
        this.filmActors = filmActors;
    }

    public void setFilmCategories(Set<FilmCategoryDto> filmCategories) {
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