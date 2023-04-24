package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.FilmActorId;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link FilmActorId} entity
 */
@XmlRootElement
public class FilmActorIdDto implements Serializable {
    private short actorId;
    private short filmId;

    public FilmActorIdDto() {
    }

    public FilmActorIdDto(short actorId, short filmId) {
        this.actorId = actorId;
        this.filmId = filmId;
    }

    public void setActorId(short actorId) {
        this.actorId = actorId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    public short getActorId() {
        return actorId;
    }

    public short getFilmId() {
        return filmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorIdDto entity = (FilmActorIdDto) o;
        return Objects.equals(this.actorId, entity.actorId) &&
                Objects.equals(this.filmId, entity.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, filmId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "actorId = " + actorId + ", " +
                "filmId = " + filmId + ")";
    }
}