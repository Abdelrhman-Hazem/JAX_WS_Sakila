package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.FilmActor;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * A DTO for the {@link FilmActor} entity
 */
@XmlRootElement
public class FilmActorDto implements Serializable {
    private final FilmActorIdDto id;
    private final FilmDtoSimple film;
    private final ActorDtoSimple actor;
    private final Timestamp lastUpdate;

    public FilmActorDto(FilmActorIdDto id, FilmDtoSimple film, ActorDtoSimple actor, Timestamp lastUpdate) {
        this.id = id;
        this.film = film;
        this.actor = actor;
        this.lastUpdate = lastUpdate;
    }

    public FilmActorIdDto getId() {
        return id;
    }

    public FilmDtoSimple getFilm() {
        return film;
    }

    public ActorDtoSimple getActor() {
        return actor;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorDto entity = (FilmActorDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.film, entity.film) &&
                Objects.equals(this.actor, entity.actor) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, film, actor, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "film = " + film + ", " +
                "actor = " + actor + ", " +
                "lastUpdate = " + lastUpdate + ")";
    }
}