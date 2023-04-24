package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.Store;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Store} entity
 */
@XmlRootElement
public class StoreDtoSimple implements Serializable {
    private Short storeId;
    private AddressDto address;

    public StoreDtoSimple() {
    }

    public StoreDtoSimple(Short storeId, AddressDto address) {
        this.storeId = storeId;
        this.address = address;
    }

    public void setStoreId(Short storeId) {
        this.storeId = storeId;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public Short getStoreId() {
        return storeId;
    }

    public AddressDto getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreDtoSimple entity = (StoreDtoSimple) o;
        return Objects.equals(this.storeId, entity.storeId) &&
                Objects.equals(this.address, entity.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, address);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "storeId = " + storeId + ", " +
                "address = " + address + ")";
    }
}