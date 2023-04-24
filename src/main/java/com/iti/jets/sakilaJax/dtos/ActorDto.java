package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.Actor;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link Actor} entity
 */
@XmlRootElement
public class ActorDto implements Serializable {
    private  Short actorId;
    private  String firstName;
    private  String lastName;
    private  Set<FilmActorDto> filmActors;

    public ActorDto(Short actorId, String firstName, String lastName, Set<FilmActorDto> filmActors) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.filmActors = filmActors;
    }

    public ActorDto() {
    }

    public void setActorId(Short actorId) {
        this.actorId = actorId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFilmActors(Set<FilmActorDto> filmActors) {
        this.filmActors = filmActors;
    }

    public Short getActorId() {
        return actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<FilmActorDto> getFilmActors() {
        return filmActors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorDto entity = (ActorDto) o;
        return Objects.equals(this.actorId, entity.actorId) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.filmActors, entity.filmActors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, firstName, lastName, filmActors);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "actorId = " + actorId + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "filmActors = " + filmActors + ")";
    }
}