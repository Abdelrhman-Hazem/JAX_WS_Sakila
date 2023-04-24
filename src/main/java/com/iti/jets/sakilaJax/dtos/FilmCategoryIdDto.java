package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.FilmCategoryId;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link FilmCategoryId} entity
 */
@XmlRootElement
public class FilmCategoryIdDto implements Serializable {
    private short categoryId;
    private short filmId;

    public FilmCategoryIdDto() {
    }

    public FilmCategoryIdDto(short categoryId, short filmId) {
        this.categoryId = categoryId;
        this.filmId = filmId;
    }

    public void setCategoryId(short categoryId) {
        this.categoryId = categoryId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    public short getCategoryId() {
        return categoryId;
    }

    public short getFilmId() {
        return filmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmCategoryIdDto entity = (FilmCategoryIdDto) o;
        return Objects.equals(this.categoryId, entity.categoryId) &&
                Objects.equals(this.filmId, entity.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, filmId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "categoryId = " + categoryId + ", " +
                "filmId = " + filmId + ")";
    }
}