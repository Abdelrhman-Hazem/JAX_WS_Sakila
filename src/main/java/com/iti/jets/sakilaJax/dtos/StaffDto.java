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
    private boolean active;
    private Short staffId;
    private StoreDtoSimple store;
    private AddressDto address;
    private String firstName;
    private String lastName;
    private byte[] picture;
    private String email;
    private String username;
    private String password;
    private Timestamp lastUpdate;
    private Set<PaymentDtoSimple> payments;
    private Set<StoreDtoSimple> stores;
    private Set<RentalDtoSimple> rentals;

    public StaffDto() {
    }

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

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setStaffId(Short staffId) {
        this.staffId = staffId;
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

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setPayments(Set<PaymentDtoSimple> payments) {
        this.payments = payments;
    }

    public void setStores(Set<StoreDtoSimple> stores) {
        this.stores = stores;
    }

    public void setRentals(Set<RentalDtoSimple> rentals) {
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