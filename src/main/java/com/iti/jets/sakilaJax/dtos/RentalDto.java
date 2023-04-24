package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.Rental;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link Rental} entity
 */
@XmlRootElement
public class RentalDto implements Serializable {
    private Integer rentalId;
    private StaffDtoSimple staff;
    private CustomerDtoSimple customer;
    private InventoryDto inventory;
    private Timestamp rentalDate;
    private Timestamp returnDate;
    private Timestamp lastUpdate;
    private Set<PaymentDtoSimple> payments;

    public RentalDto() {
    }

    public RentalDto(Integer rentalId, StaffDtoSimple staff, CustomerDtoSimple customer, InventoryDto inventory, Timestamp rentalDate, Timestamp returnDate, Timestamp lastUpdate, Set<PaymentDtoSimple> payments) {
        this.rentalId = rentalId;
        this.staff = staff;
        this.customer = customer;
        this.inventory = inventory;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.lastUpdate = lastUpdate;
        this.payments = payments;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public void setStaff(StaffDtoSimple staff) {
        this.staff = staff;
    }

    public void setCustomer(CustomerDtoSimple customer) {
        this.customer = customer;
    }

    public void setInventory(InventoryDto inventory) {
        this.inventory = inventory;
    }

    public void setRentalDate(Timestamp rentalDate) {
        this.rentalDate = rentalDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setPayments(Set<PaymentDtoSimple> payments) {
        this.payments = payments;
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public StaffDtoSimple getStaff() {
        return staff;
    }

    public CustomerDtoSimple getCustomer() {
        return customer;
    }

    public InventoryDto getInventory() {
        return inventory;
    }

    public Timestamp getRentalDate() {
        return rentalDate;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public Set<PaymentDtoSimple> getPayments() {
        return payments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalDto entity = (RentalDto) o;
        return Objects.equals(this.rentalId, entity.rentalId) &&
                Objects.equals(this.staff, entity.staff) &&
                Objects.equals(this.customer, entity.customer) &&
                Objects.equals(this.inventory, entity.inventory) &&
                Objects.equals(this.rentalDate, entity.rentalDate) &&
                Objects.equals(this.returnDate, entity.returnDate) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate) &&
                Objects.equals(this.payments, entity.payments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentalId, staff, customer, inventory, rentalDate, returnDate, lastUpdate, payments);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "rentalId = " + rentalId + ", " +
                "staff = " + staff + ", " +
                "customer = " + customer + ", " +
                "inventory = " + inventory + ", " +
                "rentalDate = " + rentalDate + ", " +
                "returnDate = " + returnDate + ", " +
                "lastUpdate = " + lastUpdate + ", " +
                "payments = " + payments + ")";
    }
}