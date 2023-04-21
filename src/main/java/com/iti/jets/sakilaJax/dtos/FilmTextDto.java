package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.FilmText;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link FilmText} entity
 */
@XmlRootElement
public class FilmTextDto implements Serializable {
    private final short filmId;
    private final String title;
    private final String description;

    public FilmTextDto(short filmId, String title, String description) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
    }

    public short getFilmId() {
        return filmId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmTextDto entity = (FilmTextDto) o;
        return Objects.equals(this.filmId, entity.filmId) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, title, description);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "filmId = " + filmId + ", " +
                "title = " + title + ", " +
                "description = " + description + ")";
    }
}