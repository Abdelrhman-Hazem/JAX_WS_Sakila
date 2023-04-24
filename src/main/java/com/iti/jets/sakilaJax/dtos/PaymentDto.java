package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.Payment;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * A DTO for the {@link Payment} entity
 */
@XmlRootElement
public class PaymentDto implements Serializable {
    private Short paymentId;
    private StaffDtoSimple staff;
    private CustomerDtoSimple customer;
    private RentalDtoSimple rental;
    private BigDecimal amount;
    private Timestamp paymentDate;
    private Timestamp lastUpdate;

    public PaymentDto() {
    }

    public PaymentDto(Short paymentId, StaffDtoSimple staff, CustomerDtoSimple customer, RentalDtoSimple rental, BigDecimal amount, Timestamp paymentDate, Timestamp lastUpdate) {
        this.paymentId = paymentId;
        this.staff = staff;
        this.customer = customer;
        this.rental = rental;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.lastUpdate = lastUpdate;
    }

    public void setPaymentId(Short paymentId) {
        this.paymentId = paymentId;
    }

    public void setStaff(StaffDtoSimple staff) {
        this.staff = staff;
    }

    public void setCustomer(CustomerDtoSimple customer) {
        this.customer = customer;
    }

    public void setRental(RentalDtoSimple rental) {
        this.rental = rental;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Short getPaymentId() {
        return paymentId;
    }

    public StaffDtoSimple getStaff() {
        return staff;
    }

    public CustomerDtoSimple getCustomer() {
        return customer;
    }

    public RentalDtoSimple getRental() {
        return rental;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentDto entity = (PaymentDto) o;
        return Objects.equals(this.paymentId, entity.paymentId) &&
                Objects.equals(this.staff, entity.staff) &&
                Objects.equals(this.customer, entity.customer) &&
                Objects.equals(this.rental, entity.rental) &&
                Objects.equals(this.amount, entity.amount) &&
                Objects.equals(this.paymentDate, entity.paymentDate) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, staff, customer, rental, amount, paymentDate, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "paymentId = " + paymentId + ", " +
                "staff = " + staff + ", " +
                "customer = " + customer + ", " +
                "rental = " + rental + ", " +
                "amount = " + amount + ", " +
                "paymentDate = " + paymentDate + ", " +
                "lastUpdate = " + lastUpdate + ")";
    }
}