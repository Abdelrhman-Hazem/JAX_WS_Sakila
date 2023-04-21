package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.Actor;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Actor} entity
 */
@XmlRootElement
public class ActorDtoSimple implements Serializable {
    private final Short actorId;
    private final String firstName;
    private final String lastName;

    public ActorDtoSimple(Short actorId, String firstName, String lastName) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorDtoSimple entity = (ActorDtoSimple) o;
        return Objects.equals(this.actorId, entity.actorId) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, firstName, lastName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "actorId = " + actorId + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ")";
    }
}