package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.Customer;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Customer} entity
 */
@XmlRootElement
public class CustomerDtoSimple implements Serializable {
    private final boolean active;
    private final Short customerId;
    private final String firstName;
    private final String lastName;

    public CustomerDtoSimple(boolean active, Short customerId, String firstName, String lastName) {
        this.active = active;
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean getActive() {
        return active;
    }

    public Short getCustomerId() {
        return customerId;
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
        CustomerDtoSimple entity = (CustomerDtoSimple) o;
        return Objects.equals(this.active, entity.active) &&
                Objects.equals(this.customerId, entity.customerId) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(active, customerId, firstName, lastName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "active = " + active + ", " +
                "customerId = " + customerId + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ")";
    }
}