package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.Film;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Film} entity
 */
@XmlRootElement
public class FilmDtoSimple implements Serializable {
    private Short filmId;
    private String title;

    public FilmDtoSimple(Short filmId, String title) {
        this.filmId = filmId;
        this.title = title;
    }

    public FilmDtoSimple() {
    }

    public void setFilmId(Short filmId) {
        this.filmId = filmId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Short getFilmId() {
        return filmId;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmDtoSimple entity = (FilmDtoSimple) o;
        return Objects.equals(this.filmId, entity.filmId) &&
                Objects.equals(this.title, entity.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, title);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "filmId = " + filmId + ", " +
                "title = " + title + ")";
    }
}