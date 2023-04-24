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
public class PaymentDtoSimple implements Serializable {
    private Short paymentId;
    private BigDecimal amount;
    private Timestamp paymentDate;
    private Timestamp lastUpdate;

    public PaymentDtoSimple() {
    }

    public PaymentDtoSimple(Short paymentId, BigDecimal amount, Timestamp paymentDate, Timestamp lastUpdate) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.lastUpdate = lastUpdate;
    }

    public void setPaymentId(Short paymentId) {
        this.paymentId = paymentId;
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
        PaymentDtoSimple entity = (PaymentDtoSimple) o;
        return Objects.equals(this.paymentId, entity.paymentId) &&
                Objects.equals(this.amount, entity.amount) &&
                Objects.equals(this.paymentDate, entity.paymentDate) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, amount, paymentDate, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "paymentId = " + paymentId + ", " +
                "amount = " + amount + ", " +
                "paymentDate = " + paymentDate + ", " +
                "lastUpdate = " + lastUpdate + ")";
    }
}