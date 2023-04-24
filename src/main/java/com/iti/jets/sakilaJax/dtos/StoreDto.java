package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.Store;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link Store} entity
 */
@XmlRootElement
public class StoreDto implements Serializable {
    private Short storeId;
    private StaffDtoSimple staff;
    private AddressDto address;
    private Timestamp lastUpdate;
    private Set<StaffDtoSimple> staffs;
    private Set<InventoryDto> inventories;
    private Set<CustomerDtoSimple> customers;

    public StoreDto() {
    }

    public StoreDto(Short storeId, StaffDtoSimple staff, AddressDto address, Timestamp lastUpdate, Set<StaffDtoSimple> staffs, Set<InventoryDto> inventories, Set<CustomerDtoSimple> customers) {
        this.storeId = storeId;
        this.staff = staff;
        this.address = address;
        this.lastUpdate = lastUpdate;
        this.staffs = staffs;
        this.inventories = inventories;
        this.customers = customers;
    }

    public void setStoreId(Short storeId) {
        this.storeId = storeId;
    }

    public void setStaff(StaffDtoSimple staff) {
        this.staff = staff;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setStaffs(Set<StaffDtoSimple> staffs) {
        this.staffs = staffs;
    }

    public void setInventories(Set<InventoryDto> inventories) {
        this.inventories = inventories;
    }

    public void setCustomers(Set<CustomerDtoSimple> customers) {
        this.customers = customers;
    }

    public Short getStoreId() {
        return storeId;
    }

    public StaffDtoSimple getStaff() {
        return staff;
    }

    public AddressDto getAddress() {
        return address;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public Set<StaffDtoSimple> getStaffs() {
        return staffs;
    }

    public Set<InventoryDto> getInventories() {
        return inventories;
    }

    public Set<CustomerDtoSimple> getCustomers() {
        return customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreDto entity = (StoreDto) o;
        return Objects.equals(this.storeId, entity.storeId) &&
                Objects.equals(this.staff, entity.staff) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate) &&
                Objects.equals(this.staffs, entity.staffs) &&
                Objects.equals(this.inventories, entity.inventories) &&
                Objects.equals(this.customers, entity.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, staff, address, lastUpdate, staffs, inventories, customers);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "storeId = " + storeId + ", " +
                "staff = " + staff + ", " +
                "address = " + address + ", " +
                "lastUpdate = " + lastUpdate + ", " +
                "staffs = " + staffs + ", " +
                "inventories = " + inventories + ", " +
                "customers = " + customers + ")";
    }
}