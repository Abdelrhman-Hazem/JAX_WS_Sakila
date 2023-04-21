package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.Staff;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Staff} entity
 */
@XmlRootElement
public class StaffDtoSimple implements Serializable {
    private final boolean active;
    private final Short staffId;
    private final String firstName;
    private final String lastName;

    public StaffDtoSimple(boolean active, Short staffId, String firstName, String lastName) {
        this.active = active;
        this.staffId = staffId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean getActive() {
        return active;
    }

    public Short getStaffId() {
        return staffId;
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
        StaffDtoSimple entity = (StaffDtoSimple) o;
        return Objects.equals(this.active, entity.active) &&
                Objects.equals(this.staffId, entity.staffId) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(active, staffId, firstName, lastName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "active = " + active + ", " +
                "staffId = " + staffId + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ")";
    }
}