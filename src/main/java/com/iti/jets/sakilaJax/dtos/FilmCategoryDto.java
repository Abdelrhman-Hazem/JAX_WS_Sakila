package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.FilmCategory;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * A DTO for the {@link FilmCategory} entity
 */
@XmlRootElement
public class FilmCategoryDto implements Serializable {
    private final FilmCategoryIdDto id;
    private final FilmDtoSimple film;
    private final CategoryDtoSimple category;
    private final Timestamp lastUpdate;

    public FilmCategoryDto(FilmCategoryIdDto id, FilmDtoSimple film, CategoryDtoSimple category, Timestamp lastUpdate) {
        this.id = id;
        this.film = film;
        this.category = category;
        this.lastUpdate = lastUpdate;
    }

    public FilmCategoryIdDto getId() {
        return id;
    }

    public FilmDtoSimple getFilm() {
        return film;
    }

    public CategoryDtoSimple getCategory() {
        return category;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmCategoryDto entity = (FilmCategoryDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.film, entity.film) &&
                Objects.equals(this.category, entity.category) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, film, category, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "film = " + film + ", " +
                "category = " + category + ", " +
                "lastUpdate = " + lastUpdate + ")";
    }
}