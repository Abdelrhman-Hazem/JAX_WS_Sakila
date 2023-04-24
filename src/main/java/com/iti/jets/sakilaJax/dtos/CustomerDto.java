package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.Customer;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link Customer} entity
 */
@XmlRootElement
public class CustomerDto implements Serializable {
    private boolean active;
    private Short customerId;
    private StoreDtoSimple store;
    private AddressDto address;
    private String firstName;
    private String lastName;
    private String email;
    private Timestamp createDate;
    private Timestamp lastUpdate;
    private Set<PaymentDto> payments;
    private Set<RentalDto> rentals;

    public CustomerDto() {
    }

    public CustomerDto(boolean active, Short customerId, StoreDtoSimple store, AddressDto address, String firstName, String lastName, String email, Timestamp createDate, Timestamp lastUpdate, Set<PaymentDto> payments, Set<RentalDto> rentals) {
        this.active = active;
        this.customerId = customerId;
        this.store = store;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
        this.payments = payments;
        this.rentals = rentals;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setCustomerId(Short customerId) {
        this.customerId = customerId;
    }

    public void setStore(StoreDtoSimple store) {
        this.store = store;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setPayments(Set<PaymentDto> payments) {
        this.payments = payments;
    }

    public void setRentals(Set<RentalDto> rentals) {
        this.rentals = rentals;
    }

    public boolean getActive() {
        return active;
    }

    public Short getCustomerId() {
        return customerId;
    }

    public StoreDtoSimple getStore() {
        return store;
    }

    public AddressDto getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public Set<PaymentDto> getPayments() {
        return payments;
    }

    public Set<RentalDto> getRentals() {
        return rentals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto entity = (CustomerDto) o;
        return Objects.equals(this.active, entity.active) &&
                Objects.equals(this.customerId, entity.customerId) &&
                Objects.equals(this.store, entity.store) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.createDate, entity.createDate) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate) &&
                Objects.equals(this.payments, entity.payments) &&
                Objects.equals(this.rentals, entity.rentals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(active, customerId, store, address, firstName, lastName, email, createDate, lastUpdate, payments, rentals);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "active = " + active + ", " +
                "customerId = " + customerId + ", " +
                "store = " + store + ", " +
                "address = " + address + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "email = " + email + ", " +
                "createDate = " + createDate + ", " +
                "lastUpdate = " + lastUpdate + ", " +
                "payments = " + payments + ", " +
                "rentals = " + rentals + ")";
    }
}