package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.Staff;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link Staff} entity
 */
@XmlRootElement
public class StaffDto implements Serializable {
    private final boolean active;
    private final Short staffId;
    private final StoreDtoSimple store;
    private final AddressDto address;
    private final String firstName;
    private final String lastName;
    private final byte[] picture;
    private final String email;
    private final String username;
    private final String password;
    private final Timestamp lastUpdate;
    private final Set<PaymentDtoSimple> payments;
    private final Set<StoreDtoSimple> stores;
    private final Set<RentalDtoSimple> rentals;

    public StaffDto(boolean active, Short staffId, StoreDtoSimple store, AddressDto address, String firstName, String lastName, byte[] picture, String email, String username, String password, Timestamp lastUpdate, Set<PaymentDtoSimple> payments, Set<StoreDtoSimple> stores, Set<RentalDtoSimple> rentals) {
        this.active = active;
        this.staffId = staffId;
        this.store = store;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.picture = picture;
        this.email = email;
        this.username = username;
        this.password = password;
        this.lastUpdate = lastUpdate;
        this.payments = payments;
        this.stores = stores;
        this.rentals = rentals;
    }

    public boolean getActive() {
        return active;
    }

    public Short getStaffId() {
        return staffId;
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

    public byte[] getPicture() {
        return picture;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public Set<PaymentDtoSimple> getPayments() {
        return payments;
    }

    public Set<StoreDtoSimple> getStores() {
        return stores;
    }

    public Set<RentalDtoSimple> getRentals() {
        return rentals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffDto entity = (StaffDto) o;
        return Objects.equals(this.active, entity.active) &&
                Objects.equals(this.staffId, entity.staffId) &&
                Objects.equals(this.store, entity.store) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.picture, entity.picture) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate) &&
                Objects.equals(this.payments, entity.payments) &&
                Objects.equals(this.stores, entity.stores) &&
                Objects.equals(this.rentals, entity.rentals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(active, staffId, store, address, firstName, lastName, picture, email, username, password, lastUpdate, payments, stores, rentals);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "active = " + active + ", " +
                "staffId = " + staffId + ", " +
                "store = " + store + ", " +
                "address = " + address + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "picture = " + picture + ", " +
                "email = " + email + ", " +
                "username = " + username + ", " +
                "password = " + password + ", " +
                "lastUpdate = " + lastUpdate + ", " +
                "payments = " + payments + ", " +
                "stores = " + stores + ", " +
                "rentals = " + rentals + ")";
    }
}